package mainFolder.Ejercicio.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase Singleton para gestionar la SessionFactory de Hibernate.
 * Se crea UNA sola vez y se reutiliza en toda la aplicación.
 */
public class GestionSesiones {

    // SessionFactory única para toda la aplicación
    private static final SessionFactory sessionFactory;

    // Bloque estático: se ejecuta UNA sola vez al arrancar la app
    static {
        try {
            sessionFactory = new Configuration()
                    .configure() // carga hibernate.cfg.xml desde src/main/resources
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory");
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Devuelve la SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Cierra la SessionFactory al terminar el programa
    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}