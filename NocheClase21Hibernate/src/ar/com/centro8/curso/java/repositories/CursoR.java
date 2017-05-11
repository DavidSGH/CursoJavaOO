package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.pojos.Curso;
import org.hibernate.SessionFactory;

public class CursoR extends GenericR<Curso, Integer> {
    
    public CursoR (SessionFactory sessionFactory){
        super(sessionFactory);
    }
    
}
