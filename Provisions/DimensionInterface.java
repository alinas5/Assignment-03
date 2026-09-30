//KIT107 Assignment 3
/**
 *	Dimension ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 18th 2026
 *	
 *	This file holds the Dimension ADT which represents
 *	the two-dimensional size of a board.  The board's
 *	dimension consists of vertical and horizontal
 *	components.
 *
 * 	This file is complete.
 */


public interface DimensionInterface
{
	//public Dimension(int v, int h);
	public void setVert(int v);
	public void setHoriz(int h);
	public int getVert();
	public int getHoriz();
	public Object clone();
}


