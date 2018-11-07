package br.edu.unibratec.psc.model.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoaDAO extends AbstractDAO<Pessoa> {
	
	@Inject
	private EntityManager em;
	
	public List<Pessoa> consultarTodasAsPessoas() {
		String querySelect = "Select p From Pessoa p";
		
		TypedQuery<Pessoa> typedQuery = 
			UtilJPA.getEntityManager().createQuery(
				querySelect, 
				Pessoa.class);
		
		List<Pessoa> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
	public List<Pessoa> consultarTodasAsPessoasByInjectedEM() {
		String querySelect = "Select p From Pessoa p";
		
		TypedQuery<Pessoa> typedQuery = 
			this.em.createQuery(
				querySelect, 
				Pessoa.class);
		
		List<Pessoa> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
}