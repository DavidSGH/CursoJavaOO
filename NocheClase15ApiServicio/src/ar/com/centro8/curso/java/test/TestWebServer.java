package ar.com.centro8.curso.java.test;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestWebServer {
    public static void main(String[] args) throws Exception{
        ServerSocket sc=new ServerSocket(8080);
        String html="<h1>Servidor de Carlos</h1>Curso de Java";
        String resp="HTTP/1.0\n"
                   +"Content-Type: text/html\n"
                   +"Content-Length:"+html.length()+"\n\n"
                   +html;
        while(true){
            System.out.println("Esperando Cliente.");
            Socket so=sc.accept();
            System.out.println("Se conecto "+so.getInetAddress());
            OutputStream out=so.getOutputStream();
            out.write(resp.getBytes());
            out.close();
        }
    }
}
