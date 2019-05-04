package br.edu.unibratec.psc.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EnderecoPK implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6539444810312647971L;
	
	private String	aCEP;
	private Short	aNumero;
	
	public EnderecoPK() {}

	public String getCEP() {
		return aCEP;
	}
	
	public void setCEP(String aCEP) {
		this.aCEP = aCEP;
	}

	public Short getNumero() {
		return aNumero;
	}

	public void setNumero(Short aNumero) {
		this.aNumero = aNumero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aCEP == null) ? 0 : aCEP.hashCode());
		result = prime * result + ((aNumero == null) ? 0 : aNumero.hashCode());
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
		EnderecoPK other = (EnderecoPK) obj;
		if (aCEP == null) {
			if (other.aCEP != null)
				return false;
		} else if (!aCEP.equals(other.aCEP))
			return false;
		if (aNumero == null) {
			if (other.aNumero != null)
				return false;
		} else if (!aNumero.equals(other.aNumero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnderecoPK [CEP=" + aCEP + ", Numero=" + aNumero + "]";
	}
	
}
