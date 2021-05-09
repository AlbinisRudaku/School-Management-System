package sms.main;
/**
 * @Author Albinis Rudaku & Yllka Nuredini
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class StartProject extends Application {

    /**
     * This method start the applicaion by starting the preloader
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sms/view/fxml/SplashScreen.fxml"));
        primaryStage.setTitle("School Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/sms/other/img/up-logo.png")));
        primaryStage.show();
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}