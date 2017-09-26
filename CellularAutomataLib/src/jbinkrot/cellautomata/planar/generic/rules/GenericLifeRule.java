package jbinkrot.cellautomata.planar.generic.rules;

import jbinkrot.cellautomata.planar.generic.GenericPlanarAutomataRule;

public class GenericLifeRule extends GenericPlanarAutomataRule<Boolean> {
	
	@Override
	public Boolean getResultState(Boolean[][] board, int xpos, int ypos) {
		int neighbors = (getWrapped(board, xpos,   ypos+1) == Boolean.TRUE ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos,   ypos-1) == Boolean.TRUE ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos-1, ypos+1) == Boolean.TRUE ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos-1, ypos) == Boolean.TRUE   ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos-1, ypos-1) == Boolean.TRUE ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos+1, ypos+1) == Boolean.TRUE ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos+1, ypos) == Boolean.TRUE   ? 1 : 0);
		neighbors += 	(getWrapped(board, xpos+1, ypos-1) == Boolean.TRUE ? 1 : 0);
		if(board[xpos][ypos] == Boolean.TRUE) {
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
