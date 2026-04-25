package br.edu.unibratec.psc.web.ws.rs;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import br.edu.unibratec.psc.model.dao.PessoaDAO;

@Path("/insert")
public class PessoaService {
	
	@Inject
	private PessoaDAO dao;
	
	@POST
	public Response insertPessoa(
		@QueryParam("uuid")
		String pUUID
	) {
		return null;
	}
	
}