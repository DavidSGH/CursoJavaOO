package ar.com.centro8.curso.java.apiservicio2;

import ar.com.centro8.curso.java.entities.Alumno;
import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.AlumnoR;
import ar.com.centro8.curso.java.repositories.GenericR;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServicioBaja implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket sc = new ServerSocket(8202);
            while(true){
                try {
                    System.out.println("Servicio Baja - Esperando Conexion.");
                    Socket so = sc.accept();
                    System.out.println("Servicio Baja - Se conecto "+sc.getInetAddress());
                    ObjectInputStream in = new ObjectInputStream(so.getInputStream());
                    alumnos a = (alumnos) in.readObject();
                    if(a!=null)
                        new GenericR().remove(a);
                        
                    OutputStream out = so.getOutputStream();
                    out.write(((a!=null)?"true":"false").getBytes());
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
