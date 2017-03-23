package nocheclase0fx;

import ar.com.centro8.curso.java.util.Box;
import ar.com.centro8.curso.java.util.Stream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField txtNombre;
    @FXML
    private Label label1;
    @FXML
    private Label label11;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextArea txaTexto;
    
    private String file = "datos.txt";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    

    @FXML
    private void agregar(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String registro = nombre+";"+apellido+";"+telefono+"\n";
        
        // Escribo el String en el archivo.
        Stream.append(file, registro);
        
        Box.msg("Se cargaron los datos exitosamente!");
        
        mostrar();
        
        limpiar();
    }

    private void limpiar() {
        // Limpieza de Formuario
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtNombre.requestFocus();
    }
    
    private void mostrar(){
        txaTexto.setText(Stream.getText(file));
    }
    
}
