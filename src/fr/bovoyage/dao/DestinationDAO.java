package fr.bovoyage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.bovoyage.metier.DatesVoyage;
import fr.bovoyage.metier.Destination;

public class DestinationDAO {
	private EntityManagerFactory emf;

	public DestinationDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@SuppressWarnings("unchecked") // suppression du warning sur le typage du
									// retour de em.getResultList();
	public List<Destination> getAllDestinations() {
		EntityManager em = emf.createEntityManager();
		List<Destination> destinations = em.createQuery("from Destination").getResultList();
		em.close();
		return destinations;
	}

	public List<DatesVoyage> getDatesVoyageByDestinationId(int id) {
		List<DatesVoyage> datesVoyages = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Destination d = em.find(Destination.class, id);
		for (DatesVoyage dv : d.getDatesVoyages()) {
			datesVoyages.add(dv);
		}
		em.close();
		return datesVoyages;
	}
	
	public Destination getDestinationById(int destid){
		EntityManager em = emf.createEntityManager();
		Destination dest = em.find(Destination.class, destid);
		return dest;
	}
}
