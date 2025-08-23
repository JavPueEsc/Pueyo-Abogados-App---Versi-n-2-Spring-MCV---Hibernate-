package com.jpueyodev;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * Libera correctamente recursos JDBC al parar/recargar la app:
 *  1) Apaga el hilo de limpieza de MySQL (AbandonedConnectionCleanupThread).
 *  2) Des-registra los drivers JDBC cargados por el classloader de la webapp.
 *
 * Nota: si usas web.xml con metadata-complete="true", registra este listener en web.xml
 * en lugar de @WebListener.
 */
@WebListener
public class CleanupListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 1) Apagar el hilo del conector MySQL
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } catch (Throwable t) {
            // opcional: log.warn("Error apagando AbandonedConnectionCleanupThread", t);
        }

        // 2) Des-registrar drivers JDBC pertenecientes a este classloader
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver d = drivers.nextElement();
            if (d.getClass().getClassLoader() == cl) {
                try {
                    DriverManager.deregisterDriver(d);
                } catch (Throwable t) {
                    // opcional: log.warn("Error desregistrando driver: " + d, t);
                }
            }
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // no-op
    }
}