package jbinkrot.cellautomata.planar;

import java.util.Arrays;
import java.util.HashSet;

public class SimplePlanarAutomata {
	
	private boolean[][] state;
	private HashSet<SimplePlanarAutomataRule> rules;
	private int width;
	private int height;
	
	public SimplePlanarAutomata(boolean[][] initialState) {
		width = state.length;
		height = state[0].length;
		rules = new HashSet<SimplePlanarAutomataRule>();

		setState(initialState);
	}
	
	public SimplePlanarAutomata(int width, int height) {
		this.width = width;
		this.height = height;
		state = new boolean[width][];
		for(int i = 0; i < width; i++)
			state[i] = new boolean[height];
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
				throw new IllegalArgumentException("State must be rectangular");
			}
		}
	}
	
	public boolean[][] step() {
		boolean[][] oldState = getState();
		
		
		
		return getState();
	}
	
	private int getStateNum(boolean left, boolean center, boolean right) {
		return (left ? 1 : 0) +
				(center ? 2 : 0) +
				(right ? 4 : 0);
	}
	
}
