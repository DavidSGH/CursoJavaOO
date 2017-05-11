package ar.com.centro8.curso.java.test;

import ar.com.centro8.curso.java.entities.alumnos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;

public class Serializar {
    public static void main(String[] args) throws Exception {
        String file = "alumnos.dat";
        
        /*
        // Serializado 
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        
        out.writeObject(new alumnos(1,"Javier","Peña",24,1));
        out.writeObject(new alumnos(2,"Laura","Gutierrez",24,1));
        out.writeObject(new alumnos(3,"Cecilia","Oviedo",24,1));
        
        out.close();
        fos.close();
        */
        
        //Deserializado
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        alumnos a;
        
        try{
            while(true){
                a=(alumnos)ois.readObject();
                System.out.println(a);
            }
        }catch(Exception e){
            System.out.println("Fin del archivo.");
        }
        
        ois.close();
        fis.close();
    }
}
