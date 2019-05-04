package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaDAOTest {
	
	@Test
	public void testInsertPessoa() {
		/*
		 * Arrange
		 */
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("John Doe");
		
		PessoaDAO dao = new PessoaDAO();
		
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
	
}