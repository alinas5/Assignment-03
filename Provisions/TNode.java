//KIT107 Assignment 3
/**
 *	GameTree Node ADT
 *
 *	@author Julian Dermoudy
 *	@version September 20th 2026
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


public class TNode implements TNodeInterface
{
	// finals
	protected final boolean TRACING=true; // do we want to see trace output?

	// non-finals
	protected Object data;		// the value stored in the node
	protected int level;		// the level in the tree of this node
	protected TNode parent;		// the parent node of the current node
	protected TNode child;		// the child node of the current node
	protected TNode sibling;	// the sibling node of the current node


	/**
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object holds the parameter value
	 *					(o) within its "data" field, its "level" field
	 *					set to 1, and its "parent", "child", and
	 *					"sibling" fields are null
	 *	Informally: intialises the instance variables of the newly
	 *				created TNode object to hold the given parameter
	 *				level 1, and to terminate the parent", "child", and
	 *				"sibling" fields
	 *
	 *	@param o the Object to store in the data field of the node
	*/
	public TNode(Object o)
	{
      	trace("TNode: Constructor starts");

		setData(o);
		setLevel(1);
		setParent(null);
		setChild(null);
		setSibling(null);

      	trace("TNode: Constructor ends");
	}


	/**
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object holds the parameter value
	 *					(o) within its "data" field, the value l within
	 *					its "level" field, the value p within its
	 *					"parent" field, and its "child", and "sibling"
	 *					fields are null
	 *	Informally: intialises the instance variables of the newly
	 *				created TNode object to hold the given parameters
	 *				and to terminate the parent", "child", and "sibling"
	 *				fields
	 *
	 *	@param o the Object to store in the data field of the node
	 *	@param l the int to store in the level field of the node
	 *	@param p the TNode to store in the parent field of the node
	*/
	public TNode(Object o, int l, TNode p)
	{
      	trace("TNode: Constructor starts");

		setData(o);
		setLevel(l);
		setParent(p);
		setChild(null);
		setSibling(null);

      	trace("TNode: Constructor ends");
	}


	/**
	 *	Setter method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is altered to
	 *					hold the given (o) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "data" instance variable
	 *
	 * 	@param o Object to store within the TNode				
	*/
	public void setData(Object o)
	{
      	trace("setData(): starts");

		data=o;

		trace("setData(): ends");
	}
	
	
	/**
	 *	Setter method for "level" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's level field is altered to
	 *					hold the given (l) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "level" instance variable
	 *
	 * 	@param l int to store within the TNode				
	*/
	public void setLevel(int l)
	{
      	trace("setLevel(): starts");

		level=l;

		trace("setLevel(): ends");
	}
	
	
	/**
	 *	Setter method for "parent" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's parent field is altered to
	 *					hold the given (p) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "parent" instance variable
	 *
	 * 	@param p TNode to store within the TNode				
	*/
	public void setParent(TNode p)
	{
      	trace("setParent(): starts");

		parent=p;

		trace("setParent(): ends");
	}
	
	
	/**
	 *	Setter method for "child" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's child field is altered to
	 *					hold the given (c) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "child" instance variable
	 *
	 * 	@param c TNode to store within the TNode				
	*/
	public void setChild(TNode c)
	{
      	trace("setChild(): starts");

		child=c;

		trace("setChild(): ends");
	}
	
	
	/**
	 *	Setter method for "sibling" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's sibling field is altered to
	 *					hold the given (s) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "sibling" instance variable
	 *
	 * 	@param s TNode to store within the TNode				
	*/
	public void setSibling(TNode s)
	{
      	trace("setSibling(): starts");

		sibling=s;

		trace("setSibling(): ends");
	}
	
	
	/**
	 *	Getter method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is returned
	 *	Informally: examine the TNode object's "data" instance
	 *				variable returning its value
	 *
	 * 	@return Object contents of the data field
	 */
	public Object getData()
	{
		trace("getData(): starts and ends");
		return data;
	}
	

	/**
	 *	Getter method for "level" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's level field is returned
	 *	Informally: examine the TNode object's "level" instance
	 *				variable returning its value
	 *
	 * 	@return int contents of the level field
	 */
	public int getLevel()
	{
		trace("getLevel(): starts and ends");
		return level;
	}
	

	/**
	 *	Getter method for "parent" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's parent field is returned
	 *	Informally: examine the TNode object's "parent" instance
	 *				variable returning its value
	 *
	 * 	@return TNode contents of the dparentata field
	 */
	public TNode getParent()
	{
		trace("getParent(): starts and ends");
		return parent;
	}
	

	/**
	 *	Getter method for "child" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's child field is returned
	 *	Informally: examine the TNode object's "child" instance
	 *				variable returning its value
	 *
	 * 	@return TNode contents of the child field
	 */
	public TNode getChild()
	{
		trace("getChild(): starts and ends");
		return child;
	}
	

	/**
	 *	Getter method for "sibling" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's sibling field is returned
	 *	Informally: examine the TNode object's "sibling" instance
	 *				variable returning its value
	 *
	 * 	@return TNode contents of the sibling field
	 */
	public TNode getSibling()
	{
		trace("getSibling(): starts and ends");
		return sibling;
	}
	

	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s the String to be displayed as the trace message
	 */
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("TNode: " + s);
		}
	}
}
