package br.edu.unibratec.psc.util;

import java.util.List;

public class UtilMethods {
	
	public static boolean isListValid(List<?> pList) {
		return 
			pList != null			&& 
			!pList.isEmpty();
	}
	
}