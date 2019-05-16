package br.edu.unibratec.psc.web.ws.rs;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

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