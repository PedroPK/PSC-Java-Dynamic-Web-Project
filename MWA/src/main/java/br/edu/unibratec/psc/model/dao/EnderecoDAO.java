package br.edu.unibratec.psc.model.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import br.edu.unibratec.psc.model.entity.Endereco;
import br.edu.unibratec.psc.model.entity.Pessoa;

public class EnderecoDAO extends AbstractDAO<Endereco> implements Serializable {
	
	@Inject
	private EntityManager em;
	
}