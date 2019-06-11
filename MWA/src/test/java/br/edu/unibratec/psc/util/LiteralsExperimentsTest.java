package br.edu.unibratec.psc.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiteralsExperimentsTest {

	@Test
	public void twoBiggerThanThreeTest() {
		// Arrange and Act
		boolean response = LiteralsExperiments.twoBiggerThanThree();
		
		// Assert
		assertFalse(response);
	}

	@Test
	public void textSubstring2Test() {
		// Arrange and Act
		String response = LiteralsExperiments.textSubstring2();
		
		// Assert
		assertNotNull(response);
		assertTrue(response.length() > 0);
		System.out.println(response);
	}

	@Test
	public void displayHardcodedFloat_37_19Test() {
		// Arrange and Act
		String response = LiteralsExperiments.displayHardcodedFloat_37_19();
		
		// Assert
		assertNotNull(response);
		assertTrue(response.length() > 0);
		System.out.println(response);
	}

}
