package nocheclase11;

import java.io.InputStream;
import java.net.Socket;

public class ClienteMinimo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4321);
            InputStream in = socket.getInputStream();
            int car;
            while((car = in.read()) != -1){
                System.out.print((char)car);
            }
            System.out.println();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
