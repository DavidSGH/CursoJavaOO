package nocheclase08_v2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NocheClase08_v2 {
    
    public static void main(String[] args) {
        // Multithread
        
        //Consulta de cantidad de procesadores
        System.out.println(Runtime.getRuntime().availableProcessors());
        
        class ClaseThread extends Thread{
            private String descripcion;
            
            public ClaseThread(String descripcion){
                this.descripcion = descripcion;
            }
            
            @Override
            public void run(){
                for (int i=0; i<=50;i++){
                    System.out.println(descripcion+": "+i);
                    dormir();
                }
            }

            private void dormir() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NocheClase08_v2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } // end Class ClaseThread
        
        ClaseThread ct1 = new ClaseThread("Hilo 1");
        ClaseThread ct2 = new ClaseThread("Hilo 2");
        ClaseThread ct3 = new ClaseThread("Hilo 3");
        ClaseThread ct4 = new ClaseThread("Hilo 4");
        
        System.out.println(ct1.getId());
        System.out.println(ct1.getName());
        System.out.println(ct1.getPriority());
        System.out.println(ct1.isAlive());
        System.out.println(ct1.isDaemon());
        System.out.println(ct1.isInterrupted());
        
        ct1.setPriority(Thread.MAX_PRIORITY);
        ct1.setPriority(10);
        ct2.setPriority(Thread.NORM_PRIORITY);
        ct3.setPriority(Thread.MIN_PRIORITY);
        
        
        // Metodo start()
        ct1.start();
        ct2.start();
        ct3.start();
        ct4.start();
        
        System.out.println("Fin del programa");
    }
    
}
