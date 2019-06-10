package br.edu.unibratec.psc.util;

import java.util.ArrayList;
import java.util.List;

public class VarArgsExperiments<T> {
	
	public static <T> T[] unsafe(T... elements) {
		// Potencial heap pollution via VarArgs parameter elements
		return elements;
	}
	
	public static <T> T[] broken (T seed) {
		T[] plant = unsafe(seed, seed, seed);
		
		return plant;
	}
	
	public static String[] plant() {
		String[] plants = (String[]) broken("seed");
		
		return plants;
	}
	
	private List<T> versions = new ArrayList<>(); 
	
	@SafeVarargs
	public final void safe(T... toAdd) {
		for ( T version: toAdd ) {
			versions.add(version);
		}
	}

	@Override
	public String toString() {
		String toString = "VarArgsExperiments [";
		
		if ( this.versions != null ) {
			toString = toString + "versions=" + versions;
		}
		
		toString = toString  + "]";
		
		return toString;
	}
	
	
	
}