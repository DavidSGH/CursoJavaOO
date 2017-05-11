package nocheclase11;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMinimo2 implements Runnable {
    
    @Override
    public void run() {
        int car;
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            while(true){
                System.out.println("Esperando conexion del Cliente.");
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                while((car=in.read()) != -1){
                    System.out.print((char)car);
                }
                System.err.println();
                in.close();
                socket.close();
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
