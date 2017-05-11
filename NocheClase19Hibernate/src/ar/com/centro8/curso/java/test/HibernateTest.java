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
        
        Transaction tr = session.beginTransaction();
        
        try {
            
            //session.save(a1);
            //session.save(a2);
            //a1.setNombre("Alberto");
            //session.update(a1);
            //alumnox.setId(20);
            //session.delete(alumnox);
            
            tr.commit();
        } catch (Exception e) {
            System.out.println(e);
            tr.rollback();
        }
        
        alumnox = (Alumno)session.get(Alumno.class, 9); //Eager
        System.out.println(alumnox);
        alumnox = (Alumno)session.load(Alumno.class,9); //Lazy
        System.out.println(alumnox);
        
        //Cierro la sesion
        session.close();
        sf.close();
    }
}
