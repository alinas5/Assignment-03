//KIT107 Assignment 3
/**
 *	Symbol ADT
 *
 *	@author Julian Dermoudy
 *	@version September 20th 2026
 *	
 *	This file holds the Symbol ADT which represents
 *	pieces within the two-dimensional grid.
 *	A Symbol consists of a representation of the
 *	knight, plus its number.
 *
 * 	This file is complete.
 */


import java.awt.*;


public class Symbol implements SymbolInterface, Cloneable
{
	// finals
	protected final boolean TRACING=false; // do we want to see output for tracing (debugging) purposes?
	
	// non-finals
	protected Image icon;	// the picture of the knight
	protected int number;	// the number of the knight
	protected Location loc;	// the location of the knight
	
	
	/**
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object is empty
	 *	Informally: intialises the instance variables of the newly
	 *				created Symbol object to empty
	 */
	public Symbol()
	{
		trace("Symbol: constructor starts");

		setIcon(null);
		setNumber(0);
		setLocation(null);

		trace("Symbol: constructor ends");
	}
	
	
	/**
	 *	Constructor method 2.
	 *	Pre-condition: l is a defined Location object
	 *	Post-condition: the Symbol object is empty, but with the
	 *					given location
	 *	Informally: intialises the instance variables of the newly
	 *				created Symbol object to empty but with the
	 *				given location
	 *
	 * 	@param l the location of the Symbol
	 */
	public Symbol(Location l)
	{
		trace("Symbol: constructor starts");

		// initialise the insstance variables
		setIcon(null);
		setNumber(0);
		setLocation(l);

		trace("Symbol: constructor ends");
	}
	
	
	/**
	 *	Constructor method 3.
	 *	Pre-condition: the given Image and Location are defined and
	 *				   the int parameter is a non-negative number
	 *	Post-condition: the Symbol object is initialised to the given
	 *					representation, number, and location
	 *	Informally: intialises the instance variables of the newly
	 *				created Symbol object to the values given
	 *
	 *	@param i the knight's icon
	 * 	@param n the knight's number
	 * 	@param l the knight's location
	 */
	public Symbol(Image i, int n, Location l)
	{
		trace("Symbol: constructor starts");

		// initialise the insstance variables
		setIcon(i);
		setNumber(n);
		setLocation(l);

		trace("Symbol: constructor ends");
	}


	/**
	 *	Setter method for "icon" instance variable.
	 *	Pre-condition: the given Image is defined
	 *	Post-condition: the Symbol object's icon is altered to hold
	 *					the given (i) value
	 *	Informally: assign the value of the parameter to the Symbol
	 *				object's icon instance variable
	 *
	 *	@param i the icon of the knight
	 */
	public void setIcon(Image i)
	{
		trace("setIcon(): starts");

		icon=i;

		trace("setIcon(): ends");
	}
	
	
	/**
	 *	Setter method for "number" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's number is altered to hold
	 *					the given (n) value
	 *	Informally: assign the value of the parameter to the Symbol
	 *				object's number instance variable
	 *
	 *	@param n the number of the knight
	 */
	public void setNumber(int n)
	{
		trace("setNumber(): starts");
		
		number=n;

		trace("setNumber(): ends");
	}
	
	
	/**
	 *	Setter method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's loc is altered to hold
	 *					the given (l) value
	 *	Informally: assign the value of the parameter to the Symbol
	 *				object's loc instance variable
	 *
	 *	@param l the location of the knight
	 */
	public void setLocation(Location l)
	{
		trace("setLocation(): starts");
		
		loc=l;

		trace("setLocation(): ends");
	}
	
	
	/**
	 *	Setter method for "icon" and "number" instance variables.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's icon is set to null and
	 *					its number is reset to 0
	 *	Informally: redefine this symbol to be empty
	 */
	public void makeEmpty()
	{
		trace("makeEmpty(): starts");

		setIcon(null);
		setNumber(0);

		trace("makeEmpty(): ends");
	}
	
	
	/**
	 *	Getter method for "icon" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's icon value is returned
	 *	Informally: examine the Symbol object's icon instance
	 *					variable returning its value
	 *
	 * 	@return Image the knight's icon
	 */
	public Image getIcon()
	{
		trace("makeEmpty(): starts and ends");
		return icon;
	}
	
	
	/**
	 *	Getter method for "number" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's number value is returned
	 *	Informally: examine the Symbol object's number instance
	 *					variable returning its value
	 *
	 * 	@return int the knight's number
	 */
	public int getNumber()
	{
		trace("getNumber(): starts and ends");
		return number;
	}
	
	
	/**
	 *	Getter method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's loc value is returned
	 *	Informally: examine the Symbol object's loc instance
	 *					variable returning its value
	 *
	 * 	@return Location the knight's location
	 */
	public Location getLocation()
	{
		trace("getLocation(): starts and ends");
		return loc;
	}	
	

