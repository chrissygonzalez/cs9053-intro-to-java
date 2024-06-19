public class TestPyramid {
	  public static void printPyramid(SquarePyramid s) {
		  System.out.println("My pyramid has a height of " 
		  + s.getHeight() + " and a side of " 
		  + s.getSide() + " and a volume of " 
		  + s.getVolume() + " and an id of "
		  + s.getID() + " and a surface area of "
		  + s.getSurfaceArea());
	  }
	  
	  public static void main(String[] args) {
		  SquarePyramid s = new SquarePyramid();
		  printPyramid(s);
		  
		  SquarePyramid sp = new SquarePyramid(3, 5);
		  printPyramid(sp);
		  
		  SquarePyramid sqP = new SquarePyramid(12, 15);
		  printPyramid(sqP);
		  
		  s.setHeight(8);
		  s.setSide(9);
		  printPyramid(s);
		  
		  s.setHeight(-5);
		  s.setSide(-3);
		  printPyramid(s);
	  }
}