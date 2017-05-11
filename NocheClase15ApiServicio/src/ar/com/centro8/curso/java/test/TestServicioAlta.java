package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestServicioAlta {

    public static void main(String[] args) throws Exception{
        Socket so = new Socket ("172.16.10.253",8201);
        ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
        out.writeObject(new alumnos("Bob","Constructor",29,3));
        out.close();
        so.close();
        
    }
}
