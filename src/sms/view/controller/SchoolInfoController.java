package sms.view.controller;
import javafx.fxml.FXMLLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;
import sms.dbController.SchoolController;
import sms.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sms.dbController.StudentController;


public class SchoolInfoController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            School s = SchoolController.schoolInfo();
            if (s != null) {
                SchoolNameField.setText(s.getSchoolName());
                SchoolAddressField.setText(s.getSchoolAddress());
                classAvailableField.setText(s.getClassAvailable());
                postalCodeField.setText(s.getPostalCode());
                dateOfEstdField.setText(s.getDateOfEstd());
                totalLandAreaField.setText(s.getTotalLandArea());
                provinceField.setText(s.getProvince());
                nameOfPrincipalField.setText(s.getNameOfPrincipal());
                pricipalNoField.setText(s.getPricipalNo());


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No Information Found!");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private AnchorPane root;

    @FXML
    private TextField SchoolNameField;

    @FXML
    private TextField SchoolAddressField;

    @FXML
    private TextField classAvailableField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private JFXButton updateDetails;

    @FXML
    private JFXButton addDetails;

    @FXML
    private TextField dateOfEstdField;

    @FXML
    private TextField totalLandAreaField;

    @FXML
    private TextField provinceField;

    @FXML
    private TextField nameOfPrincipalField;

    @FXML
    private TextField pricipalNoField;

    @FXML
    private JFXButton printDetails;

    @FXML
    private JFXButton Back;

    @FXML
    void Back(ActionEvent event) {

        try {
            AnchorPane user = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/MainDashboard.fxml")));
            root.getChildren().setAll(user);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    @FXML
    void addDetails(ActionEvent event) {            //This Method Button Removed Due to Unwanted
        try {

            ValidationController v = new ValidationController();

            if (v.numbersOnly(classAvailableField)&&(v.numbersOnly(postalCodeField))&&(v.validatePhone(pricipalNoField))) {

                String SchoolName = SchoolNameField.getText();
                String SchoolAddress = SchoolAddressField.getText();
                String classAvailable = classAvailableField.getText();
                String postalCode = postalCodeField.getText();
                String dateOfEstd = dateOfEstdField.getText();
                String totalLandArea = totalLandAreaField.getText();
                String province = provinceField.getText();
                String nameOfPrincipal = nameOfPrincipalField.getText();
                String pricipalNo = pricipalNoField.getText();

                School sch = new School(SchoolName, SchoolAddress, classAvailable, postalCode, dateOfEstd, totalLandArea, province, nameOfPrincipal, pricipalNo);

                int i = SchoolController.AddDetails(sch);

                if (i > 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Updated Successfully");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("School Information");
                    alert.setHeaderText(null);
                    alert.setContentText("There was an error updating details!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void printDetails(ActionEvent event) {

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            InputStream report = getClass().getResourceAsStream("/sms/Reports/SchoolInfo.jrxml");
            JasperDesign jd = JRXmlLoader.load(report);
            JRDesignQuery query = new JRDesignQuery();
            query.setText("select * from schoolinfo");
            jd.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd);


        } catch (ClassNotFoundException | SQLException | JRException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void updateDetails(ActionEvent event) {
        try {
            String SchoolName = SchoolNameField.getText();
            String SchoolAddress = SchoolAddressField.getText();
            String classAvailable = classAvailableField.getText();
            String postalCode = postalCodeField.getText();
            String dateOfEstd = dateOfEstdField.getText();
            String totalLandArea = totalLandAreaField.getText();
            String province = provinceField.getText();
            String nameOfPrincipal = nameOfPrincipalField.getText();
            String pricipalNo = pricipalNoField.getText();

            School sch = new School(SchoolName,SchoolAddress,classAvailable,postalCode,dateOfEstd,totalLandArea,province,nameOfPrincipal,pricipalNo);

            int i = SchoolController.updateInfo(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information Updated Successfully!");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("There was an error updating details!");
                alert.showAndWait();
            }

        }catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
