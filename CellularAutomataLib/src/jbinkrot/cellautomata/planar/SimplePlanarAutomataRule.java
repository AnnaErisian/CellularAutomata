package jbinkrot.cellautomata.planar;

public abstract class SimplePlanarAutomataRule {
	/**
	 * Returns the state to enter when the rule applies
	 */
	public abstract boolean getResultState(boolean[][] board, int xpos, int ypos);
	
	public static boolean getWrapped(boolean[][] board, int xpos, int ypos) {
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
