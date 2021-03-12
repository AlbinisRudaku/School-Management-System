package sms.helpers;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelperStage {

    private HelperStage() {

    }

    public static void close(Node node) {
        ImageView img = (ImageView) node;

        Stage window = (Stage) img.getScene().getWindow();
        window.close();
    }
}
