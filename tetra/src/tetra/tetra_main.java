package tetra;

import java.util.ArrayList;
import java.io.*;

public class tetra_main {

	public static void main(String[] args) {
		double distance = 2;
		
		UnitClaster uc = new UnitClaster(distance);
		
		tetra_main util = new tetra_main();
		util.locate_debug(uc);
		
	}

	private void locate_debug(UnitClaster uc) {
		// locete debug
		try {
			ArrayList<double[]> locate = uc.getLocation();
			FileWriter fw = new FileWriter("data.txt");
			FileWriter script = new FileWriter("script.txt");
			
			script.write("splot 'C:\\\\Users\\\\Iris\\\\Dropbox\\\\polyhedron\\\\tetra\\\\data.txt' w l");
			
			for(double[] loc : locate) {
				System.out.println("x: " + loc[0] + " y: " + loc[1] + " z: " + loc[2]);
				fw.write(loc[0] + " " + loc[1] + " " + loc[2] + "\n");
			}
			
			fw.close();
			script.close();
		} catch(Exception e) {
			
		}
	}
}
