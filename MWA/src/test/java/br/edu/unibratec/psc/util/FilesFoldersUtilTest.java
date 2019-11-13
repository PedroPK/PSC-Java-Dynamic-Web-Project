package br.edu.unibratec.psc.util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FilesFoldersUtilTest {

	@Test
	public void testGetRelativePathToSrcTestResourceImages_JSF_PNG_File() {
		// Act
		String fullPath = 
			FilesFoldersUtil.getAbsolutePathToSrcTestResourceImages_JSF_PNG_File();
		
		// Assert
		assertNotNull(fullPath);
		assertFalse(fullPath.contains("//"));
		
		System.out.println(fullPath);
	}
	
	@Ignore
	@Test
	public void testGetRelativePathToSrcTestResourceImagesFolder() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testGetRelativePathToSrcTestResourceFolder() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetRelativePathToSrcMainResourceFolder() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetFolderSeparator() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testGetPathDirectory() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetOperationalSystemName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetFullPathToSrcTestResourceFolder() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testCreateFile() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testCreateInputStream() {
		fail("Not yet implemented");
	}

}
