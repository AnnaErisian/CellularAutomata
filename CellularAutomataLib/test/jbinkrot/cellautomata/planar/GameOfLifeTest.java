package jbinkrot.cellautomata.planar;

import jbinkrot.cellautomata.planar.rules.LifeRule;

public class GameOfLifeTest {
	public static void main(String[] args) {
		boolean[][] inistate = new boolean[20][20];
		inistate[3][3] = true;
		inistate[3][4] = true;
		inistate[3][5] = true;

		inistate[9][3] = true;
		inistate[10][4] = true;
		inistate[10][5] = true;
		inistate[11][4] = true;
		inistate[11][3] = true;
		
		SimplePlanarAutomata a = new SimplePlanarAutomata(inistate, new LifeRule());
		
		for(int i = 0; i < 100; i++) {
			boolean[][] s = a.getState();
			for(int row = 0; row < 20; row++) {
				for(int col = 0; col < 20; col++) {
					System.out.print(s[col][row] ? "██" : "  ");
				}
				System.out.println();
			}
			a.step();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
