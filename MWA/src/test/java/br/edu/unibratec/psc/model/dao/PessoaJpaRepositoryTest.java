package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.unibratec.psc.model.dao.configs.JpaConfiguration;
import br.edu.unibratec.psc.model.entity.Pessoa;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ContextConfiguration(
	classes= {
		JpaConfiguration.class,
		PessoaJpaRepository.class
	}
)
public class PessoaJpaRepositoryTest {
	
	@Autowired
	PessoaJpaRepository dao;
	
	@Test
	public void testFindAll() throws ParseException {
		// Arrange
		Pessoa p1 = new Pessoa("Pedro",		"123.0456.789-09",	"01/02/1983");
		Pessoa p2 = new Pessoa("Paulo",		"234.567.890-12",	"02/03/1984");
		Pessoa p3 = new Pessoa("Plinio",	"345.678.901-23",	"03/04/1985");
		
		List<Pessoa>	toSaveList = new ArrayList<>();
		toSaveList.add(p1);
		toSaveList.add(p2);
		toSaveList.add(p3);
		
		dao.saveAll(toSaveList);
		
		
		// Act
		List<Pessoa> resultSet = dao.findAll();
		
		
		// Assert
		assertNotNull(	resultSet				);
		assertFalse(	resultSet.isEmpty()		);
		assertEquals(	3, resultSet.size());
	}

	@Test
	public void testFindAllSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllByIdIterableOfID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveAllIterableOfS() {
		fail("Not yet implemented");
	}

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
	public void testDeleteInBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAllInBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllExampleOfS() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllExampleOfSSort() {
		fail("Not yet implemented");
	}

}
