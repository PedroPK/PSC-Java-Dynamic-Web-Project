package br.edu.unibratec.psc.web.jsf;

import javax.faces.bean.ManagedBean;

import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.model.fachada.FachadaRepositorios;

@ManagedBean()
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
		if ( this.pessoa != null ) { 
			System.out.println( this.pessoa.toString() );
			
			FachadaRepositorios repositorios = new FachadaRepositorios();
			repositorios.inserir(pessoa);
			
			Pessoa consultado = repositorios.consultar(pessoa);
			
			System.out.println("Objeto Pessoa inserido é o mesmo que foi Consultado? " + (this.pessoa == consultado));
			System.out.println("Objeto Pessoa inserido é igual que foi Consultado? " + (this.pessoa.equals(consultado)));
			
			System.out.println("Todos os registros de Pessoas: " + repositorios.consultarTodasAsPessoas() );
		}
	}

}