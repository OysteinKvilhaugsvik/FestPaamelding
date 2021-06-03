package no.hvl.dat108;

public class ValidatorSimple {

	public boolean isValidTemperature(String s) {
		
		return s != null && s.matches("-?[0-9]*\\.[0-9]*");
	}
	
	public boolean erCelsius(double s) {
		
		return s > -273.15;
	}
	
	public boolean erFahrenheit(double s) {
		
		return s > -459.67;
	}
}
