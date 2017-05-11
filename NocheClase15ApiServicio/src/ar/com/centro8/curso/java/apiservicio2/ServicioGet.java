package ar.com.centro8.curso.java.apiservicio2;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.GenericR;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServicioGet implements Runnable{

    @Override
    public void run() {
        try {
            ServerSocket sc = new ServerSocket(8202);
            String clazz = "ar.com.centro8.curso.java.entities.alumnos";
            
            while(true){
                try {
                    System.out.println("Servicio Baja - Esperando Conexion.");
                    Socket so = sc.accept();
                    System.out.println("Servicio Baja - Se conecto "+sc.getInetAddress());
                    InputStream in = so.getInputStream();
                    int car;
                    String stin ="";
                    while((car=in.read())!=0){
                        stin+=(char)car;
                    }
                    
                    alumnos a;
                    try {
                        a = (alumnos) new GenericR().get(clazz, "id=" + stin).get(0);
                    } catch (Exception e) {
                        a = null;
                    }
                    ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
                    out.writeObject(a);
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
