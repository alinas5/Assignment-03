//KIT107 Assignment 3
/**
 *	Graphical User Interface and Solution
 *
 *	@author Julian Dermoudy
 *	@version September 18th 2026
 *
 *	This file holds the paint(), actionPerformed(), and
 *	other related routines.  The class is a Frame that
 *	contains the graphical user interface.
 *	
 *	This file is complete.
 */


import java.awt.*;
import java.awt.event.*;


public class KnightsTour extends Frame implements KnightsTourInterface, ActionListener
{
	// finals
	protected final boolean TRACING=false;	// do we want to see output for tracing (debugging) purposes?
	protected final Image PICTURE=Toolkit.getDefaultToolkit().getImage("knight.gif");	// picture of knight

	// non-finals
	// components of the Knight's Tour
	protected Display screen;				// output mechanism
	protected GameTree search;				// game tree
	protected Grid startBoard;				// starting board
	protected int tourLength;				// desired length of tour
	protected Location loc;					// starting location
	protected Dimension dim;				// board dimension

	// necessary utility variables
	protected int startX, startY;			// starting location
	protected int solnLength;				// count of moves
	protected int boardDim;					// size of board
	protected Stack solution;				// final path
	protected Stack dfst;					// data structure for DFS
	protected Queue bfst;					// data structure for BFS
	protected Symbol knight;				// knight symbol
	protected boolean running;				// started yet?

	// GUI components
	protected Label prompt1,prompt2,prompt3,prompt4;
	protected TextField field1,field2,field3,field4,field5;
	protected Button doitBF,doitDF,showAgain;


	/**
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: a Frame has been created with the GUI
	 *	components loaded and visible
	 *	Informally: open the GUI window
	 *
	 * 	@param t the title for the window
	 */
	public KnightsTour(String t)
	{
      	trace("KnightsTour: Constructor starts");

		// stop race condition by initialising running to false
		running=false;

      	// instantiate frame and window listener
      	setLayout(new FlowLayout());
      	setTitle(t);
      	addWindowListener(
      		new WindowAdapter() {
      			public void windowClosing(WindowEvent e) {
      				dispose();
      				System.exit(0);
      			}
      		}
      	);
     	setSize(610,410);
     	setResizable(false);

     	// instantiate GUI widgets
		prompt1=new Label("Start in row:");
		field1=new TextField(2);
		prompt2=new Label("and column:");
		field2=new TextField(2);
		prompt3=new Label("for a tour of length:");
		field3=new TextField(2);
		prompt4=new Label("on a board of side:");
		field4=new TextField(2);
		field5=new TextField(50);
		field1.setText("4");
		field2.setText("2");
		field3.setText("64");
		field4.setText("8");
		field5.setText("");
		field5.setEditable(false);
		doitBF=new Button("BF Produce the Tour!");
		doitDF=new Button("DF Produce the Tour!");
		showAgain=new Button("Re-trace Solution");
		add(prompt1);
		add(field1);
		add(prompt2);
		add(field2);
		add(prompt3);
		add(field3);
		add(prompt4);
		add(field4);
		add(doitBF);
		add(doitDF);
		add(showAgain);
		add(field5);

		// add event handlers
		field1.addActionListener(this);
		field2.addActionListener(this);
		field3.addActionListener(this);
		field4.addActionListener(this);
		doitBF.addActionListener(this);
		doitDF.addActionListener(this);
		showAgain.addActionListener(this);

		// initialise instance variables
		startY=Integer.parseInt(field1.getText());
		startX=Integer.parseInt(field2.getText());
		loc=new Location(startY,startX);
		knight=new Symbol(PICTURE,1,loc);
		tourLength=Integer.parseInt(field3.getText());
		boardDim=Integer.parseInt(field4.getText());
		dim=new Dimension(boardDim,boardDim);
		startBoard=new Grid(dim,loc,knight);
		screen=new Display();
      	screen.setGraphics(getGraphics());

      	// show it!
		setVisible(true);
      	repaint();

		trace("KnightsTour: Constructor ends");
	}


