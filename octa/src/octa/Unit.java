package octa;

import java.util.ArrayList;


public class Unit {
	
	double[] loc;
	ArrayList<Unit> wired;
	double d;
	int dir;
	
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
		int[] db = getDirBit(dir);
		this.dir = dir;
		setLocate(loc[0] + (db[0] * d),
				loc[1] + (db[1] * d),
				loc[2] + (db[2] * d));
	}
	
	public int[] getDirBit(int dir) {
		int[] r = new int[3];
		int bd = Integer.parseInt(Integer.toBinaryString(dir));
		r[0] = ((bd & (100)) == 0) ? -1: 1;
		r[1] = ((bd & (010)) == 0) ? -1: 1;
		r[2] = ((bd & (001)) == 0) ? -1: 1;
//		System.out.println(x + " ," + y + " ," + z);
		return r;
	}
	
	public double[] getLocate() { return loc; }
	public int getDir() { return dir; }
}
