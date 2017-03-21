package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.connector.Table;
import ar.com.centro8.curso.java.repositories.AlumnoRepo;
import ar.com.centro8.curso.java.util.Log;
import ar.com.centro8.curso.java.util.X;
import ar.com.centro8.java.entities.Alumno;
import java.sql.ResultSet;

public class TestClase02 {
    public static void main(String[] args) {
        /*
        // Test Clase table y JDBC
        String table = "alumnos";
        String fields = "nombre, apellido, edad, curso";
        String nombre = "Juan";
        String apellido = "Perez";
        String edad = "24";
        String curso = "2";
        String values = "'"+nombre+"','"+apellido+"',"+edad+","+curso;
        Table.insert(table, fields, values);
        
        ResultSet rs=Table.select(table);
        try {
            while(rs.next()){
                X.print(
                    rs.getInt("id")+","+
                    rs.getString("nombre")+","+
                    rs.getString("apellido")+","+
                    rs.getString("edad")+","+
                    rs.getString("curso")
                );
            }
            rs.close();
        } catch (Exception e) {
            Log.set(e);
        }*/
        
        /*
        Alumno alumno = new Alumno("Jimena","Molina",34,2);
        AlumnoRepo alumnoRepo = new AlumnoRepo(alumno);
        alumnoRepo.save();
        
        new AlumnoRepo(new Alumno("Carolina","Rojas",22,1));
        */
        
        //Alumno alumno = new Alumno ("Melina","Miguel",26,1);
        //new AlumnoRepo(alumno).save();
        
        //Alumno alumno = new AlumnoRepo().getById(2);
        Alumno alumno = new AlumnoRepo().getById(1);
        X.print(alumno);
        
        
        
    }
}
