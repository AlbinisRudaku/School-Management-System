package sms.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;
import sms.helpers.EditResourcesHelper;
import sms.helpers.LoadResourcesHelper;
import java.net.URL;
import java.util.ResourceBundle;


public class TeachersController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void add_teacher(javafx.scene.input.MouseEvent event) {
        Parent root = LoadResourcesHelper.loadFXML("dialogs/add_teacher");
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.show();
    }

    @FXML
    public void edit_teacher(javafx.scene.input.MouseEvent event) {
        Parent root = EditResourcesHelper.loadFXML("dialogs/edit_teacher");
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.show();
    }
}