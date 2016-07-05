package fr.bovoyage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.bovoyage.metier.Dossier;
import fr.bovoyage.metier.Participant;

public class DossierDAO {
	private EntityManagerFactory emf;

	public DossierDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(int destId, int dateId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		Dossier dossier = new Dossier(destId,dateId);
		tr.begin();
		em.persist(dossier);
		tr.commit();
		em.close();		
	}
	
}
