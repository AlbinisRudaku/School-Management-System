package sms.view.controller;

import com.jfoenix.controls.JFXButton;
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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sms.db.DBConnection;
import sms.tableModel.StaffTableModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PrintStaffsController implements Initializable {

    public JFXButton Back2;
    public JFXButton Back1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Type.getItems().addAll("Current Teachers");
    }
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private JFXButton print;

    @FXML
    private JFXButton generate;

    @FXML
    private JFXButton Back;

    @FXML
    private TableView<StaffTableModel> staffTable;

    @FXML
    private TableColumn<StaffTableModel, String> EmpNoColumn;

    @FXML
    private TableColumn<StaffTableModel, String> NameColumn;

    @FXML
    private TableColumn<StaffTableModel, String> dobColumn;

    @FXML
    private TableColumn<StaffTableModel, String> genderColumn;

    @FXML
    private TableColumn<StaffTableModel, String> emailColumn;

    @FXML
    private TableColumn<StaffTableModel, String> assmpDutyColumn;

    @FXML
    private TableColumn<StaffTableModel, String> phoneColumn;

    @FXML
    private TableColumn<StaffTableModel, String> addressColumn;

    @FXML
    private TableColumn<StaffTableModel, String> gradeColumn;

    ObservableList<StaffTableModel> staffList = FXCollections.observableArrayList();

    @FXML
    void Back() {
        try {
            AnchorPane studentMgmt = FXMLLoader.load(getClass().getResource(("/sms/view/fxml/StaffManagement.fxml")));
            root.getChildren().setAll(studentMgmt);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void Type(ActionEvent event) {
    }

    /**
     * Generate print list
     */
    @FXML
    void generate() {
        try {
            staffTable.getItems().clear();
            String type = Type.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();

            if (type == "Current Teachers") {

                String sql = "select * from staffs";
                ResultSet rs = conn.createStatement().executeQuery(sql);

                while (rs.next()) {
                    StaffTableModel staff = new StaffTableModel(
                            rs.getInt("empNo"),
                            rs.getString("teacherName"),
                            rs.getString("dob"),
                            rs.getString("gender"),
                            rs.getString("email"),
                            rs.getString("assumpOfDuties"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            rs.getString("prsntGrade")
                    );
                    staffList.add(staff);
                }
            }

            EmpNoColumn.setCellValueFactory(new PropertyValueFactory<>("empNo"));
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
            dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            assmpDutyColumn.setCellValueFactory(new PropertyValueFactory<>("assumpOfDuties"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("prsntGrade"));

            staffTable.setItems(staffList);

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print list
     * @param event
     */
    @FXML
    void print(ActionEvent event) {
        staffTable.getItems().clear();
        String type = Type.getValue();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            InputStream report1 = getClass().getResourceAsStream("/sms/Reports/StaffList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/sms/Reports/StaffListPast.jrxml");
            JRDesignQuery query = new JRDesignQuery();

            if (type == "Current Teachers"){
                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }
        }
        catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}