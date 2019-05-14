package br.edu.unibratec.psc.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.edu.unibratec.psc.model.entity.enums.Genero;

@Entity
public class Livro implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3433794759021576008L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int				id;
	
	private String			isbn;
	private String			name;
	private short			pages;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass=Genero.class)
	private List<Genero>	generos;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Autor>		authors;
	
	private BigDecimal		valor;
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Genero> getGeneros() {
		return generos;
	}
	
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	public List<Autor> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<Autor> authors) {
		this.authors = authors;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public short getPages() {
		return pages;
	}
	
	public void setPages(short pages) {
		this.pages = pages;
	}
	
	@Override
	public Object getPrimaryKey() {
		return getId();
	}
	
	public void addAutor( Autor pAutor ) {
		if ( this.authors == null ) {
			this.authors = new ArrayList<Autor>();
		}
		
		if ( !this.authors.contains(pAutor) ) {
			this.authors.add(pAutor);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((generos == null) ? 0 : generos.hashCode());
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pages;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (generos == null) {
			if (other.generos != null)
				return false;
		} else if (!generos.equals(other.generos))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages != other.pages)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Livro [id=" + id + ", isbn=" + isbn + ", name=" + name + ", pages=" + pages + ", generos=" + generos
				+ ", authors=" + authors + ", valor=" + valor + "]";
	}
	
	@Override
	public void loadLazyAttributes() {
		getAuthors();
		getGeneros();
	}
	
}
