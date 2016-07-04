package fr.bovoyage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.bovoyage.metier.DatesVoyage;

public class DatesVoyageDAO {
private EntityManagerFactory emf;
	
	public DatesVoyageDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@SuppressWarnings("unchecked") // suppression du warning sur le typage du retour de em.getResultList();
	public List<DatesVoyage> getDatesVoyagesByDestinationId(int destid) {
		List<DatesVoyage> datesVoyages = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("DatesVoyage.getByDestinationId");
		query.setParameter("destid", destid);
		datesVoyages = query.getResultList();
		em.close();
		return datesVoyages;
	}
	
}
