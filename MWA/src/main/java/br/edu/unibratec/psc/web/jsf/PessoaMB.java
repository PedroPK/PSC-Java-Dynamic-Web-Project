package br.edu.unibratec.psc.web.jsf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.model.fachada.FachadaRepositorios;

@ManagedBean()
public class PessoaMB {
	
	Pessoa pessoa = new Pessoa();
	
	List<Pessoa> listaPessoas;
	
	public PessoaMB() {}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}
	
	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	public void inserir() {
		if ( this.pessoa != null ) { 
			System.out.println( this.pessoa.toString() );
			
			FachadaRepositorios repositorios = new FachadaRepositorios();
			repositorios.inserir(pessoa);
			
			Pessoa consultado = repositorios.consultar(pessoa);
			
			System.out.println("Objeto Pessoa inserido é o mesmo que foi Consultado? " + (this.pessoa == consultado));
			System.out.println("Objeto Pessoa inserido é igual que foi Consultado? " + (this.pessoa.equals(consultado)));
			
			this.listaPessoas = repositorios.consultarTodasAsPessoas();
			Iterator<Pessoa> iterator = this.listaPessoas.iterator();
			
			System.out.println("Todos os registros de Pessoas.");
			do {
				int contador = 1;
				System.out.println("Pessoa " + contador + ": " + iterator.next().toString());
			}
			while ( iterator.hasNext() );
		}
	}

}