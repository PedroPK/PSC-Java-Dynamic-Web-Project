package br.edu.unibratec.psc.model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.unibratec.psc.model.dao.EnderecoDAO;

public class EnderecoTest {
	
	private EnderecoDAO aDao;
	
	@Before
	public void instancializarDAO() {
		this.aDao = new EnderecoDAO();
	}
	
	@Test
	public void testarInserirEndereco() {
		// Arranjar
		Endereco endereco = new Endereco();
		endereco.setCEP("51.234-56");
		endereco.setNumero((short) 123);
		endereco.setLogradouro("Av. Dantas Barreto");
		
		// Agir
		aDao.insert(endereco);
		
		Endereco consultado = 
			aDao.selectByEntity(Endereco.class, endereco);
		
		// Assert
		assertNotNull(consultado);
		assertNotSame(endereco, consultado);
		assertEquals(endereco, consultado);
	}
	
}