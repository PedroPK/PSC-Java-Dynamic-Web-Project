package br.edu.unibratec.psc.model.fachada;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

public class FachadaRepositorios {
	
	public void inserir(Pessoa pPessoa) {
		PessoaDAO pessoaDao = new PessoaDAO();
		pessoaDao.insert(pPessoa);
	}
	
	public Pessoa consultar(Pessoa pPessoa) {
		PessoaDAO pessoaDao = new PessoaDAO();
		
		Pessoa pessoa = pessoaDao.selectByEntity(Pessoa.class, pPessoa);
		
		return pessoa;
	}
	
}