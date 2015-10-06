package tetra;

import java.util.ArrayList;


public class Unit {
	
	double[] loc;
	ArrayList<Unit> wired;
	double d;
	
	public Unit(double d) {
		init(d);
	}
	
	public void init(double d) {
		loc = new double[3];
		wired = new ArrayList<>();
		this.d = d;
	}
	
	public void setLocate(double x, double y, double z) {
		loc[0] = x;
		loc[1] = y;
		loc[2] = z;
	}
	
	public void setUnit(Unit a) {
		if(wired.indexOf(a) == -1) {
			wired.add(a);
		}
	}
	
	public void setNextUnitLocate(int dir) {
		int x, y, z;
		int bd = Integer.parseInt(Integer.toBinaryString(dir));
		x = ((bd & (100)) == 0) ? -1: 1;
		y = ((bd & (010)) == 0) ? -1: 1;
		z = ((bd & (001)) == 0) ? -1: 1;
//		System.out.println(x + " ," + y + " ," + z);
		
		setLocate(loc[0] + (x * d),
				loc[1] + (y * d),
				loc[2] + (z * d));
	}
	
	public double[] getLocate() { return loc; }
}
