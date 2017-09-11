package jbinkrot.cellautomata.elementary;

import java.util.Arrays;

public class ElementaryAutomata {
	
	private boolean[] state;
	private boolean[] rules;
	private int size;
	
	public ElementaryAutomata(boolean[] initialState) {
		state = initialState;
		size = state.length;
		rules = new boolean[8];
	}
	
	public ElementaryAutomata(int size) {
		this(new boolean[size]);
	}

	public void setRule(boolean left, boolean center, boolean right, boolean result) {
		int statenum = getStateNum(left, center, right);
		rules[statenum] = result;
	}
	
	public boolean[] getState() {
		return Arrays.copyOf(state, size);
	}
	
	public void setState(boolean[] newState) {
		state = newState;
	}
	
	public boolean[] step() {
		boolean[] oldState = getState();
		
		// wrap around left
		int pre = getStateNum(oldState[size-1], oldState[0], oldState[1]);
		state[0] = rules[pre];
		// wrap around right
		pre = getStateNum(oldState[size-2], oldState[size-1], oldState[0]);
		state[size-1] = rules[pre];
		// center cells
		for(int pos = 1; pos < size - 1; pos++) {
			pre = getStateNum(oldState[pos-1], oldState[pos], oldState[pos+1]);
			state[pos] = rules[pre];
		}
		return getState();
	}
	
	private int getStateNum(boolean left, boolean center, boolean right) {
		return (left ? 1 : 0) +
				(center ? 2 : 0) +
				(right ? 4 : 0);
	}
	
}
