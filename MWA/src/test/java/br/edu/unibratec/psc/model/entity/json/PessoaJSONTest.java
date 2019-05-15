package br.edu.unibratec.psc.model.entity.json;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaJSONTest {
	
	@Test
	public void testCreateObjectBuilderPessoa_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = new Pessoa();
		pessoa.setCdMatricula(1);
		pessoa.setCpf("039");
		pessoa.setNome("My name is Slim Shady");
		pessoa.setDataNascimento("01/02/2003");
		
		// Act
		String pessoaJSON = 
			PessoaJSON.createObjectBuilderPessoa(pessoa).build().toString();
		System.out.println(pessoaJSON);
		
		// Assert
		
	}
	
	@Ignore
	@Test
	public void testGetListPessoasJSON() {
		fail("Not yet implemented");
	}

}
