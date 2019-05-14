package br.edu.unibratec.psc.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.unibratec.psc.model.entity.Livro;

public class LivroDAO extends AbstractDAO<Livro> implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2528127357177262002L;
	
	@Inject
	private EntityManager em;
	
	public List<Livro> consultarTodasAsLivros() {
		String querySelect = "Select p From Livro p";
		
		TypedQuery<Livro> typedQuery = 
			UtilJPA.getEntityManager().createQuery(
				querySelect, 
				Livro.class);
		
		List<Livro> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
	public List<Livro> consultarTodasAsLivrosByInjectedEM() {
		String querySelect = "Select p From Livro p";
		
		TypedQuery<Livro> typedQuery = 
			this.em.createQuery(
				querySelect, 
				Livro.class);
		
		List<Livro> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
}