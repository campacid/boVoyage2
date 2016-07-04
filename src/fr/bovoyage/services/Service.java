package fr.bovoyage.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.bovoyage.dao.ClientDAO;
import fr.bovoyage.dao.DatesVoyageDAO;
import fr.bovoyage.dao.DestinationDAO;
import fr.bovoyage.metier.DatesVoyage;
import fr.bovoyage.metier.Destination;
import fr.bovoyage.metier.dto.DestinationTO;

public class Service {
	private ClientDAO clientDAO;
	private DestinationDAO destinationDAO;
	private DatesVoyageDAO datesVoyagesDAO;
	
	public Service(EntityManagerFactory factory){
		clientDAO = new ClientDAO(factory);
		destinationDAO = new DestinationDAO(factory);
		datesVoyagesDAO = new DatesVoyageDAO(factory);
	}
	
	public List<DestinationTO> getListeDestinations(){
		List<DestinationTO> destinationsTO = new ArrayList<>();
		List<Destination> destinations = new ArrayList<>();
		destinations = destinationDAO.getAllDestinations();
		for(Destination dest:destinations){
			destinationsTO.add(new DestinationTO(dest));
		}
		return destinationsTO;
	}
	
	public List<DatesVoyage> getDatesVoyagesByDestinationId (int destid){
		List<DatesVoyage> datesVoyages = new ArrayList<>();
		datesVoyages = destinationDAO.getDatesVoyageByDestinationId(destid);
		return datesVoyages;
	}
	
	public DestinationTO getDestinationById(int destid){
		DestinationTO destinationTO = new DestinationTO(destinationDAO.getDestinationById(destid));
		return destinationTO;
	}
	
	
}
