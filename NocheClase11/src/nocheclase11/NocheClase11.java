package nocheclase11;

import com.sun.istack.internal.logging.Logger;
import java.net.InetAddress;

public class NocheClase11 {

    public static void main(String[] args) throws Exception{
        
        /*
        InetAddress direccion = InetAddress.getLocalHost();
        System.out.println(direccion);
        direccion = InetAddress.getByName("PRAGMANB531");
        System.out.println(direccion);
        direccion = InetAddress.getByName("172.16.10.182");
        System.out.println(direccion);
        */
        
        /*
            Arquitectura de Comunicaciones TCP
        
            Server                          Client
            ---------------                 ---------------
            ServerSocket(Port#,timeOut)     Socker(host,port#)
            accept()
            ---------------                 ---------------
            OutputStream - PrintStream  ->  InputStream
            InputStream         <-----      OutputStream - PrintStream
            ---------------                 ---------------
            close()                         close()
            ---------------                 ---------------
            
        */
        
        new Thread(new ServidorMinimo2()).start();
        
        new Thread(new ClienteMinimo2("localhost","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.10.192","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.10.182","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.10.217","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.1.24","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.10.162","Hola soy David!")).start();
        new Thread(new ClienteMinimo2("172.16.10.249","Hola soy David!")).start();
        
    }
    
}
