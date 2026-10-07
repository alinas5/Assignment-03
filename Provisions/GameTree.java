//KIT107 Assignment 3
/**
 * GameTree ADT
 * 
 * @author <<Alina Samoylenko 771455 Addison Allen 762593 >>
 * @version <<09/30/2026>>
 * 
 *          This file holds the GameTree ADT which is a
 *          general game tree. The GameTree is built using
 *          TNode ADTs. A GameTree object consists of a
 *          "root" field which refers to a TNode object
 *          which has "data" and "level" fields,
 *          "parent, "child", and "sibling" references.
 *
 *          YOU NEED TO MAKE CHANGES TO THIS FILE
 */

public class GameTree implements GameTreeInterface {
	// finals
	protected final boolean TRACING = true; // do we want to see output for tracing (debugging) purposes?
	protected final int HORIZONTAL[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; // 8 possible column movements
	protected final int VERTICAL[] = { -1, -2, -2, -1, 1, 2, 2, 1 }; // the corresponding row movements

	// static non-finals
	protected static int count = 0; // count of moves

	// non-static non-finals
	protected TNode root; // the node at the top of the tree

	/**
	 * Constructor method 1.
	 * Pre-condition: none
	 * Post-condition: the GameTree object's "root" field is null
	 * Informally: creates an empty tree
	 */
	public GameTree() {
		trace("GameTree(): Constructor starts");

		root = null;

		trace("GameTree(): Constructor ends");
	}

	/**
	 * Constructor method 2.
	 * Pre-condition: none
	 * Post-condition: the GameTree object's "root" field refers
	 * to a new TNode object containing
	 * parameter value (o) with a null parent,
	 * null child, and null sibling, and level
	 * number 1
	 * Informally: create a tree of a single node (i.e. a leaf)
	 * with the node value provided on the
	 * parameter list
	 *
	 * @param o the board (Object) to place in the TNode's data field
	 */
	public GameTree(Object o) {
		// Initialise the instance variable
		root = new TNode(o);
	}

	/**
	 * Constructor method 3.
	 * Pre-condition: none
	 * Post-condition: the GameTree object's "root" field refers
	 * to a new TNode object containing the
	 * parameter value (p) for parent,
	 * parameter value (o) for data, parameter
	 * value (l) for level, and a null child
	 * and sibling
	 * Informally: create a tree of a single node (i.e. a leaf)
	 * with the node value, level number, and
	 * parent provided on the parameter list
	 *
	 * @param o the board (Object) to place in the TNode's data field
	 * @0aram l the level number of this node in the GameTree
	 * @param p the GameTree which is to be the parent of this one
	 */
	public GameTree(Object o, int l, GameTree p) {
		// Initialise the instance variable
		root = new TNode(o, l, p.root);
	}

	/**
	 * Emptiness test.
	 * Pre-condition: none
	 * Post-condition: true is returned if the GameTree object is
	 * empty, false is returned otherwise
	 * Informally: indicate if the GameTree contains no nodes
	 *
	 * @return boolean whether or not this GameTree is empty
	 */
	public boolean isEmpty() {
		trace("isEmpty(): starts and finishes");

		return (root == null);
	}

	/**
	 * Getter method for "root" instance variable's data value.
	 * Pre-condition: none
	 * Post-condition: the value of the GameTree object's data
	 * field is returned
	 * Informally: return the value within the root node,
	 * throw an exception if the tree is empty
	 *
	 * @return Object the root TNode's data field
	 */
	public Object getData() throws EmptyGameTreeException {
		trace("getData(): starts");

		if (isEmpty()) {
			// empty game trees have no data
			throw new EmptyGameTreeException();
		} else {
			trace("getData(): ends");

			return root.getData();
		}
	}

	/**
	 * Getter method for "root" instance variable's level value.
	 * Pre-condition: none
	 * Post-condition: the value of the GameTree object's level
	 * field is returned
	 * Informally: return the level value within the root node,
	 * throw an exception if the tree is empty
	 *
	 * @return int the root TNode's level field
	 */
	public int getLevel() throws EmptyGameTreeException {
		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}
		return root.getLevel();
	}

