package ar.com.centro8.curso.java.paginator;

import ar.com.centro8.curso.java.pojos.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import java.util.List;

public class AlumnoPaginator {
    
    private AlumnoR alumnoR;
    private List<Alumno> page;
    private int pageNumber;
    private int pageSize;
    
    public AlumnoPaginator (AlumnoR alumnoR){
        this.alumnoR = alumnoR;
    }

    public AlumnoPaginator(AlumnoR alumnoR, int pageSize) {
        this.alumnoR = alumnoR;
        this.pageSize = 10;
    }
    
    public List<Alumno> nextPage(){
        return page;
    }
    
    public boolean hasNextPage(){
        page = alumnoR.getPage(pageNumber,pageSize);
        pageNumber++;
        return !page.isEmpty();
    }
}
