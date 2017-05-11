package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class TestServicioGetAll {
    public static void main(String[] args) throws Exception {
        Socket so = new Socket ("172.16.10.253",8204);
        ObjectInputStream in = new ObjectInputStream(so.getInputStream());
        List<alumnos> lista = (List<alumnos>) in.readObject();
        lista.forEach(System.out::println);
        in.close();
        so.close();
    }
}
