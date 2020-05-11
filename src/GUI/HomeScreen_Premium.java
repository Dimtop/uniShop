package GUI;

import java.util.ArrayList;

import javax.swing.JButton;

public class HomeScreen_Premium extends HomeScreen_Registered {

	protected JButton viewPremiumPlanButton = new JButton("View Premium Plan");
	
	public HomeScreen_Premium(ArrayList<String> tags, ArrayList<String> ads) {
		super(tags, ads);
		
		//adding premium user's button further more
		addButton();
	}

	protected void addButton() {
		
		//View Premium Plan Button Section
		viewPremiumPlanButton.setSize(150, 20);
		viewPremiumPlanButton.setLocation(wishListButton.getX()-viewPremiumPlanButton.getWidth()-gap, gap);
		this.getContentPane().add(viewPremiumPlanButton);		
		
	}

}
