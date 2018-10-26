package br.edu.unibratec.psc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements EntityInterface {
	
	/**
	 * - Serial Version UID 
	 */
	private static final long serialVersionUID = 2318543695455472804L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cdMatricula;
	
	private String nome;
	
	//@OneToOne(/*cascade=CascadeType.ALL*/)
	//private DadosBasicos	dadosBasicos;
	
	public int getCdMatricula() {
		return cdMatricula;
	}
	
	public void setCdMatricula(int pCdMatricula) {
		this.cdMatricula = pCdMatricula;
	}
	
	/*public DadosBasicos getDadosBasicos() {
		return dadosBasicos;
	}*/
	
	/*public void setDadosBasicos(DadosBasicos pDadosBasicos) {
		this.dadosBasicos = pDadosBasicos;
	}*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdMatricula;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		//result = prime * result + ((dadosBasicos == null) ? 0 : dadosBasicos.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cdMatricula != other.cdMatricula)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		/*if (dadosBasicos == null) {
			if (other.dadosBasicos != null)
				return false;
		} else if (!dadosBasicos.equals(other.dadosBasicos))
			return false;*/
		return true;
	}
	
	public Object getPrimaryKey() {
		return getCdMatricula();
	}
	
}