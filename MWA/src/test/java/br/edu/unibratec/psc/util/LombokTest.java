package br.edu.unibratec.psc.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import lombok.Getter;
import lombok.Setter;

public class LombokTest {

	@Test
	public void test() {
		// Arrange Act
		User user = new User();
		String name = "Johnny";
		// Act
		user.setFirstName(name);
		
		assertNotNull(user.getFirstName());
		assertEquals(name, user.getFirstName());
	}
	
	// Arrange 01
	@Getter @Setter
	class User {
		private String firstName;
	}

}
