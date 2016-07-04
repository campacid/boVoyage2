package fr.bovoyage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.bovoyage.metier.Participant;

public class ParticipantDAO {
	private EntityManagerFactory emf;

	public ParticipantDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(Participant participant){
		EntityManager em = emf.createEntityManager();
		em.persist(participant);
		em.close();
	}

	public void delete(Participant participant) {
		EntityManager em = emf.createEntityManager();
		Participant part = em.find(Participant.class, participant.getId());
		em.remove(part);
		em.close();
	}

}
