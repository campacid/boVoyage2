package fr.bovoyage.dao;

import javax.persistence.EntityManagerFactory;

public class ClientDAO {
private EntityManagerFactory emf;
	
	public ClientDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
