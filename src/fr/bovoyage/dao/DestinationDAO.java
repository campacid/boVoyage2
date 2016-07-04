package fr.bovoyage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.bovoyage.metier.Destination;

public class DestinationDAO {
private EntityManagerFactory emf;
	
	public DestinationDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Destination> getAllDestinations(){
		EntityManager em = emf.createEntityManager();
		List<Destination> destinations = em.createQuery("from Destination").getResultList();
		em.close();
		return destinations;
	}
}
