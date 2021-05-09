package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import sms.dbController.LoginController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {


    @FXML
    private AnchorPane login;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField pwdField;

    @FXML
    private JFXButton Login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    LoginController log = new LoginController();

    /**
     * Login method lets you login to the application
     */
    @FXML
    public void Login() {

        String username = usernameField.getText();
        String password = pwdField.getText();

        if(username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Username & password Required!");
            alert.showAndWait();
        }
        else {
            if(username.startsWith("admin")) {
                try {
                    if (log.Login(username, password)) {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid username or password!");
                        alert.showAndWait();
                    }
                }
                catch(SQLException | ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }

            }
            else if((username.startsWith("teacher"))) {
                try {
                    if (log.Login(username, password)) {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid username or password..!");
                        alert.showAndWait();
                    }

                }
                catch(SQLException | ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
            else if((username.startsWith("albinisi"))) {
                try {
                    if (log.Login(username, password)) {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid username or password!");
                        alert.showAndWait();
                    }
                }
                catch(SQLException | ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
            else if ((username.startsWith("yllka"))) {
                try {
                    if (log.Login(username, password)) {
                        AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
                        login.getChildren().setAll(user);
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid username or password!");
                        alert.showAndWait();
                    }
                }
                catch (SQLException | IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password!");
                alert.showAndWait();
            }
        }
    }
}