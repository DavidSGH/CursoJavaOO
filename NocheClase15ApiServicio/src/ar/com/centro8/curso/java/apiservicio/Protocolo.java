package ar.com.centro8.curso.java.apiservicio;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.repositories.GenericR;
import java.util.List;

public class Protocolo {

    /*
        Protocolo del api
        1 alta alumno.
                1;nombre;apellido;edad;curso    return true,false
        2 baja alumno.
                2;id                            return true,false
        3 get alumno.
                3;id                            return id;nombre;apellido;edad;curso
        4 lista alumno.
                4                               return list(id;nombre;apellido;edad;curso)
     */

    public static String retorno(String cmd) {
        String[] vector = cmd.split(";");
        for (int a = 0; a < vector.length; a++) {
            System.out.println(vector[a]);
        }
        String retorno = "null";
        switch (vector[0]) {
            case "1":
                retorno = alta(vector);
                break;
            case "2":
                retorno = baja(vector);
                break;
            case "3":
                retorno = get(vector);
                break;
            case "4":
                retorno = getAll(vector);
                break;
        }
        return retorno;
    }

    public static String alta(String[] vector) {
        alumnos a = new alumnos(
                vector[1],
                vector[2],
                Integer.parseInt(vector[3]),
                Integer.parseInt(vector[4])
        );
        new GenericR().save(a);
        return "true";
    }

    public static String baja(String[] vector) {
        try {
            new AlumnoR(new AlumnoR()
                    .getById(Integer.parseInt(vector[1])))
                    .delete();
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    public static String get(String[] vector) {
        try {
            String clazz="ar.com.centro8.curso.java.entities.alumnos";
            alumnos a=(alumnos)new GenericR()
                    .get(clazz, Integer.parseInt(vector[1]));
            return a.getId()+";"+a.getNombre()+";"+a.getApellido()+";"
                    +a.getEdad()+";"+a.getCurso();
        } catch (Exception e) {
            return "false";
        }
    }

    public static String getAll(String[] vector) {
        try {
            String clazz="ar.com.centro8.curso.java.entities.alumnos";
            List<alumnos>lista=new GenericR().getAll(clazz);
            String retorno="";
            for(alumnos item:lista){
                retorno+=item.getId()+";"+item.getNombre()+";"
                        +item.getApellido()+";"+item.getEdad()+";"
                        +item.getCurso()+"\n";
            };
            return retorno;
        } catch (Exception e) {
            return "false";
        }
    }

}
