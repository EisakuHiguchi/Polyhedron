package icosa;

public class Pointer3D {
	
	double x, y, z;
	
	public Pointer3D() {
		
	}
	public Pointer3D(double x, double y, double z) {
		setPoint(x,y,z);
	}
	
	public void setPoint(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	public void setZ(double z) { this.z = z; }
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getZ() { return z; }

	public double[] getPoint() {
		double[] r = new double[3];
		r[0] = x;
		r[1] = y;
		r[2] = z;		
		return r;
	}
}
