package jbinkrot.cellautomata.planar.generic;

public abstract class GenericPlanarAutomataRule<E> {
	/**
	 * Returns the state to enter when the rule applies
	 */
	public abstract E getResultState(E[][] board, int xpos, int ypos);
	
	public E getWrapped(E[][] board, int xpos, int ypos) {
		if(xpos < 0)
			xpos = board.length + xpos;
		if(ypos < 0)
			ypos = board[0].length + ypos;
		if(xpos >= board.length)
			xpos = xpos - board.length;
		if(ypos >= board[0].length)
			ypos = ypos - board[0].length;
		return board[xpos][ypos];
	}
	
	
}
