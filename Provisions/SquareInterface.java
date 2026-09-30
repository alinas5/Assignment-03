//KIT107 Assignment 3
/**
 *	Square ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 18th 2026
 *	
 *	This file holds the Square ADT which represents
 *	a physical space within a grid.  A Square in a
 *	grid consists of a location, a background, and
 *	a symbol (an empty symbol indicates an empty
 *	square). 
 *	
 *	This file is complete.
 */


import java.awt.Image;


public interface SquareInterface
{
	//public Square(Location l,Image b);
	//public Square(Location l,Symbol s,Image b);
	public Object clone();
	public Location getLocation();
	public void setLocation(Location l);
	public Symbol getSymbol();
	public void setSymbol(Symbol s);
	public Image getBackground();
	public void setBackground(Image b);
	public boolean isEmpty();
	public void showSquare(Display s, int w);
	public String toString();
}
