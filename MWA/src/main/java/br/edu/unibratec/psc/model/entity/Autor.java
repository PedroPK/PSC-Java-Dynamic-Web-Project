package br.edu.unibratec.psc.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.collection.internal.PersistentBag;

@Entity
public class Autor extends Pessoa {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7589964742049284643L;
	
	@ManyToMany(
		mappedBy="authors", 
		cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			
		}
	)
	private List<Livro>		books;
	
	public List<Livro> getBooks() {
		if (	this.books != null && 
				this.books instanceof PersistentBag
		) {
			if ( this.books.isEmpty() ) {
				this.books = null;
			}
		}
		return books;
	}
	
	public void setBooks(List<Livro> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [books=" + books + ", getCdMatricula()=" + getCdMatricula() + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + ", getDataNascimento()=" + getDataNascimento() + ", getEndereco()="
				+ getEndereco() + ", getPrimaryKey()=" + getPrimaryKey() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	@Override
	public void loadLazyAttributes() {
		getBooks();
	}
	
}
