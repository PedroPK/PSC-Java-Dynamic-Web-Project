package br.edu.unibratec.psc.util;

import java.util.List;

public class UtilMethods {
	
	public static boolean isListValid(List<?> pList) {
		return 
			pList != null			&& 
			!pList.isEmpty();
	}
	
	public static boolean isStringValid(String pString) {
		boolean response = false;
		
		if ( pString != null && !pString.trim().isEmpty() ) {
			response  = true;
		}
		
		return response;
	}
	
	public static String getShortCharPairs(short pInitialShort, short pFinalShort, int pQtColumns) {
		String result = "\n" + "Short and Char pairs" + "\n";
		int columns = 0;
		
		short s = pInitialShort;
		while ( s <= pFinalShort ) {
			String shortCharPair = shortCharPair(s);
			result = result + shortCharPair;
			
			columns = columns + 1;
			if (columns == pQtColumns) {
				result = result + "\n";
				columns = 0;
			}
			
			s = (short) (s + 1);
		}
		result = result + "\n\n";
		
		return result;
	}
	
	public static char shortToChar(short pShort) {
		char c = (char) pShort;
		
		return c;
	}
	
	public static short charToShort(char pChar) {
		short s = (short) pChar;
		
		return s;
	}
	
	public static String shortCharPair(short pShort) {
		String shortChar = "";
		
		shortChar = pShort + ": " + shortToChar(pShort) + "\t";
		
		return shortChar;
	}
	
}