package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.unibratec.psc.model.dao.configs.JpaConfiguration;
import br.edu.unibratec.psc.model.entity.Pessoa;

@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
@SpringBootTest(
	classes= {
		JpaConfiguration.class,
		ImageJpaRepository.class
	}
)
public class ImageJpaRepositoryTest {
	
	@Autowired
	ImageJpaRepository dao;
	
	@Test
	public void testFlush() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSaveAndFlush() {
		/*
		 * Arrange
		 */
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("John Doe");
	}
	
	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}
	
}
