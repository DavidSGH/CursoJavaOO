package nocheclase11;

import java.io.PrintWriter;
import java.net.Socket;

public class ClienteMinimo2 implements Runnable {
    
    private String server;
    private String mensaje;

    public ClienteMinimo2(String server, String mensaje) {
        this.server = server;
        this.mensaje = mensaje;        
    }
    
    @Override
    public void run(){
        String mensaje = "Hola soy David!";
        System.out.println();
        try {
            Socket socket = new Socket("localhost", 5555);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.write(mensaje);
            out.close();
            socket.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
