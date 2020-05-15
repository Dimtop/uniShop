package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*	User Interface of the system's home screen
 * 	displayed on a Registered User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Registered extends HomeScreen {

	protected JButton logoutButton = new JButton("LogOut");
	protected JButton myProfileButton = new JButton("My Profile");
	protected JButton upgradePremiumPlanButton = new JButton("Upgrade Premium Plan");
	protected JButton wishListButton = new JButton("WishList");
	
	protected JSeparator separator = new JSeparator();
	protected JPanel leftButtonsPanel = new JPanel();
	protected JButton createNewAd = new JButton("Create New Ad");
	protected JButton myMessages = new JButton("My Messages");
	
	public HomeScreen_Registered(ArrayList<String> tags, ArrayList<String> ads) {
		super(tags, ads);
		
		//Top Buttons setup
		setupTopButtons();
		
		//Left Buttons setup
		setupLeftButtons();
	}
	
	protected void setupLeftButtons() {
		
		//Separator Section
		separator.setBackground(Color.BLACK);
		separator.setSize(searchPanel.getWidth(), 5);
		separator.setLocation(gap, 2*gap + searchPanel.getHeight());
		mainPanel.add(separator);
		
		//Panel Section
		leftButtonsPanel.setLayout(null);
		leftButtonsPanel.setBounds(gap, 3*gap + searchPanel.getHeight(), searchPanel.getWidth(), 120);
		getContentPane().add(leftButtonsPanel);
		
		//Create New Ad Button Section
		createNewAd.setSize(searchPanel.getWidth()-10, 45);
		createNewAd.setLocation(5, 5);
		leftButtonsPanel.add(createNewAd);
		
		//My Messages Button Section
		myMessages.setSize(searchPanel.getWidth()-10, 45);
		myMessages.setLocation(5, 70);
		myMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyMessages();
			}
		});
		leftButtonsPanel.add(myMessages);
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
		myProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyProfile(false);
			}
		});
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
