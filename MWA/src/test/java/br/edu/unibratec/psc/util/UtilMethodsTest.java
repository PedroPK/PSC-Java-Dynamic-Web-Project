package br.edu.unibratec.psc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.util.CalendarUtil;

public class UtilMethodsTest {
	
	@Test
	public void testIsListValid_Null() {
		// Arrange
		List<String> nullList = null;
		
		// Act
		boolean response = UtilMethods.isListValid(nullList);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsListValid_Empty() {
		// Arrange
		List<String> emptyList = new ArrayList<String>();
		
		// Act
		boolean response = UtilMethods.isListValid(emptyList);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsListValid_OneElement_EmptyString() {
		// Arrange
		List<String> oneElementList = new ArrayList<String>();
		oneElementList.add("");
		
		// Act
		boolean response = UtilMethods.isListValid(oneElementList);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void testIsStringValid_Null() {
		// Arrange
		String nullString = null;
		
		// Act
		boolean response = UtilMethods.isStringValid(nullString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsStringValid_Empty() {
		// Arrange
		String emptyString = "";
		
		// Act
		boolean response = UtilMethods.isStringValid(emptyString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsStringValid_OneCharacter_BlankSpace() {
		// Arrange
		String oneBlackSpaceString = " ";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneBlackSpaceString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsStringValid_OneCharacter_Tab() {
		// Arrange
		String oneTabString = "\t";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneTabString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void testIsStringValid_OneCharacter_Underscore() {
		// Arrange
		String oneUnderscoreString = "_";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneUnderscoreString);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void testShortToChar_Zero() {
		// Arrange
		short s = 0;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(0, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_One() {
		// Arrange
		short s = 1;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(1, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_ThirtyTwo() {
		// Arrange
		short s = 32;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(32, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_SixtyFour() {
		// Arrange
		short s = 64;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals('@', c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_OneHundredTwentyEight() {
		// Arrange
		short s = 128;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(128, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testCharToShort_a() {
		// Arrange
		char c = 'a';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	97,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_b() {
		// Arrange
		char c = 'b';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	98,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_z() {
		// Arrange
		char c = 'z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	122,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_A() {
		// Arrange
		char c = 'A';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	65,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_Z() {
		// Arrange
		char c = 'Z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	90,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_zero_x_f_f() {
		// Arrange
		char c = 0xff;
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	255,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void testShortToChar_zero_x_f_f() {
		// Arrange
		short s = 0xff;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(	'ÿ',		c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void testGetShortCharPairs() {
		// Arrange
		short initialShort = 65;
		short finalShort = 256;
		
		// Act
		String shortCharPairs = UtilMethods.getShortCharPairs(initialShort, finalShort, 10);
		
		// Assert
		assertNotNull(shortCharPairs);
		assertFalse(shortCharPairs.isBlank());
		//System.out.println(shortCharPairs);
	}
	
	@Test
	public void testGetDateFromLocalDate_Null() {
		// Arrange
		LocalDate localDateNull = null;
		
		// Act
		Date dateNull = UtilMethods.getDateFromLocalDate(localDateNull);
		
		// Assert
		assertNull(dateNull);
	}
	
	@Test
	public void testGetDateFromLocalDate_NotNull_1984Oct06() {
		// Arrange
		LocalDate localDateNull_1984Oct06 = LocalDate.of(1984, 10, 06);
		
		// Act
		Date dateNotNull_1984Oct06 = UtilMethods.getDateFromLocalDate(localDateNull_1984Oct06);
		
		// Assert
		assertNotNull(dateNotNull_1984Oct06);
		//System.out.println(dateNotNull_1984Oct06);
	}
	
	@Ignore
	@Test
	public void testGetDateFromLocalDate_1983Feb13() {
		// Arrange
		LocalDate localDateNull = LocalDate.of(1983, 02, 13);
		
		// Act
		Date dateNull = UtilMethods.getDateFromLocalDate(localDateNull);
		
		// Assert
		assertNotNull(dateNull);
	}
	
	@Test
	public void testFormatDate_Null() {
		// Arrange
		Date dateNull = null;
		
		// Act
		String emptyString = UtilMethods.formatDate(dateNull);
		
		// Assert
		assertNotNull(emptyString);
	}
	
	@Test
	public void testFormatDate_1983Feb13() {
		// Arrange
		Date dateNotNull = UtilMethods.getDate(1983, 02, 13);
		
		// Act
		String notEmptyString = UtilMethods.formatDate(dateNotNull);
		
		// Assert
		assertNotNull(notEmptyString);
		assertFalse(notEmptyString.isBlank());
		assertTrue(notEmptyString.length() == 10);
		
		System.out.println(notEmptyString);
	}
	
	@Test
	public void testGetDate_1983Feb13() {
		// Arrange
		int year	= 1983;
		int month	= 02;
		int day		= 13;
		
		// Act
		Date date = UtilMethods.getDate(year, month, day);
		
		// Assert
		assertNotNull(date);
	}
	
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
	
	@Test
	public void isDateValid_Null() {
		// Arrange
		String dateNull = null;
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isDateValid_EmptyString() {
		// Arrange
		String dateNull = "";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isDateValid_BlanckString() {
		// Arrange
		String dateNull = " ";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isDateValid_ValidDate_01Jan2003() {
		// Arrange
		String dateNull = "01/02/2003";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void isDateValid_ValidDate_32Jan2003() {
		// Arrange
		String dateNull = "32/02/2003";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertFalse(response);
	}
	
	private void printShortAndChar(short pShort, char pChar) {
		System.out.println(pShort + ": " + pChar);
	}
	
	private void printCharAndShort(char pChar, short pShort) {
		System.out.println(pChar + ": " + pShort);
	}
	
}