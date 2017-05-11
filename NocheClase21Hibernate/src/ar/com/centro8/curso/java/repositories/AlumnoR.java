package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.pojos.Alumno;
import org.hibernate.SessionFactory;

public class AlumnoR extends GenericR <Alumno, Integer> {
    
    public AlumnoR(SessionFactory sessionFactory){
        super(sessionFactory);
    }
    
}
