package GUI;

import java.util.ArrayList;

import javax.swing.*;

/*	User Interface of the system's home screen
 * 	displayed on a Registered User
 * 	Input :
 */

public class HomeScreen_R extends HomeScreen {
	
	private JButton logOutButton = new JButton("Log Out");
	private JButton myProfileButton = new JButton("My Profile");
	private JButton upgradePremiumPlanButton = new JButton("Upgrade Premium Plan");
	private JButton wishlistButton = new JButton("WishList");
	
	public HomeScreen_R(ArrayList<String> preferences) {
		super(preferences);
		
		//TopButtons Section
		setUpTopButtons();
	}
	
	//setting up Top Buttons
	@Override
	protected void setUpTopButtons() {
		
		//Log Out Button
		logOutButton.setSize(85, 20);
		//logOutButton.setLocation(1149, 10);
		topButtonsPanel.add(logOutButton);
		
		//My Profile Button
		myProfileButton.setSize(100, 20);
		myProfileButton.setLocation(1039, 10);
		//getContentPane().add(myProfileButton);
		
		//Upgrade Premium Plan Button
		
		
		//WishList Button
		
		
	}
}
