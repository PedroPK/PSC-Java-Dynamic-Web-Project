package br.edu.unibratec.psc.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
	private static EntityManagerFactory emfPSC;
	private static EntityManagerFactory emfH2;
	
	public static void createEntityManagerFactoryPSC() {
		if ( emfPSC == null ) {
			emfPSC = Persistence.createEntityManagerFactory(PersistUnits.psc.toString());
		}
	}
	
	public static void createEntityManagerFactoryH2() {
		if ( emfH2 == null ) {
			String persistenceUnitName = PersistUnits.h2.toString();
			System.out.println(persistenceUnitName);
			emfH2 = Persistence.createEntityManagerFactory(persistenceUnitName);
		}
	}
	
	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		return getEntityManager(PersistUnits.h2);
	}
	
	public static EntityManager getEntityManager(PersistUnits pPU) {
		EntityManagerFactory emf = null;
		if ( pPU.equals(PersistUnits.psc) ) {
			if ( emfPSC == null ) {
				createEntityManagerFactoryPSC();
			}
			emf = emfPSC;
		} else {
			if ( pPU.equals(PersistUnits.h2) ) {
				if ( emfH2 == null ) {
					createEntityManagerFactoryH2();
				}
				emf = emfH2;
			}
		}
		
		return emf.createEntityManager();
	}
	
	public static void closeEntityManager(
		EntityManager	pEM,
		boolean			pFecharEntityManager
	) {
		if ( pEM != null && pFecharEntityManager ) {
			pEM.close();
		}
	}
	
	public static void closeEntityManager(
		EntityManager pEM
	) {
		if ( pEM != null ) {
			pEM.close();
		}
	}
	
	public static void closeEntityManagerFactory() {
		if ( emfPSC != null ) {
			emfPSC.close();
		}
		if ( emfH2 != null ) {
			emfH2.close();
		}
	}
	
}