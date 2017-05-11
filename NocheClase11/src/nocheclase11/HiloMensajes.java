package nocheclase11;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class HiloMensajes implements Runnable{
    
    private JTextArea textArea;

    public HiloMensajes(JTextArea textArea){
        this.textArea = textArea;
    }
    
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                String origen = socket.getInetAddress().toString();
                int car;
                String mensaje = "";
                while((car=in.read())!=-1){
                    mensaje +=(char)car;
                }
                textArea.append(origen+": "+mensaje+"\n");
                mensaje = "";
                in.close();
                socket.close();
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
