package fr.bovoyage.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.bovoyage.dao.ClientDAO;
import fr.bovoyage.dao.DatesVoyageDAO;
import fr.bovoyage.dao.DestinationDAO;
import fr.bovoyage.dao.ParticipantDAO;
import fr.bovoyage.dao.DossierDAO;
import fr.bovoyage.metier.Client;
import fr.bovoyage.metier.DatesVoyage;
import fr.bovoyage.metier.Destination;
import fr.bovoyage.metier.Participant;
import fr.bovoyage.metier.dto.DestinationTO;

public class Service {
	private EntityManagerFactory factory;
	private ClientDAO clientDAO;
	private DestinationDAO destinationDAO;
	private ParticipantDAO participantDAO;
	private DossierDAO dossierDAO;
	
	public Service() {
		factory = Persistence.createEntityManagerFactory("bovoyages");
		clientDAO = new ClientDAO(factory);
		destinationDAO = new DestinationDAO(factory);
		participantDAO = new ParticipantDAO(factory);
		dossierDAO = new DossierDAO(factory);
	}

	public void close() {
		factory.close();
	}

	// méthodes liées aux destinations
	// //////////////////////////////////////////////

	public List<DestinationTO> getListeDestinations() {
		List<DestinationTO> destinationsTO = new ArrayList<>();
		List<Destination> destinations = new ArrayList<>();
		destinations = destinationDAO.getAllDestinations();
		for (Destination dest : destinations) {
			destinationsTO.add(new DestinationTO(dest));
		}
		return destinationsTO;
	}

	public List<DatesVoyage> getDatesVoyagesByDestinationId(int destid) {
		List<DatesVoyage> datesVoyages = new ArrayList<>();
		datesVoyages = destinationDAO.getDatesVoyageByDestinationId(destid);
		return datesVoyages;
	}

	public DestinationTO getDestinationById(int destid) {
		DestinationTO destinationTO = new DestinationTO(destinationDAO.getDestinationById(destid));
		return destinationTO;
	}

	// méthodes liées aux Participants
	// //////////////////////////////////////////////
	public void saveParticipant(Participant participant) {
		participantDAO.save(participant);
	}

	public void deleteParticipant(Participant participant) {
		participantDAO.delete(participant);
	}

	// méthodes liées aux Clients //////////////////////////////////////////////
	public void saveClient(Client client) {
		clientDAO.save(client);
	}

	public void deleteClient(Client client) {
		clientDAO.delete(client);
	}

	public void sauvegarderDossier(List<Participant> participants, int destid, Date dateAller, Date dateRetour) {
		List<Integer> idParticipants = new ArrayList<>();
		for (Participant participant : participants) {
			participantDAO.save(participant);
			idParticipants.add(new Integer(participant.getId()));
		}
		dossierDAO.save(idParticipants,destid,dateAller,dateRetour);
	}

}
