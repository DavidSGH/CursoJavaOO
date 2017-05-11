package nocheclase08;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NocheClase08 {

    public static void main(String[] args) {
        // Multithread
        
        //Consulta de cantidad de procesadores
        System.out.println(Runtime.getRuntime().availableProcessors());
        
        class ClaseThread extends Thread{
            private String descripcion;

            public ClaseThread(String descripcion) {
                this.descripcion = descripcion;
            }
            
            @Override
            public void run(){
                for(int a=0;a<=50;a++){
                    System.out.println(descripcion+":"+a);
                    dormir(50);
                }
            }

            private void dormir(int t) {
                try {
                    Thread.sleep(t);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
               
            }
        }// end class
        
        ClaseThread ct1=new ClaseThread("Hilo 1");
        ClaseThread ct2=new ClaseThread("Hilo 2");
        ClaseThread ct3=new ClaseThread("Hilo 3");
        ClaseThread ct4=new ClaseThread("Hilo 4");
        
        // Método run no dispara hilos
      //  ct1.run();
      //  ct2.run();
      //  ct3.run();
      //  ct4.run();
        
        System.out.println(ct1.getId());
        System.out.println(ct1.getName());
        System.out.println(ct1.getPriority());
        System.out.println(ct1.getState());
        System.out.println(ct1.isAlive());
        System.out.println(ct1.isDaemon());
        System.out.println(ct1.isInterrupted());
      
        ct1.setPriority(Thread.MAX_PRIORITY);
        ct1.setPriority(10);
        ct2.setPriority(Thread.NORM_PRIORITY);
        ct3.setPriority(Thread.MIN_PRIORITY);
        
        /*
        Ciclo de vida de un hilo
        
        NEW     RUNNABLE    NOT RUNNABLE            TERMINATED(dead) 
                .start()    BLOCKED bloqueo x IO    muerte natural
                            WAITING .wait()         asesinato   .stop() deprecated()
                            TIME WAITING .sleep()
        
        */
        
        
        //Método start()
        //ct1.start();
        //ct2.start();
        //ct3.start();
        //ct4.start();
        //for(int a=1;a<=50;a++){
        //    System.out.println(ct1.getState());
        //}
        //ct1.start();
        //ct1.stop();
        
        //try {
        //    Thread.sleep(20000);
        //} catch (InterruptedException ex) {
        //    System.out.println(ex);
        //}
        
        System.out.println(ct1.getState());
        System.out.println("Fin del programa");
        
        
        class ClaseRunnable implements Runnable{
            private String descripcion;

            public ClaseRunnable(String descripcion) {
                this.descripcion = descripcion;
            }
            
            @Override
            public void run() {
                for(int a=1;a<=10;a++){
                    System.out.println(descripcion+":"+a);
                    dormir(20);
                }
            }

            private void dormir(int t) {
                try {
                    Thread.sleep(t);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NocheClase08.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }// end class
        
        ClaseRunnable cr1=new ClaseRunnable("Hilo 1");
        ClaseRunnable cr2=new ClaseRunnable("Hilo 2");
        ClaseRunnable cr3=new ClaseRunnable("Hilo 3");
        ClaseRunnable cr4=new ClaseRunnable("Hilo 4");
        
        Thread t1=new Thread(cr1);
        Thread t2=new Thread(cr2);
        Thread t3=new Thread(cr3);
        Thread t4=new Thread(cr4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        
    }
    
}