	/**
	 *	paint method.
	 *	Pre-condition: search isn't null
	 *	Post-condition: the tour has been displayed move by move on
	 *					the screen
	 *	Informally: build a stack from the solution back to the start
	 *				and then traverse the stack displaying each move
	 *
	 *	@param g the window containing the GUI
	 */
	public void paint(Graphics g)
	{
		Grid b;		// the board to display at each step
		Stack s;	// the stack to reverse

		trace("paint: paint begins");

		// display the board
		screen.setGraphics(getGraphics());
		startBoard.showGrid(screen);

		if (running)
		{	// either solving or solved
			b=(Grid)search.getData();
			trace("Solution is: " + b.toString());
			if (! solution.isEmpty())
			{
				// reverse the solution and show it from start to finish
				s=new Stack();
  				while (! solution.isEmpty())
  				{
 					b=(Grid) solution.top();
 					s.push(b);
  					solution.pop();
					// sleep to allow the animation
					try
					{
						trace("sleeping...");
						Thread.sleep(750);	// increase/decrease to slow/hurry
					}
					catch (InterruptedException e)
					{
						trace("awake!");
					}
					b.showGrid(screen);
				}

				trace("paint: reverse the path");
				// reverse the reversal!
				solution=new Stack();
				while (! s.isEmpty())
				{
					b=(Grid) s.top();
 					solution.push(b);
  					s.pop();
				}
			}
		}

		trace("paint: paint ends");
	}


	/**
	 *	actionPerformed method.
	 *	Pre-condition: GUI is initialised
	 *	Post-condition: the search variable holds the solution if
	 *					one exists if the user wishes for it to be
	 *					found, or values are read in from the
	 *					text fields if that is the user's wish
	 *	Informally: control all events to allow the problem to be
	 *				configured, and/or the solution to be found
	 *
	 * 	@param e the ActionEvent object that has inspired the action
	 */
	public void actionPerformed(ActionEvent e)
	{
		// finals
		final int MAX_DIM=9;	// maximim dimension

		// non-finals
		Grid g;		// grid at the top of tree
		int potX;	// potential starting column
		int potY;	// potential starting row
		int potLen;	// potential tour length
		int potDim;	// potential board dimension

		trace("actionPerformed(): begins");

		showStatus("");
		if (e.getSource() == showAgain)	
		{
			// redisplay
			if (! running)	// nothing to show if not solving or solved
			{
				trace("actionPerformed(): not running!");
				showStatus("Can't show a solution until we find one...");
				solnLength=0;
			}
		}

		if ((e.getSource() == field1) || (e.getSource() == field2))
		{
			// new starting location	 
			trace("actionPerformed(): input of new start position");
			running=false;

			// get values and test their validity
			potY=Integer.parseInt(field1.getText());
			potX=Integer.parseInt(field2.getText());
			if (((potY<1) || (potY>boardDim)) || ((potX<1) || (potX>boardDim)))
			{
				// invalid so reject
				showStatus("Cannot change location, must be within 1 and " + boardDim);
				field1.setText(Integer.toString(startY));
				field2.setText(Integer.toString(startX));
			}
			else
			{
				// valid so update
				startY=potY;
				startX=potX;
				loc=new Location(startY,startX);
				startBoard=new Grid(dim,loc,knight);
			}
		}

		if (e.getSource() == field3)
		{
			// new tour length
			trace("actionPerformed(): input of new tour length");
			running=false;

			// get value and test its validity
			potLen=Integer.parseInt(field3.getText());
			if ((potLen<1) || (potLen>(boardDim*boardDim)))
			{
				// invalid so reject
				showStatus("Cannot change length, must be within 1 and " + boardDim * boardDim);
				field3.setText(Integer.toString(tourLength));
			}
			else
			{
				// valid so update
				tourLength=potLen;
			}
		}

		if (e.getSource() == field4)
		{
			// new board size
			trace("actionPerformed(): input of new dimension");
			running=false;

			// get value and test its validity
			potDim=Integer.parseInt(field4.getText());
			if ((((startY>potDim)) || ((startX>potDim))) ||(tourLength>(potDim*potDim)))
			{
				// invalid so reject
				showStatus("Cannot change dimension, grid must contain location and tour");
				field4.setText(Integer.toString(boardDim));
			}
			else
			{
				if (potDim>MAX_DIM)
				{
					// invalid so reject
					showStatus("Cannot change dimension, maximum is 9 x 9");
					field4.setText(Integer.toString(boardDim));
				}
				else
				{
					// valid so update
					boardDim=potDim;
					dim=new Dimension(boardDim,boardDim);
					startBoard=new Grid(dim,loc,knight);
				}
			}
		}

		if ((e.getSource() == doitBF) || (e.getSource() == doitDF)) 
		{
			// solve it!

			// load the settings for this run
			trace("actionPerformed(): one of the start buttons pressed");
			startY=Integer.parseInt(field1.getText());
			startX=Integer.parseInt(field2.getText());
			loc=new Location(startY,startX);
			tourLength=Integer.parseInt(field3.getText());
			boardDim=Integer.parseInt(field4.getText());
			dim=new Dimension(boardDim,boardDim);

			// initialise the data structures
			dfst=new Stack();
			bfst=new Queue();
			search=new GameTree();
			search.resetCount();
			startBoard=new Grid(dim,loc,knight);

			// search for the solution
			showStatus("Searching for a solution...");
			trace("actionPerformed(): searching for a solution...");
			if (e.getSource() == doitBF)
			{
				// breadth-first
				trace("actionPerformed(): breadth-first");
				search=search.buildGameBF(startBoard,bfst,tourLength);
			}
			if (e.getSource() == doitDF)
			{
				// depth-first
				trace("actionPerformed(): depth-first");
				search=search.buildGameDF(startBoard,dfst,tourLength);
			}
			if (search.isEmpty())
			{
				// no solution
				solution=new Stack();
				solnLength=0;
				startBoard=new Grid(dim,loc,knight);
				showStatus("No solution!");
				trace("actionPerformed(): no solution");
				search=new GameTree(startBoard);
			}
			else
			{
				// solution found
				showStatus("Solution found in " + search.getCount() + " attempts -- building path...");
				trace("actionPerformed(): Solution found in " + search.getCount() + " attempts");
				solution=retrace(search);
				showStatus("Solution found in " + search.getCount() + " attempts");
				g=(Grid)search.getData();
				solnLength=g.getSquare(g.getLocation()).getSymbol().getNumber();
			}
			running=true;
		}

		trace("actionPerformed(): actionPerformed() ends");

		repaint();
	}

