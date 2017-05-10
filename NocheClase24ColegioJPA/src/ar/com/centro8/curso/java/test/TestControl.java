package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.Control;
import ar.com.centro8.curso.java.repositories.ControlR;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestControl {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("NocheClase24ColegioJPAPU")
                .createEntityManager();
        em.getTransaction().begin();
        new ControlR(em, 
                new Control("Pepito","localhost", new Date(), "alumnos", "insert", 1))
                .persist();
        em.getTransaction().commit();
        
    }
}
