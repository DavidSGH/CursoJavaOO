package ar.com.centro8.curso.java.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TestApi {

    public static void main(String[] args) throws Exception {
        //String comando = "1;Lautaro;Rodriguez;26;2";
        //String comando="2;40";
        //String comando="3;44";
        String comando="4";
        String retorno="";
        Socket socket = new Socket("localhost", 8500);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write(comando.getBytes());
        out.write(0);
        int car;
        while ((car = in.read()) != -1) {
            retorno+=(char) car;
        }
        System.out.println(retorno);
        out.close();
        in.close();
        socket.close();

    }
}
