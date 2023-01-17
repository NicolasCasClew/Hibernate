
import jakarta.persistence.*;
import oracleDBs.Departamentos;
import oracleDBs.Empleados;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        int dep1;
        int dep2;

       // try {
        //eliminarDepto();
        //insertarDepto( new Departamentos(BigInteger.valueOf(55),"Innovacion","Agüimes"));
        insertarEmpleado( new Empleados("551","551","Oficinista", BigInteger.valueOf(55), BigInteger.valueOf(1300)));
        insertarEmpleado( new Empleados("552","552","Oficinista", BigInteger.valueOf(55),BigInteger.valueOf(1800)));
        insertarEmpleado( new Empleados("553","553","Oficinista", BigInteger.valueOf(55),BigInteger.valueOf(1200)));





            //System.out.println( entityManager.find(Empleados.class,"X1234567W").toString());
            System.out.println(leerEmpleado("553").toString());
            spacer();

            modificarEmpleado("552");

            leerTodos();

            eliminarEmpleado("553");

            leerTodos();

        System.out.println("Que departamentos quieres consultar? (1/2)");
            dep1 = sc.nextInt();
            sc.nextLine();
        System.out.println("Que departamentos quieres consultar? (2/2)");
            dep2= sc.nextInt();

        Query query = entityManager.createNativeQuery(
                "Select distinct * From empleados INNER JOIN departamentos on cod_ofi= departamento Where (cod_ofi = ? OR cod_ofi = ?) And sueldo >= 1500 ", Empleados.class);
        query.setParameter(1, dep1);
        query.setParameter(2, dep2);

        List<Empleados> results = query.getResultList();
        for(Empleados i : results){
            System.out.println(i.getCodOfi());
            }

        query = entityManager.createNativeQuery(
                "Select distinct * From empleados INNER JOIN departamentos on cod_ofi= departamento Where (cod_ofi = ? OR cod_ofi = ?)", Empleados.class);
        query.setParameter(1, dep1);
        query.setParameter(2, dep2);
        spacer();
        results = query.getResultList();
        for(Empleados i : results){

            modificarSueldo(i.getNif(),500);
        }


        query = entityManager.createNativeQuery(
                "SELECT * FROM empleados INNER JOIN departamentos ON cod_ofi = departamento WHERE localidad = 'Agüimes'", Empleados.class);
        spacer();
        results = query.getResultList();
        for(Empleados i : results){
            eliminarEmpleado(i.getNif());

            //System.out.println(i.getNombre());
        }

        query = entityManager.createNativeQuery(
                "SELECT * FROM empleados", Empleados.class);
        spacer();
        results = query.getResultList();
        for(Empleados i : results){
            System.out.println(i.toStringFull());
        }

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
    public static void  modificarSueldo(String codigo, int cantidad){
        transaction.begin();
            Empleados empleado = leerEmpleado(codigo);
            empleado.setSueldo(empleado.getSueldo().add(BigInteger.valueOf(cantidad)) );
            entityManager.merge(empleado);
            System.out.println("Sueldo de "+empleado.getNombre()+" actualizado correctamente");
        transaction.commit();
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
        Empleados empleado = leerEmpleado(codigo);
        System.out.println("Empleado "+empleado.getNombre()+" eliminado");
            entityManager.remove(empleado);

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