	/**
	 *	do-er method to retrace a GameTree from leaf to root.
	 *	Pre-condition: the given tree t is not null
	 *	Post-condition: a stack is returned consisting of a path
	 *					from root to solution
	 *	Informally: given the solution as the leaf node in a
	 *				game tree, use the parent links to build a
	 *				path on a stack from root to leaf
	 *
	 *	@param t the game tree to retrace
	 *
	 *	@return Stack the nodes of t from leaf to root
	 */
	protected Stack retrace(GameTree t)
	{
		GameTree g;	// an intermediate solution
		Stack s;	// a stack used in the reversal

  		trace("retrace(): begins");

		// reverse the game tree t onto stack s
  		g=t;
		s=new Stack();
		while (! g.isEmpty())
		{
			// add the current node to the stack and move up the tree
			s.push(g.getData());
			g = g.getParent();
		}

  		trace("retrace(): ends");

		return s;
	}


	/**
	 *	display status method.
	 *	Pre-condition: field5 is defined
	 *	Post-condition: field5 has been filled with the given
	 *					String
	 *	Informally: show a status message in a text field
	 *
	 * 	@param s the message to display
	 */
	protected void showStatus(String s)
	{
  		trace("showStatus(): begins");

		field5.setText(s);

  		trace("showStatus(): ends");

	}


	/**
	 *	Show tracing information if "TRACING" variable is true.
	 *	Pre-condition: none
	 *	Post-condition: the given String is displayed on the console
	 *					if "TRACING" is true.
	 *	Informally: provide output for tracing purposes, if desired
	 *
	 * 	@param s the String to display
	 */
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("KNIGHTSTOUR: " + s);
		}
	}
}
