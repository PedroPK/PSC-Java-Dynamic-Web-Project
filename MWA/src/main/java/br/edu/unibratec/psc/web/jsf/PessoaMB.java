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
			FachadaRepositorios repositorios = new FachadaRepositorios();
			
			repositorios.inserir(pessoa);
			
			this.listaPessoas = repositorios.consultarTodasAsPessoas();
		}
	}
	
}