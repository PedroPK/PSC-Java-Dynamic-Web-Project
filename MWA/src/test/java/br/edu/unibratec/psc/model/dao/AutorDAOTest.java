package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.*;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Autor;
import br.edu.unibratec.psc.model.entity.Livro;

public class AutorDAOTest {
	
	private AutorDAO dao;
	
	@Before
	public void initDAO() {
		this.dao = new AutorDAO();
	}
	
	@Ignore
	@Test
	public void testConsultarTodosOsAutors() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testConsultarTodasAsAutorsByInjectedEM() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsertAutor() {
		/*
		 *  Arrange
		 */
		Autor autor = new Autor();
		autor.setCpf("123.456.789-01");
		autor.setNome("Alberto Souza");
		
		/*
		 *  Act
		 */
		this.dao.insert(autor);
		
		// Select the Inserted registry
		EntityManager em = this.dao.getEntityManager();
		Autor selectedAutor = this.dao.selectByEntity(Autor.class, autor, em, false);
		List<Livro> books = selectedAutor.getBooks();
		em.close();
		
		/*
		 *  Assert
		 */
		assertNotNull(selectedAutor);
		assertNotSame(selectedAutor, autor);
		assertEquals(autor, selectedAutor);
	}
	
}
