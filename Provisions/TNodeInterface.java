//KIT107 Assignment 3
/**
 *	GameTree Node ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 18th 2026
 *	
 *	This file holds the GameTree Node ADT which represents
 *	the nodes in a ternary tree.  GameTree nodes consist of
 *	a "data" field, a "level" number, nd three references to 
 *	other nodes (these being the parent node ("parent"), the
 *	eldest child node ("child"), and the next eldest sibling
 *	node ("sibling").
 *
 * 	This file is complete.
 */


public interface TNodeInterface
{
	//public TNode(Object o);
	//public TNode(Object o, int l, TNode p);
	public void setData(Object o);
	public Object getData();
	public void setLevel(int l);
	public int getLevel();
	public void setParent(TNode p);
	public TNode getParent();
	public void setChild(TNode c);
	public TNode getChild();
	public void setSibling(TNode s);
	public TNode getSibling();
}
