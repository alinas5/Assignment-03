
//KIT107 Assignment 3
/**
 *	Grid ADT
 *
 *	@author <<Alina Samoylenko 771455 Addison Allen 762593>>
 *	@version <<09/30/2026>>
 *	
 *	This file holds the Grid ADT which represents
 *	the 'chess' board.  The Grid consists of a location (of
 *	the current position of the knight), a
 *	dimension, and a two-dimensional array (table/matrix)
 *	of the squares in a board.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
 */

import java.awt.*;

public class Grid implements GridInterface, Cloneable {
	// non-static finals
	protected final boolean TRACING = true; // do we want to see output for tracing (debugging) purposes?
	protected final int SIZE = 8; // default side length of board

	// static finals
	protected final static Image WHITE = Toolkit.getDefaultToolkit().getImage("white.gif");
	protected final static Image BLACK = Toolkit.getDefaultToolkit().getImage("black.gif");

	// non-finals
	protected Dimension dimension; // size of the grid
	protected Square[][] board; // all the Squares within the grid
	protected Location loc; // current knight position

	/**
	 * Constructor method 1.
	 * Pre-condition: none
	 * Post-condition: a 8x8 grid is created in which all
	 * squares are empty
	 * Informally: create an empty 8x8 grid
	 */
	public Grid() {
		trace("Grid: constructor starts");

		// create Dimension object of default size
		dimension = new Dimension(SIZE, SIZE);

		// initialise other instance variables to default values
		initialiseGrid();

		trace("Grid: constructor ends");
	}

	/**
	 * Constructor method 2.
	 * Pre-condition: none
	 * Post-condition: a grid of given dimension where all
	 * squares are empty is created
	 * Informally: create an unoccupied grid of given dimension
	 *
	 * @param: d the desired Dimension for the Grid
	 */
	public Grid(Dimension d) {
		/* COMPLETE ME */
	}

	/**
	 * Constructor method 3.
	 * Pre-condition: the given Dimension, Location, and Symbol
	 * values are defined and valid
	 * Post-condition: a Grid of given Dimension is created
	 * where all squares have no symbol but the
	 * square at the given location is occupied
	 * by the given symbol. An exception is
	 * thrown if the given location is not within
	 * the given dimension.
	 * Informally: create a grid of given dimension where all
	 * squares are empty except the one at the
	 * given location which is occupied by the
	 * given symbol
	 *
	 * @param d the desired Dimension for the Grid
	 * @param l the location for the knight on the Grid
	 * @param s the knight
	 */
	public Grid(Dimension d, Location l, Symbol s) throws IllegalGridException {
		trace("Grid: constructor starts");

		// assign given Dimension to the dimension field
		dimension = d;

		// initialise other instance variables to default values
		initialiseGrid();

		// add knight to the board if the location is valid
		if (validMove(l)) {
			// valid
			trace("Grid(): adding the knight");
			occupySquare(l, s);
		} else {
			// invalid
			throw new IllegalGridException();
		}

		trace("Grid: constructor ends");
	}

	/**
	 * initialiseGrid
	 * Pre-condition: none
	 * Post-condition: the two-dimensional array of Squares is
	 * instantiated and filled with newly
	 * created empty squares each with the
	 * correct location and the 'current'
	 * location is left undefined.
	 * Informally: create an empty grid of known dimension
	 */
	protected void initialiseGrid() {
		Location l; // location loop variable
		Dimension d; // dimension of the grid

		trace("initialiseGrid(): starts");

		// create the board
		d = getDimension();
		board = new Square[d.getVert()][d.getHoriz()];

		// create the squares within the board
		for (int r = 0; r < d.getVert(); r++) {
			for (int c = 0; c < d.getHoriz(); c++) {
				l = new Location(r + 1, c + 1);
				if (((r + c) % 2) == 0) {
					// every second square is white
					board[r][c] = new Square(l, WHITE);
				} else {
					// and the others are black
					board[r][c] = new Square(l, BLACK);
				}
			}
		}

		// no symbol yet, so no location for a symbol
		loc = null;

		trace("initialiseGrid(): ends");
	}

