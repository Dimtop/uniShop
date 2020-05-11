package dbconnector;

import java.sql.SQLException;
import java.util.ArrayList;
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
        usernameInput.close();

        Scanner passwordInput = new Scanner(System.in);
        System.out.println("Password: ");
        String password = passwordInput.nextLine();
        passwordInput.close();

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


        //EMAIL UPDATE
        int emailUpdateResult = uc.updateEmail(3, "fotiosperkasKKE@gmail.com");
        System.out.println(emailUpdateResult);

        //MESSAGES UPDATE
        ArrayList<String> dumbMessages = new ArrayList<String>();
        dumbMessages.add("122");
        dumbMessages.add("123");

        int messagesUpdateResult = uc.updateMessages(3, dumbMessages);
        System.out.println(messagesUpdateResult);

        int deleteResult =  uc.deleteUser(5);
        System.out.println(deleteResult);

        //CLOSING CONNECTION
        try {
            uc.getDBConnection().close();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }


    }
}