package br.edu.unibratec.psc.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.unibratec.psc.model.entity.Autor;

public class AuthorDAO extends AbstractDAO<Autor> implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 9052248264063440017L;
	
	@Inject
	private EntityManager em;
	
	public List<Autor> consultarTodosOsAutors() {
		String querySelect = "Select p From Autor p";
		
		TypedQuery<Autor> typedQuery = 
			UtilJPA.getEntityManager().createQuery(
				querySelect, 
				Autor.class);
		
		List<Autor> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
	public List<Autor> consultarTodasAsAutorsByInjectedEM() {
		String querySelect = "Select p From Autor p";
		
		TypedQuery<Autor> typedQuery = 
			this.em.createQuery(
				querySelect, 
				Autor.class);
		
		List<Autor> resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
}