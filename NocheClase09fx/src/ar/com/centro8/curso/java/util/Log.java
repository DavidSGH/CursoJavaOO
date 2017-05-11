package ar.com.centro8.curso.java.util;

import java.net.InetAddress;
import java.util.Date;

public class Log {
    private static final String FILE="log.csv";
    private static void append(Exception ex){
        Date date=new Date();
        String user=System.getProperty("user.name");
        InetAddress host=null;
        try {
            host=InetAddress.getLocalHost();
        } catch (Exception e) {
            System.out.println(e);
        }
        String registro=date+";"+host+";"+user+";"+ex+"\n";
        Stream.append(FILE, registro);
    }
    /**
     * Método para ser usado en aplicaciones Desktop
     * @param ex 
     */
    public static void set(Exception ex){
        append(ex);
        Box.error("Ocurrio un error!");
    }
    /**
     * Método para ser usado en aplicaciones Servidor
     * @param ex 
     */
    public static void setS(Exception ex){
        append(ex);
        X.print("Ocurrio un error!");
    }
    
}
