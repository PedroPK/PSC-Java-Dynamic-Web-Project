package br.edu.unibratec.psc.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Ignore;
import org.junit.Test;

public class PessoaTest {

	@Test
	public void testHashCodeFixo() throws ParseException {
		// Arrange
		Pessoa pessoa = new Pessoa();
		pessoa.setCdMatricula(12345);
		pessoa.setCpf("987654321-09");
		pessoa.setNome("Jerson");
		pessoa.setDataNascimento("01/02/2003");
		
		// Act
		int hashCodeObtido = pessoa.hashCode();
		
		// Assert
		int resultadoEsperado = -2123539591;
		assertEquals(resultadoEsperado, hashCodeObtido);
	}
	
	@Test
	public void setDateTest() {
		// Arrange
		Pessoa pessoa = new Pessoa();
		String data = "01/02/2003";
		
		// Act
		
		
		// Assert
		fail("Not implemented yet.");
	}
	
	@Test
	public void testGetNomeEntidadeParaQuerySelectGenerico() {
		// Arrange
		
		
		// Act
		String nmEntidade = Pessoa.class.getSimpleName();
		//String nmEntidade = arrayPacoteNome[arrayPacoteNome.length - 1];
		
		// Assert
		assertEquals("Pessoa", nmEntidade);
	}
	
	@Ignore
	@Test
	public void Test() {
		// Arrange
		
		
		// Act
		
		
		// Assert
		fail("Not implemented yet.");
	}

}