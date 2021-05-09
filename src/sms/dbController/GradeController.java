package sms.dbController;

import com.mysql.jdbc.PreparedStatement;
import sms.db.DBConnection;
import sms.model.Grade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GradeController {

    /**
     * getGrades Method
     * @return Grades
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<String> getGrades() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select grade From grades");

        ArrayList<String>gradeList=new ArrayList<>();
        while(rst.next()) {
            gradeList.add(rst.getString("grade"));
        }
        return gradeList;
    }
}
