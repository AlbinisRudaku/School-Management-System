package sms.view.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ValidationController {

    public static boolean validateEmpty(TextField txt) {
        if (txt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Management System");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the required fields!");
            alert.showAndWait();

            return false;
        }
        return true;
    }

    public boolean validateNIC(TextField txt) {
        if (txt.getText().matches("^(\\d{10}|\\d{12})") || (txt.getText().isEmpty())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Management System");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Personal Number!");
            alert.showAndWait();

            return false;
        }
    }

    public boolean numbersOnly(TextField txt) {
        if (txt.getText().matches("[0-9]+")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Management System");
            alert.setHeaderText(null);
            alert.setContentText("Invalid input type!");
            alert.showAndWait();

            return false;
        }
    }

    public boolean validatePhone(TextField txt) {
        if (txt.getText().matches("^(\\d{9})")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Management System");
            alert.setHeaderText(null);
            alert.setContentText("Invalid phone number!");
            alert.showAndWait();

            return false;
        }
    }

    public boolean validateDate(TextField txt) {
        if (txt.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Management System");
            alert.setHeaderText(null);
            alert.setContentText("Invalid date!");
            alert.showAndWait();

            return false;
        }
    }
}
