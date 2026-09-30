//KIT107 Assignment 3
/**
 *	GameTree ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 20th 2026
 *	
 *	This file holds the GameTree ADT which is a
 *	general game tree.  The GameTree is built using
 *	TNode ADTs.  A GameTree object consists of a
 *	"root" field which refers to a TNode object
 *	which has a "data" field, a "level" number, and 
 *	"parent", "child", "sibling" references.
 *
 * 	This file is complete.
 */


public interface GameTreeInterface
{
	//public GameTree();
	//public GameTree(Object o);
	//public GameTree(Object o, int l, GameTree p);
	public boolean isEmpty();
	public void setData(Object o) throws EmptyGameTreeException;
	public Object getData() throws EmptyGameTreeException;
	public void setChild(GameTree c) throws EmptyGameTreeException;
	public GameTree getChild() throws EmptyGameTreeException;
	public void setSibling(GameTree s) throws EmptyGameTreeException;
	public GameTree getSibling() throws EmptyGameTreeException;
	public void setParent(GameTree p) throws EmptyGameTreeException;
	public GameTree getParent() throws EmptyGameTreeException;
	public void resetCount();
	public void incCount();
	public int getCount();
	public GameTree buildGameDF(Grid b, Stack s, int tl);
	public GameTree buildGameBF(Grid b, Queue q, int tl);
	public String toString();
}
