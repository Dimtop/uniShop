package dbconnector;

import java.util.Scanner;

public class App 
{
    public static void main(String args[]){

        UserController uc = new UserController();

        Scanner usernameInput = new Scanner(System.in);
        System.out.println("Username: ");
        String username = usernameInput.nextLine();

        Scanner passwordInput = new Scanner(System.in);
        System.out.println("Password: ");
        String password = passwordInput.nextLine();

        int loginResult = uc.authenticateUser(username, password);


        if(loginResult == 0){
            System.out.println("Login failed.");
        }
        else{
            System.out.println("Loged in.");
        }


        int usernameUpdateResult =  uc.updateUsername(1, "stampoulidisGeorgios");
        
        if(usernameUpdateResult == 0){
            System.out.println("Update failed.");
        }
        else{
            System.out.println("Uopdated.");
        }
    }
}