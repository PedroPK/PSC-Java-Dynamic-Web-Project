package br.edu.unibratec.psc.model.entity.json;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.util.UtilMethods;

public class PessoaJSON {
	
	public static String getListPessoasJSON(List<Pessoa> listPessoa) {
		JsonArrayBuilder jsonArrayBuilder =  Json.createArrayBuilder();
		
		if ( UtilMethods.isListValid(listPessoa) ) {
			for (Pessoa pessoa: listPessoa) {
				jsonArrayBuilder.add(
					createObjectBuilderPessoa(pessoa)
				);
			}
		}
		
		String json = jsonArrayBuilder.build().toString();
		
		return json;
	}
	
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
	
}