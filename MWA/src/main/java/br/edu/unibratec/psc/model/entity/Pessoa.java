package br.edu.unibratec.psc.model.entity;

import static br.edu.unibratec.psc.util.Constants.DATE_PATTERN;
import static br.edu.unibratec.psc.util.UtilMethods.getDateFromLocalDate;
import static br.edu.unibratec.psc.util.UtilMethods.isStringValid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode		@ToString(exclude="dataNascimento")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements EntityInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7739129857761202984L;
	
	@Getter		@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int			cdMatricula;
	
	@Getter		@Setter
	private String		nome;
	
	@Getter		@Setter
	private String		cpf;
	
	@JsonbDateFormat(value=DATE_PATTERN)
	private LocalDate		dataNascimento;
	
	private String		birthdateString;
	
	@Getter		@Setter
	private Endereco	endereco;
	
	@Getter		@Setter
	private String uuid;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
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
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimentoToString() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String dtNascimentoString = sdf.format(dataNascimento);
		return dtNascimentoString;
	}
	
	public void setDataNascimento(String pDtNascimentoString) throws ParseException {
		if ( isStringValid(pDtNascimentoString) && pDtNascimentoString.length() == 10 ) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
			
			int day		=	Integer.parseInt(pDtNascimentoString.substring(0, 2));
			int month	=	Integer.parseInt(pDtNascimentoString.substring(3, 5));
			int year	=	Integer.parseInt(pDtNascimentoString.substring(6, 10));
			
			this.dataNascimento =
				LocalDate.of(year, month, day)
			;
			//this.dataNascimento = sdf.parse(pDtNascimentoString);
		}
	}
	
	/**
	 * This method  will generate an Randon and Unique UUID to let REST requisition to access this Object
	 */
	@PrePersist
	public void createrUUID() {
		this.uuid = UUID.randomUUID().toString();
	}
	
	public Object getPrimaryKey() {
		return getCdMatricula();
	}
	
	@Override
	public void loadLazyAttributes() {
		// TODO Auto-generated method stub
		
	}
	
	public String getBirthdateString() {
		return birthdateString;
	}
	
	public void setBirthdateString(String pBirthdateString) {
		if ( isStringValid(pBirthdateString) ) {
			
		}
		this.birthdateString = pBirthdateString;
	}
	
}