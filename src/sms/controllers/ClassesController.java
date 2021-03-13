package sms.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import sms.helpers.EditResourcesHelper;
import sms.helpers.HelperStage;
import sms.helpers.LoadResourcesHelper;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.ResourceBundle;

public class ClassesController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void close(MouseEvent event) {
        HelperStage.close((Node) event.getSource());
    }

    @FXML
    public void edit_class(javafx.scene.input.MouseEvent event) {
        Parent root = EditResourcesHelper.loadFXML("dialogs/edit_class");
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.show();
    }
}
