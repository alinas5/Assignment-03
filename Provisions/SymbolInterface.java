//KIT107 Assignment 3
/**
 *	Symbol ADT Interface
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

import java.awt.Image;


public interface SymbolInterface
{
	//public Symbol();
	//public Symbol(Location l);
	//public Symbol(Image i, int n, Location l);
	public void setIcon(Image i);
	public Image getIcon();
	public void setNumber(int n);
	public int getNumber();
	public void setLocation(Location l);
	public Location getLocation();
	public void makeEmpty();
	public boolean isEmpty();
	public Object clone();
	public void showSymbol(Display s, int w);
	public String toString();
}

