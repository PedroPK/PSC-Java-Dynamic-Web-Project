package br.edu.unibratec.psc.model.entity.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	/**
	 * Gets a java.util.Date instance, by a specific Day, Month and Year
	 * 
	 * @param	pDay		A Int that should represent the Day
	 * @param	pMonth		A Int that should represent the Month
	 * @param	pYear		A Int that should represent the Year
	 * 
	 * @return	java.util.Date 
	 */
	public static Date getDate(
		int		pDay, 
		int		pMonth, 
		int		pYear
	) {
		// Get a Calendar instance
		Calendar calendar = Calendar.getInstance();
		
		// Set Day, Month and Year to Calendar
		calendar.set(pYear, (int) pMonth, (int) pDay);
		
		// Transform the Calendar in a java.util.Date
		Date date = calendar.getTime();
		
		return date;
	}
	
	public static String formatLocalDate(
		int		pDay,
		int		pMonth,
		int		pYear
	) {
		// Gets a LocalDate instance
		LocalDate ld = LocalDate.of(pYear, pMonth, pDay);
		
		// Gets a DateTimeFormater with the Brazilian Pattern
		DateTimeFormatter dtf = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// Formats the LocalDate by the DateFormat
		String result = ld.format(dtf);;
		
		return result;
	}
	
}