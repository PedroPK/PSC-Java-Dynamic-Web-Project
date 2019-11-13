package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

/**
 * How to access this Managed Bean:
 *  - http://localhost:8080/MWA/jsf/primeFaces.xhtml
 *  
 * @author pedropk
 *
 */
@Named
@ViewScoped
public class PrimeFacesMB implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1772316099848213676L;
	
	@Inject
	private PessoaDAO daoPessoa;
	
	/**
	 *  Atributos de Tela
	 */
	Pessoa pessoa = new Pessoa();
	//List<Pessoa> listaPessoas;
	private PessoasSelectedDataModel	pessoas;
	
	public PessoasSelectedDataModel getPessoas() {
		return pessoas;
	}

	public void setPessoas(PessoasSelectedDataModel pessoas) {
		this.pessoas = pessoas;
	}
	
	public PrimeFacesMB() {
		pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pPessoa) {
		this.pessoa = pPessoa;
	}
	
	public PessoasSelectedDataModel getListaPessoas() {
		return pessoas;
	}
	
	public void setListaPessoas(PessoasSelectedDataModel pListaPessoas) {
		this.pessoas = pListaPessoas;
	}
	
	public void inserir() {
		// Create a registry at Database
		//this.daoPessoa.insert(this.pessoa);
		this.daoPessoa.update(pessoa);
		
		// Retrieve all registries from Database
		this.pessoas = new PessoasSelectedDataModel( this.daoPessoa.consultarTodasAsPessoasByInjectedEM() );
	}
	
	public void delete(Pessoa pPessoa) {
		this.daoPessoa.deleteObject(pPessoa);
		
		// Retrieve all registries from Database
		this.pessoas = new PessoasSelectedDataModel( this.daoPessoa.consultarTodasAsPessoasByInjectedEM() );
	}
	
}