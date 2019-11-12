package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Endereco;

public class EnderecoDAOTest {
	
	private EnderecoDAO aDao;
	
	@Before
	public void instancializarDAO() {
		this.aDao = new EnderecoDAO();
	}
	
	@Ignore
	@Test
	public void testarAtribuirDadosEndereco() {
		// Arranjar		&&		Agir
		Endereco endereco = new Endereco();
		endereco.setCEP("51.234-56");
		endereco.setNumero((short) 123);
		endereco.setLogradouro("Av. Dantas Barreto");
		
		fail("Incomplete Test");
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
	
	@Test
	public void testarAlteracaoEnderecoPK() {
		// Arrange
		Endereco enderecoInserido = new Endereco();
		enderecoInserido.setCEP("12.345-67");
		enderecoInserido.setNumero((short) 90);
		enderecoInserido.setLogradouro("Conde da Boa Vista");
		
		// Act
		aDao.insert(enderecoInserido);
		
		Endereco alterado = 
			aDao.selectByEntity(
				Endereco.class, 
				enderecoInserido);
		
		// Alterando um dos Atributos que comp�e a PK do Endere�o
		alterado.setNumero((short) 91);
		
		aDao.update(alterado);
		
		Endereco consultadoInserido = 
			aDao.selectByEntity(
				Endereco.class, 
				enderecoInserido);
		
		Endereco consultadoAlterado = 
				aDao.selectByEntity(
					Endereco.class, 
					enderecoInserido);
		
		// Assert
		assertNotNull(consultadoInserido);		// The original persisted Registry still exists
		assertNotNull(alterado);				// A new Registry, with the changed Primary Key, is created.
		
		assertNotSame(enderecoInserido,	consultadoInserido);
		assertEquals(alterado,			consultadoAlterado);
		
	}
	
}