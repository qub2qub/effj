// Encapsulation of data by accessor methods and mutators
		package effj.ch04.item14;

//import effj.ch03.item12.OuterClass;

class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static void main(String[] args) {
//		OuterClass ok = new OuterClass();
	}
}
