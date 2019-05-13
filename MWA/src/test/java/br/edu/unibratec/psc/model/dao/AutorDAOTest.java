package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Autor;

public class AutorDAOTest {
	
	private AutorDAO dao;
	
	@Before
	public void initDAO() {
		this.dao = new AutorDAO();
	}
	
	@Test
	public void testConsultarTodosOsAutors() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarTodasAsAutorsByInjectedEM() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertAutor() {
		// Arrange
		Autor autor = new Autor();
		autor.setCpf("123.456.789-01");
		autor.setNome("Alberto Souza");
		
		// Act
		EntityManager em = this.dao.getEntityManager();
		this.dao.insert(autor, em, false);
		Autor selectedAutor = this.dao.selectByEntity(Autor.class, autor, em, false);
		
		// Assert
		assertNotNull(selectedAutor);
		//assertNotSame(selectedAutor, autor);
		assertEquals(autor, selectedAutor);
		
		em.close();
	}

}
