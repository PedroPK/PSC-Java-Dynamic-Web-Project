package br.edu.unibratec.psc.model.entity.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	public static String formatCalendarDate(
		int		pDay, 
		int		pMonth, 
		int		pYear
	) {
		// Gets a java.util.Date by Day, Month and Year
		Date date = CalendarUtil.getDate(pDay, pMonth, pYear);
		
		// Gets a DateFormat instance to Full Format the Date
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
		
		// Format the Date and gets a Result String
		String result = df.format(date);
		
		return result;
	}
	
}