package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaDAOTest {
	
	private PessoaDAO dao;
	
	@Before
	public void initDAO() {
		this.dao = new PessoaDAO();
	}
	
	@Test
	public void testInsertPessoa() {
		/*
		 * Arrange
		 */
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("John Doe");
		
		dao = new PessoaDAO();
		
		/*DadosBasicos dadosBasicos = new DadosBasicos();
		dadosBasicos.setCpf("123.456.789-0");
		dadosBasicos.setNome("John Doe");		//dadosBasicos.setDtNascimento();
		 */
		
		//pessoa.setCdMatricula(1);
		//pessoa.setDadosBasicos(dadosBasicos);
		
		/*
		 * Act
		 */
		dao.insert(pessoa);
		
		/*
		 * Assert
		 */
		Pessoa selected = dao.selectByEntity(Pessoa.class, pessoa);
		assertEquals(pessoa, selected);
		assertNotSame(pessoa, selected);
		assertEquals(pessoa.getNome(), selected.getNome());
	}
	
	@Test
	public void testFindAll() {
		 // Arrange
		Pessoa john = new Pessoa();
		john.setNome("John Doe");
		
		Pessoa james = new Pessoa();
		james.setNome("James Lannister");
		
		// Act
		dao = new PessoaDAO();
		dao.insert(john);
		dao.insert(james);
		
		List<Pessoa> resultSet = dao.findAll();
		
		// Assert
		assertNotNull(resultSet);
		
	}
	
}