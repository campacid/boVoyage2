package fr.bovoyage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bovoyage.metier.DatesVoyage;
import fr.bovoyage.metier.Participant;
import fr.bovoyage.metier.dto.DestinationTO;
import fr.bovoyage.services.Service;

/**
 * Servlet implementation class BoVoyageServlet
 */
@WebServlet("/BoVoyageServlet")
public class BoVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = (Service) getServletContext().getAttribute("service");
		List<DestinationTO> destinations = service.getListeDestinations();
		request.setAttribute("destinations", destinations);

		String target = request.getParameter("target");
		if (target == null) {
			target = "index";
		}

		String page = null;
		switch (target) {

		case "index":
			page = "/index.jsp";
			break;

		case "detail":
			int id = Integer.parseInt(request.getParameter("id"));
			request.getSession().setAttribute("destId", id);
			DestinationTO dest = service.getDestinationById(id);
			List<DatesVoyage> datesVoyages = service.getDatesVoyagesByDestinationId(dest.getId());
			request.setAttribute("datesVoyages", datesVoyages);
			request.setAttribute("destination", dest);
			page = "/DescriptionVoyage.jsp";
			break;
		case "formulaire":
			int nbParticipants = Integer.parseInt(request.getParameter("nbParticipants"));
			@SuppressWarnings("unchecked")
			List<Participant> participants = (List<Participant>) request.getSession().getAttribute("participants");
			int nbFormulaire = --nbParticipants;
			request.setAttribute("nbParticipants", nbParticipants);
			String isFirst = request.getParameter("isFirst");

		//	int dateId = Integer.parseInt(request.getParameter("dateId"));
		//	request.setAttribute("dateId", dateId);
			if (isFirst != null && isFirst.equals("true")) {
				page = "/Formulaire.jsp";
			} else {
				if (nbFormulaire != -1) {
					page = "/Formulaire.jsp";

					String civ = request.getParameter("civilite");
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					String dateNaissance = request.getParameter("dateDeNaissance");
					String emailParticipant = request.getParameter("emailParticipant");

					if (participants == null) {
						participants = new ArrayList<>();
					}
					participants.add(new Participant(civ, nom, prenom, emailParticipant, dateNaissance));

					request.getSession().setAttribute("participants", participants);
				} else {
					String civ = request.getParameter("civilite");
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					String dateNaissance = request.getParameter("dateDeNaissance");
					String emailParticipant = request.getParameter("emailParticipant");

					if (participants == null) {
						participants = new ArrayList<>();
					}
					participants.add(new Participant(civ, nom, prenom, emailParticipant, dateNaissance));
					page = "/ValidationVoyage.jsp";
					service.sauvegarderDossier(participants, (Integer) request.getSession().getAttribute("destId"),0);
				}
			}
			break;

		}

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
