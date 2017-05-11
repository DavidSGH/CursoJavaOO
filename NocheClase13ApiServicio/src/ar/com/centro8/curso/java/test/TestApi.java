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
        String comando = "1;Lautaro;Rodriguez;26;2";
        Socket socket = new Socket("localhost", 8500);
        System.out.println("1");
        PrintStream out = new PrintStream(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       
        System.out.println("2");
        
        System.out.println("3");
        for (int a = 0; a < comando.length(); a++) {
            out.write(comando.charAt(a));
            System.out.print(comando.charAt(a));
        }
        //out.print(comando);
      
        System.out.println();
        int car;
        System.out.println("4");
        while ((car = in.read()) != -1) {
            System.out.print((char) car);
        }
        
        //System.out.println(in.readLine());
        System.out.println("5");
        out.close();
        in.close();
        socket.close();

    }
}
