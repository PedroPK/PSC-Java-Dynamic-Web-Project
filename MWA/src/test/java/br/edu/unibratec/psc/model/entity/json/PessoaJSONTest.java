package br.edu.unibratec.psc.model.entity.json;

import static org.junit.Assert.*;

import java.text.ParseException;

import javax.json.JsonObject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaJSONTest {
	
	@Test
	public void testCreateObjectBuilderPessoa_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String pessoaJSON = 
			PessoaJSON.toString(pessoa);
		System.out.println(pessoaJSON);
		
		// Assert
		String expected = "{\"cdMatricula\":1,\"nome\":\"My name is Slim Shady\",\"cpf\":\"039\",\"dataNascimento\":\"Sat Feb 01 00:00:00 BRT 2003\",\"endereco\":\"null\"}";
		assertNotNull(pessoaJSON);
		assertEquals(expected, pessoaJSON);
		
	}
	
	private Pessoa getPessoa_EnderecoNull() throws ParseException {
		Pessoa pessoa = new Pessoa();
		pessoa.setCdMatricula(1);
		pessoa.setCpf("039");
		pessoa.setNome("My name is Slim Shady");
		pessoa.setDataNascimento("01/02/2003");
		return pessoa;
	}
	
	@Ignore
	@Test
	public void testGetListPessoasJSON() {
		fail("Not yet implemented");
	}

}
