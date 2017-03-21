package ar.com.centro8.curso.java.util;

import java.util.Scanner;

/**
 *  Clase que representa la consola del sistema.
 *  Creado: 06/10/2016
 *  Modificación: 
 * @author Curso Técnicas de programación
 */
public class X {
    /**
     * Imprime en consola
     * @param obj Objeto a Imprimir
     */
    public static void print(Object obj){
        System.out.println(obj);
    }
    public static void newLine(){
        System.out.println();
    }
    public static void line(){
        line(40);
    }
    public static void line(int cantidad){
        for(int a=1;a<=cantidad;a++) System.out.print("*");
        System.out.println();
    }
    public static String input(String msg){
        System.out.print(msg);
        return new Scanner(System.in).next();
    }
    public static int inputInt(String msg){
        System.out.print(msg);
        //Scanner scanner=new Scanner(System.in);
        //int numero=scanner.nextInt();
        //return numero;
        return new Scanner(System.in).nextInt();
    }
    public static float inputFloat(String msg){
        System.out.println(msg);
        return new Scanner(System.in).nextFloat();
    }
}
