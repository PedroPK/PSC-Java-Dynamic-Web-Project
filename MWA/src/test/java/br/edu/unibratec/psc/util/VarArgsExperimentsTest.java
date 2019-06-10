package br.edu.unibratec.psc.util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class VarArgsExperimentsTest {
	
	@Ignore
	@Test
	public void testUnsafe() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testBroken() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPlant() {
		// Arrange
		
		// Act
		String[] plants = VarArgsExperiments.plant();
		
		// Assert
		assertNotNull(plants);
		assertFalse(plants.length > 0);
	}
	
	@Test
	public void testSafe() {
		// Arrange
		VarArgsExperiments<String> varArgs = new VarArgsExperiments<String>();
		
		// Act
		varArgs.safe("Safe 01", "Safe 02", "Safe 03");
		
		// Assert
		assertNotNull(varArgs.toString());
		assertFalse(varArgs.toString().length() > 0);
	}

}
