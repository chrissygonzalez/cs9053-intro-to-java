
public class  EstimateCatalan {

	public static final double CATALAN =  0.915965594177219015054603514932384110774;
	
	public static double estimateCatalan() {
		final double DIFF = 0.00001;
		int n = 0;
		double sum = 0;
		double numerator = 0;
		double denominator = 0;
		
		while (Math.abs(sum - CATALAN) > DIFF) {
			numerator = Math.pow(-1, n);
			denominator = (2.0 * n + 1) * (2.0 * n + 1);
			sum = sum + (numerator / denominator);
			n++;
		}
		System.out.println("G is estimated as " + sum + " after " + n + " iterations");
		return sum;
	}
	
	public static void main(String[] args) {
		estimateCatalan();
	}
}
