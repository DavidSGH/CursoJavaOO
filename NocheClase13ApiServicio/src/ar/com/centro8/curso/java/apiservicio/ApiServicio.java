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

    /*
        Protocolo del api
        1 alta alumno.
                1;nombre;apellido;edad;curso    return true,false
        2 baja alumno.
                2;id                            return true,false
        3 get alumno.
                3;id                            return id;nombre;apellido;edad;curso
        4 lista alumno.
                4                               return list(id;nombre;apellido;edad;curso)
    */
    
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
                System.out.println("1");
                PrintStream out = new PrintStream(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                input="";
                System.out.println("2");
                //input=in.readLine();
                System.out.println(input);
                while((car=in.read())!=-1){
                    input+=(char)car;
                    System.out.print((char)car);
                } 
                System.out.println("3");
                output=retorno(input);
                System.out.println("4");
                out.println(input);
                for(int a=0;a<output.length();a++){
                   out.write(output.charAt(a));
                    System.out.println(output.charAt(a));
                }
                in.close();
                out.close();
                socket.close();
                System.out.println("6");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String retorno(String input){
        return "Test";
    }
    
}
