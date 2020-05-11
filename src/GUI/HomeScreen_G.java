package GUI;

import java.util.*;

import javax.swing.*;

/*	User Interface of the system's home screen
 * 	displayed on a Guest User 
 * 	Input :
 */

public class HomeScreen_G extends HomeScreen {

	private JButton logInButton = new JButton("LogIn");
	private JButton registerButton = new JButton("Register");
	
	public HomeScreen_G(ArrayList<String> preferences) {
		
		super(preferences);
		
		//TopButtons Section
		setUpTopButtons();
	}
	
	//setting up Top Buttons
	@Override
	protected void setUpTopButtons() {
		
		//LogIn Button
		logInButton.setSize(65, 20);
		logInButton.setLocation(1169, 10);
		getContentPane().add(logInButton);
		
		//Register Button
		registerButton.setSize(85, 20);
		registerButton.setLocation(1074, 10);
		getContentPane().add(registerButton);
	}
}
