package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.repositories.AlumnoRepo;
import ar.com.centro8.curso.java.repositories.GenericRepo;
import ar.com.centro8.curso.java.util.X;
import ar.com.centro8.java.entities.Alumno;
import java.util.List;
import java.lang.reflect.Field;


public class TestClase03 {
    public static void main (String[] args){
        AlumnoRepo alumnoRepo = new AlumnoRepo();
        //List<Alumno> lista = alumnoRepo.getAll();
        //for(Alumno a:lista){
            //X.print(a);
        //}
        //X.line();
        
        
        /*
        new AlumnoRepo().getAll().forEach(X::print);
        X.line();
        new AlumnoRepo().getByFiltro("nombre = 'Jimena'").forEach(X::print);
        X.line();
        //new AlumnoRepo().getByFiltro("nombre like '%a'").forEach(X::print);
        //X.line();
        new AlumnoRepo().getByNombreApellido("Jimena", "Molina").forEach(X::print);
        X.line();
        X.line();
        new AlumnoRepo(new AlumnoRepo().getById(7)).delete();
        new AlumnoRepo().getAll().forEach(X::print);
        
        X.line();
        AlumnoRepo ar = new AlumnoRepo(new AlumnoRepo().getById(3));
        ar.getAlumno().setNombre("Raul");
        ar.getAlumno().setApellido("Rosales");
        ar.update();
        X.line();
        new AlumnoRepo().getAll().forEach(X::print);
        */
        
        Alumno a = new Alumno();
        // Reflection
        /*
        Field[] campos = a.getClass().getDeclaredFields();
        
        for(int x=0;x<campos.length;x++){
            X.print(campos[x].getName());
        }
        */
        
        GenericRepo gr = new GenericRepo();
        gr.getAll();
        
    }
    
}
