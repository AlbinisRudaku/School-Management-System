package sms.dbController;

import sms.db.DBConnection;
import sms.model.Staff;
import sms.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserController {

    /**
     * addUser method lets you add users that can open the application
     * @param user
     * @return The new added user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int addUser(User user) throws ClassNotFoundException,SQLException {
        String SQL = "INSERT INTO users VALUES(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getPassword());

        return  stm.executeUpdate();
    }

    /**
     * updateUser lets you update the users information
     * @param user
     * @return The new updated information
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int updateUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE users SET username= ?, password= ?  WHERE username= '" + user.getUsername() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getPassword());

        return  stm.executeUpdate();
    }

    /**
     * deleteUser method lets you delete a user
     * @param username
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int deleteUser(String username) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM users WHERE username ='" + username + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    /**
     * getAllUsers method returns all the users
     * @return All the users registered
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList <User> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From users");
        ArrayList <User> userList = new ArrayList<>();

        while(rst.next()) {
            User user;
            user = new User(rst.getString(1), rst.getString(2));
            userList.add(user);
        }
        return userList;
    }

    /**
     * searchUser method lets you search for users by their name
     * @param username
     * @return The wanted user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static User searchUser(String username) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, username);
        ResultSet rst=stm.executeQuery();

        if(rst.next()) {
            User user = new User(rst.getString("username"), rst.getString("password"));
            return user;
        }
        return null;
    }
}
