package ar.com.centro8.curso.java.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *  Clase que genera cuadros de dialogos JOptioPane.
 *  Creado: 06/10/2016
 *  Modificación: 
 * @author Curso Técnicas de programación
 */
public class Box {
    public static void msg(Object msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    public static void msg(Component cmp,Object msg){
        JOptionPane.showMessageDialog(cmp, msg);
    }
    public static String input(String msg){
        return JOptionPane.showInputDialog(msg);
    }
    public static String input(Component cmp,String msg){
        return JOptionPane.showInputDialog(cmp, msg);
    }
    public static int inputInt(String msg){
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }
    public static int inputInt(Component cmp,String msg){
        return Integer.parseInt(JOptionPane.showInputDialog(null,msg));
    }
    public static float inputFloat(String msg){
        return Float.parseFloat(JOptionPane.showInputDialog(msg));
    }
    public static float inputFloat(Component cmp,String msg){
        return Float.parseFloat(JOptionPane.showInputDialog(cmp,msg));
    }
    public static boolean question(String question){
        //return JOptionPane.showConfirmDialog(null, question, "Pregunta?", JOptionPane.YES_NO_OPTION)==0;
        return JOptionPane.showConfirmDialog(null, question, "Pregunta?", 0)==0;
    }
    public static boolean question(Component cmp,String question){
        return JOptionPane.showConfirmDialog(cmp, question, "Pregunta?", 0)==0;
    }
    public static void error(Object obj){
        //JOptionPane.showMessageDialog(null, obj, "Ocurrio un error!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, obj, "Ocurrió un error!", 0);
    }
    public static void error(Component cmp,Object obj){
        JOptionPane.showMessageDialog(cmp, obj, "Ocurrió un error!", 0);
    }
}
