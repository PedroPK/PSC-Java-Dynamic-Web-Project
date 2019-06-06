package br.edu.unibratec.psc.util;

import static br.edu.unibratec.psc.util.Constants.DATE_PATTERN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
	
	public static Date getDateFromLocalDate(LocalDate pLocalDate) {
		Date response = null;
		
		if ( pLocalDate != null ) {
			response = 
				Date.from(
					pLocalDate
						.atStartOfDay()
						.atZone(ZoneId.systemDefault())
						.toInstant()
			);
		}
		
		return response;
	}
	
	public static Date getDate(int pYear, int pMonth, int pDay) {
		Date response = null;
		
		LocalDate localDate = LocalDate.of(pYear, pMonth, pDay);
		response = getDateFromLocalDate(localDate);
		
		return response;
	}
	
	public static String formatDate(Date pDate) {
		String response = "";
		
		if ( pDate != null ) {
			SimpleDateFormat sdf = getSimpleDateFormat();
			
			response = sdf.format(pDate);
		}
		
		return response;
	}
	
	public static SimpleDateFormat getSimpleDateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf;
	}
	
	public static boolean isDateValid(String pDate) {
		boolean response = false;
		
		if ( isStringValid(pDate) && pDate.length() == 10 ) {
			SimpleDateFormat sdf = getSimpleDateFormat();
			
			try {
				sdf.parse(pDate);
				
				
				//LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
				response = true;
			} catch (ParseException e) {
				// If a Exception were thrown, the pDate is not a Valid Date
			}
		}
		
		return response;
	}
	
}