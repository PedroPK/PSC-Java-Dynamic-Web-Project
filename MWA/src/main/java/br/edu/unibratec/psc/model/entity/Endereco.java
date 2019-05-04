package br.edu.unibratec.psc.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Endereco implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4641149132328126273L;

	@EmbeddedId
	private EnderecoPK	aEndereco;
	
	private String		aLogradouro;
	private String		aBairro;
	private String		aCidade;
	private String		aEstado;
	private String		aPais;
	
	public Endereco() {}
	
	public String getCEP() {
		return aEndereco.getCEP();
	}
	
	public void setCEP(String aCEP) {
		instancializarEnderecoPKseNecessario();
		
		this.aEndereco.setCEP(aCEP);
	}

	private void instancializarEnderecoPKseNecessario() {
		if ( this.aEndereco == null ) {
			this.aEndereco = new EnderecoPK();
		}
	}

	public Short getNumero() {
		return this.aEndereco.getNumero();
	}

	public void setNumero(Short aNumero) {
		instancializarEnderecoPKseNecessario();
		
		this.aEndereco.setNumero(aNumero);
	}
	
	/*public EnderecoPK getEndereco() {
		return aEndereco;
	}

	public void setEndereco(EnderecoPK endereco) {
		this.aEndereco = endereco;
	}*/

	public String getLogradouro() {
		return aLogradouro;
	}

	public void setLogradouro(String logradouro) {
		this.aLogradouro = logradouro;
	}

	public String getBairro() {
		return aBairro;
	}

	public void setBairro(String bairro) {
		this.aBairro = bairro;
	}

	public String getCidade() {
		return aCidade;
	}

	public void setCidade(String cidade) {
		this.aCidade = cidade;
	}

	public String getEstado() {
		return aEstado;
	}

	public void setEstado(String estado) {
		this.aEstado = estado;
	}

	public String getPais() {
		return aPais;
	}

	public void setPais(String pais) {
		this.aPais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aBairro == null) ? 0 : aBairro.hashCode());
		result = prime * result + ((aCidade == null) ? 0 : aCidade.hashCode());
		result = prime * result + ((aEndereco == null) ? 0 : aEndereco.hashCode());
		result = prime * result + ((aEstado == null) ? 0 : aEstado.hashCode());
		result = prime * result + ((aLogradouro == null) ? 0 : aLogradouro.hashCode());
		result = prime * result + ((aPais == null) ? 0 : aPais.hashCode());
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
		Endereco other = (Endereco) obj;
		if (aBairro == null) {
			if (other.aBairro != null)
				return false;
		} else if (!aBairro.equals(other.aBairro))
			return false;
		if (aCidade == null) {
			if (other.aCidade != null)
				return false;
		} else if (!aCidade.equals(other.aCidade))
			return false;
		if (aEndereco == null) {
			if (other.aEndereco != null)
				return false;
		} else if (!aEndereco.equals(other.aEndereco))
			return false;
		if (aEstado == null) {
			if (other.aEstado != null)
				return false;
		} else if (!aEstado.equals(other.aEstado))
			return false;
		if (aLogradouro == null) {
			if (other.aLogradouro != null)
				return false;
		} else if (!aLogradouro.equals(other.aLogradouro))
			return false;
		if (aPais == null) {
			if (other.aPais != null)
				return false;
		} else if (!aPais.equals(other.aPais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnderecoPKComposta [endereco=" + aEndereco + ", logradouro=" + aLogradouro + ", bairro=" + aBairro
				+ ", cidade=" + aCidade + ", estado=" + aEstado + ", pais=" + aPais + "]";
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return this.aEndereco;
	}
	
}
