package sms.helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DynamicViews {

    private DynamicViews() {

    }

    public static void loadBorderCenter(BorderPane borderPane, String resource) throws IOException {

        try {
            Parent dashboard = FXMLLoader.load(new DynamicViews().getClass().getResource("/sms/views/" + resource + ".fxml"));
            borderPane.setCenter(dashboard);
        }
        catch (IOException ex) {

        }
    }
}
