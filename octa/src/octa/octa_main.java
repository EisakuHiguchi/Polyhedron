package octa;

import java.util.ArrayList;
import java.io.*;

public class octa_main {

	public static void main(String[] args) {
		double distance = 2;
		
		UnitClaster uc = new UnitClaster(distance);
		square[] square = new square[6];
		
		for(int i = 0; i < square.length; i++) {
			square[i] = new square(i, distance);
			square[i].setUnit(uc.getUnitarray());
		}
		
		
		octa_main util = new octa_main();
//		util.locate_debug(uc);
		util.square_debug(square);
		
		System.out.println("fin");
	}

	private void locate_debug(UnitClaster uc) {
		// locete debug
		try {
			ArrayList<double[]> locate = uc.getLocation();
			FileWriter fw = new FileWriter("data.txt");
			FileWriter script = new FileWriter("script.txt");
			
			script.write("splot 'C:\\\\Users\\\\Iris\\\\Dropbox\\\\polyhedron\\\\tetra\\\\data.txt' w l\n");
			
			for(double[] loc : locate) {
				System.out.println("x: " + loc[0] + " y: " + loc[1] + " z: " + loc[2]);
				fw.write(loc[0] + " " + loc[1] + " " + loc[2] + "\n");
			}
			
			fw.close();
			script.close();
		} catch(Exception e) {
			
		}
	}
	
	private void square_debug(square[] square) {
		// locete debug
		try {
			FileWriter script = new FileWriter("script.txt");
			FileWriter fw = new FileWriter("squaredata.txt");
			for(int i = 0; i < square.length; i++) {
				ArrayList<double[]> locate = square[i].getLocation();

				
				for(double[] loc : locate) {
//						System.out.println("x: " + loc[0] + " y: " + loc[1] + " z: " + loc[2]);
					fw.write(loc[0] + " " + loc[1] + " " + loc[2] + "\n");
				}
			}
			
			script.write("splot 'C:\\\\Users\\\\Iris\\\\Dropbox\\\\" +
					"polyhedron\\\\octa\\\\" + 
					"squaredata.txt' " +
					" w l\n");				

			fw.close();
			script.close();
		} catch(Exception e) {
			
		}
	}
	
}
