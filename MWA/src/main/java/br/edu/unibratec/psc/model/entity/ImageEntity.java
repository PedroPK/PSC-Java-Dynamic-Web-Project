package br.edu.unibratec.psc.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
public class ImageEntity implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5664172794165383837L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private		Integer		id;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private		byte[]		photoImage;
	
	//public Image
	
	@Override
	public Object getPrimaryKey() {
		return getId();
	}

	@Override
	public void loadLazyAttributes() {
		byte[] image = getPhotoImage();
	}
	
}