package sms.helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadResourcesHelper {

    private LoadResourcesHelper() {

    }

    public static Parent loadFXML(String resource) {
        Parent root = null;

        try {
            new FXMLLoader();
            FXMLLoader loader = new FXMLLoader(LoadResourcesHelper.class.getResource("/sms/views/" + resource + ".fxml"));
            root = loader.load();
//            root = FXMLLoader.load(new LoadResourcesHelper().getClass().getResource("sms/views/" + resource + ".fxml"));
        }
        catch (IOException ex) {
            Logger.getLogger(LoadResourcesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return root;
    }
}
