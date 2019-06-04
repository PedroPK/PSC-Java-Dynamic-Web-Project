package br.edu.unibratec.psc.model.entity.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaJSONTest {
	
	@Test
	public void test01_CreateObjectBuilderPessoa_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String pessoaJSON = 
			PessoaJSON.toString(pessoa);
		System.out.println("test01_CreateObjectBuilderPessoa_EnderecoNull: \n" + pessoaJSON + "\n\n");
		
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
	
	@Test
	public void testJsonB_NullPessoa() {
		// Arrange
		Pessoa pessoa = null;
		
		// Act
		String json = PessoaJSON.jsonB(pessoa);
		
		// Assert
		assertNull(json);
	}
	
	@Test
	public void test02_JsonB_PessoaNotNull_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String json = PessoaJSON.jsonB(pessoa);
		
		// Assert
		assertNotNull(json);
		assertFalse(json.isEmpty());
		
		System.out.println(
			"test02_JsonB_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
	}
	
	@Test
	public void test03_JsonBformatted_PessoaNotNull_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String json = PessoaJSON.jsonB_prettyPrinting(pessoa);
		
		// Assert
		assertNotNull(json);
		assertFalse(json.isEmpty());
		
		System.out.println(
			"test03_JsonBformatted_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
	}
	
	@Test
	public void testGson_NullPessoa() {
		// Arrange
		Pessoa pessoa = null;
		
		// Act
		String json = PessoaJSON.gson(pessoa);
		
		// Assert
		assertNull(json);
	}
	
	@Test
	public void test04_Gson_PessoaNotNull_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String json = PessoaJSON.gson(pessoa);
		
		// Assert
		assertNotNull(json);
		assertFalse(json.isEmpty());
		
		System.out.println(
			"test04_Gson_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
	}
	
	@Test
	public void test05_FromJson_copyPastedFormattedStringFromConsole() {
		// Arrange
		String pessoaJson = "{\n" + 
				"    \"cdMatricula\": 1,\n" + 
				"    \"cpf\": \"039\",\n" + 
				"    \"dataNascimento\": \"01/02/2003\",\n" + 
				"    \"nome\": \"My name is Slim Shady\",\n" + 
				"    \"primaryKey\": 1\n" + 
				"}";
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println(
			"test05_FromJson_copyPastedFormattedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
	@Test
	public void test06_FromFormattedJson_copyPastedFormattedStringFromConsole() {
		// Arrange
		String pessoaJson = "{\n" + 
				"    \"cdMatricula\": 1,\n" + 
				"    \"cpf\": \"039\",\n" + 
				"    \"dataNascimento\": \"01/02/2003\",\n" + 
				"    \"nome\": \"My name is Slim Shady\",\n" + 
				"    \"primaryKey\": 1\n" + 
				"}";
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonFormattedText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println(
			"test06_FromFormattedJson_copyPastedFormattedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
	@Test
	public void test07_FromJson_copyPastedStringFromConsole() {
		// Arrange
		String pessoaJson = "{\"cdMatricula\":1,\"cpf\":\"039\",\"dataNascimento\":\"01/02/2003\",\"nome\":\"My name is Slim Shady\",\"primaryKey\":1}";
		System.out.println(
				"test07_FromJson_copyPastedStringFromConsole:\n" + pessoaJson + "\n\n");
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println(
			"test07_FromJson_copyPastedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
}
