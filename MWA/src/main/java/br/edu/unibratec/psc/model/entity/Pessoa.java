package br.edu.unibratec.psc.model.entity;

import java.util.Date;

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
	
	private String	nome;
	private String	cpf;
	private Date	dataNascimento;
	
	public int getCdMatricula() {
		return cdMatricula;
	}
	
	public void setCdMatricula(int pCdMatricula) {
		this.cdMatricula = pCdMatricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdMatricula;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public Object getPrimaryKey() {
		return getCdMatricula();
	}
	
	@Override
	public String toString() {
		return "Pessoa [cdMatricula="	+ cdMatricula + 
				", nome="				+ nome + 
				", cpf="				+ cpf + 
				", dataNascimento="		+ dataNascimento + "]";
	}
	
}