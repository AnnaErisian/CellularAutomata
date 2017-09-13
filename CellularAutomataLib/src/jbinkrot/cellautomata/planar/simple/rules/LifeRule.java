package jbinkrot.cellautomata.planar.simple.rules;

import jbinkrot.cellautomata.planar.simple.SimplePlanarAutomataRule;

public class LifeRule extends SimplePlanarAutomataRule {
	
	@Override
	public boolean getResultState(boolean[][] board, int xpos, int ypos) {
		int neighbors = (SimplePlanarAutomataRule.getWrapped(board, xpos,   ypos+1) ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos,   ypos-1) ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos-1, ypos+1) ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos-1, ypos)   ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos-1, ypos-1) ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos+1, ypos+1) ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos+1, ypos)   ? 1 : 0) +
						(SimplePlanarAutomataRule.getWrapped(board, xpos+1, ypos-1) ? 1 : 0);
		if(board[xpos][ypos]) {
			if(neighbors < 2)
				return false;
			if(neighbors > 3)
				return false;
			return true;
		} else {
			if(neighbors == 3)
				return true;
			return false;
		}
	}

}
