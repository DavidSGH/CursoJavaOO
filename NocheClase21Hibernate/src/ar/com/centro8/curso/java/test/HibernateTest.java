package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.hibernate.utils.HibernateUtil;
import ar.com.centro8.curso.java.pojos.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTest {

    public static void main(String[] args) {
        // Inicio la sesion de hibernate
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Alumno a1 = new Alumno("Fernando", "Alfonso",34,2);
        Alumno a2 = new Alumno("Pad", "Simmon",64,1);
        Alumno alumnox = new Alumno();
        
        Transaction tx = session.beginTransaction();
        
        try {
            
            //session.save(a1);
            //session.save(a2);
            //a1.setNombre("Alberto");
            //session.update(a1);
            //alumnox.setId(20);
            //session.delete(alumnox);
            
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
        
                //select
        Alumno a3=(Alumno)session.get(Alumno.class, 38);    //Eager
        //Alumno a4=(Alumno)session.load(Alumno.class, 39);   //Lazy
       
        System.out.println(a3);
        //System.out.println(a4);
        
        //update
        tx=session.beginTransaction();
        try {
            a3.setNombre("Ramiro");
            session.update(a3);
            tx.commit();
        } catch (Exception e) {
            System.out.println("ocurrio un error!");
            tx.rollback();
        }
        
        //delete
        tx=session.beginTransaction();
        try {
            //session.delete(a4);
            //session.delete(session.load(Alumno.class, 40));
            //session.delete("ar.com.centro8.curso.java.pojos.Alumno", 41);
            tx.commit();
        } catch (Exception e) {
            System.out.println("ocurrio un error!");
            tx.rollback();
        }
        
        // HQL Hibernate Query Language
        /*
        session
                .createQuery("from Alumno")
                .list()
                .forEach(System.out::println);
        */
        /*
        session
                .createQuery("from Alumno where nombre='Carlos'")
                .list()
                .forEach(System.out::println);
        */
        /*
        List<Alumno>lista=session
                .createQuery("from Alumno where nombre='Carlos'")
                .list();
        for(Alumno a:lista) System.out.println(a);
        */
        
        
        // query con SQL
        session
                .createSQLQuery("select * from alumnos")
                .addEntity(Alumno.class)
                .list()
                .forEach(System.out::println);
        
        
        // funciones de agrupamiento hql
        System.out.println("-- Cantidad de Alumnos ="+
                session
                .createQuery("select count(a) from Alumno a")
                .uniqueResult()
        );
        
        System.out.println("-- Edad del alumno menor ="+
                session
                .createQuery("select min(a.edad) from Alumno a")
                .uniqueResult()
        );
        
        System.out.println("-- Edad del alumno mayor ="+
                session
                .createQuery("select max(a.edad) from Alumno a")
                .uniqueResult()
        );
        
        System.out.println("-- Cantidad de alumnos del curso 2 ="+
                session
                .createQuery("select count(a) from Alumno a where curso=2")
                .uniqueResult()
        );
        
        System.out.println("-- Cantidad de alumnos por curso.");
        String query = "select a.curso,count(a) "
                + "from Alumno a group by a.curso";
        session.createQuery(query).list().forEach(System.out::println);
        
        
        //Cierro la sesion
        session.close();
        sf.close();
    }
}
