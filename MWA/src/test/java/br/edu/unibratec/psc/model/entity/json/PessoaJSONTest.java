package br.edu.unibratec.psc.model.entity.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaJSONTest {
	
	@Test
	public void test01_CreateObjectBuilderPessoa_EnderecoNull() throws ParseException {
		// Arrange
		Pessoa pessoa = getPessoa_EnderecoNull();
		
		// Act
		String pessoaJSON = PessoaJSON.toString(pessoa);
		//System.out.println("test01_CreateObjectBuilderPessoa_EnderecoNull: \n" + pessoaJSON + "\n\n");
		
		// Assert
		String expected = "{\"cdMatricula\":1,\"nome\":\"My name is Slim Shady\",\"cpf\":\"039\",\"dataNascimento\":\"01/02/2003\",\"endereco\":\"null\"}";
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
		
		//System.out.println("test02_JsonB_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
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
		
		//System.out.println("test03_JsonBformatted_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
	}
	
	@Test
	public void test00_Gson_NullPessoa() {
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
		
		System.out.println("test04_Gson_PessoaNotNull_EnderecoNull: \n" + json + "\n\n");
	}
	
	@Test
	public void test05_FromJsonText_copyPastedFormattedStringFromConsole() {
		// Arrange
		String pessoaJson = "{\n" + "    \"cdMatricula\": 1,\n" + "    \"cpf\": \"039\",\n"
				+ "    \"dataNascimento\": \"01/02/2003\",\n" + "    \"nome\": \"My name is Slim Shady\",\n"
				+ "    \"primaryKey\": 1\n" + "}";
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println("test05_FromJsonText_copyPastedFormattedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
	@Test
	public void test06_fromJsonFormattedText_copyPastedFormattedStringFromConsole() {
		// Arrange
		String pessoaJson = 
			"{\n" + 
			"    \"cdMatricula\": 1,\n"						+ 
			"    \"cpf\": \"039\",\n"						+
			"    \"dataNascimento\": \"01/02/2003\",\n"		+ 
			"    \"nome\": \"My name is Slim Shady\",\n"	+
			"    \"primaryKey\": 1\n" + 
			"}";
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonFormattedText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println("test06_fromJsonFormattedText_copyPastedFormattedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
	@Test
	public void test07_fromJsonText_copyPastedStringFromConsole() {
		// Arrange
		String pessoaJson = "{\"cdMatricula\":1,\"cpf\":\"039\",\"dataNascimento\":\"01/02/2003\",\"nome\":\"My name is Slim Shady\",\"primaryKey\":1}";
		System.out.println("test07_FromJson_copyPastedStringFromConsole:\n" + pessoaJson);
		
		// Act
		Pessoa pessoa = PessoaJSON.fromJsonText(pessoaJson);
		
		// Assert
		assertNotNull(pessoa);
		System.out.println("test07_fromJsonText_copyPastedStringFromConsole:\n" + pessoa + "\n\n");
	}
	
	@Ignore
	@Test
	public void serialize() {
		// Arrange, part 01
		class Developer {
			
			private LocalDateTime birthdate;
			
			@JsonbDateFormat(value = "yyyy-MM-dd")
			private LocalDate firstHack;

			@JsonbCreator
			public Developer(@JsonbProperty("birthdate") LocalDateTime birthdate,
					@JsonbProperty("firstHack") LocalDate firstHack) {
				this.birthdate = birthdate;
				this.firstHack = firstHack;
			}
		}
		
		// Arrange, part 02
		Jsonb jsonb = JsonbBuilder.newBuilder().build();
		
		// Arrange, part 03
		Developer developer = 
			new Developer(
				LocalDateTime.of(1995, Month.MARCH, 12, 12, 42),
				LocalDate.of(1998, Month.MARCH, 12));
		
		// Act
		String serialized = jsonb.toJson(developer);
		
		// Assert
		System.out.println("serialized = " + serialized);
		assertThat(serialized, CoreMatchers.containsString("birthdate"));
	}

}
