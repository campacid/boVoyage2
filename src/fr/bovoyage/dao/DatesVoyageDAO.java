package fr.bovoyage.dao;

import javax.persistence.EntityManagerFactory;

public class DatesVoyageDAO {
private EntityManagerFactory emf;
	
	public DatesVoyageDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
