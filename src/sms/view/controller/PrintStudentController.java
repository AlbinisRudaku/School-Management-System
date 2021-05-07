package sms.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sms.db.DBConnection;
import sms.dbController.GradeController;
import sms.tableModel.StudentTableModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrintStudentController implements Initializable {


    @FXML
    private TableView<StudentTableModel> studentTable;

    @FXML
    private TableColumn<StudentTableModel, String> adNoColumn;

    @FXML
    private TableColumn<StudentTableModel, String> fullNameColumn;

    @FXML
    private TableColumn<StudentTableModel, String> dobColumn;

    @FXML
    private TableColumn<StudentTableModel, String> doaColumn;

    @FXML
    private TableColumn<StudentTableModel, String> genderColumn;

    @FXML
    private TableColumn<StudentTableModel, String> gradeColumn;

    @FXML
    private TableColumn<StudentTableModel, String> parentNameColumn;

    @FXML
    private TableColumn<StudentTableModel, String> nicColumn;

    @FXML
    private TableColumn<StudentTableModel, String> contactNoColumn;

    @FXML
    private TableColumn<StudentTableModel, String> addressColumn;

    @FXML
    private ComboBox<String> loadGrades;

    @FXML
    private ComboBox<String> loadYears;

    @FXML
    private ComboBox<String> loadGender;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton printStudents;

    @FXML
    private JFXCheckBox adNoCheckBox;

    @FXML
    private JFXCheckBox fullNameCheckBox;

    @FXML
    private JFXCheckBox dobCheckBox;

    @FXML
    private JFXCheckBox doaCheckBox;

    @FXML
    private JFXCheckBox genderCheckBox;

    @FXML
    private JFXCheckBox parentCheckBox;

    @FXML
    private JFXCheckBox nicCheckBox;

    @FXML
    private JFXCheckBox contactCheckBox;

    @FXML
    private JFXCheckBox addressCheckBox;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton Back;

    ObservableList<StudentTableModel> studentList = FXCollections.observableArrayList();

    @FXML
    void Back(ActionEvent event) {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StudentManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGrades();
        loadYears();
        loadGender.getItems().addAll("All", "M", "F");
    }

    @FXML
    void loadGender() {

    }

    @FXML
    void loadGrades() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getGrades();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadGrades.setItems(observableArray);
        }
    }


    @FXML
    void loadYears() {
        ArrayList arrayList = null;
        try {
            arrayList = GradeController.getYears();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ObservableList observableArray = FXCollections.observableArrayList();
        observableArray.addAll(arrayList);

        if (observableArray != null) {
            loadYears.setItems(observableArray);
        }
    }

    @FXML
    void generate(ActionEvent event) {

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            if (gender == "All") {

                String sql = "select * from students where grade = '" + grade + "'";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"),
                            rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("grade"), rs.getString("parentName"),
                            rs.getString("nic"), rs.getString("phone"), rs.getString("address"));

                    studentList.add(s);
                }
            } else {
                String sql2 = "select * from students where grade = '" + grade + "' AND gender = '" + gender + "'";
                ResultSet rs = conn.createStatement().executeQuery(sql2);

                while (rs.next()) {
                    StudentTableModel s = new StudentTableModel(rs.getInt("adNo"), rs.getString("fullName"),
                            rs.getString("dob"), rs.getString("doa"), rs.getString("gender"), rs.getString("grade"), rs.getString("parentName"),
                            rs.getString("nic"), rs.getString("phone"), rs.getString("address"));

                    studentList.add(s);
                }
            }

            adNoColumn.setCellValueFactory(new PropertyValueFactory<>("adNo"));
            fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
            dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            doaColumn.setCellValueFactory(new PropertyValueFactory<>("doa"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
            parentNameColumn.setCellValueFactory(new PropertyValueFactory<>("parentName"));
            nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
            contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

            studentTable.setItems(studentList);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void printStudents(ActionEvent event) {

        try {
            studentTable.getItems().clear();
            String grade = loadGrades.getValue();
            String gender = loadGender.getValue();
            String year = loadYears.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();
            InputStream report1 = getClass().getResourceAsStream("/sms/Reports/StudentList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/sms/Reports/StudentListGender.jrxml");
//            InputStream report3 = getClass().getResourceAsStream("/sms/Reports/PastStudentList.jrxml");
//            InputStream report4 = getClass().getResourceAsStream("/sms/Reports/PastStudentListGender.jrxml");

           /* JasperDesign jd = JRXmlLoader.load("src\\sms\\Reports\\StudentList.jrxml");
            JasperDesign jd2 = JRXmlLoader.load("src\\sms\\Reports\\StudentListGender.jrxml");
            JasperDesign jd3 = JRXmlLoader.load("src\\sms\\Reports\\PastStudentList.jrxml");
            JasperDesign jd4 = JRXmlLoader.load("src\\sms\\Reports\\PastStudentListGender.jrxml");
            */
            JRDesignQuery query = new JRDesignQuery();

            if(loadYears.getValue()==null) {

                if (loadGrades != null) {

                    if (gender == "All") {

                        JasperDesign jd = JRXmlLoader.load(report1);
                        query.setText("select * from students where grade = '" + grade + "'");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);

                    } else {
                        JasperDesign jd2 = JRXmlLoader.load(report2);
                        query.setText("select * from students where grade = '" + grade + "' AND gender = '" + gender + "'");
                        jd2.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd2);
                    }
                }
            }
        }catch (ClassNotFoundException | SQLException | JRException e) {
            e.printStackTrace();
        }

    }
}

