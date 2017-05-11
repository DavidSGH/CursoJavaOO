package ar.com.centro8.curso.java.apiservicio2;

public class Start {
    public static void main(String[] args) {
        new Thread(new ServicioAlta()).start();
        new Thread(new ServicioBaja()).start();
        new Thread(new ServicioGet()).start();
        new Thread(new ServicioGetAll()).start();
    }
    
}
