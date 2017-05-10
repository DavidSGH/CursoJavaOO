package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.entities.Control;
import javax.persistence.EntityManager;

public class ControlR {
    private EntityManager em;
    private Control control;
    
    public ControlR(EntityManager em){
        this.em = em;
    }

    public ControlR(EntityManager em, Control control) {
        this.em = em;
        this.control = control;
    }
    
    public void persist(){
        em.persist(control);
    }
}
