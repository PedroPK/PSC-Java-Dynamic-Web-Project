package br.edu.unibratec.psc.web.jsf;

import javax.faces.bean.ManagedBean;

import br.edu.unibratec.psc.model.entity.Pessoa;

@ManagedBean
public class PessoaMB {
	
	Pessoa pessoa = new Pessoa();
	String nome = "";
	
	public PessoaMB() {}

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