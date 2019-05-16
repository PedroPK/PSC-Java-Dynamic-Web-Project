package br.edu.unibratec.psc.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements EntityInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7739129857761202984L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int			cdMatricula;
	
	private String		nome;
	private String		cpf;
	private Date		dataNascimento;
	
	private Endereco	endereco;
	
	private String uuid;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Pessoa(String nome, String cpf, String pDtNascimentoString) throws ParseException {
		super();
		this.nome = nome;
		this.cpf = cpf;
		setDataNascimento(pDtNascimentoString);
	}
	
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
	
	public void setDataNascimento(String pDaNascimentoString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dataNascimento = sdf.parse(pDaNascimentoString);
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String pUuid) {
		this.uuid = pUuid;
	}
	
	/**
	 * This method  will generate an Randon and Unique UUID to let REST requisition to access this Object
	 */
	@PrePersist
	public void createrUUID() {
		this.uuid = UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdMatricula;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
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
		
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
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
				", dataNascimento="		+ dataNascimento +
				", endereco="			+ endereco +
			"]";
	}

	@Override
	public void loadLazyAttributes() {
		// TODO Auto-generated method stub
		
	}
	
}