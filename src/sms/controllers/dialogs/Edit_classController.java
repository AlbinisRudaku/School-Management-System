package sms.controllers.dialogs;

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

public class Edit_classController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void close(MouseEvent event) {
        HelperStage.close((Node) event.getSource());
    }
}