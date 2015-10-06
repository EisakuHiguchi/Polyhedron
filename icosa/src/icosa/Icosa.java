package icosa;

import java.util.ArrayList;

public class Icosa {
	
	ArrayList<Pointer3D> allUnit;
	ArrayList<IcosaWire> allWire;	
	
	public Icosa() {
		init();
		generatePoint();
		
	}
	
	private void init() {
		allUnit = new ArrayList<>();
		allWire = new ArrayList<>();
	}
	
	
	
	// create icosa
	private void generatePoint() {
		double[] g = setGenPrm(getGold());
//		double[] g = setGenPrm(1);
		double[] h = setGenPrm(1);

		for(int i = 0 ; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				allUnit.add(new Pointer3D(h[i], g[j], 0));
				allUnit.add(new Pointer3D(0, h[i], g[j]));
				allUnit.add(new Pointer3D(g[j], 0 ,h[i]));
			}
		}
	}
	
	private double[] setGenPrm(double p) {
		double[] prm = new double[2];
		prm[0] = p;
		prm[1] = -p;
		return prm;
	}

	private double getGold() {
		return (1 + Math.sqrt(5)) / 2;
	}
	
	public ArrayList<Pointer3D> getAllPoint() { return allUnit; }
}
