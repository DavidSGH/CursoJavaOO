package nocheclase06webbrowser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtURL;
    @FXML
    private WebView webView;
    @FXML
    private ComboBox buscadores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navegar();
    }    

    @FXML
    private void ir(ActionEvent event) {
        navegar();
    }
    
    private void navegar(){
        String url=txtURL.getText();
        if(!url.startsWith("http://")) url="http://"+url;
        txtURL.setText(url);
        webView.getEngine().load(url);
    }
    
    @FXML
    private void inicio(ActionEvent event){
        String url = "http://google.com.ar";
        txtURL.setText(url);
        webView.getEngine().load(url);
    }
    
}
