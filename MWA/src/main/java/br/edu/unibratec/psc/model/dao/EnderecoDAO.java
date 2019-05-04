package br.edu.unibratec.psc.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.unibratec.psc.model.entity.Endereco;
import br.edu.unibratec.psc.model.entity.Pessoa;

public class EnderecoDAO extends AbstractDAO<Endereco> implements Serializable {
	
	@Inject
	private EntityManager em;
	
}