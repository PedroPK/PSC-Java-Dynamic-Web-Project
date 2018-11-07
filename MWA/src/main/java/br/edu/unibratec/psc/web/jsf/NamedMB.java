package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unibratec.psc.model.dao.PessoaDAO;
import br.edu.unibratec.psc.model.entity.Pessoa;

@Named("namedMB")
@RequestScoped
public class NamedMB implements Serializable {
	
	@Inject
	private PessoaDAO daoPessoa;
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1772316099848213676L;
	
	Pessoa pessoa = new Pessoa();
	String nome = "";
	
	public NamedMB() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void inserir() {
		System.out.println( "Named: " + this.pessoa.getNome() );
		
		this.daoPessoa.insert(this.pessoa);
		List<Pessoa> listaPessoas = this.daoPessoa.consultarTodasAsPessoasByInjectedEM();
		System.out.println(listaPessoas.toString());
	}
	
}