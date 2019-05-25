package br.edu.unibratec.psc.model.entity.json;

import java.util.List;

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
import br.edu.unibratec.psc.util.UtilMethods;

public class PessoaJSON {
	
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
			dtNascimento = pPessoa.getDataNascimento().toString();
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
	
	public static JsonObject buildObjectPessoa(Pessoa pPessoa) {
		return PessoaJSON.createObjectBuilderPessoa(pPessoa).build();
	}
	
	public static String toString(Pessoa pPessoa) {
		return PessoaJSON.buildObjectPessoa(pPessoa).toString();
	}
	
	public static String jsonB(Pessoa pPessoa) {
		String response = null;
		
		if ( pPessoa != null ) {
			Jsonb jsonB = JsonbBuilder.create();
			response = jsonB.toJson(pPessoa);
		}
		
		return response;
	}
	
	public static String jsonB_prettyPrinting(Pessoa pPessoa) {
		String response = null;
		
		if ( pPessoa != null ) {
			JsonbConfig jsonbConfig = new JsonbConfig();
			jsonbConfig.setProperty(JsonbConfig.FORMATTING, Boolean.TRUE);
			
			Jsonb jsonB = JsonbBuilder.create(jsonbConfig);
			response = jsonB.toJson(pPessoa);
		}
		
		return response;
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
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response = gson.toJson(pPessoa);
		}
		
		return response;
	}
	
}