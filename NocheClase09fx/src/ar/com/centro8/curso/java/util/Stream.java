package ar.com.centro8.curso.java.util;

//Stream de caracteres (caracter X caracter).
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que permite trabajar con streaming de caracteres.
 * @author DOCENTE AULA1
 */
public class Stream {
    public static void print(String file){
        FileReader in;
        int car;
        try {
            in=new FileReader(file);
            while((car=in.read())!=-1){
                System.out.print((char)car);
            }
            in.close();
        } catch (IOException ex) {
            X.print(ex);
        }
        System.out.println();
    }
    public static String getText(String file){
        FileReader in;
        //String texto="";
        StringBuffer texto=new StringBuffer();
        int car;
        try {
            in=new FileReader(file);
            while((car=in.read())!=-1){
                texto.append((char)car);
            }
            in.close();
        } catch (Exception e) {
            X.print(e);
        }
        return texto.toString();
    }
    
    public static void setText(String file,String text){
        FileWriter out;
        try {
            out=new FileWriter(file);
            out.write(text);
            out.close();
        } catch (Exception e) {
            X.print(e);
        }
    }
    
    public static void append(String file,String text){
        FileWriter out;
        try {
            out=new FileWriter(file,true);
            out.write(text);
            out.close();
        } catch (Exception e) {
            X.print(e);
        }
    }
    
}
