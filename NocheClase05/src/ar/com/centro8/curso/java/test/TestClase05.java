package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.GenericR;
import ar.com.centro8.curso.java.util.X;


public class TestClase05 {

    public static void main (String[] args){
        String clax = "ar.com.centro8.curso.java.entities.alumnos";
        GenericR gr = new GenericR();
        alumnos a = (alumnos)gr.get(clax,8);
        X.print(a);
        X.line();
        gr.getAll(clax).forEach(X::print);
        X.line();
        gr.get(clax, "nombre like 'Melina'").forEach(X::print);
        
    }
}
