package jbinkrot.cellautomata.planar;

import java.util.Arrays;

public class SimplePlanarAutomata {
	
	private boolean[][] state;
	private SimplePlanarAutomataRule rule;
	private int width;
	private int height;
	
	public SimplePlanarAutomata(boolean[][] initialState, SimplePlanarAutomataRule rule) {
		width = initialState.length;
		height = initialState[0].length;
		this.rule = rule;
		setState(initialState);
	}
	
	public SimplePlanarAutomata(int width, int height, SimplePlanarAutomataRule rule) {
		this.width = width;
		this.height = height;
		this.rule = rule;
		state = new boolean[width][height];
	}

	public void setRule(SimplePlanarAutomataRule rule, boolean result) {
		
	}
	
	public boolean[][] getState() {
		boolean[][] cstate = new boolean[width][];
		for(int i = 0; i < width; i++)
			cstate[i] = Arrays.copyOf(state[i], height);
		return cstate;
	}
	
	public void setState(boolean[][] newState) {
		state = newState;
		//ensure rectangularity
		for(boolean[] b : newState) {
			if(b.length != height) {
				throw new IllegalArgumentException("State must be rectangular: " + b.length + " != " + height);
			}
		}
	}
	
	public boolean[][] step() {
		boolean[][] oldState = getState();

		for(int col = 0; col < width; col++) {
			for(int row = 0; row < height; row++) {
				state[col][row] = rule.getResultState(oldState, col, row);
			}
		}
		
		return getState();
	}
	
}
