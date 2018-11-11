package br.edu.unibratec.psc.model.dao;

public class ObjetoNuloPersistenciaException extends Exception {
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = 6825806899427202658L;
	
	public ObjetoNuloPersistenciaException() {
		super();
		System.out.println("Um objeto nulo foi passado para ser Persistido!");
	}
	
	public ObjetoNuloPersistenciaException(String pMessage) {
		super(pMessage);
		System.out.println("Um objeto nulo foi passado para ser Persistido, tipo: " + pMessage );
	}
	
} 