	/**
	 * clone()
	 * Pre-condition: the current Grid object is validly defined
	 * Post-condition: the Grid object is copied
	 * Informally: copy the current Grid
	 *
	 * @return Object the copy of the Grid (as an Object)
	 */
	public Object clone() {
		Grid b; // clone of the board
		Dimension d; // clone of the dimension
		Location l; // clone of the loc

		trace("clone(): starts");

		// copy the dimension
		d = (Dimension) getDimension().clone();

		// copy the board
		b = new Grid(d);
		for (int r = 0; r < d.getVert(); r++) {
			for (int c = 0; c < d.getHoriz(); c++) {
				l = new Location(r + 1, c + 1);
				b.occupySquare(l, (Symbol) getSymbol(l).clone());
			}
		}

		// copy the loc
		b.loc = (Location) getLocation().clone();

		trace("clone(): ends");
		return b;
	}

	/**
	 * Setter method for an element of the "board" instance variable.
	 * Pre-condition: the given Square value is defined
	 * Post-condition: the given square is assigned to an element
	 * of the grid object selected according to
	 * the square's location within the grid. An
	 * exception is thrown if the square's
	 * location is outside the grid's dimensions.
	 * Informally: insert the given square into the grid at the
	 * appropriate location or produce an error if not
	 * possible
	 *
	 * @param s the Square to insert into the Grid
	 */
	public void setSquare(Square s) throws IllegalGridException {
		/* COMPLETE ME */
	}

