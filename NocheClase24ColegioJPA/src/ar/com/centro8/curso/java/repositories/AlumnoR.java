package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.entities.Alumno;
import ar.com.centro8.curso.java.entities.Control;
import java.util.Date;
import javax.persistence.EntityManager;

public class AlumnoR {
    private EntityManager em;
    private Alumno alumno;
    private Control control;
    private String usuario;
    private String terminal;

    public AlumnoR(EntityManager em, Alumno alumno, String usuario, String terminal) {
        this.em = em;
        this.alumno = alumno;
        this.usuario = usuario;
        this.terminal = terminal;
    }
    
    public boolean persist(){
        em.getTransaction().begin();
        try {
            em.persist(alumno);
            new ControlR(em,
                    new Control(usuario, terminal, new Date(), "alumnos"
                        ,"insert",alumno.getId()))
            .persist();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    
    
}
