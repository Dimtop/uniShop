package dbconnector;

import java.sql.*;
import java.util.ArrayList;

public class AdController {

    private Connection dbConnection;
    private Statement dbStatement;
    ResultSet adsCollection;

    public AdController() {
        DatabaseConnector dbConnector = new DatabaseConnector();
        this.dbConnection = dbConnector.connect();
        try {
            this.dbStatement = this.dbConnection.createStatement();
            this.adsCollection = this.dbStatement.executeQuery("SELECT * FROM hasAd");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int createAd( int buyerID, String datePosted, ArrayList<String> tags, ArrayList<String> photoLinks,
            String description, String adName) {
        try {
            this.dbStatement.executeUpdate("INSERT INTO hasAd VALUES (NULL," + buyerID +",NULL" + ",'" + datePosted + "','"
                    + this.normalizeStringArrays(tags) + "','" + this.normalizeStringArrays(photoLinks) + "','"
                    + description + "',0" + ","  + 0 + ",'" + adName + "');");

                    return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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




    public Connection getDBConnection(){
        return this.dbConnection;
    }




    
}