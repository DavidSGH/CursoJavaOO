package nocheclase05fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    
    private ToggleGroup group;
    
    @FXML //Notation 
    TextField txtNombre;
    @FXML
    private CheckBox chkBici;
    @FXML
    private CheckBox chkMoto;
    @FXML
    private CheckBox chkAuto;
    @FXML
    private TextArea txtATexto;
    @FXML
    private RadioButton radSoltero;
    @FXML
    private RadioButton radCasado;
    @FXML
    private RadioButton radViudo;
    @FXML
    private RadioButton radDivorciado;
    @FXML
    private ComboBox<String> cmbColores;
    
    @FXML
    public void aceptar(ActionEvent ae){
        String nombre = txtNombre.getText();
        JOptionPane.showMessageDialog(null, "Hola "+nombre);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Ceacion de Grupo de Estado Civil
        group = new ToggleGroup();
        radSoltero.setToggleGroup(group);
        radCasado.setToggleGroup(group);
        radViudo.setToggleGroup(group);
        radDivorciado.setToggleGroup(group);
        
        // Carga de Items ControlBox Colores
        cmbColores.getItems().add("Rojo");
        cmbColores.getItems().add("Verde");
        cmbColores.getItems().add("Azul");
        cmbColores.getItems().add("Amarillo");
        cmbColores.getItems().add("Negro");
        cmbColores.getItems().add("Blanco");
        cmbColores.getItems().add("Gris");
        cmbColores.setValue(null);
        
    }    

    @FXML
    private void agregar(ActionEvent event) {
        String texto = "Nombre= "+txtNombre.getText()+".\n";
        
        // Resultado de los CheckBox seleccionados
        if(chkBici.isSelected()) texto +="Tiene Bici.\n";
        if(chkMoto.isSelected()) texto +="Tiene Moto.\n";
        if(chkAuto.isSelected()) texto +="Tiene Auto.\n";
        
        // Resultado del Radio Buttom seleccionado
        if(radSoltero.isSelected()) texto +="Su estado civil es: Soltero.\n";
        if(radCasado.isSelected()) texto +="Su estado civil es: Casado.\n";
        if(radViudo.isSelected()) texto +="Su estado civil es: Viudo.\n";
        if(radDivorciado.isSelected()) texto +="Su estado civil es: Divorciado.\n";
        
        // Resultado del ComboBox seleccionado
        String color = cmbColores.getValue();
        if(color!=null) texto += "Color = "+color+".\n";
 
        // Impresion en el Text Area
        txtATexto.setText(texto);
        
        // Convierto Color a Ingles
        switch(color){
            case "Rojo": color ="red";break;
            case "Verde": color ="green";break;
            case "Azul": color ="blue";break;
            case "Amarillo": color ="yellow";break;
            case "Blanco": color ="white";break;
            case "Negro": color ="black";break;
            case "Gris": color ="gray";break;
            default: color ="gray";
        }
        
        // Set del Backgroud del TxtArea
        txtATexto.setStyle("-fx-control-inner-background: "+color+";");
        
        
        limpiar();
        
    }

    private void limpiar() {
        // Limpiar Formulario
        txtNombre.setText("");
        chkBici.setSelected(false);
        chkMoto.setSelected(false);
        chkAuto.setSelected(false);
        /*
        radSoltero.setSelected(false);
        radCasado.setSelected(false);
        radViudo.setSelected(false);
        radDivorciado.setSelected(false);
        */
        group.selectToggle(null);
        
        cmbColores.setValue(null);
        
        txtNombre.requestFocus();
    }
    
}
