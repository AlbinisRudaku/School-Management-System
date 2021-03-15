package sms.db;

import java.sql.*;


public class DBConnection{
    private Connection connection;
    private static DBConnection dbConnection;

    private DBConnection()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagementsystem","root","");
    }
    public Connection getConnection(){

        return connection;
    }
    public static DBConnection getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

}


