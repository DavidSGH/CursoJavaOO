package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.repositories.GenericR;
import ar.com.centro8.curso.java.util.X;

public class TestClase04_2 {
    public static void main(String[] args){
        alumnos a = new alumnos("Carolina", "Herrera", 34, 1);
        GenericR gr = new GenericR();
        gr.save(a);
        
        //new AlumnoR().getAll().forEach(X::print);
        
        String clazz = "ar.com.centro8.java.entities.alumnos";
        a = (alumnos)gr.get(clazz, 8);
        X.print(a);
        
    }
}
