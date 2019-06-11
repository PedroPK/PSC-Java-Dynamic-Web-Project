package br.edu.unibratec.psc.util;

public class LiteralsExperiments {
	
	public static boolean twoBiggerThanThree() {
		boolean response = false;
		
		if ( 2 > 3 ) {
			response = true;
		} else {
			response = false;
		}
		
		return response;
	}
	
	public static String textSubstring2() {
		String response = "";
		
		response = "text".substring(2);
		
		return response;
	}
	
	public static String displayHardcodedFloat_37_19() {
		String response = "";
		
		response = "Display a Hard-Coded Float: " + 37.19f;
		
		return response;
	}
	
}