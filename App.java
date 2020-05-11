package dbconnector;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {

        AdController ac = new AdController();

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("cars");
        tags.add("lessons");

        ArrayList<String> photoLinks = new ArrayList<String>();
        photoLinks.add("https://1");
        photoLinks.add("https://2");

        ac.createAd(1, "2020-11-05" ,tags , photoLinks, "This is a description.", "Driving Lessons");

        //CLOSING CONNECTION
        try {
            ac.getDBConnection().close();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }


    }
}