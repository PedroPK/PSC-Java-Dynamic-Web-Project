package br.edu.unibratec.psc.web.jsf;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unibratec.psc.model.entity.Pessoa;

@Named("namedMB")
@RequestScoped
public class NamedMB implements Serializable {
	
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
		System.out.println( this.pessoa.getNome() );
	}
	
}