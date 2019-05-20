package br.edu.unibratec.psc.model.entity.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class CalendarUtilTest {
	
	@Ignore
	@Test
	public void testCalendarSetMethod() {
		// Arrange
		Calendar calendar = Calendar.getInstance();
		
		// Act
		calendar.set(1983, 02, 13);
		System.out.println( calendar.toString() );
		
		// Assert
	}
	
	@Test
	public void testCalendarDateFormat_1983_02_13() {
		// Arrange
		byte	day = 13;
		byte	month = 02;
		short	year = 1983;
		
		// Act
		String result = CalendarUtil.formatCalendarDate(day, month, year);
		
		// Assert
		String expectedResult = "Sunday, March 13, 1983";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
	@Test
	public void testCalendarDateFormat_1983_11_31() {
		// Arrange
		int		day = 31;
		int		month = 11;
		int		year = 1983;
		
		// Act
		String result = CalendarUtil.formatCalendarDate(day, month, year);
		
		// Assert
		String expectedResult = "Saturday, November 31, 1983";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
}