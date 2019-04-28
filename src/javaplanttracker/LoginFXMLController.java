/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private JFXTextField userTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXTextField newUserTF;
    @FXML
    private JFXPasswordField newPasswordTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logInAct(ActionEvent event) {
    }

    @FXML
    private void signUpAct(ActionEvent event) {
        
        Connection conn = null;
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            String sql = "INSERT INTO USERS VALUES ('" + newUserTF.getText() + "', '" + newPasswordTF.getText() + "')";
            conn.createStatement().execute(sql);
            
            //If everything works fine:
            
            
        } catch (Exception e) {
            
            System.out.println(e);
            Alert alert = new Alert(AlertType.CONFIRMATION, e.toString(), ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                newUserTF.setText("");
                newPasswordTF.setText("");
            }
        }
    }

}
