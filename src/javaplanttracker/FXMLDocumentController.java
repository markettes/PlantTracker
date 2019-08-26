/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Marcos
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label userLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void setUserLabel(String name) {
        userLabel.setText("User: " + name);
    }

    @FXML
    private void addPlantAct(ActionEvent event) {
        
    }
}
