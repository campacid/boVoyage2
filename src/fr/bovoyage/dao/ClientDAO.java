package fr.bovoyage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.bovoyage.metier.Client;
import fr.bovoyage.metier.Participant;

public class ClientDAO {
private EntityManagerFactory emf;
	
	public ClientDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	public void save(Client client){
		EntityManager em = emf.createEntityManager();
		em.persist(client);
		em.close();
	}
	
	public void delete(Client client) {
		EntityManager em = emf.createEntityManager();
		Participant cli = em.find(Participant.class, client.getId());
		em.remove(cli);
		em.close();
	}
	
	public Client getClientById(int idClient){
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, idClient);
		em.close();
		return client;
	}
}
