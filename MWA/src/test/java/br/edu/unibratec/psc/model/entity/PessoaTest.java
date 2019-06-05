package br.edu.unibratec.psc.model.entity;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

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

}