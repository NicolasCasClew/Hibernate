
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oracleDBs.Departamentos;
import oracleDBs.Empleados;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    public static void main(String[] args){
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);


       // try {
        //eliminarDepto();
        insertarDepto( new Departamentos(BigInteger.valueOf(55),"Innovacion","Agüimes"));
        insertarEmpleado( new Empleados("551","551","Oficinista", BigInteger.valueOf(55)));
        insertarEmpleado( new Empleados("552","552","Oficinista", BigInteger.valueOf(55)));
        insertarEmpleado( new Empleados("553","553","Oficinista", BigInteger.valueOf(55)));




            //System.out.println( entityManager.find(Empleados.class,"X1234567W").toString());
            System.out.println(leerEmpleado("553").toString());
            spacer();

            modificarEmpleado("552");

            leerTodos();

            eliminarEmpleado("553");

            leerTodos();





    }
    public static void insertarDepto(Departamentos dpto){
        transaction.begin();
            entityManager.persist(dpto);
        transaction.commit();
    }
    public static void insertarEmpleado(Empleados emp){
        transaction.begin();
            entityManager.persist(emp);
        transaction.commit();
    }
    public static Empleados leerEmpleado(String codigo){
        return entityManager.find(Empleados.class,codigo);
    }
    public static void leerTodos(){
        ArrayList<Empleados> list = (ArrayList<Empleados>) entityManager.createQuery("from "+Empleados.class.getName(), Empleados.class).getResultList();

        for(int i= 0;i<list.size(); i++){
            System.out.println(list.get(i).toString());

        }
        spacer();
    }
    public static void modificarEmpleado(String codigo){
        //Cambio el cargo en vez del sueldo porque no tengo esa columna en mi Base de Datos
        transaction.begin();
            Empleados empleado = leerEmpleado(codigo);
            empleado.setCargo("Jefe de Sala");
            entityManager.merge(empleado);
        transaction.commit();
    }
    public static void eliminarEmpleado(String codigo){
        transaction.begin();
            entityManager.remove(leerEmpleado(codigo));
        transaction.commit();
    }
    public static void eliminarDepto(){
        transaction.begin();
            entityManager.remove(entityManager.find(Departamentos.class,BigInteger.valueOf(55)));
        transaction.commit();
    }
    public static void spacer(){
        System.out.println("_______________________________________________________");
        System.out.println();
    }
}