	/**
	 * Getter method for an element of the "board" instance variable.
	 * Pre-condition: the given Location value is within the
	 * bounds of the current grid
	 * Post-condition: the Square object at the appropriate
	 * element of the "board" selected according
	 * to the given Location value is returned. An
	 * exception is thrown if this location is not
	 * within the dimensions of the grid.
	 * Informally: return the square of the grid at the given
	 * location, an exception is thrown if the
	 * location is not within the grid
	 *
	 * @param l the location to examine the Square at
	 * @return Square the Square examined/extracted from the board
	 */
	public Square getSquare(Location l) throws IllegalGridException {
		/* COMPLETE ME */

		return null; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/**
	 * Setter method for the "dimension" instance variable.
	 * Pre-condition: the given Dimension value is defined and
	 * valid
	 * Post-condition: the instance variable "dimension" is
	 * assigned the given Dimension value. An
	 * exception is thrown if this location is
	 * not within the dimensions of the grid.
	 * Informally: assign the given dimension to the grid object
	 *
	 * @param d the intended dimension for the Grid
	 */
	public void setDimension(Dimension d) throws IllegalGridException {
		/* COMPLETE ME */
	}

	/**
	 * Getter method for "dimension" instance variable.
	 * Pre-condition: none
	 * Post-condition: the value of the grid object's dimension
	 * field is returned
	 * Informally: return the current grid's dimension
	 *
	 * @return Dimension the side-length of the board
	 */
	public Dimension getDimension() {
		/* COMPLETE ME */

		return null; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/*
	 * Setter method for the "loc" instance variable.
	 * Pre-condition: the given Location is defined
	 * Post-condition: the instance variable "loc" is assigned
	 * the given value. An exception is thrown
	 * if this location is not within the
	 * dimensions of the grid.
	 * Informally: set the current occupied location
	 *
	 * @param l the desired location to set
	 */
	public void setLocation(Location l) throws IllegalGridException {
		/* COMPLETE ME */
	}

	/**
	 * Getter method for "loc" instance variable.
	 * Pre-condition: none
	 * Post-condition: the current location on the Grid is
	 * returned
	 * Informally: return the current location on the Grid
	 *
	 * @return Location the location of the knight in the Grid
	 */
	public Location getLocation() {
		/* COMPLETE ME */

		return null; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/**
	 * Pre-condition: the given Location value is defined
	 * Post-condition: the square at the position in the
	 * grid indicated by the given Location
	 * value is altered to the given Symbol.
	 * An exception is thrown (by getSquare())
	 * if this location is not within the
	 * dimensions of the grid.
	 * Informally: update the square at the nominated location
	 * of the grid with the given symbol
	 *
	 * @parem l the location to occupy
	 * @param s the symbol to put at the square
	 */
	public void occupySquare(Location l, Symbol s) throws IllegalGridException {
		/* COMPLETE ME */
	}

	/**
	 * Pre-condition: the given Location value is
	 * defined
	 * Post-condition: a Boolean value is returned which
	 * represents whether the symbol of
	 * the square of the current Grid
	 * object with the given Location
	 * value is empty. An exception is
	 * thrown (by getSquare()) if this
	 * location is not within the
	 * dimensions of the grid.
	 * Informally: return whether or not the square at
	 * the given location is occupied
	 *
	 * @param l the location to examine
	 *
	 * @return whether the indicated square is occupied
	 */
	public boolean squareOccupied(Location l) throws IllegalGridException {
		/* COMPLETE ME */

		return false; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/**
	 * getSymbol()
	 * Pre-condition: the given Location value is defined
	 * Post-condition: return the symbol of the square of
	 * the current Grid object with the given
	 * Location. An exception is thrown (by
	 * getSquare()) if this location is not
	 * within the dimensions of the grid.
	 * Informally: return the symbol at the given location
	 * of the grid
	 *
	 * @param l the location to extract the symbol from
	 * 
	 * @return Symbol the symbol
	 */
	public Symbol getSymbol(Location l) throws IllegalGridException {
		/* COMPLETE ME */

		return null; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/**
	 * validMove()
	 * Pre-condition: the given Location value is defined
	 * Post-condition: true is returned if the given
	 * Location is within the bounds of
	 * the current Grid object, false is
	 * returned if it is not
	 * Informally: return whether or not the given
	 * location lies within the current grid
	 *
	 * @param l the location to test
	 * 
	 * @return boolean whether the location is on the board
	 */
	public boolean validMove(Location l) {
		/* COMPLETE ME */

		return false; // REPLACE ME WITH YOUR IMPLEMENTATION
	}

	/**
	 * fullGrid()
	 * Pre-condition: none
	 * Post-condition: true is returned if the grid has
	 * all squares occupied, false is
	 * returned if it is not
	 * Informally: return whether or not the given
	 * grid is full
	 *
	 * @return boolean, whether or not all squares are occupied
	 */
	public boolean fullGrid() {
		Location l; // the location loop variable

		trace("fullGrid(): starts");

		// check all locations
		for (int r = 1; r <= getDimension().getVert(); r++) {
			for (int c = 1; c <= getDimension().getHoriz(); c++) {
				l = new Location(r, c);
				if (!squareOccupied(l)) {
					// this Square is empty, so Grid is not full
					trace("fullGrid(): ends");
					return false;
				}
			}
		}

		// no Squares were empty, so Grid is full
		trace("fullGrid(): ends");
		return true;
	}

	/**
	 * toString()
	 * Pre-condition: none
	 * Post-condition: a String representation of the grid
	 * is returned
	 * Informally: find a String representation of the grid
	 *
	 * @return String the printable representation of tht Grid
	 */
	public String toString() {
		Location l; // the location loop variable
		String s; // result

		trace("toString(): starts");

		// display the board complete with outlines for each square
		// top line
		s = "+";
		for (int k = 1; k <= getDimension().getHoriz(); k++) {
			s += "---+";
		}
		s += "\n";

		// all the squares
		for (int r = 0; r < getDimension().getVert(); r++) {
			s += "|";
			for (int c = 0; c < getDimension().getHoriz(); c++) {
				l = new Location(r + 1, c + 1);
				s = s + getSquare(l).toString();
				s += "|";
			}
			s += "\n";
			s += "+";
			// separator line
			for (int k = 1; k <= getDimension().getHoriz(); k++) {
				s += "---+";
			}
			s += "\n";
		}

		trace("toString(): starts");
		return s;
	}

	/**
	 * showGrid()
	 * Pre-condition: the Display parameter is correctly defined
	 * Post-condition: the screen representation of the Grid
	 * object is displayed on the given Display
	 * with top-left coordinate (0,50) and
	 * squares of appropriate width
	 * Informally: display the current grid
	 *
	 * @param d the Display onto which the Grid is to be drawn
	 */
	public void showGrid(Display d) {
		Location l; // location loop variable
		Graphics g; // the graphics context to draw on
		int width; // the width of output
		Square q; // square loop variable

		trace("showGrid(): starts\n" + toString());

		// determine settings
		g = d.getGraphics();
		width = (600 - 10 - ((getDimension().getHoriz() - 1) * 5)) / getDimension().getHoriz();

		// process every square
		for (int r = 1; r <= getDimension().getVert(); r++) {
			for (int c = 1; c <= getDimension().getHoriz(); c++) {
				// show the current square
				l = new Location(r, c);
				q = getSquare(l);
				q.showSquare(d, width);
			}
		}
		g.setColor(Color.BLACK);

		trace("showGrid(): ends");
	}

	/*
	 * Show tracing information if "TRACING" variable is true.
	 * Pre-condition: none
	 * Post-condition: the given String is displayed on the console
	 * if "TRACING" is true.
	 * Informally: provide output for tracing purposes, if desired
	 *
	 * @param s the String to display
	 */
	protected void trace(String s) {
		if (TRACING) {
			System.out.println("GRID: " + s);
		}
	}
}