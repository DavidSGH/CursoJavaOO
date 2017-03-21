package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.connector.Table;
import ar.com.centro8.curso.java.entities.Alumno;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.util.Log;
import ar.com.centro8.curso.java.util.X;
import java.sql.ResultSet;
import java.util.List;

public class TestClase02 {
    public static void main(String[] args) {
        // Test Clase Table y JDBC
        /*
        String table="alumnos";
        String fields="nombre,apellido,edad,curso";
        String nombre="Juan";
        String apellido="Perez";
        String edad="24";
        String curso="2";
        String values="'"+nombre+"','"+apellido+"',"+edad+","+curso;
        Table.insert(table, fields, values);
        
        ResultSet rs=Table.select(table);
        try {
            while(rs.next()){
                X.print(
                        rs.getInt("id")+","+
                        rs.getString("nombre")+","+
                        rs.getString("apellido")+","+
                        rs.getInt("edad")+","+
                        rs.getInt("curso")
                );
            }
            rs.close();
        } catch (Exception e) {
            Log.set(e);
        }
        */
        
        //Test AlumnoR
        //Alumno alumno=new Alumno("Jimena","Molina",34,2);
        //AlumnoR alumnoR=new AlumnoR(alumno);
        //alumnoR.save();
        
        //new AlumnoR(new Alumno("Carolina","Rojas",22,1)).save();
        
        //Alumno alumno=new Alumno("Melina","Miguel",26,1);
        //new AlumnoR(alumno).save();
        
        Alumno alumno=new AlumnoR().getById(1);
        X.print(alumno);
        
        
    }
}
