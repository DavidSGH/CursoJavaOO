package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.pojos.Alumno;
import ar.com.centro8.curso.java.pojos.Curso;
import java.util.List;
import org.hibernate.SessionFactory;

public class CursoR extends GenericR<Curso, Integer> {
    
    public CursoR (SessionFactory sessionFactory){
        super(sessionFactory);
    }
    
    public List<Curso> getByTitulo(String titulo){
        return get("titulo='"+titulo+"'");
    }
    
    public List<Curso> getByProfesor(String profesor){
        return get("profesor='"+profesor+"'");
    }
    
    public List<Curso> getByDia(String dia){
        return get("dia='"+dia+"'");
    }
    
    public List<Curso> getByTurno(String turno){
        return get("turno='"+turno+"'");
    }
    
}
