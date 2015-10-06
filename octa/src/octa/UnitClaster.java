package octa;

import java.util.ArrayList;

public class UnitClaster {

	ArrayList<Unit> unitarray;
	
	public UnitClaster(double d) {
		init(d);
	}
	
	public void init(double d) {
		unitarray = new ArrayList<>();
		Unit u;
		for(int i = 0; i < 8; i++) {
			u = new Unit(d);
			unitarray.add(u);
			u.setNextUnitLocate(i);
		}
		
	}
	
	public ArrayList<double[]> getLocation() {
		ArrayList<double[]> r = new ArrayList<>();
		for(Unit u: unitarray) {
			r.add(u.getLocate());
		}
		return r;
	}
	
	public ArrayList<Unit> getUnitarray() { return unitarray; }
	
}
