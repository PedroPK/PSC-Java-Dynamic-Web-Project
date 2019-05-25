package br.edu.unibratec.psc.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
		
		printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_One() {
		// Arrange
		short s = 1;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_ThirtyTwo() {
		// Arrange
		short s = 32;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		printShortAndChar(s, c);
	}
	
	@Test
	public void testShortToChar_SixtyFour() {
		// Arrange
		short s = 64;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		printShortAndChar(s, c);
	}

	private void printShortAndChar(short pShort, char pChar) {
		System.out.println(pShort + ": " + pChar);
	}
	
	@Test
	public void testShortToChar_OneHundredTwentyEight() {
		// Arrange
		short s = 128;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		printShortAndChar(s, c);
	}
	
	@Test
	public void testCharToShort_a() {
		// Arrange
		char c = 'a';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_b() {
		// Arrange
		char c = 'b';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_z() {
		// Arrange
		char c = 'z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_A() {
		// Arrange
		char c = 'A';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_Z() {
		// Arrange
		char c = 'Z';
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testCharToShort_zero_x_f_f() {
		// Arrange
		char c = 0xff;
		
		// Act
		short s = UtilMethods.charToShort(c);
		
		printCharAndShort(c, s);
	}
	
	@Test
	public void testShortToChar_zero_x_f_f() {
		// Arrange
		short s = 0xff;
		
		// Act
		char c = UtilMethods.shortToChar(s);
		
		printShortAndChar(s, c);
	}

	private void printCharAndShort(char pChar, short pShort) {
		System.out.println(pChar + ": " + pShort);
	}
	
	@Test
	public void testGetShortCharPairs() {
		// Arrange
		short initialShort = 65;
		short finalShort = 256;
		
		// Act
		String shortCharPairs = UtilMethods.getShortCharPairs(initialShort, finalShort, 10);
		
		System.out.println(shortCharPairs);
	}
	
}