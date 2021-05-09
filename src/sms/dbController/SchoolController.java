package sms.dbController;

import sms.db.DBConnection;
import sms.model.School;
import sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SchoolController {

    /**
     * schoolInfo method gives you information about the school
     * @return information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static School schoolInfo() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM schoolinfo";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()) {
            School s = new School(
                    rst.getString("SchoolName"),
                    rst.getString("SchoolAddress"),
                    rst.getString("classAvailable"),
                    rst.getString("postalCode"),
                    rst.getString("dateOfEstd"),
                    rst.getString("totalLandArea"),
                    rst.getString("province"),
                    rst.getString("nameOfPrincipal"),
                    rst.getString("pricipalNo")
            );
            return s;
        }
        return null;
    }

    /**
     * AddDetails method lets you insert school information
     * @param school
     * @return The new inserted information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int AddDetails(School school)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO schoolinfo VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getPostalCode());
        stm.setObject(5, school.getDateOfEstd());
        stm.setObject(6, school.getTotalLandArea());
        stm.setObject(7, school.getProvince());
        stm.setObject(8, school.getNameOfPrincipal());
        stm.setObject(9, school.getPricipalNo());

        return  stm.executeUpdate();
    }

    /**
     * updateInfo method lets you upodate school info
     * @param school
     * @return The new updated information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int updateInfo(School school) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE schoolinfo SET SchoolName= ? ,SchoolAddress= ? ,classAvailable= ? ,postalCode= ? ,dateOfEstd=? ,totalLandArea=? ,province=? ,nameOfPrincipal=? , pricipalNo=? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getPostalCode());
        stm.setObject(5, school.getDateOfEstd());
        stm.setObject(6, school.getTotalLandArea());
        stm.setObject(7, school.getProvince());
        stm.setObject(8, school.getNameOfPrincipal());
        stm.setObject(9, school.getPricipalNo());

        return  stm.executeUpdate();
    }
}
