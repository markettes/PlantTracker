/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class AddPlantController implements Initializable {

    String username;
    @FXML
    private JFXTextField typeTF;
    @FXML
    private JFXTextField siteTF;
    @FXML
    private JFXTextField freqTF;
    @FXML
    private Label adressLabel;
    
    FileChooser fileChooser = new FileChooser();
    @FXML
    private JFXButton exitBut;

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
        Stage stage = (Stage) exitBut.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addAct(ActionEvent event) {
    }
    
    //Get data for save the plant with the correspondent username
    public void setUsername(String user){
        username = user;
    }
}
