package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.ObjectInputStream;
import static java.lang.System.in;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSerializable {
    
    public static void main(String[] args) throws Exception{
        ServerSocket sc = new ServerSocket(5000);
        
        while(true){
            System.out.println("Esperando Cliente.");
            Socket so = sc.accept();
            System.out.println("Se conecto "+ so.getInetAddress());
            try {
                ObjectInputStream in = new ObjectInputStream(so.getInputStream());
                alumnos a = (alumnos) in.readObject();
                System.out.println(a);
                in.close();
            } catch (Exception e){
                System.out.println("Objeto incorrecto.");
            }
            
            so.close();
            
        }
        
    }
}
