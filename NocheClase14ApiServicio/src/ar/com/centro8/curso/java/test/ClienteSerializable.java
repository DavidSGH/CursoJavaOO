package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSerializable {
    public static void main(String[] args) throws Exception {
        Socket so = new Socket("172.16.10.253",5000);
        ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
        out.writeObject(new alumnos("Nova","Afalla",32,2));
        out.close();
        so.close();
        
    }
}
