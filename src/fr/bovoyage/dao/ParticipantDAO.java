package fr.bovoyage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.bovoyage.metier.Participant;

public class ParticipantDAO {
	private EntityManagerFactory emf;

	public ParticipantDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(Participant participant){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(participant);
		tr.commit();
		em.close();
	}

	public void delete(Participant participant) {
		EntityManager em = emf.createEntityManager();
		Participant part = em.find(Participant.class, participant.getId());
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.remove(part);
		tr.commit();
		em.close();
	}

}
