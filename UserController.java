package dbconnector;

import java.sql.*;

public class UserController {

    private Connection dbConnection;
    private Statement dbStatement;

    public UserController() {
        DatabaseConnector dbConnector = new DatabaseConnector();
        this.dbConnection = dbConnector.connect();
        try {
            this.dbStatement = this.dbConnection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String registerUser(String username, String password, String email, int premium, String preferences,
            int tier) {

        if (tier < 0 || tier > 2) {
            return "Tier should be between 1-3";
        }
        try {
            this.dbStatement.executeUpdate("INSERT INTO Users VALUES (NULL,'" + username + "','" + password + "','"
                    + email + "'," + premium + "," + "''," + preferences + "," + tier + ",''," + "''" + ");"

            );
            this.dbConnection.close();
            return "success";
        } catch (Exception e) {
            System.out.println(e);

            return e.toString();
        }
    }

    public int authenticateUser(String username, String password) {

  
        try {
            ResultSet usersCollection = this.dbStatement.executeQuery("SELECT * FROM Users");

            while(usersCollection.next()){
                if(usersCollection.getString("username").equals(username) && usersCollection.getString("passwrd").equals(password)){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            return 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }

    }

}