package sms.dbController;

import javafx.scene.control.Alert;
import sms.model.Student;
import sms.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class StudentController {

    /**
     * AddStudent method lets you add more students
     * @param student
     * @return The new added student
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int AddStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getDob());
        stm.setObject(4, student.getDoa());
        stm.setObject(5, student.getGender());
        stm.setObject(6, student.getGrade());
        stm.setObject(7, student.getParentName());
        stm.setObject(8, student.getNic());
        stm.setObject(9, student.getPhone());
        stm.setObject(10, student.getAddress());

        return  stm.executeUpdate();
    }

    /**
     * searchStudent lets you search students by their name
     * @param adNo
     * @return The student that we want
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Student searchStudent(Integer adNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM students WHERE adNo = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, adNo);
        ResultSet rst=stm.executeQuery();

        if(rst.next()){
            Student s = new Student(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10));
            return s;
        }
        return null;
    }

    /**
     * deleteStudent lets you delete a student
     * @param adNo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int deleteStudent(String adNo) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM students WHERE adNo ='"+adNo+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        return  stm.executeUpdate();
    }

    /**
     * updateStudent lets you update information about the students
     * @param student
     * @return The new updated information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int updateStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE students SET adNo= ? ,fullName= ? ,dob= ? ,doa= ? ,gender= ? ,grade=? ,parentName= ? ,nic= ? ,phone= ? ,address=? WHERE adNo= '" + student.getAdNo() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getDob());
        stm.setObject(4,student.getDoa());
        stm.setObject(5,student.getGender());
        stm.setObject(6,student.getGrade());
        stm.setObject(7,student.getParentName());
        stm.setObject(8,student.getNic());
        stm.setObject(9,student.getPhone());
        stm.setObject(10,student.getAddress());

        return  stm.executeUpdate();
    }
}
