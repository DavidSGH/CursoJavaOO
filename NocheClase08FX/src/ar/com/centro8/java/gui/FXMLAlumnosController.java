
package ar.com.centro8.java.gui;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.repositories.GenericR;
import ar.com.centro8.curso.java.util.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TextField;


public class FXMLAlumnosController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCurso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    private boolean validar(){
        //Validator v = new Validator(txtNombre,"nombre");
        if(!new Validator(txtNombre,"nombre").size(2,20)) return false;
        if(!new Validator(txtApellido,"apellido").size(2,20)) return false;
        if(!new Validator(txtEdad,"edad").isInteger(18,70)) return false;
        return true;
    }
    
    @FXML
    private void agregar(ActionEvent event) {
        
        GenericR gr = new GenericR();
        alumnos a;
        
        if (validar()){
            a = new alumnos(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    Integer.parseInt(txtCurso.getText())
            );
            gr.save(a);
            
            
            
            limpiar();
        }
    }

    private void limpiar() {
        // Limpiar
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtCurso.setText("");
        txtNombre.requestFocus();
    }

    @FXML
    private void tblAlumnos(SortEvent<?> event) {
    }
    
}
