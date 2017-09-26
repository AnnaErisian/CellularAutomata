package jbinkrot.cellautomata.elementary;

import java.util.Arrays;

public class ElementaryAutomataTest {
	public static void main(String[] args) {
		boolean[] init = new boolean[40];
		Arrays.fill(init, false);
		init[20] = true;
		ElementaryAutomata a = new ElementaryAutomata(init);
		a.setRule(false, false, false, false);
		a.setRule(false, false, true, true);
		a.setRule(false, true, false, true);
		a.setRule(false, true, true, true);
		a.setRule(true, false, false, true);
		a.setRule(true, false, true, false);
		a.setRule(true, true, false, false);
		a.setRule(true, true, true, false);
		
		for(int i = 0; i < 500; i++) {
			for(boolean b : a.getState()) {
				System.out.print(b ? "████" : "    ");
			}
			System.out.println();
			for(boolean b : a.getState()) {
				System.out.print(b ? "████" : "    ");
			}
			System.out.println();
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			a.step();
		}
	}
}
