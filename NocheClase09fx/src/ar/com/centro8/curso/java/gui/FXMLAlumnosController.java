package ar.com.centro8.curso.java.gui;

import ar.com.centro8.curso.java.entities.alumnos;
import ar.com.centro8.curso.java.entities.cursos;
import ar.com.centro8.curso.java.repositories.GenericR;
import ar.com.centro8.curso.java.util.Box;
import ar.com.centro8.curso.java.util.FxTable;
import ar.com.centro8.curso.java.util.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLAlumnosController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    private TextField txtCurso;
    @FXML
    private TableView<alumnos> tblAlumnos;
    @FXML
    private TextField txtBuscarApe;
    @FXML
    private TableView<cursos> tblCursos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargar();
    }    

    private void cargar(){
        String clazz="ar.com.centro8.curso.java.entities.alumnos";
        new FxTable().cargar(new GenericR().getAll(clazz),tblAlumnos);
        clazz="ar.com.centro8.curso.java.entities.cursos";
        new FxTable().cargar(new GenericR().getAll(clazz),tblCursos);
        
    }
    
    private boolean validar(){
        //Validator v=new Validator(txtNombre,"nombre");
        if(!new Validator(txtNombre,"nombre").size(2, 20)) return false;
        if(!new Validator(txtApellido,"apellido").size(2, 20)) return false;
        if(!new Validator(txtEdad,"edad").isInteger(18, 70)) return false;
        if(tblCursos.getSelectionModel().getSelectedItem()==null){
            Box.error("Debe seleccionar un curso.");
            return false;
        }
        return true;
    }
    
    @FXML
    private void agregar(ActionEvent event) {
        GenericR gr=new GenericR();
        alumnos a;
        if(validar()){
            a=new alumnos(
              txtNombre.getText(),
              txtApellido.getText(),
              Integer.parseInt(txtEdad.getText()),
              tblCursos.getSelectionModel().getSelectedItem().getId()
            );
            gr.save(a);
        
            limpiar();
            
        }
        cargar();
        
    }

    private void limpiar() {
        //limpiar
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        //txtCurso.setText("");
        tblCursos.getSelectionModel().setSelectionMode(null);
        txtNombre.requestFocus();
    }

    @FXML
    private void buscar(KeyEvent event) {
        //String clazz="ar.com.centro8.curso.java.entities.alumnos";
        //String filtro="apellido like '%"+txtBuscarApe.getText()+"%'";
        //new FxTable().cargar(new GenericR().get(clazz,filtro),tblAlumnos);
        new FxTable()
                .cargar(new GenericR()
                .get("ar.com.centro8.curso.java.entities.alumnos"
                        ,"apellido like '%"
                        +txtBuscarApe.getText()+"%'"),tblAlumnos);
    }
    
}
