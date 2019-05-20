package br.edu.unibratec.psc.model.entity.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

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
	public void testFormatLocalDate_1983_02_13() {
		// Arrange
		byte	day = 13;
		byte	month = 02;
		short	year = 1983;
		
		// Act
		String result = CalendarUtil.formatLocalDate(day, month, year);
		
		// Assert
		String expectedResult = "13/02/1983";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
	@Test
	public void testFormatLocalDate_1983_12_13() {
		// Arrange
		byte	day = 13;
		byte	month = 12;
		short	year = 1983;
		
		// Act
		String result = CalendarUtil.formatLocalDate(day, month, year);
		
		// Assert
		String expectedResult = "13/12/1983";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
	@Test
	public void testFormatLocalDate_1983_12_31() {
		// Arrange
		byte	day = 31;
		byte	month = 12;
		short	year = 1983;
		
		// Act
		String result = CalendarUtil.formatLocalDate(day, month, year);
		
		// Assert
		String expectedResult = "31/12/1983";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
	@Test
	public void testFormatLocalDate_1500_12_31() {
		// Arrange
		byte	day = 31;
		byte	month = 12;
		short	year = 1500;
		
		// Act
		String result = CalendarUtil.formatLocalDate(day, month, year);
		
		// Assert
		String expectedResult = "31/12/1500";
		assertNotNull(	result);
		assertFalse(	result.isEmpty());
		assertEquals(	expectedResult,		result);
	}
	
}
