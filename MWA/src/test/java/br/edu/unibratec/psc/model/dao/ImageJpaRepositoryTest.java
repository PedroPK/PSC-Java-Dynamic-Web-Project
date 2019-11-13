package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.unibratec.psc.model.dao.configs.JpaConfiguration;
import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.util.FilesFoldersUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ContextConfiguration(classes= {JpaConfiguration.class})
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ImageJpaRepositoryTest {
	
	@Autowired
	ImageJpaRepository dao;
	
	@BeforeClass
	public static void printBaseDirectory() {
		String pathDirectory =		FilesFoldersUtil.getPathDirectory(); 
		System.out.println(pathDirectory);
	}
	
	@Test
	public void testFlush() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testSaveAndFlush() {
		/*
		 * Arrange
		 */
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("John Doe");
	}
	
	@Ignore
	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}
	
}
