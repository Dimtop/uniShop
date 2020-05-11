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

            boolean userExists = false;
            try {
                ResultSet usersCollection = this.dbStatement.executeQuery("SELECT * FROM Users");
    
                while (usersCollection.next()) {
                    if(usersCollection.getString("username").equals(username) || usersCollection.getString("email").equals(email)){
                        userExists = true;
                    }
                }   

                if(userExists){
                    return "The username or the email has alredy been used";
                }
                else{
                    if (tier < 0 || tier > 2) {
                        return "Tier should be between 1-3";
                    }
                    else{
                        this.dbStatement.executeUpdate("INSERT INTO Users VALUES (NULL,'" + username + "','" + password + "','"
                        + email + "'," + premium + "," + "''," + preferences + "," + tier + ",''," + "''" + ");"
    
                        );
                        return "success";
                    }
                }
               
            } catch (SQLException e) {
            
                System.out.println(e);

                return e.toString();
            }
    }

    public int authenticateUser(String username, String password) {

        int userFound = 0;

        try {
            ResultSet usersCollection = this.dbStatement.executeQuery("SELECT * FROM Users");

            while (usersCollection.next()) {
                if (usersCollection.getString("username").equals(username)
                        && usersCollection.getString("passwrd").equals(password)) {
                        userFound = 1;
                }
            }   
            return userFound;
        } catch (SQLException e) {
        
            e.printStackTrace();
            return 0;
        }

    }

    public int updateUsername(int userID, String usernameToSet) {

        try {
            this.dbStatement
                    .executeUpdate("UPDATE Users SET username='" + usernameToSet + "' WHERE userID=" + userID + ";");
            return 1;
        } catch (SQLException e) {
            
            e.printStackTrace();
            return 0;
        }

    }

    public int updatePassword(int userID, String passwordToSet) {

        try {
            this.dbStatement
                    .executeUpdate("UPDATE Users SET passwrd='" + passwordToSet + "' WHERE userID=" + userID + ";");
            return 1;
        } catch (SQLException e) {
            
            e.printStackTrace();
            return 0;
        }

    }

    public Connection getDBConnection(){
        return this.dbConnection;
    }

}