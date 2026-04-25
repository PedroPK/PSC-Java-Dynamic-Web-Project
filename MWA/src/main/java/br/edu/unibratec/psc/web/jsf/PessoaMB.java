package br.edu.unibratec.psc.web.jsf;

import java.util.List;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

import br.edu.unibratec.psc.model.entity.Pessoa;
import br.edu.unibratec.psc.model.fachada.FachadaRepositorios;

@Named
@RequestScoped
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
			FachadaRepositorios repositorios = new FachadaRepositorios();
			
			repositorios.inserir(pessoa);
			
			this.listaPessoas = repositorios.consultarTodasAsPessoas();
		}
	}
	
	public void delete(Pessoa pPessoa) {
		FachadaRepositorios repositorios = new FachadaRepositorios();
		
		// Delete Object from Database
		repositorios.delete(pPessoa);
		
		// Retrieve all registries from Database
		this.listaPessoas = repositorios.consultarTodasAsPessoas();
	}
	
	public void delete() {
		FachadaRepositorios repositorios = new FachadaRepositorios();
		
		// Retrieve all registries from Database
		this.listaPessoas = repositorios.consultarTodasAsPessoas();
	}
	
}