package sms.controllers;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import sms.helpers.DynamicViews;


public class AppController implements Initializable {
    @FXML
    private BorderPane border_pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    public void show_dashboard(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "dashboard");
    }

    @FXML
    public void show_teachers(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "teachers");
    }

    @FXML
    public void show_students(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "students");
    }

    @FXML
    public void show_parents(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "parents");
    }

    @FXML
    public void show_subjects(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "subjects");
    }

    @FXML
    public void show_results(javafx.scene.input.MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "results");
    }
}
