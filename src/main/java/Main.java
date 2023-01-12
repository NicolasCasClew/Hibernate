import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oracleDBs.Departamentos;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();
        //Configuration con = new Configuration().configure("hibernate.cfg.xml");
       // Session session = HibernateUtil.getSessionFactory().openSession();
       // session.beginTransaction();

        try {
            transaction.begin();
            Departamentos dep = new Departamentos();
            dep.setDepartamento(BigInteger.valueOf(99));
            dep.setNombre("testeos2");
            dep.setLocalidad("TestiLandia2");
            //session.save(dep);
            //session.persist(dep);
            //session.getTransaction().commit();



            //System.out.println("Depto= "+ dep.getDepartamento()+"   Nombre= "+dep.getNombre()+ "   Local= "+dep.getLocalidad());
            //entityManager.merge(dep);
            entityManager.persist(dep);




            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}

