package fr.bovoyage.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public class DossierDAO {
	private EntityManagerFactory emf;

	public DossierDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(List<Integer> idParticipants, int destId, int dateId) {
		
		
	}
	
}
