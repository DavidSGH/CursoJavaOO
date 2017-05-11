package ar.com.centro8.curso.java.apiservicio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApiServicio implements Runnable{


    
    public static void main(String[] args) {
        new Thread(new ApiServicio()).start();
    }
    
    @Override
    public void run() {
        String input,output;
        int car;
        try {
            ServerSocket serverSocket=new ServerSocket(8500);
            while(true){
                System.out.println("Esperando cliente.");
                Socket socket=serverSocket.accept();
                InputStream in=socket.getInputStream();
                OutputStream out=socket.getOutputStream();
                input="";
                while((car=in.read())!=0){
                    input+=(char)car;
                }
                out.write(Protocolo.retorno(input).getBytes());
                in.close();
                out.close();
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
