package fr.ensicaen.tennis;

import fr.ensicaen.tennis.persistence.Database;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class ServletContextManager implements ServletContextListener {

	public static final String DATABASE_OBJECT = "DatabaseObject";

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		System.out.println("DEMARRAGE "+ApplicationProperties.get("application_name"));
		context.setAttribute(DATABASE_OBJECT, Database.getInstance());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ARRET "+ApplicationProperties.get("application_name"));
		ServletContext context = servletContextEvent.getServletContext();
		Database d = (Database)context.getAttribute(DATABASE_OBJECT);
		if (d != null) d.close();

		// Now deregister JDBC drivers in this context's ClassLoader:
		// Get the webapp's ClassLoader
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		// Loop through all drivers
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				// This driver was registered by the webapp's ClassLoader, so deregister it:
				try {
					System.out.println("Deregistering JDBC driver (" + driver + ")");
					DriverManager.deregisterDriver(driver);
				} catch (SQLException ex) {
					System.out.println("Error deregistering JDBC driver (" + ex + ")");
				}
			} else {
				// driver was not registered by the webapp's ClassLoader and may be in use elsewhere
				System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader" + driver);
			}
		}
	}
}
