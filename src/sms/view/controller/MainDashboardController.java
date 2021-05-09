package sms.view.controller;

import com.jfoenix.controls.JFXButton;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainDashboardController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private AnchorPane root;

    @FXML
    void setBtnUserSettings(ActionEvent event) {
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/UserAccount.fxml")));
            root.getChildren().setAll(user);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void setBtnSchoolInfo(ActionEvent event) {
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/SchoolInfo.fxml")));
            root.getChildren().setAll(user);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void setBtnStudentMgmt(ActionEvent event) {
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(user);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    void btnStaffMgmt(ActionEvent event){
        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(user);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}

