package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.hibernate.utils.HibernateUtil;
import ar.com.centro8.curso.java.paginator.AlumnoPaginator;
import ar.com.centro8.curso.java.pojos.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import org.hibernate.SessionFactory;

public class HibernateTest4 {
    public static void main(String[] args) throws InterruptedException {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        AlumnoR ar = new AlumnoR(sf);
        
        AlumnoPaginator ap = new AlumnoPaginator(ar,10);
        while(ap.hasNextPage()){
            System.out.println("--------------------------------------------------");
            ap.nextPage().forEach(System.out::println);
            Thread.sleep(500);
            System.out.println("--------------------------------------------------");
        }
        
        sf.close();
    }
    
}
