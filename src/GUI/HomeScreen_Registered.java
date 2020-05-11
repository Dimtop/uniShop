package GUI;

import java.util.ArrayList;

import javax.swing.JButton;

public class HomeScreen_Registered extends HomeScreen {

	protected JButton logoutButton = new JButton("LogOut");
	protected JButton myProfileButton = new JButton("My Profile");
	protected JButton upgradePremiumPlanButton = new JButton("Upgrade Premium Plan");
	protected JButton wishListButton = new JButton("WishList");
	
	public HomeScreen_Registered(ArrayList<String> tags, ArrayList<String> ads) {
		super(tags, ads);
		
		//Top Buttons setup
		setupTopButtons();
	}

	@Override
	protected void setupTopButtons() {
		
		//Log Out Button Section
		logoutButton.setSize(75, 20);
		logoutButton.setLocation(this.getWidth()-logoutButton.getWidth()-30, gap);		
		this.getContentPane().add(logoutButton);
		
		//My Profile Button Section
		myProfileButton.setSize(100, 20);
		myProfileButton.setLocation(logoutButton.getX()-myProfileButton.getWidth()-gap, gap);
		this.getContentPane().add(myProfileButton);
		
		//Upgrade Premium Plan Button Section
		upgradePremiumPlanButton.setSize(170, 20);
		upgradePremiumPlanButton.setLocation(myProfileButton.getX()-upgradePremiumPlanButton.getWidth()-gap, gap);
		this.getContentPane().add(upgradePremiumPlanButton);
		
		//WishList Button Section
		wishListButton.setSize(90, 20);
		wishListButton.setLocation(upgradePremiumPlanButton.getX()-wishListButton.getWidth()-gap, gap);
		this.getContentPane().add(wishListButton);
		
		
	}

}
