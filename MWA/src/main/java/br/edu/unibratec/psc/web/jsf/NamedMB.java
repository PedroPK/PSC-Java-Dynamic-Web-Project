package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

@Named
@ViewScoped
public class NamedMB implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1772316099848213676L;
	
	@Inject
	private PessoaDAO daoPessoa;
	
	@ManagedProperty(value="#{param.pessoaCdMatricula}")
	private int cdMatricula;
	
	
	
	
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
		// Create a registry at Database
		//this.daoPessoa.insert(this.pessoa);
		this.daoPessoa.update(pessoa);
		
		// Retrieve all registries from Database
		this.listaPessoas = this.daoPessoa.consultarTodasAsPessoasByInjectedEM();
	}
	
	public void delete(Pessoa pPessoa) {
		this.daoPessoa.deleteObject(pPessoa);
		
		// Retrieve all registries from Database
		this.listaPessoas = this.daoPessoa.consultarTodasAsPessoasByInjectedEM();
	}
	
}