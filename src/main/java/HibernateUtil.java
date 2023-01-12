import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

//Esta es la clase HibernateUtil que se incluye en NetBeans, no en Eclipse... pero que te puedes crear como t� quieras.

public class HibernateUtil {

     private static final SessionFactory sessionFactory;
     static {
         try {
             // Create the SessionFactory from standard (hibernate.cfg.xml)
        	 // config file.
             File f = new File("src/main/java/hibernate.cfg.xml");

             //Configuration config = new Configuration().configure(f);
            sessionFactory = new Configuration().configure(f).buildSessionFactory();
           } catch (Throwable ex) {
             // Log the exception.
             System.err.println("Initial SessionFactory creation failed." + ex);
             throw new ExceptionInInitializerError(ex);
         }
     }
     
     public static SessionFactory getSessionFactory() {
         return sessionFactory;
     }
 }