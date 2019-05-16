package br.edu.unibratec.psc.model.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.unibratec.psc.model.entity.Autor;
import br.edu.unibratec.psc.model.entity.Livro;

public class LivroDAOTest {
	
	private LivroDAO dao;
	
	@Before
	public void initDAO() {
		this.dao = new LivroDAO();
	}
	
	@Ignore
	@Test
	public void testConsultarTodasAsLivros() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testConsultarTodasAsLivrosByInjectedEM() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsertT() {
		/* 
		 * Arrange
		 */
		Livro livro = new Livro();
		livro.setIsbn("978-85-5519-115-2");
		livro.setPages((short) 332);
		
		Autor autor = new Autor();
		autor.setCpf("123.456.789-01");
		autor.setNome("Alberto Souza");
		
		livro.addAutor(autor);
		
		
		// Act
		this.dao.insert(livro);
		
		EntityManager em = this.dao.getEntityManager();
		Livro selectedBook = 
			this.dao.selectByEntity(
				Livro.class, 
				livro, em, 
				false, 
				true);
		selectedBook.getAuthors();
		selectedBook.getGeneros();
		em.close();
		
		// Assert
		assertNotNull(selectedBook);
		assertNotSame(selectedBook, livro);
		assertEquals(selectedBook, livro);
	}

}
