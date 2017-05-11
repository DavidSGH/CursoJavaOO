package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.pojos.Alumno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AlumnoR extends GenericR <Alumno, Integer> {
    
    public AlumnoR(SessionFactory sessionFactory){
        super(sessionFactory);
    }
    
    public List<Alumno> getByApellido(String apellido){
        return get("apellido='"+apellido+"'");
    }
    
    public List<Alumno> getByCurso(int curso){
        return get("curso='"+curso+"'");
    }
    
    public List<Alumno> getPage(int NumberPage, int PageSize){
        return getPage(NumberPage, PageSize, "1=1");
    }
    
    public List<Alumno> getPage (int NumberPage, int PageSize, String filtro){
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Alumno where "+filtro);
        query.setFirstResult((NumberPage-1)*PageSize);
        query.setMaxResults(PageSize);
        List<Alumno> lista = query.list();
        session.close();             
        return lista;
    }
}
