package nocheclase11;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMinimo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4321);
            //String mensaje = "Hola este es el servidor de David";
            String mensaje = "Procesadores = "+Runtime.getRuntime().availableProcessors()+System.getProperties();
            while(true){
                System.out.println("Esperando conexion de un cliente");
                Socket socket = serverSocket.accept();
                System.out.println("Usuario conectado: "+socket.getInetAddress());
                OutputStream out = socket.getOutputStream();
                for (int i=0; i<mensaje.length();i++){
                    out.write(mensaje.charAt(i));
                }
                System.out.println("Cerrado el Stream.");
                out.close();
                System.out.println("Cerrando el socket.");
                socket.close();
                //System.out.println("Cerrando el server");
                //serverSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
