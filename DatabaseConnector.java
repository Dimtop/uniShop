package dbconnector;

import java.sql.*;

public class DatabaseConnector {
    private String host;
    private String username;
    private String password;


    public DatabaseConnector(){
       
        this.host =  "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7339541";
        this.username  = "sql7339541";
        this.password = "LSVjBcjwWB";
    }   

    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection dbConnection = DriverManager.getConnection(this.host, this.username, this.password);
            Statement dbStatement  = dbConnection.createStatement();
            return dbConnection;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}