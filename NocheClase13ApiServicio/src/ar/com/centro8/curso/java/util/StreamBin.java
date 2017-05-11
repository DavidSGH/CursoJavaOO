package ar.com.centro8.curso.java.util;

//Stream Binario Byte a Byte
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamBin {
    public static void copiar(String origen,String destino){
        FileInputStream in;
        FileOutputStream out;
        int by;
        try {
            in=new FileInputStream(origen);
            out=new FileOutputStream(destino);
            while((by=in.read())!=-1){
                out.write(by);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }
    public static boolean comparar(String file1,String file2){
        FileInputStream in1,in2;
        int by1,by2;
        try {
            in1=new FileInputStream(file1);
            in2=new FileInputStream(file2);
            while((by1=in1.read())!=-1 & (by2=in2.read())!=-1){
                if(by1!=by2){
                    in1.close();
                    in2.close();
                    return false;
                }
            }
            in1.close();
            in2.close();
        } catch (Exception e) {
            Log.set(e);
            return false;
        }
        return true;
    }
}
