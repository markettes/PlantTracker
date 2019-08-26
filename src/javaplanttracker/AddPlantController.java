/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class AddPlantController implements Initializable {

    @FXML
    private JFXTextField typeTF;
    @FXML
    private JFXTextField siteTF;
    @FXML
    private JFXTextField freqTF;
    @FXML
    private Label adressLabel;
    
    FileChooser fileChooser = new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchAct(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpeg","*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        adressLabel.setText(selectedFile.getName());
    }

    @FXML
    private void exitAct(ActionEvent event) {
    }

    @FXML
    private void addAct(ActionEvent event) {
    }
    
}
