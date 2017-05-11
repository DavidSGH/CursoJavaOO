package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestServicioBaja {

    public static void main(String[] args) throws Exception{
        Socket so = new Socket ("172.16.10.253",8203);
        OutputStream out = so.getOutputStream();
        out.write("11".getBytes());
        out.write(0);
        ObjectInputStream in = new ObjectInputStream(so.getInputStream());
        alumnos a = (alumnos) in.readObject();
        System.out.println(a);
        in.close();
        out.close();
        so.close();
        
        so = new Socket("172.16.10.253",8202);
        ObjectOutputStream out2 = new ObjectOutputStream(so.getOutputStream());
        out2.writeObject(a);
        DataInputStream in2 = new DataInputStream(so.getInputStream());
        if(a!=null)System.out.println(in2.readLine());
        out2.close();
        in2.close();
        so.close();
    }
}