	/**
	 * Getter method for "root" instance variable's parent value.
	 * Pre-condition: none
	 * Post-condition: the value of the GameTree object's parent
	 * field is returned
	 * Informally: return the parent value within the root node,
	 * throw an exception if the tree is empty
	 *
	 * @return GameTree the root TNode's parent field
	 */
	public GameTree getParent() throws EmptyGameTreeException {
		GameTree p;

		/* COMPLETE ME */
		trace("getParent(): starts");

		if (isEmpty()) {
			// empty game trees have no parent
			throw new EmptyGameTreeException();
		} else {
			// build result
			p = new GameTree();
			p.root = root.getParent();

			trace("getParent(): ends");

			return p;
		}
	}

	/**
	 * Getter method for "root" instance variable's child value.
	 * Pre-condition: none
	 * Post-condition: the value of the GameTree object's child
	 * field is returned
	 * Informally: return the child value within the root node,
	 * throw an exception if the tree is empty
	 *
	 * @return GameTree the root TNode's child field
	 */
	public GameTree getChild() throws EmptyGameTreeException {
		GameTree tree = new GameTree(); // create new gametree

		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}
		tree.root = root.getChild(); // set this game tree to the child of this root
		return tree;
	}

	/**
	 * Getter method for "root" instance variable's sibling value.
	 * Pre-condition: none
	 * Post-condition: the value of the GameTree object's sibling
	 * field is returned
	 * Informally: return the sibling value within the root node,
	 * throw an exception if the tree is empty
	 *
	 * @return GameTree the root TNode's sibling field
	 */
	public GameTree getSibling() throws EmptyGameTreeException {
		GameTree tree = new GameTree(); // create new game tree
		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}

		tree.root = root.getSibling(); // set the root of new tree to the sibling tree
		return tree;
	}

	/**
	 * Setter method for "root" instance variable's data field.
	 * Pre-condition: none
	 * Post-condition: the TNode object's data field is altered
	 * to hold the given (o) value
	 * Informally: store the given value in the root node of the
	 * GameTree object, throw an exception if the tree
	 * is empty
	 *
	 * @param Object the value to be placed within the TNode's
	 *               data field
	 */
	public void setData(Object o) throws EmptyGameTreeException {
		trace("setData(): starts");

		if (isEmpty()) {
			// an empty tree doesn't have anywhere to put data
			throw new EmptyGameTreeException();
		}

		trace("setData(): ends");

		root.setData(o);
	}

	/**
	 * Setter method for "root" instance variable's level field.
	 * Pre-condition: none
	 * Post-condition: the TNode object's level field is altered
	 * to hold the given (l) value
	 * Informally: store the given value in the root node of the
	 * GameTree object, throw an exception if the tree
	 * is empty
	 *
	 * @param int the value to be placed within the TNode's
	 *            level field
	 */
	public void setLevel(int l) throws EmptyGameTreeException {
		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}
		root.setLevel(l);
	}

	/**
	 * Setter method for "root" instance variable's parent field.
	 * Pre-condition: none
	 * Post-condition: the TNode object's parent field is altered
	 * to hold the given (p) value
	 * Informally: store the given value in the root node of the
	 * GameTree object, throw an exception if the tree
	 * is empty
	 *
	 * @param GameTree the value to be placed within the TNode's
	 *                 parent field
	 */
	public void setParent(GameTree p) throws EmptyGameTreeException {
		trace("setParent(): starts");

		if (isEmpty()) {
			// an empty tree doesn't have anywhere to put data
			throw new EmptyGameTreeException();
		}

		trace("setParent(): ends");

		root.setParent(p.root);
	}

	/**
	 * Setter method for "root" instance variable's child field.
	 * Pre-condition: none
	 * Post-condition: the TNode object's child field is altered
	 * to hold the given (c) value
	 * Informally: store the given value in the root node of the
	 * GameTree object, throw an exception if the tree
	 * is empty
	 *
	 * @param GameTree the value to be placed within the TNode's
	 *                 child field
	 */
	public void setChild(GameTree c) throws EmptyGameTreeException {
		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}

		root.setChild(c.root);
	}

	/**
	 * Setter method for "root" instance variable's sibling field.
	 * Pre-condition: none
	 * Post-condition: the TNode object's sibling field is altered
	 * to hold the given (s) value
	 * Informally: store the given value in the root node of the
	 * GameTree object, throw an exception if the tree
	 * is empty
	 *
	 * @param GameTree the value to be placed within the TNode's
	 *                 sibling field
	 */
	public void setSibling(GameTree s) throws EmptyGameTreeException {
		if (isEmpty()) {
			throw new EmptyGameTreeException();
		}
		root.setSibling(s.root);
	}

	/**
	 * Reset the move count
	 * Precondition: none
	 * Postcondition: the count instance variable has been
	 * returned to 1
	 * Informally: reset the value of the count
	 */
	public void resetCount() {
		trace("resetCount(): starts");

		count = 1;

		trace("resetCount(): ends");
	}

	/**
	 * Increment the move count
	 * Precondition: none
	 * Postcondition: the count instance variable has been
	 * incrememented
	 * Informally: increment the value of the count
	 */
	public void incCount() {
		trace("incCount(): starts");

		count++;

		trace("incCount(): ends");
	}

	/**
	 * Get the move count
	 * Precondition: none
	 * Postcondition: the count instance variable has been
	 * returned
	 * Informally: get the value of the count
	 * 
	 * @return int the count of movres made
	 */
	public int getCount() {
		trace("getCount(): starts and ends");
		return count;
	}

	/**
	 * Do-er method to add an additional level to the game tree
	 * beneath the current level
	 * Pre-condition: current tree isn't empty and Stack is
	 * properly instantiated
	 * Post-condition: current tree node has a linked list of tree
	 * nodes beneath it, all at level+1, all with
	 * copies of the board with an additional move,
	 * and all added to the stack -- unless the
	 * current tree node is already deep enough, or
	 * if there are no additional moves available
	 * Informally: expand the current tree node by adding a list of
	 * possible moves beneath it
	 *
	 * @param s  Stack of GameTrees seen but not visited
	 * @param tl int which specifies desired length of the Knight's
	 *           Tour
	 */
	public void generateLevelDF(Stack s, int tl) {
		Grid g;         // the grid of the game trees root
		Location loc;   // The location to check whether it is possible or not
		GameTree child; // the gametree to make a child of this one
        Symbol sym;     // the symbol of the new location

        // First, loop through all possible locations for the knight to move to.
		for (int i = 0; i < HORIZONTAL.length; i++)
		{
            // Create a new location
            loc = new Location(0, 0);
            // Get the grid from the root of the game tree
			g = (Grid) ((Grid) root.getData()).clone();
			// create a possible location
			loc.setColumn(g.getLocation().getColumn() + VERTICAL[i]);
			loc.setRow(g.getLocation().getRow() + HORIZONTAL[i]);

			if (g.validMove(loc)&&!g.squareOccupied(loc)&&getLevel()<tl) {
				// make this the grids new knight location
                sym = (Symbol)(g.getSymbol(g.getLocation()).clone());
                sym.setNumber(sym.getNumber()+1);
                // Put the knight in its new place
				g.occupySquare(loc, sym);
				// Make tree a child of the gametree, then push it onto stack
                child = new GameTree(g, getLevel() + 1, this);
                child.setSibling(getChild());
                setChild(child);
				// push onto stack
				s.push(child);
			}
		}
	}

	/**
	 * Build the entire game tree
	 * Pre-condition: the Grid and Stack have been properly
	 * instantiated
	 * Post-condition: if the current game tree is empty then it is
	 * replaced by a game tree containing the given
	 * board and a recursive call is returned. If
	 * the current game tree isn't empty then if
	 * the desired tour length has been reached the
	 * current game tree is returned otherwise a
	 * level is added to the game tree and the
	 * answer is a recursive call on the top game
	 * tree of the stack (which is first removed).
	 * If the stack is empty an empty game tree is
	 * returned.
	 * Informally: recursively build the game tree finding the next
	 * place to 'start' on the stack and returning the
	 * solution game tree, or an empty game tree if
	 * no solution exists.
	 *
	 * @param b  the current state of the board
	 * @param s  the stack of GameTrees known but not visited
	 * @param tl the desired tour length
	 *
	 * @return GameTree the solution (or an empty tree if there is
	 *         none)
	 */
	public GameTree buildGameDF(Grid b, Stack s, int tl) {
		GameTree topTree;   // the top tree of the stack

        // If this tree is empty, Replace this tree with a game tree containing
		// the board b, then return buildGameDF();
		if (isEmpty()) {
            // Make the root the grid that was passed in
			root = new TNode((Grid)(b.clone()));
            // Push this tree onto the stack and build the next part of the tree
            s.push(this);
			return buildGameDF(b, s, tl);
		} else {
            // If we've reached the desired tour length, return this tree
			if (getLevel() >= tl) 
			{
				return this;
			} 
            else 
            {
				// add a level to the GameTree
				generateLevelDF(s, tl);
                // if the stack is empty return an empty gametree
				if (s.isEmpty()) {
					return new GameTree();
				} else {
                    // otherwise, we pop the top tree on the stack and build the tree on that
					topTree = (GameTree) s.top();
					s.pop(); // remove the top gametree
                    incCount();
					return topTree.buildGameDF(b, s, tl);
				}
			}
		}
	}

	/**
	 * Do-er method to add an additional level to the game tree
	 * beneath the current level
	 * Pre-condition: current tree isn't empty and Queue is
	 * properly instantiated
	 * Post-condition: current tree node has a linked list of tree
	 * nodes beneath it, all at level+1, all with
	 * copies of the board with an additional move,
	 * and all added to the queue -- unless the
	 * current tree node is already deep enough, or
	 * if there are no additional moves available
	 * Informally: expand the current tree node by adding a list of
	 * possible moves beneath it
	 *
	 * @param q  Queue of GameTrees seen but not visited
	 * @param tl int which specifies desired length of the Knight's
	 *           Tour
	 */
	public void generateLevelBF(Queue q, int tl) {
		Grid g;         // the grid of the game trees root
		Location loc;   // The location to check whether it is possible or not
		GameTree child; // the gametree to make a child of this one
        Symbol sym;     // the symbol of the new location

        // First, loop through all possible locations for the knight to move to.
		for (int i = 0; i < HORIZONTAL.length; i++)
		{
            // Create a new location
            loc = new Location(0, 0);
            // Get the grid from the root of the game tree
			g = (Grid) ((Grid) root.getData()).clone();
			// create a possible location
			loc.setColumn(g.getLocation().getColumn() + VERTICAL[i]);
			loc.setRow(g.getLocation().getRow() + HORIZONTAL[i]);

			if (g.validMove(loc)&&!g.squareOccupied(loc)&&getLevel()<tl) {
				// make this the grids new knight location
                sym = (Symbol)(g.getSymbol(g.getLocation()).clone());
                sym.setNumber(sym.getNumber()+1);
                // Put the knight in its new place
				g.occupySquare(loc, sym);
				// Make tree a child of the gametree, then add it to the end of the queue
                child = new GameTree(g, getLevel() + 1, this);
                child.setSibling(getChild());
                setChild(child);
				// add onto end of queue
				q.add(child);
			}
		}
	}

	/**
	 * Build the entire game tree
	 * Pre-condition: the Grid and Queue have been properly
	 * instantiated
	 * Post-condition: if the current game tree is empty then it is
	 * replaced by a game tree containing the given
	 * board and a recursive call is returned. If
	 * the current game tree isn't empty then if
	 * the desired tour length has been reached the
	 * current game tree is returned otherwise a
	 * level is added to the game tree and the
	 * answer is a recursive call on the front game
	 * tree of the queue (which is first removed).
	 * If the queue is empty an empty game tree is
	 * returned.
	 * Informally: recursively build the game tree finding the next
	 * place to 'start' in the queue and returning the
	 * solution game tree, or an empty game tree if
	 * no solution exists.
	 *
	 * @param b  the current state of the board
	 * @param q  the queue of GameTrees known but not visited
	 * @param tl the desired tour length
	 *
	 * @return GameTree the solution (or an empty tree if there is
	 *         none)
	 */
	public GameTree buildGameBF(Grid b, Queue q, int tl) {
		GameTree frontTree;   // the front tree in the queue

        // If this tree is empty, Replace this tree with a game tree containing
		// the board b, then return buildGameDF();
		if (isEmpty()) {
            // Make the root the grid that was passed in
			root = new TNode((Grid)(b.clone()));
            // Push this tree onto the stack and build the next part of the tree
            q.add(this);
			return buildGameBF(b, q, tl);
		} else {
            // If we've reached the desired tour length, return this tree
			if (getLevel() >= tl) 
			{
				return this;
			} 
            else 
            {
				// add a level to the GameTree
				generateLevelBF(q, tl);
                // if the stack is empty return an empty gametree
				if (q.isEmpty()) {
					return new GameTree();
				} else {
                    // otherwise, we remove the front of the queue and build the tree on that
					frontTree = (GameTree) q.front();
					q.remove(); // remove the top gametree
                    incCount();
					return frontTree.buildGameBF(b, q, tl);
				}
			}
		}
	}

	/**
	 * String conversion for root node value
	 * Pre-condition: none
	 * Post-condition: a String object is returned consisting of the
	 * String representation of the value within the
	 * root node, followed by " " or "<>" if the GameTree
	 * object is the empty tree
	 * Informally: produce a String representation of the tree's root
	 * node
	 *
	 * @return String the printable representation of the board
	 */
	public String rootNodeToString() {
		String s; // the result

		trace("rootNodeToString(): starts");

		// generate the printable result
		s = "";
		if (isEmpty()) {
			// nothing to print
			s = "<>";
		} else {
			// get printable version of the board
			s = getData().toString() + " ";
		}

		trace("rootNodeToString(): ends");
		return s;
	}

	/**
	 * String conversion for tree
	 * Pre-condition: none
	 * Post-condition: a String object is returned consisting of the
	 * String representation of all items in the GameTree,
	 * from top to bottom in depth-first order (left,
	 * forward, right), separated by " " and
	 * contained within "<" and ">"
	 * Informally: produce a String representation of the Stack
	 *
	 * @return String a printable version of the GameTree
	 */
	public String toString() {
		GameTree c; // child nodes
		String s; // result

		trace("toString(): starts");

		if (isEmpty()) {
			// nothing to print
			s = "<>";
		} else {
			// produce result
			s = rootNodeToString();
			// Uncomment the following to see the remainder of the tree
			/*
			 * c=getChild();
			 * if (! c.isEmpty())
			 * s=s+(c.toString());
			 * c=getSibling();
			 * if (! c.isEmpty())
			 * s=s+(c.toString());/
			 **/
		}

		trace("toString(): ends");
		return s;
	}

	/**
	 * Show tracing information if "TRACING" variable is true.
	 * Pre-condition: none
	 * Post-condition: the given String is displayed on the console
	 * if "TRACING" is true.
	 * Informally: provide output for tracing purposes, if desired
	 *
	 * @param s the string to print if messages are to be printed
	 */
	protected void trace(String s) {
		if (TRACING) {
			System.out.println("GAMETREE: " + s);
		}
	}
}