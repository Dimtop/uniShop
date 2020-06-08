package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniShop.*;

/*	User Interface of the system's home screen
 * 	displayed on a Premium User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Premium extends HomeScreen_Registered {

	protected JButton viewPremiumPlanButton;
	
	protected Premium currUser;
	
	public HomeScreen_Premium(ArrayList<String> tags, ArrayList<Ad> ads, Premium user) {
		super(tags, ads, user);
		this.currUser = user;
	}
	
	protected void setupTopButtons() {
		super.setupTopButtons();
		
		addButton();
	}

	protected void addButton() {
		
		//View Premium Plan Button Section
		viewPremiumPlanButton = new JButton("View Premium Plan");
		viewPremiumPlanButton.setSize(150, 20);
		viewPremiumPlanButton.setLocation(wishListButton.getX()-viewPremiumPlanButton.getWidth()-gap, gap);
		viewPremiumPlanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message = "You are on tier: " + currUser.getTier(); 
				
				JOptionPane.showMessageDialog(mainPanel, message);
			}
		});
		this.getContentPane().add(viewPremiumPlanButton);		
		
	}
	
	@Override
	protected void creatingNewAdListener() {
		createNewAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateNewAdPrem();
			}
		});
	}
	
	protected void upgradeToPremiumPlan(JFrame currentFrame) {
		
		currUser.setTier(currUser.getTier()+1);
		String message = "Your premium plan has update on tier " + currUser.getTier(); 
		//update db
		
		JOptionPane.showMessageDialog(mainPanel, message);
		
		if(currUser.getTier() == 3) {
			this.upgradePremiumPlanButton.setEnabled(false);
			currentFrame.revalidate();
		}
	}
	
	@Override
	protected User getCurrUser() {
		return this.currUser;
	}

}