	/**
	 *	Test whether given symbol is empty.
	 *	Pre-condition: none
	 *	Post-condition: return true if the given symbol is undefined
	 *					and false otherwise
	 *	Informally: examine the Symbol to see if it is empty or not
	 *
	 * 	@return boolean whether the symbol is 'empty' or not
	 */
	public boolean isEmpty()
	{
		trace("isEmpty(): starts and ends");
		return (getIcon() == null);
	}
	
	
	/**
	 *	Clone a symbol.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object is copied
	 *	Informally: copy the current Symbol
	 *
	 * 	@return Object the copied Symbol (as an Object)
	 */
	public Object clone()
	{
		Symbol s; // result
		
		trace("clone(): starts");

		// create the answer
		s=new Symbol();

		// fill in the values (if the current symbol isn't empty)
		if (! isEmpty())
		{
			s.setIcon(getIcon());
			s.setNumber(getNumber());
			s.setLocation((Location) getLocation().clone());
		}
		
		trace("clone(): ends");

		// return result
		return s;
	}
	
	
	/**
	 *	show method for Symbol
	 *	Pre-condition: the Display parameter is correctly defined and w is
	 *				   a positive integer
	 *	Post-condition: the screen representation of the Symbol
	 *					object is displayed on the given Display at a
	 *					width of w pixels
	 *	Informally: display the current symbol
	 *
	 * 	@param s the Display onto which the symbol should be drawn
	 * 	@param w the width for display
	*/
	public void showSymbol(Display s, int w)
	{
		int r,c;	// the row and column components of the symbol's location
		Graphics g;	// the graphics context for drawing on
				
		trace("showSymbol(): starts\n" + toString());
		
		// extract symbol's row and column
		r=getLocation().getRow();
		c=getLocation().getColumn();

		// get graphics context
		g=s.getGraphics();
		
		if (! isEmpty())
		{
			// symbol is of a knight so display it
			g.drawImage(icon,(c+1)*32+110,(r+1)*32+50,null);
			g.setColor(Color.RED);
			g.drawString(Integer.toString(getNumber()),(c+1)*32+110+13,(r+1)*32+50+27);
			g.setColor(Color.BLACK);
		}

		trace("showSymbol(): ends");
	}
	
	
	/**
	 *	toString()
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the current
	 *					Symbol is returned
	 *	Informally: find the String equivalent of the current
	 *				symbol (" " for none, "k" for knight)
	 *
	 * 	@return String the printable representation of the knight
	 */
	public String toString()
	{
		String s; // the result

		trace("toString(): starts");

		// initialise the result
		s="";

		// determine printable format
		if (isEmpty())
		{
			// empty symbol
			s="   ";
		}
		else
		{
			// knight so format as a two digit number
			if (number<10)
			{
				s="k0" + getNumber();
			}
			else
			{
				s="k" + getNumber();
			}
		}

		trace("toString() ends");
		return s;
	}
	
	
	/**
	 *	Show tracing information if "TRACING" variable is true.
	 *	Pre-condition: none
	 *	Post-condition: the given String is displayed on the console
	 *					if "TRACING" is true.
	 *	Informally: provide output for tracing purposes, if desired
	 *
	 * 	@param s the message to display
	 */
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("SYMBOL: " + s);
		}
	}
}