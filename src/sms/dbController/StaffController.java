package sms.dbController;

import sms.db.DBConnection;
import sms.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffController {

    /**
     * AddStaff method lets you insert new teachers
     * @param staff
     * @return The new teacher
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int AddStaff(Staff staff)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO staffs VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, staff.getEmpNo());
        stm.setObject(2, staff.getTeacherName());
        stm.setObject(3, staff.getDob());
        stm.setObject(4, staff.getGender());
        stm.setObject(5, staff.getEmail());
        stm.setObject(6, staff.getAssumpOfDuties());
        stm.setObject(7, staff.getPhone());
        stm.setObject(8, staff.getAddress());
        stm.setObject(9, staff.getPrsntGrade());

        return  stm.executeUpdate();
    }

    /**
     * searchStaff lets you search teachers by ID
     * @param empNo
     * @return The wanted teacher/teachers
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Staff searchStaff(Integer empNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staffs WHERE empNo = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, empNo);
        ResultSet rst=stm.executeQuery();

        if(rst.next()) {
            Staff staff = new Staff(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
            return staff;
        }
        return null;
    }

    /**
     * searchStaffByName lets you search teacher by their name
     * @param teacherName
     * @return The wanted teacher/teachers
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Staff searchStaffByName(String teacherName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM staffs WHERE teacherName LIKE '%" + teacherName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();

        if(rst.next()) {
            Staff staff = new Staff(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
            return staff;
        }
        return null;
    }

    /**
     * deleteStaff lets you delete teachers by their ID
     * @param empNo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int deleteStaff(Integer empNo) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM staffs WHERE empNo ='" + empNo + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    /**
     * updateStaff lets you update information about the teachers
     * @param staff
     * @return The new updated information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int updateStaff(Staff staff) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE staffs SET empNo= ?, teacherName= ?, dob= ?, gender= ?, email=?, assumpOfDuties= ?, phone= ? ,address= ?, prsntGrade=? WHERE empNo= '" + staff.getEmpNo() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, staff.getEmpNo());
        stm.setObject(2, staff.getTeacherName());
        stm.setObject(3, staff.getDob());
        stm.setObject(4, staff.getGender());
        stm.setObject(5, staff.getEmail());
        stm.setObject(6, staff.getAssumpOfDuties());
        stm.setObject(7, staff.getPhone());
        stm.setObject(8, staff.getAddress());
        stm.setObject(9, staff.getPrsntGrade());

        return  stm.executeUpdate();
    }
}
