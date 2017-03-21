package ar.com.centro8.curso.java.util;

import javafx.scene.control.TextField;
import javax.swing.JTextField;

/**
 * Clase Validator que permite validar controles Text en Swing o JavaFX
 *
 * @author Curso Java
 */
public class Validator {

    private JTextField txtSwing = null;
    private TextField txtFx = null;
    private String name;

    public Validator(JTextField txtSwing,String name) {
        this.txtSwing = txtSwing;
        this.name=name;
    }

    public Validator(TextField txtFx,String name) {
        this.txtFx = txtFx;
        this.name=name;
    }

    private String getText() {
        if (txtSwing != null) {
            return txtSwing.getText();
        }
        if (txtFx != null) {
            return txtFx.getText();
        }
        return null;
    }
    
    private String getName(){
        return name;
    }

    private void setText(String text) {
        if (txtSwing != null) {
            txtSwing.setText(text);
        }
        if (txtFx != null) {
            txtFx.setText(text);
        }
    }

    private void requestFocus() {
        if (txtSwing != null) {
            txtSwing.requestFocus();
        }
        if (txtFx != null) {
            txtFx.requestFocus();
        }
    }

    private void selectAll() {
        if (txtSwing != null) {
            txtSwing.selectAll();
        }
        if (txtFx != null) {
            txtFx.selectAll();
        }
    }

    private boolean error(String msg) {
        Box.error(msg);
        requestFocus();
        selectAll();
        return false;
    }

    /**
     * Valida la longitud del texto
     *
     * @param size
     * @return
     */
    public boolean size(int size) {
        if (getText().length() != size) {
            return error("La longitud de "+getName()+" debe ser " 
                    + size + " caracteres.");
        }
        return true;
    }

    /**
     * Valida la longitud de texto del control.
     *
     * @param min cantidad mínima de caracteres
     * @param max cantidad máxima de caracteres
     * @return
     */
    public boolean size(int min, int max) {
        if (getText().length() < min || getText().length() > max) {
            return error("La longitud de "+getName()+" debe ser entre " 
                    + min + " y "+max + " caracteres.");
        }
        return true;
    }

    public boolean isInteger() {
        int nro;
        try {
            nro = Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            return error("Se espera un numero entero en "+getName()+".");
        }
        return true;
    }

    public boolean isInteger(int min, int max) {
        int nro = 0;
        try {
            nro = Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            return error("Se espera un número entero en "+getName()+".");
        }
        if (nro < min || nro > max) {
            return error("Se espera en "+getName()+" un número entre " 
                    + min + " y " + max);
        }
        return true;
    }

}
