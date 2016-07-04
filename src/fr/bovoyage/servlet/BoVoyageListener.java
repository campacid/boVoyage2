package fr.bovoyage.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.bovoyage.services.Service;

/**
 * Application Lifecycle Listener implementation class BoVoyageListener
 *
 */
@WebListener
public class BoVoyageListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BoVoyageListener() {
       
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         Service service = (Service) event.getServletContext().getAttribute("service");
         service.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
        Service service = new Service();
        event.getServletContext().setAttribute("service", service);
    }
	
}
