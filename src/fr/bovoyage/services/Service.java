package fr.bovoyage.services;

import javax.persistence.EntityManagerFactory;

import fr.bovoyage.dao.ClientDAO;
import fr.bovoyage.dao.DatesVoyageDAO;
import fr.bovoyage.dao.DestinationDAO;

public class Service {
	private ClientDAO clientDAO;
	private DestinationDAO destinationDAO;
	private DatesVoyageDAO datesVoyagesDAO;
	
	public Service(EntityManagerFactory factory){
		clientDAO = new ClientDAO(factory);
		destinationDAO = new DestinationDAO(factory);
		datesVoyagesDAO = new DatesVoyageDAO(factory);
	}
	
}
