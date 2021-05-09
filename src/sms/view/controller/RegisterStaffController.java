package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import sms.dbController.StaffController;
import sms.dbController.StudentController;
import sms.model.Staff;
import sms.model.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterStaffController implements Initializable {

    public JFXRadioButton genderField2;
    public JFXRadioButton genderField1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private AnchorPane root;

    @FXML
    private TextField empNoField;

    @FXML
    private TextField teacherNameField;

    @FXML
    private TextField dobField;

    @FXML
    private JFXRadioButton genderField;

    @FXML
    private ToggleGroup g;

    @FXML
    private TextField emailField;

    @FXML
    private TextField asmOfDutyField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private JFXButton AddStaff;

    @FXML
    private JFXButton reset;

    @FXML
    private TextField prsntGradeField;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Add Teachers
     * @param event
     */
    @FXML
    void AddStaff(ActionEvent event) {
        try {
            ValidationController v = new ValidationController();

            if(v.validateEmpty(empNoField) && v.validateEmpty(teacherNameField) && v.validateEmpty(dobField) && v.validateEmpty(phoneField) && v.validateDate(dobField) && v.validateDate(asmOfDutyField) && v.validatePhone(phoneField) && v.numbersOnly(empNoField) && v.numbersOnly(phoneField)) {
                int empNo = Integer.parseInt(empNoField.getText());

                String teacherName = teacherNameField.getText();
                String dob = dobField.getText();
                RadioButton selectedRadioButton = (RadioButton) g.getSelectedToggle();
                String gender = selectedRadioButton.getText();
                String email = emailField.getText();
                String assumpOfDuties = asmOfDutyField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String prsntGrade = prsntGradeField.getText();

                Staff s = new Staff(empNo, teacherName, dob, gender, email, assumpOfDuties, phone, address, prsntGrade);
                int i = StaffController.AddStaff(s);

                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Teacher Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher registered successfully!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    emailField.setText(null);
                    asmOfDutyField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    prsntGradeField.setText(null);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Teacher Registration");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error adding the teacher!");
                    alert.showAndWait();
                }
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reset values
     * @param event
     */
    @FXML
    void reset(ActionEvent event) {
        empNoField.setText(null);
        teacherNameField.setText(null);
        dobField.setText(null);
        emailField.setText(null);
        asmOfDutyField.setText(null);
        addressField.setText(null);
        phoneField.setText(null);
        prsntGradeField.setText(null);
    }
}