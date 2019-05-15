package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
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
	
	/**
	 *  Atributos de Tela
	 */
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> listaPessoas;
	
	private HtmlDataTable htmlDataTable;
	
	
	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}
	
	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}
	
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
	
	public String index() {
		return "index";
	}
	
	/**
	 * Use this repository as Example:
	 *  - https://github.com/alura-cursos/java-ee-webapp-2/
	 */
	
}