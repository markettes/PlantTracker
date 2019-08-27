/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

        try {
            
            
            
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("AddPlant.fxml"));
            AnchorPane root = (AnchorPane) miCargador.load();
            
            //Pass data to the next controller
            AddPlantController usernameController = miCargador.getController();
            usernameController.setUsername(userLabel.getText().substring(5));
                    
            //Shot the window
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.setTitle("Add Plant");
            stage.setResizable(false);

            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
