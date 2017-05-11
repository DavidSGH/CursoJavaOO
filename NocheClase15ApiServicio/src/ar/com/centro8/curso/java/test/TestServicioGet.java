package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestServicioGet {
    public static void main(String[] args) throws Exception {
        Socket so = new Socket ("172.16.10.253",8203);
        OutputStream out = so.getOutputStream();
        out.write("12".getBytes());
        out.write(0);
        ObjectInputStream in = new ObjectInputStream(so.getInputStream());
        alumnos a = (alumnos) in.readObject();
        System.out.println(a);
        in.close();
        out.close();
        so.close();
    }
}
