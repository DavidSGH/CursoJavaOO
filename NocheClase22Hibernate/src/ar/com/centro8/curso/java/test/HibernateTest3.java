package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.hibernate.utils.HibernateUtil;
import ar.com.centro8.curso.java.pojos.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.repositories.CursoR;
import org.hibernate.SessionFactory;

public class HibernateTest3 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        AlumnoR ar = new AlumnoR(sf);
        
        System.out.println("--------------------");
        ar.getByApellido("Gomez").forEach(System.out::println);
        System.out.println("--------------------");
        System.out.println("--------------------");
        ar.getByCurso(1).forEach(System.out::println);
        
        CursoR cr = new CursoR(sf);
        System.out.println("--------------------");
        cr.getByTitulo("Java").forEach(System.out::println);
        System.out.println("--------------------");
        cr.getByProfesor("Rios").forEach(System.out::println);
        System.out.println("--------------------");
        cr.getByDia("Martes").forEach(System.out::println);
        System.out.println("--------------------");
        cr.getByTurno("Noche").forEach(System.out::println);
        
        sf.close();
    }
    
}
