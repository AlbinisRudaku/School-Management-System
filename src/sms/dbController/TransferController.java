package sms.dbController;

import sms.db.DBConnection;
import sms.model.Student;
import sms.model.User;

import java.sql.*;
import java.util.ArrayList;

public class TransferController {


    public static int updateGrade(String year) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE paststudents SET year= '" + year + "'  WHERE year= 'Grade 5'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    public static int deleteStudent(String grade) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Students WHERE grade ='" + grade + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    public static ArrayList<Student> getGrade5() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From students Where grade = 'Grade 5'");
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10));

            studentList.add(student);
        }
        return studentList;
    }
}
