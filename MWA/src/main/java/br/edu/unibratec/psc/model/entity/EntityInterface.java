package br.edu.unibratec.psc.model.entity;

import java.io.Serializable;

public interface EntityInterface extends Serializable {
	
	public Object getPrimaryKey();
	
	public void loadLazyAttributes();
	
}
