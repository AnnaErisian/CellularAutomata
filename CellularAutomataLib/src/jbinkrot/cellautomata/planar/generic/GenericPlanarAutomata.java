package jbinkrot.cellautomata.planar.generic;

import java.util.Arrays;

public class GenericPlanarAutomata<E> {
	
	private E[][] state;
	private GenericPlanarAutomataRule<E> rule;
	private int width;
	private int height;
	
	public GenericPlanarAutomata(E[][] initialState, GenericPlanarAutomataRule<E> rule) {
		width = initialState.length;
		height = initialState[0].length;
		this.rule = rule;
		setState(initialState);
	}

	public void setRule(GenericPlanarAutomataRule<E> rule, boolean result) {
		this.rule = rule;
	}
	
	public E[][] getState() {
		E[][] cstate = Arrays.copyOf(state, width);
		for(int i = 0; i < width; i++)
			cstate[i] = Arrays.copyOf(state[i], height);
		return cstate;
	}
	
	public void setState(E[][] newState) {
		state = newState;
		//ensure rectangularity
		for(E[] e : newState) {
			if(e.length != height) {
				throw new IllegalArgumentException("State must be rectangular: " + e.length + " != " + height);
			}
		}
	}
	
	public E[][] step() {
		E[][] oldState = getState();

		for(int col = 0; col < width; col++) {
			for(int row = 0; row < height; row++) {
				state[col][row] = rule.getResultState(oldState, col, row);
			}
		}
		
		return getState();
	}
	
}
