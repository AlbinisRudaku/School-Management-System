package sms.controllers.dialogs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import sms.helpers.HelperStage;
import sms.helpers.LoadResourcesHelper;
import java.net.URL;
import java.util.ResourceBundle;

public class Add_teacherController implements Initializable {
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
    private void close(MouseEvent event) {
        HelperStage.close((Node) event.getSource());
    }
}