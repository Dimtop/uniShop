package dbconnector;

import java.sql.*;

public class UserController {

    private Connection dbConnection;

    public UserController(){
        DatabaseConnector dbConnector = new DatabaseConnector();
        this.dbConnection = dbConnector.connect();
    }

    public void createUser(){

    }

}