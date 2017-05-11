package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.hibernate.utils.HibernateUtil;
import ar.com.centro8.curso.java.pojos.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import org.hibernate.SessionFactory;

public class HibernateTest2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        AlumnoR ar = new AlumnoR(sf);
        
        Alumno a = ar.getById(9);
        System.out.println(a);
        
        //int x = ar.save(new Alumno("Jimena","Rosales",34,1));
        //System.out.println(ar.getById(x));
        
        a = ar.getById(15);
        a.setNombre("Johana");
        ar.update(a);
        System.out.println(ar.getById(15));
        
        a = ar.getById(3);
        if (a!=null){
            ar.remove(a);
            System.out.println("El registro fue eliminado.");
        }
        else System.out.println("El registro no existe!");
        
        ar.getAll().forEach(System.out::println);
        
        ar.get("nombre='Estrellita'").forEach(System.out::println);
        
        sf.close();
    }
    
}
