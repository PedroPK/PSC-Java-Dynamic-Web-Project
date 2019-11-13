package br.edu.unibratec.psc.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

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