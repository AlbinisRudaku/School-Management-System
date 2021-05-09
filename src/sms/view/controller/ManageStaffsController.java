package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sms.db.DBConnection;
import sms.dbController.StaffController;
import sms.dbController.StudentController;
import sms.model.Staff;
import sms.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageStaffsController implements Initializable {

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
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField asmOfDutyField;

    @FXML
    private TextField prsntGradeField;

    @FXML
    private JFXButton deleteStaff;

    @FXML
    private JFXButton update;

    @FXML
    private TextField genderField;

    @FXML
    private TextField EmpNo;

    @FXML
    private JFXButton searchStaff;

    @FXML
    private TextField empName;

    @FXML
    private JFXButton searchByName;

    @FXML
    private JFXButton printStaff;

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
     * Search Teachers by name
     * @param event
     */
    @FXML
    void searchByName(ActionEvent event) {
        try {
            String teacherName = empName.getText();
            Staff s = StaffController.searchStaffByName(teacherName);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                dobField.setText(s.getDob());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                asmOfDutyField.setText(s.getAssumpOfDuties());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
                prsntGradeField.setText(s.getPrsntGrade());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Teacher Search");
                alert.setHeaderText(null);
                alert.setContentText("Teacher not found!");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                dobField.setText(null);
                emailField.setText(null);
                asmOfDutyField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                prsntGradeField.setText(null);
                empName.setText(null);
                EmpNo.setText(null);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search teachers by ID
     * @param event
     */
    @FXML
    void searchStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(EmpNo.getText());
            Staff s = StaffController.searchStaff(empNo);
            if (s != null) {
                empNoField.setText(String.valueOf(s.getEmpNo()));
                teacherNameField.setText(s.getTeacherName());
                dobField.setText(s.getDob());
                genderField.setText(s.getGender());
                emailField.setText(s.getEmail());
                asmOfDutyField.setText(s.getAssumpOfDuties());
                phoneField.setText(s.getPhone());
                addressField.setText(s.getAddress());
                prsntGradeField.setText(s.getPrsntGrade());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Teacher Search");
                alert.setHeaderText(null);
                alert.setContentText("Teacher not found!");
                alert.showAndWait();

                empNoField.setText(null);
                teacherNameField.setText(null);
                dobField.setText(null);
                emailField.setText(null);
                asmOfDutyField.setText(null);
                genderField.setText(null);
                phoneField.setText(null);
                addressField.setText(null);
                prsntGradeField.setText(null);
                empName.setText(null);
                EmpNo.setText(null);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Delete teachers
     * @param event
     */
    @FXML
    void deleteStaff(ActionEvent event) {
        try {
            int empNo = Integer.parseInt(empNoField.getText());
            Staff s = new Staff(
                    Integer.parseInt(empNoField.getText()),
                    teacherNameField.getText(),
                    dobField.getText(),
                    genderField.getText(),
                    emailField.getText(),
                    asmOfDutyField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    prsntGradeField.getText()
            );

                int deleteStaff = StaffController.deleteStaff(empNo);

                if (deleteStaff > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Teacher Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher " + empNo + " has been deleted successfully!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    asmOfDutyField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    prsntGradeField.setText(null);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Teacher Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error deleting the teacher!");
                    alert.showAndWait();
                }
        }
        catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Update teachers
     * @param event
     */
    @FXML
    void update(ActionEvent event) {
        try {
            ValidationController v = new ValidationController();
            if(v.validateEmpty(empNoField) && v.validateEmpty(teacherNameField) && v.validateEmpty(dobField) && v.validateEmpty(phoneField) && v.validateDate(dobField) && v.validateDate(asmOfDutyField) && v.validatePhone(phoneField) && v.numbersOnly(empNoField) && v.numbersOnly(phoneField)) {
                int empNo = Integer.parseInt(empNoField.getText());
                String teacherName = teacherNameField.getText();
                String dob = dobField.getText();
                String gender = genderField.getText();
                String email = emailField.getText();
                String assumpOfDuties = asmOfDutyField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String prsntGrade = prsntGradeField.getText();

                Staff s = new Staff(empNo, teacherName, dob, gender, email, assumpOfDuties, phone, address, prsntGrade);
                int i = StaffController.updateStaff(s);

                if (i > 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Teacher Management");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher information updated successfully!");
                    alert.showAndWait();

                    empNoField.setText(null);
                    teacherNameField.setText(null);
                    dobField.setText(null);
                    emailField.setText(null);
                    genderField.setText(null);
                    asmOfDutyField.setText(null);
                    phoneField.setText(null);
                    addressField.setText(null);
                    prsntGradeField.setText(null);

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Staff Management");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error updating the teacher!");
                    alert.showAndWait();
                }
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

