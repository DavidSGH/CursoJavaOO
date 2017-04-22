package ar.com.centro8.curso.java.util;

//Stream de Buffers Linea a Linea
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StreamBuffer {
    private static BufferedReader in;
    public static void open(String file){
        try {
            in=new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            Log.set(e);
        }
    }
    public static void close(){
        try {
            in.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }
    public static String getLine(){
        try {
            return in.readLine();
        } catch (Exception e) {
            Log.set(e);
            return null;
        }
    }
    public static List<String> getLines(String file){
        List<String> lista=new ArrayList();
        String linea;
        open(file);
        while((linea=getLine())!=null){
            lista.add(linea);
        }
        close();
        return lista;
    }
    
    public static void setText(String file,String text){
        BufferedWriter out;
        try {
            out=new BufferedWriter(new FileWriter(file));
            out.write(text);
            out.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }
    public static void append(String file,String text){
        BufferedWriter out;
        try {
            out=new BufferedWriter(new FileWriter(file,true));
            out.write(text);
            out.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }
    
    public static void delete(String file,String line){
        List<String>lista=getLines(file);
        lista.remove(line);
        setText(file,"");
        //lista.forEach(item->append(file,item+"\n"));
    }
}
