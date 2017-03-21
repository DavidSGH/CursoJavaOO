package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.repositories.GenericR;
import ar.com.centro8.curso.java.util.X;
import java.lang.reflect.Field;
import java.util.List;

public class TestClase03 {
    public static void main(String[] args) {
        AlumnoR alumnoR=new AlumnoR();
        List<Alumno> lista=alumnoR.getAll();
        for(Alumno a:lista){
            X.print(a);
        }
        X.line();
        new AlumnoR().getAll().forEach(X::print);
        X.line();
        new AlumnoR().getByFiltro("nombre='Cristina'").forEach(X::print);
        X.line();
        new AlumnoR().getByFiltro("nombre like '%a'").forEach(X::print);
        X.line();
        new AlumnoR().getByNombre("Cristina").forEach(X::print);
        X.line();
        X.line();
        new AlumnoR(new AlumnoR().getById(7)).delete();
        new AlumnoR().getAll().forEach(X::print);
        X.line();
        AlumnoR ar=new AlumnoR(new AlumnoR().getById(3));
        ar.getAlumno().setNombre("Raul");
        ar.getAlumno().setApellido("Rosales");
        ar.update();
        X.line();
        new AlumnoR().getAll().forEach(X::print);
        
        Alumno a=new Alumno();
        // Reflection
        //Field[] campos=a.getClass().getDeclaredFields();
        //for(int x=0;x<campos.length;x++){
        //    X.print(campos[x].getName());
        //}
        
        GenericR gr=new GenericR();
        gr.getAll();
        
    }
}
