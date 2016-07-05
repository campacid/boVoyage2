package fr.bovoyage.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public class DossierDAO {
	private EntityManagerFactory emf;

	public DossierDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(List<Integer> idParticipants, int destid, Date dateAller, Date dateRetour) {
		
	}
	
}
