package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

@Named
@RequestScoped
public class NamedMB implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1772316099848213676L;
	
	@Inject
	private PessoaDAO daoPessoa;
	
	// Atributos de Tela
	Pessoa pessoa = new Pessoa();
	List<Pessoa> listaPessoas;
	
	public NamedMB() {
		pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pPessoa) {
		this.pessoa = pPessoa;
	}
	
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}
	
	public void setListaPessoas(List<Pessoa> pListaPessoas) {
		this.listaPessoas = pListaPessoas;
	}
	
	public void inserir() {
		this.daoPessoa.insert(this.pessoa);
		this.listaPessoas = this.daoPessoa.consultarTodasAsPessoasByInjectedEM();
	}
	
}