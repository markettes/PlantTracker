/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaplanttracker;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class LoginFXMLController implements Initializable {

    private final Glow bloom = new Glow();
    @FXML
    private JFXTextField userTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXTextField newUserTF;
    @FXML

    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private JFXPasswordField newPasswordTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Resize window
        gridPane.prefHeightProperty().bind(anchorPane.heightProperty());
        gridPane.prefWidthProperty().bind(anchorPane.widthProperty());
        bloom.setLevel(0.5);
        gridPane.prefHeightProperty().bind(anchorPane.heightProperty());
        gridPane.prefWidthProperty().bind(anchorPane.widthProperty());
    }

    @FXML
    private void logInAct(ActionEvent event) {
        Connection conn;
        String sql = "SELECT * from USERS where USERNAME=? and PASSWORDS=?";
        PreparedStatement pst;
        ResultSet rs;
        

        try {

            if (userTF.getText().equalsIgnoreCase("") || passwordTF.getText().equals("")) {
                throw new Exception();
            }
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            pst = conn.prepareStatement(sql);
            pst.setString(1, userTF.getText());
            pst.setString(2, passwordTF.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("You logged in correctly");

                //If everything works fine:
                FXMLLoader miCargador = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                AnchorPane root = (AnchorPane) miCargador.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                // ICON & TITLE
                stage.getIcons().add(new Image("/images/icon.png"));
                stage.setTitle("PlantTracker 0.1(ALPHA)");
                //START
                stage.setScene(scene);
                stage.show();
            } else{ throw new Exception();}

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void signUpAct(ActionEvent event) {

        Connection conn = null;

        try {

            if (newUserTF.getText().equals("") || newPasswordTF.getText().equals("")) {
                throw new Exception();
            }
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            String sql = "INSERT INTO USERS VALUES ('" + newUserTF.getText() + "', '" + newPasswordTF.getText() + "')";
            conn.createStatement().execute(sql);

            //If everything works fine:
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            AnchorPane root = (AnchorPane) miCargador.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            // ICON & TITLE
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.setTitle("PlantTracker 0.1(ALPHA)");

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            Alert alert = null;
            if (e.toString().startsWith("org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException")) {
                System.out.println(e);
                alert = new Alert(Alert.AlertType.ERROR, "Username already in use", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("Username already in use");
                alert.setContentText("Error code: " + e.toString());
                alert.showAndWait();
            } else {
                System.out.println(e);
                alert = new Alert(Alert.AlertType.ERROR, "Username or password is missing", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("Username or password is missing");
                alert.setContentText("Error code: " + e.toString());
                alert.showAndWait();
            }

            if (alert.getResult() == ButtonType.OK) {
                newUserTF.setText("");
                newPasswordTF.setText("");
            }
        }
    }

}
