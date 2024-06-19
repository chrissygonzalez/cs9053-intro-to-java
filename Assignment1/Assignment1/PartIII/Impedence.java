
public class Impedence {

	public static double calculateImpedence(double w, double R, double L, double C) {
		// calculate the second squared value
		double partial = w * L - (1.0 / (w * C));
		
		double impedence = Math.sqrt(R * R + partial * partial);
		return impedence;
	}
	
	public static void main(String[] args) {
		// angular frequency is 2 * pi * f
		double frequency = 2.0 * Math.PI * 60;
		
		// convert kiloohms to ohms
		double resistance = 1.5 * 1000;
		
		// convert milliHenrys to Henrys
		double inductance = 8.0 / 1000;
		
		// convert microFarads to Farads
		double capacitance = 96E-6; 
		
		
		double totalImpedence = calculateImpedence(frequency, resistance, inductance, capacitance);
		System.out.println("The total impedence in Ohms is: " + totalImpedence);

	}
}