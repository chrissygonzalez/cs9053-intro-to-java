
public class SquarePyramid {
	private static int nextId = 0;
	private int id;
	private double side;
	private double height;
	
	public SquarePyramid() {
		this.id = SquarePyramid.nextId++;
	}
	
	public SquarePyramid(double side, double height) {
		this.id = SquarePyramid.nextId++;
		this.height = height;
		this.side = side;
	}
	
	public double getSide() {
		return this.side;
	}
	
	public void setSide(double side) {
		if(side > 0) this.side = side;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		if(height > 0) this.height = height;
	}
	
	public double getVolume() {
		return (this.side * this.side * this.height) / 3;
	}
	
	public double getSurfaceArea() {
		double squareSide = this.side * this.side;
		double squareHeight = this.height * this.height;
		return squareSide + 2 * this.side * Math.sqrt(squareSide / 4 + squareHeight);
	}
	
	public int getID() {
		return this.id;
	}
}
