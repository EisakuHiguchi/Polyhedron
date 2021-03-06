package octa;

import java.util.ArrayList;

public class square {
	
	/*
	 * 四角形の各点を持つ
	 * 点は、対角線をとらない順番で格納
	 */
	
	ArrayList<Unit> unitarray;
	int num;// 面の方向を識別する番号
	double r; // 点間の距離
	
	public square(int num, double r) {
		init(num);
		setUnitDistance(r);
	}
	
	public void init(int num) {
		unitarray = new ArrayList<>();
		this.num = num;
	}
	
	public void setUnitDistance(double r) {
		this.r = r;
	}
	
	public boolean setDirBit(int dir) {
		int r;
		int bd = Integer.parseInt(Integer.toBinaryString(dir));

		if(num == 0) {
			r = bd & 100;
		} else if(num == 1) {
			r = bd & 010;
		} else if(num == 2){
			r = bd & 001;
		} else if(num == 3) {
			r = ~bd & 100;
		} else if(num == 4) {
			r = ~bd & 010;
		} else if(num == 5){
			r = ~bd & 001;
		} else {
			r = 0;
		}
		return r > 0;
	}
	
	public void setUnit(ArrayList<Unit> array) {
		for(Unit u: array) {
			if(setDirBit(u.getDir())){
				unitarray.add(u);
			}
		}
		sort();
	}
	
	public ArrayList<double[]> getLocation() {
		ArrayList<double[]> r = new ArrayList<>();
		for(Unit u: unitarray) {
			r.add(u.getLocate());
		}
		return r;
	}
	
	public void sort() {
		if(unitarray.size() == 4) {
			ArrayList<Unit> result = new ArrayList<>();
			Unit c = unitarray.get(0);
			result.add(c);
			double max = 0.0;
			
			Unit u = unitarray.get(2);
			Unit u2 = unitarray.get(1);
			for(Unit e:unitarray) {
				double temp = distance(c,e);
				if(temp > max) {
					max = temp;
					u = e;
				} else {
					u2 = e;
				}
			}
			
			result.add(u2);
			result.add(u);
			for(Unit e:unitarray) {
				if(result.indexOf(e) == -1) {
					result.add(e);
					break;
				}
			}
			unitarray = result;
		}
	}
	
	private double distance(Unit u1, Unit u2) {
		double[] a = u1.getLocate();
		double[] b = u2.getLocate();
		double[] d = new double[3];
		
		d[0] = a[0] - b[0];
		d[1] = a[1] - b[1];
		d[2] = a[2] - b[2];
		
		return Math.sqrt(d[0] * d[0]
				+ d[1] * d[1]
				+ d[2] * d[2]);	
	}

}
