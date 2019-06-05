package br.edu.unibratec.psc.model.entity.json;

import java.util.List;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.util.Constants;
import br.edu.unibratec.psc.util.UtilMethods;

public class PessoaJSON {
	
	/**
	 * Get a JSon String containing the info about a 
	 * List of Pessoa objects.
	 * 
	 * It uses a JsonArrayBuilder, doing it manually, 
	 * using a JST 353/374 specification.
	 * 
	 * Disclaimer: There are better and simpler ways to do it,
	 * available in Java 8 specification, 
	 * with JSON-B (Java API for JSON Binding)
	 * 
	 * @param	List<Pessoa>		listPessoa		A list of Pessoa objects that will generate a Json String
	 * 
	 * @return	String		A String containing the representation about a list os Pessoa objects 
	 */
	public static String getListPessoasJSON(List<Pessoa> listPessoa) {
		JsonArrayBuilder jsonArrayBuilder =  Json.createArrayBuilder();
		
		if ( UtilMethods.isListValid(listPessoa) ) {
			for (Pessoa pessoa: listPessoa) {
				jsonArrayBuilder = jsonArrayBuilder.add(
					createObjectBuilderPessoa(pessoa)
				);
			}
		}
		
		String json = jsonArrayBuilder.build().toString();
		
		return json;
	}
	
	/**
	 * Create a JsonObjectBuilder, capable to convert a Pessoa do a JSon String
	 * This method does it manually, using JSR 353/374 specification.
	 * 
	 * Disclaimer: There are better and simpler ways to do it,
	 * available in Java 8 specification, 
	 * with JSON-B (Java API for JSON Binding)
	 * 
	 * @param	Pessoa				Object that will be used to create a JSon Object Builder
	 * 
	 * @return	JsonObjectBuilder	Object capable to generate a JSon String from a Pessoa object
	 */
	public static JsonObjectBuilder createObjectBuilderPessoa(Pessoa pPessoa) {
		JsonObjectBuilder response = Json.createObjectBuilder();
		
		response = response
			.add("cdMatricula",		pPessoa.getCdMatricula());
		
		response = response
			.add("nome",			pPessoa.getNome());
		
		response = response
			.add("cpf",				pPessoa.getCpf());
		
		String dtNascimento = "null";
		if ( pPessoa.getDataNascimento() != null ) {
			dtNascimento = pPessoa.getDataNascimentoToString();
		}
		response = response
			.add("dataNascimento",	dtNascimento);
		
		String endereco = "null";
		if ( pPessoa.getEndereco() != null ) {
			endereco = pPessoa.getEndereco().toString();
		}
		response = response
			.add("endereco", 		endereco);
		
		
		return response;
	}
	
	/**
	 * Build a JsonObject from a Pessoa object
	 * 
	 * @param		pPessoa			Object that will be used to build a JsonObject
	 * 
	 * @return		JsonObject		a JsonObject created by a Pessoa object
	 */
	public static JsonObject buildObjectPessoa(Pessoa pPessoa) {
		return PessoaJSON.createObjectBuilderPessoa(pPessoa).build();
	}
	
	/**
	 * Generate a Json String with info abou a Pessoa object
	 * 
	 * It uses the JSR 353/374 specification.
	 * 
	 * @param		Pessoa		Object with content to be converted do a Json String
	 * 
	 * @return		String		Contains the Pessoa object info
	 */
	public static String toString(Pessoa pPessoa) {
		return PessoaJSON.buildObjectPessoa(pPessoa).toString();
	}
	
	/**
	 * Generate a Json String with info about a Pessoa object
	 * 
	 * It uses the JSR 367 specification, 
	 * with the Eclipse Yasson official reference implementation
	 * 
	 * @param		Pessoa		Object with content to be converted do a Json String
	 * 
	 * @return		String		Contains the Pessoa object info
	 */
	public static String jsonB(Pessoa pPessoa) {
		String response = null;
		
		if ( pPessoa != null ) {
			Jsonb jsonB = createJsonB();
			response = jsonB.toJson(pPessoa);
		}
		
		return response;
	}
	
	/**
	 * This method encapsulates the JsonBuilder object and its create() method invocation.
	 * 
	 * @return	Jsonb		Object that can generate a Json Text from an Object and vice-versa
	 */
	private static Jsonb createJsonB() {
		return JsonbBuilder.create();
	}
	
	/**
	 * Generate a Indented Json String with info about a Pessoa object
	 * 
	 * It will Break Lines and use Tabs to generate a human friendly Json text
	 * 
	 * It uses the JSR 367 specification, 
	 * with the Eclipse Yasson official reference implementation
	 * 
	 * @param		Pessoa		Object with content to be converted do a Json String
	 * 
	 * @return		String		Contains the Pessoa object info
	 */
	public static String jsonB_prettyPrinting(Pessoa pPessoa) {
		String response = null;
		
		if ( pPessoa != null ) {
			Jsonb jsonB = createJsonB_formatted();
			response = jsonB.toJson(pPessoa);
		}
		
		return response;
	}
	
	/**
	 * This method encapsulates the JsonConfig settings (to Format and Indent Json Text)
	 * and the JsonBuilder object and its create() method invocation.
	 * 
	 * 
	 * @return	Jsonb		Object that can generate a Json Text from an Object and vice-versa
	 */
	private static Jsonb createJsonB_formatted() {
		JsonbConfig jsonbConfig = new JsonbConfig();
		jsonbConfig.setProperty(JsonbConfig.FORMATTING, Boolean.TRUE);
		jsonbConfig.withDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH);
		
		Jsonb jsonB = JsonbBuilder.create(jsonbConfig);
		return jsonB;
	}
	
	public static Pessoa fromJsonText(String pJsonText) {
		Pessoa pessoa = null;
		
		if ( UtilMethods.isStringValid(pJsonText) ) {
			pessoa = createJsonB().fromJson(pJsonText, Pessoa.class);
		}
		
		return pessoa;
	}
	
	public static Pessoa fromJsonFormattedText(String pJsonText) {
		Pessoa pessoa = null;
		
		if ( UtilMethods.isStringValid(pJsonText) ) {
			pessoa = createJsonB_formatted().fromJson(pJsonText, Pessoa.class);
		}
		
		return pessoa;
	}
	
	/**
	 * Using the GSon library from Google to convert an Object 
	 * to a JSon String
	 * 
	 * @param	Pessoa		Object to be converted to a JSon String
	 * 
	 * @return	String		JSon representation of a Pessoa Object
	 */
	public static String gson(Pessoa pPessoa) {
		String response = null;
		
		if ( pPessoa != null ) {
			Gson gson = 
				new GsonBuilder()
					.setDateFormat(Constants.DATE_PATTERN)
					.setPrettyPrinting()
					.create();
			response = gson.toJson(pPessoa);
		}
		
		return response;
	}
	
}