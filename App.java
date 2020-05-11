package dbconnector;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {

        UserController uc = new UserController();


        //REGISTER
        String registerResult = uc.registerUser("tsirpanis", "123456", "tsirp@gmail.com", 0, "''", 2);
        System.out.println(registerResult);


        //LOGIN
        Scanner usernameInput = new Scanner(System.in);
        System.out.println("Username: ");
        String username = usernameInput.nextLine();

        Scanner passwordInput = new Scanner(System.in);
        System.out.println("Password: ");
        String password = passwordInput.nextLine();

        int loginResult = uc.authenticateUser(username, password);

        if (loginResult == 0) {
            System.out.println("Login failed.");
        } else {
            System.out.println("Loged in.");
        }

        //USERNAME UPDATE
        int usernameUpdateResult =  uc.updateUsername(2, "stampoulidisGeorgios");
        
        if(usernameUpdateResult == 0){
            System.out.println("Update failed.");
        }
        else{
            System.out.println("Updated.");
        }

        //PASSWORD UPDATE 
        int passwordUpdateResult =  uc.updatePassword(2, "stamp12");
        
        if(passwordUpdateResult == 0){
            System.out.println("Update failed.");
        }
        else{
            System.out.println("Updated.");
        }


        //CLOSING CONNECTION
        try {
            uc.getDBConnection().close();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }


    }
}