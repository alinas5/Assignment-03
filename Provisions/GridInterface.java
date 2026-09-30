//KIT107 Assignment 3
/**
 *	Grid ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 18th 2026
 *	
 *	This file holds the Grid ADT which represents
 *	the 'chess' board.  The Grid consists of a location (of
 *	the current position of the knight), a
 *	dimension, and a two-dimensional array (table/matrix)
 *	of the squares in a board.
 *
 * 	This file is complete.
 */


public interface GridInterface
{
	//public Grid();
	//public Grid(Dimension m)
	//public Grid(Dimension m, Location l, Symbol s) throws IllegalGridException;
	public Object clone();
	public void setSquare(Square s) throws IllegalGridException;
	public Square getSquare(Location l) throws IllegalGridException;
	public void setDimension(Dimension d);
	public Dimension getDimension();
	public void setLocation(Location l);
	public Location getLocation();
	public void occupySquare(Location l, Symbol s) throws IllegalGridException;
	public boolean squareOccupied(Location l) throws IllegalGridException;
	public boolean fullGrid();
	public boolean validMove(Location l);
	public String toString();
	public void showGrid(Display s);
}
