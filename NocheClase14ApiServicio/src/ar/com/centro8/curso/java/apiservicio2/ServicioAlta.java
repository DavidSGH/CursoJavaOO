package ar.com.centro8.curso.java.apiservicio2;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.GenericR;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioAlta implements Runnable{

    @Override
    public void run() {
        
        try {
            ServerSocket sc = new ServerSocket(8201);
            while(true){
                try {
                    System.out.println("Servicio Alta - Esperando Conexion.");
                    Socket so = sc.accept();
                    System.out.println("Servicio Alta - Se conecto "+sc.getInetAddress());
                    ObjectInputStream in = new ObjectInputStream(so.getInputStream());
                    alumnos a = (alumnos)in.readObject();
                    System.out.println(a);
                    new GenericR().save(a);
                    OutputStream out = so.getOutputStream();
                    out.write("true".getBytes());
                    out.close();
                    in.close();
                    so.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
