package sms.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;
import sms.helpers.EditResourcesHelper;
import sms.helpers.LoadResourcesHelper;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void add_student(javafx.scene.input.MouseEvent event) {
        Parent root = LoadResourcesHelper.loadFXML("dialogs/add_student");
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.show();
    }

    @FXML
    public void edit_student(javafx.scene.input.MouseEvent event) {
        Parent root = EditResourcesHelper.loadFXML("dialogs/edit_student");
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.show();
    }
}