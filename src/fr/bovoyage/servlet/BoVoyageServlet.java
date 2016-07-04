package fr.bovoyage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.bovoyage.metier.dto.DestinationTO;
import fr.bovoyage.services.Service;

/**
 * Servlet implementation class BoVoyageServlet
 */
@WebServlet("/BoVoyageServlet")
public class BoVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = (Service) getServletContext().getAttribute("service");
		List<DestinationTO> destinations = service.getListeDestinations();
		request.setAttribute("destinations", destinations);
		
		String target = request.getParameter("target");
		if(target==null){
			target = "index";
		}
		
		String page=null;
		switch(target){
		
		case "index":
			page="/index.jsp";
			break;
			
		case "detail":
			int id = Integer.parseInt(request.getParameter("id"));
			DestinationTO dest = service.getDestinationById(id);
			request.setAttribute("destination", dest );
			page="/DescriptionVoyage.jsp";
			break;
			
		}
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
