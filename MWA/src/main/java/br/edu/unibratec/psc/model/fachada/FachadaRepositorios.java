package br.edu.unibratec.psc.model.fachada;

import java.util.List;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

public class FachadaRepositorios {
	
	private PessoaDAO aDaoPessoa;
	
	public FachadaRepositorios() {
		getDaoPessoa();
	}
	
	private void getDaoPessoa() {
		if ( this.aDaoPessoa == null ) {
			this.aDaoPessoa = new PessoaDAO();
		}
	}
	
	public void inserir(Pessoa pPessoa) {
		this.aDaoPessoa.insert(pPessoa);
	}
	
	public Pessoa consultar(Pessoa pPessoa) {
		Pessoa pessoa = this.aDaoPessoa.selectByEntity(Pessoa.class, pPessoa);
		
		return pessoa;
	}
	
	public List<Pessoa> consultarTodasAsPessoas() {
		return this.aDaoPessoa.consultarTodasAsPessoas();
	}
	
	public void delete(Pessoa pPessoa) {
		this.aDaoPessoa.deleteObject(pPessoa);
	}
	
}