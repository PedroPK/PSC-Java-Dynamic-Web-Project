package br.edu.unibratec.psc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.util.CalendarUtil;

public class UtilMethodsTest {
	
	@Test
	public void isListValid_Null() {
		// Arrange
		List<String> nullList = null;
		
		// Act
		boolean response = UtilMethods.isListValid(nullList);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isListValid_Empty() {
		// Arrange
		List<String> emptyList = new ArrayList<String>();
		
		// Act
		boolean response = UtilMethods.isListValid(emptyList);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isListValid_OneElement_EmptyString() {
		// Arrange
		List<String> oneElementList = new ArrayList<String>();
		oneElementList.add("");
		
		// Act
		boolean response = UtilMethods.isListValid(oneElementList);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void isStringValid_Null() {
		// Arrange
		String nullString = null;
		
		// Act
		boolean response = UtilMethods.isStringValid(nullString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isStringValid_Empty() {
		// Arrange
		String emptyString = "";
		
		// Act
		boolean response = UtilMethods.isStringValid(emptyString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isStringValid_OneCharacter_BlankSpace() {
		// Arrange
		String oneBlackSpaceString = " ";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneBlackSpaceString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isStringValid_OneCharacter_Tab() {
		// Arrange
		String oneTabString = "\t";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneTabString);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isStringValid_OneCharacter_Underscore() {
		// Arrange
		String oneUnderscoreString = "_";
		
		// Act
		boolean response = UtilMethods.isStringValid(oneUnderscoreString);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void shortToChar_Zero() {
		// Arrange
		short s = 0;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(0, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void shortToChar_One() {
		// Arrange
		short s = 1;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(1, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void shortToChar_ThirtyTwo() {
		// Arrange
		short s = 32;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(32, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void shortToChar_SixtyFour() {
		// Arrange
		short s = 64;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals('@', c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void shortToChar_OneHundredTwentyEight() {
		// Arrange
		short s = 128;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(128, c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void charToShort_a() {
		// Arrange
		char c = 'a';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	97,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void charToShort_b() {
		// Arrange
		char c = 'b';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	98,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void charToShort_z() {
		// Arrange
		char c = 'z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	122,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void charToShort_A() {
		// Arrange
		char c = 'A';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	65,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void charToShort_Z() {
		// Arrange
		char c = 'Z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	90,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void charToShort_zero_x_f_f() {
		// Arrange
		char c = 0xff;
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		// Assert
		assertEquals(	255,		s);
		//printCharAndShort(c, s);
	}
	
	@Test
	public void shortToChar_zero_x_f_f() {
		// Arrange
		short s = 0xff;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		// Assert
		assertEquals(	'ÿ',		c);
		//printShortAndChar(s, c);
	}
	
	@Test
	public void getShortCharPairs() {
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
	public void getDateFromLocalDate_Null() {
		// Arrange
		LocalDate localDateNull = null;
		
		// Act
		Date dateNull = UtilMethods.getDateFromLocalDate(localDateNull);
		
		// Assert
		assertNull(dateNull);
	}
	
	@Test
	public void getDateFromLocalDate_NotNull_1984Oct06() {
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
	public void getDateFromLocalDate_1983Feb13() {
		// Arrange
		LocalDate localDateNull = LocalDate.of(1983, 02, 13);
		
		// Act
		Date dateNull = UtilMethods.getDateFromLocalDate(localDateNull);
		
		// Assert
		assertNotNull(dateNull);
	}
	
	@Test
	public void formatDate_Null() {
		// Arrange
		Date dateNull = null;
		
		// Act
		String emptyString = UtilMethods.formatDate(dateNull);
		
		// Assert
		assertNotNull(emptyString);
	}
	
	@Test
	public void formatDate_1983Feb13() {
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
	public void getDate_1983Feb13() {
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
	public void calendarSetMethod() {
		// Arrange
		Calendar calendar = Calendar.getInstance();
		
		// Act
		calendar.set(1983, 02, 13);
		System.out.println( calendar.toString() );
		
		// Assert
	}
	
	@Test
	public void formatLocalDate_1983_02_13() {
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
	public void formatLocalDate_1983_12_13() {
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
	public void formatLocalDate_1983_12_31() {
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
	public void formatLocalDate_1500_12_31() {
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
	public void isDateValid_BlankString() {
		// Arrange
		String dateBlank = " ";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateBlank);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void isDateValid__validDate_01Feb2003() {
		// Arrange
		String date = "01/02/2003";
		
		// Act
		boolean response = UtilMethods.isDateValid(date);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void isDateValid_validDate_01Jan2003() {
		// Arrange
		String dateNull = "01/02/2003";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertTrue(response);
	}
	
	@Test
	public void isDateValid_validDate_32Jan2003() {
		// Arrange
		String dateNull = "32/02/2003";
		
		// Act
		boolean response = UtilMethods.isDateValid(dateNull);
		
		// Assert
		assertFalse(response);
	}
	
	@Test
	public void getDayFromDate_Null() {
		// Arrange
		String dateNull = null;
		
		// Act
		int day = UtilMethods.getDayFromDate(dateNull);
		
		// Assert
		assertThat(day, equalTo(-1));
	}
	
	@Test
	public void getDayFromDate_Empty() {
		// Arrange
		String dateEmpty = "";
		
		// Act
		int day = UtilMethods.getDayFromDate(dateEmpty);
		
		// Assert
		assertThat(day, equalTo(-1));
	}
	
	@Test
	public void getDayFromDate_Blank() {
		// Arrange
		String dateBlank = " ";
		
		// Act
		int day = UtilMethods.getDayFromDate(dateBlank);
		
		// Assert
		assertThat(day, equalTo(-1));
	}
	
	@Test
	public void getDayFromDate_01Feb2003() {
		// Arrange
		String date = "01/02/2003";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(01));
	}
	
	@Test
	public void getDayFromDate_02Mar2004() {
		// Arrange
		String date = "02/03/2004";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(02));
	}
	
	@Test
	public void getDayFromDate_03Apr2005() {
		// Arrange
		String date = "03/04/2005";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(03));
	}
	
	@Test
	public void getDayFromDate_04May2006() {
		// Arrange
		String date = "04/05/2006";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(04));
	}
	
	@Test
	public void getDayFromDate_05Jun2007() {
		// Arrange
		String date = "05/06/2007";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(05));
	}
	
	@Test
	public void getDayFromDate_06Jul2008() {
		// Arrange
		String date = "06/07/2008";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(06));
	}
	
	@Test
	public void getDayFromDate_07Aug2009() {
		// Arrange
		String date = "07/08/2009";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(07));
	}
	
	@Test
	public void getDayFromDate_08Sep2010() {
		// Arrange
		String date = "08/09/2010";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(8));
	}
	
	@Test
	public void getDayFromDate_09Oct2011() {
		// Arrange
		String date = "09/10/2011";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(9));
	}
	
	@Test
	public void getDayFromDate_10Nov2012() {
		// Arrange
		String date = "10/11/2012";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(10));
	}
	
	@Test
	public void getDayFromDate_11Dec2013() {
		// Arrange
		String date = "11/12/2013";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(11));
	}
	
	@Test
	public void getDayFromDate_12Jan2014() {
		// Arrange
		String date = "12/01/2014";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(12));
	}
	
	@Test
	public void getDayFromDate_13Feb2015() {
		// Arrange
		String date = "13/02/2015";
		
		// Act
		int day = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(day, equalTo(13));
	}
	
	@Test
	public void getMonthFromDate_Null() {
		// Arrange
		String dateNull = null;
		
		// Act
		int month = UtilMethods.getDayFromDate(dateNull);
		
		// Assert
		assertThat(month, equalTo(-1));
	}
	
	@Test
	public void getMonthFromDate_Empty() {
		// Arrange
		String dateEmpty = "";
		
		// Act
		int month = UtilMethods.getDayFromDate(dateEmpty);
		
		// Assert
		assertThat(month, equalTo(-1));
	}
	
	@Test
	public void getMonthFromDate_Blank() {
		// Arrange
		String dateBlank = " ";
		
		// Act
		int month = UtilMethods.getDayFromDate(dateBlank);
		
		// Assert
		assertThat(month, equalTo(-1));
	}
	
	@Test
	public void getMonthFromDate_01Feb2003() {
		// Arrange
		String date = "01/02/2003";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(02));
	}
	
	@Test
	public void getMonthFromDate_02Mar2004() {
		// Arrange
		String date = "02/03/2004";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(03));
	}
	
	@Test
	public void getMonthFromDate_03Apr2005() {
		// Arrange
		String date = "03/04/2005";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(04));
	}
	
	@Test
	public void getMonthFromDate_04May2006() {
		// Arrange
		String date = "04/05/2006";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(05));
	}
	
	@Test
	public void getMonthFromDate_05Jun2007() {
		// Arrange
		String date = "05/06/2007";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(06));
	}
	
	@Test
	public void getMonthFromDate_06Jul2008() {
		// Arrange
		String date = "06/07/2008";
		
		// Act
		int month = UtilMethods.getDayFromDate(date);
		
		// Assert
		assertThat(month, equalTo(06));
	}
	
	@Test
	public void getMonthFromDate_07Aug2009() {
		// Arrange
		String date = "07/08/2009";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(8));
	}
	
	@Test
	public void getMonthFromDate_08Sep2010() {
		// Arrange
		String date = "08/09/2010";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(9));
	}
	
	@Test
	public void getMonthFromDate_09Oct2011() {
		// Arrange
		String date = "09/10/2011";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(10));
	}
	
	@Test
	public void getMonthFromDate_10Nov2012() {
		// Arrange
		String date = "10/11/2012";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(11));
	}
	
	@Test
	public void getMonthFromDate_11Dec2013() {
		// Arrange
		String date = "11/12/2013";
		
		// Act
		int month = UtilMethods.getMonthFromDate(date);
		
		// Assert
		assertThat(month, equalTo(12));
	}
	
	@Test
	public void getYearFromDate_Null() {
		// Arrange
		String dateNull = null;
		
		// Act
		int year = UtilMethods.getYearFromDate(dateNull);
		
		// Assert
		assertThat(year, equalTo(-1));
	}
	
	@Test
	public void getYearFromDate_Empty() {
		// Arrange
		String dateEmpty = "";
		
		// Act
		int year = UtilMethods.getYearFromDate(dateEmpty);
		
		// Assert
		assertThat(year, equalTo(-1));
	}
	
	@Test
	public void getYearFromDate_Blank() {
		// Arrange
		String dateBlank = " ";
		
		// Act
		int year = UtilMethods.getYearFromDate(dateBlank);
		
		// Assert
		assertThat(year, equalTo(-1));
	}
	
	@Test
	public void getYearFromDate_01Feb2003() {
		// Arrange
		String date = "01/02/2003";
		
		// Act
		int year = UtilMethods.getYearFromDate(date);
		
		// Assert
		assertThat(year, equalTo(2003));
	}
	
	private void printShortAndChar(short pShort, char pChar) {
		System.out.println(pShort + ": " + pChar);
	}
	
	private void printCharAndShort(char pChar, short pShort) {
		System.out.println(pChar + ": " + pShort);
	}
	
}