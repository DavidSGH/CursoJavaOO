package ar.com.centro8.curso.java.apiservicio2;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.GenericR;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServicioGetAll implements Runnable {

    @Override
    public void run() {
        try {
            String clazz = "ar.com.centro8.curso.java.entities.alumnos";
            ServerSocket sc = new ServerSocket(8204);
            while(true){
                System.out.println("Servicio getAll - Esperando Conexion.");
                Socket so = sc.accept();
                System.out.println("Servicio getAll - Se conecto "+so.getInetAddress());
                ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
                List<alumnos> lista = new GenericR().getAll(clazz);
                out.writeObject(lista);
                out.close();
                so.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
