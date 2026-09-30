//KIT107 Assignment 3
/**
 *	Square ADT
 *
 *	@author <<Student IDs and Names HERE>>
 *	@version <<Date HERE>>
 *
 *	This file holds the Square ADT which represents
 *	a physical space within a grid.  A Square in a
 *	grid consists of a location, a background, and
 *	a symbol (an empty symbol indicates an empty
 *	square).
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
 */


import java.awt.*;


public class Square implements SquareInterface, Cloneable
{
	// finals
	protected final boolean TRACING=true; // do we want to see trace output?

	// non-finals
	protected Symbol symbol;	// the symbol of the current square
	protected Location loc;		// the location of the current square within the board
	protected Image background;	// the background of the current square


	/**
	 *	Constructor method 1.
	 *	Pre-condition: the given location value and background
	 *				   image are defined
	 *	Post-condition: the Square object's "loc" and "background"
	 *					fields are the values given, and its
	 *					"symbol" field is the 'empty' (default)
	 *					symbol
	 *	Informally: creates an empty square of the given 'colour'
	 *				at the given location
	 *
	 * @param l the Location for the created Square
	 * @param b the background image for the created Square
	 */
	public Square(Location l, Image b)
	{
		trace("Square: constructor starts");
		
		// initialise the instance variables
		setLocation(l);
		setSymbol(new Symbol(loc));
		setBackground(b);

		trace("Square: constructor ends");	
	}
	
	
	/**
	 *	Constructor method 2.
	 *	Pre-condition: the given location value, symbol, and
	 *				   background image are defined
	 *	Post-condition: the Square object's "loc", "symbol", and
	 *					"background" fields are the values given
	 *	Informally: creates a square of the given 'colour' and
	 *				symbol at the given location
	 *
	 * @param l the Location for the created Square
	 * @param s the Symbol for the created Square
	 * @param b the background image for the created Square
	 */
	public Square(Location l, Symbol s, Image b)
	{
		// Initialise the instance variables
		loc = l;
		symbol = s;
		background = b;
	}
	
	
	/**
	 *	Clone method for a Square
	 *	Pre-condition: the current Square object is validly defined
	 *	Post-condition: the Square object is copied
	 *	Informally: copy the current Square
	 *
	 *	@return the copied Square (as an Object)
	 */
	public Object clone()
	{
		// Create new square with the same values
		Square s = new Square(loc, symbol, background);
		
		return s; 	
	}
	
	
	/**
	 *	Getter method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					location field is returned
	 *	Informally: return the current square's location
	 *
	 * 	@return Location the location of the current Square
	 */
	public Location getLocation()
	{
		trace("getLocation(): starts and finishes");
		return loc;
	}
	
	
	/**
	 *	Setter method for "loc" instance variable.
	 *	Pre-condition: the given Location value is defined and
	 *				   valid within the enclosing board
	 *	Post-condition: the value of the Square object's loc
	 *					field is altered to contain the given
	 *					Location value
	 *	Informally: update the Square object's Location to the
	 *				given value
	 *
	 * 	@param l the Location for the Square
	 */
	public void setLocation(Location l)
	{
		trace("setLocation(): starts");

		loc=l;

		trace("setLocation(): finishes");
	}
		
	
	/**
	 *	Getter method for "symbol" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					symbol field is returned
	 *	Informally: return the current square's symbol
	 *
	 * 	@return Symbol the symbol of the current Square
	 */
	public Symbol getSymbol()
	{
		trace("getSymbol(): starts and finishes");
		return symbol;
	}
	
	
	/**
	 *	Setter method for "symbol" instance variable.
	 *	Pre-condition: the given Symbol value is defined
	 *	Post-condition: the value of the Square object's symbol
	 *					field is altered to contain the given
	 *					Symbol value
	 *	Informally: update the Square object's symbol to the
	 *				given value
	 *
	 * 	@param s the Symbol for the Square
	 */
	public void setSymbol(Symbol s)
	{
		trace("setSymbol(): starts");

		symbol=s;

		trace("setSymbol(): finishes");
	}


	/**
	 *	Getter method for "background" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					background field is returned
	 *	Informally: return the current square's background
	 *					image
	 *
	 * 	@return Image the background image of the current Square
	 */
	public Image getBackground()
	{
		trace("getBackground(): starts and finishes");
		return background;
	}
	
	
	/**
	 *	Setter method for "background" instance variable.
	 *	Pre-condition: the given Image value is defined
	 *	Post-condition: the value of the Square object's loc
	 *					field is altered to contain the given
	 *					Image value
	 *	Informally: update the Square object's background to the
	 *				given value
	 *
	 * 	@param b the background for the Square
	 */
	public void setBackground(Image b)
	{
		trace("setBackground(): starts");

		background=b;

		trace("setBackground(): finishes");
	}
	
	
	/**
	 *	Check whether square is occupied.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the value of the Square
	 *					object's symbol field is empty and false is
	 *					returned otherwise
	 *	Informally: return whether the current square is empty
	 *
	 * 	@return boolean whether or not the current square is empty
	 */
	public boolean isEmpty()
	{
		return symbol==null;
	}
	
	
	/**
	 *	Display the square on the GUI
	 *	Pre-condition: the Display parameter is correctly defined
	 *	Post-condition: the screen representation of the Square
	 *					object is displayed on the given Display at
	 *					the position related to its location using
	 *					the Square object's symbol and the given
	 *					width
	 *	Informally: display the current square
	 *
	 * 	@param d the Display onto which the Square should be drawn
	 * 	@param w the maximum width the Square's image should be scaled to
	 */
	public void showSquare(Display d,int w)
	{
		int r,c;	// the row and column of the current Square
		Graphics g;	// the graphics context associate with the given Display
		
		trace("showSquare(): starts");
		
		// extract the current Square's row and column values
		r=getLocation().getRow();
		c=getLocation().getColumn();
		// extract the graphicss context from the given Display
		g=d.getGraphics();
		
		// draw the Square
		g.drawImage(getBackground(),(c+1)*32+110,(r+1)*32+50,null);
		// draw the Symbol
		getSymbol().showSymbol(d,w);

		trace("showSquare(): ends");
	}
	
	
	/**
	 *	toString
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the current
	 *					Square is returned
	 *	Informally: find the String equivalent of the current
	 *				square
	 *
	 * @return the String representation of the current Square
	 */
	public String toString()
	{
		String s; // result

		trace("toString(): starts");

		if (isEmpty())
		{
			// empty Square
			s="   ";
		}
		else
		{
			// Square contains a Symbol, return its String representation
			s=getSymbol().toString();
		}

		trace("toString(): ends");
		return s;
	}
	
	
	/*
		Show tracing information if "TRACING" variable is true.
		Pre-condition: none
		Post-condition: the given String is displayed on the console
						if "TRACING" is true.
		Informally: provide output for tracing purposes, if desired
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("SQUARE: " + s);
		}
	}
}