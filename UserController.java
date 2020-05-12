package dbconnector;

import java.sql.*;
import java.util.ArrayList;


//THIS IS THE USER CONTROLLER
public class UserController {


    private Connection dbConnection;
    private Statement dbStatement;
    ResultSet usersCollection;

    public UserController() {
        DatabaseConnector dbConnector = new DatabaseConnector();
        this.dbConnection = dbConnector.connect();
        try {
            this.dbStatement = this.dbConnection.createStatement();
            this.usersCollection = this.dbStatement.executeQuery("SELECT * FROM Users");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String registerUser(String username, String password, String email, int premium, String preferences,
            int tier) {

        boolean userExists = false;
        try {
            while (this.usersCollection.next()) {
                if (this.searchUserByUsername(username) || this.searchUserByEmail(email)) {
                    userExists = true;
                }
            }

            if (userExists) {
                return "The username or the email has alredy been used";
            } else {
                if (tier < 0 || tier > 2) {
                    return "Tier should be between 1-3";
                } else {
                    this.dbStatement.executeUpdate(
                            "INSERT INTO Users VALUES (NULL,'" + username + "','" + password + "','" + email + "',"
                                    + premium + "," + "''," + preferences + "," + tier + ",''," + "''" + ");"

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

            while (this.usersCollection.next()) {
                if (this.usersCollection.getString("username").equals(username)
                        && this.usersCollection.getString("passwrd").equals(password)) {
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

    public int updateEmail(int userID, String emailToSet) {

        try {

            this.dbStatement.executeUpdate("UPDATE Users SET email='" + emailToSet + "' WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updatePremiumPlan(int userID, int premiumPlanToSet) {

        if (premiumPlanToSet < 0) {
            premiumPlanToSet = 0;
        } else if (premiumPlanToSet > 1) {
            premiumPlanToSet = 1;
        }

        try {
            this.dbStatement
                    .executeUpdate("UPDATE Users SET premium=" + premiumPlanToSet + " WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updateWishlist(int userID, ArrayList<String> wishlistToSet) {
        try {
            this.dbStatement.executeUpdate("UPDATE Users SET wishlist='" + this.normalizeStringArrays(wishlistToSet)
                    + "' WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updatePreferences(int userID, ArrayList<String> preferencesToSet) {
        try {
            this.dbStatement.executeUpdate("UPDATE Users SET preferences='"
                    + this.normalizeStringArrays(preferencesToSet) + "' WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updateTier(int userID, int tierToSet) {

        if (tierToSet < 0 || tierToSet > 2) {
            return 0;
        }

        try {
            this.dbStatement.executeUpdate("UPDATE Users SET tier=" + tierToSet + " WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updateMessages(int userID, ArrayList<String> messagesToSet) {
        try {
            this.dbStatement.executeUpdate("UPDATE Users SET messages='" + this.normalizeStringArrays(messagesToSet)
                    + "' WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int updateAds(int userID, ArrayList<String> adsToSet) {
        try {
            this.dbStatement.executeUpdate(
                    "UPDATE Users SET ads='" + this.normalizeStringArrays(adsToSet) + "' WHERE userID=" + userID + ";");
            return 1;

        } catch (SQLException e) {

            e.printStackTrace();
            return 0;
        }
    }

    public int deleteUser(int userID) {
        try {
            this.dbStatement.executeUpdate("DELETE FROM Users WHERE userID=" + userID + ";");
            return 1;
        } catch (SQLException e) {
      
            e.printStackTrace();
            return 0;
        }
    }




    private String parseUpdateField(UserModelFiledsEnum fieldToParse) {
        switch (fieldToParse) {

            case USERNAME:
                return "username";
            case PASSWORD:
                return "passwrd";
            case EMAIL:
                return "email";
            case PREMIUM:
                return "premium";
            case WISHLIST:
                return "wishlist";
            case PREFERENCES:
                return "preferences";
            case TIER:
                return "tier";
            case MESSAGES:
                return "messages";
            case ADS:
                return "ads";
            default:
                return "";
        }
    }

    private String normalizeStringArrays(ArrayList<String> arrayToParse) {

        String parsedString = "";

        for (String currString : arrayToParse) {
            parsedString += currString + ",";
        }

        parsedString = parsedString.substring(0, parsedString.length() - 1);

        return parsedString;
    }

    private boolean searchUserByUsername(String usernameToSearch) {

        try {
            while (this.usersCollection.next()) {
                if (this.usersCollection.getString("username").equals(usernameToSearch)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
      

    }

    private boolean searchUserByEmail(String emailToSearch){

        try {
            while (this.usersCollection.next()) {
                if (this.usersCollection.getString("email").equals(emailToSearch)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

  

    public Connection getDBConnection(){
        return this.dbConnection;
    }

}