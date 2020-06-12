package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import uniShop.*;

/*	User Interface of the system's home screen
 * 	displayed on a Registered User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Registered extends HomeScreen {

	protected LocalDataBase db;
	
	protected JButton logoutButton = new JButton("LogOut");
	protected JButton myProfileButton = new JButton("My Profile");
	protected JButton upgradePremiumPlanButton = new JButton("Upgrade Premium Plan");
	protected JButton wishListButton = new JButton("WishList");
	
	protected JSeparator separator = new JSeparator();
	protected JPanel leftButtonsPanel = new JPanel();
	protected JButton createNewAd = new JButton("Create New Ad");
	protected JButton myMessages = new JButton("My Messages");
	
	protected ArrayList<String> tags = new ArrayList<>();
	protected ArrayList<Ad> ads = new ArrayList<>();
	
	protected Registered currUser;
	protected JFrame currFrame;
	
	public HomeScreen_Registered(LocalDataBase db, Registered user) {
		super(db, user);
		this.db = db;
		this.tags = this.db.getSystemPreferences();
		this.ads = this.db.randomizeAds();
		this.currUser = user;
		user.setStatus(1);
		this.currFrame = this;
		
		//Top Buttons setup
		setupTopButtons();
		
		//Left Buttons setup
		setupLeftButtons();
		
		//Adding Ads Panel
		creatingAdsPanel(ads);
		//adsScrollPane.setViewportView(adsPanel);
		
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
		creatingNewAdListener();
		leftButtonsPanel.add(createNewAd);
		
		//My Messages Button Section
		myMessages.setSize(searchPanel.getWidth()-10, 45);
		myMessages.setLocation(5, 70);
		myMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyMessages(currUser);
			}
		});
		leftButtonsPanel.add(myMessages);
	}
	
	protected void creatingNewAdListener() {
		createNewAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateNewAd(db,currUser);
			}
		});
	}
	
	@Override
	protected void creatingAdsPanel(ArrayList<Ad> ads) {
		
		adsPanel.setPreferredSize(new Dimension(937, ads.size()*(gap+150)-gap));
		adsPanel.setLayout(null);
		adsPanel.removeAll();
		
		AdPanel adPanel;
		int height = 0;
		for(Ad currAd : ads) {
			adPanel = new AdPanelRegistered(currAd, currUser, db);
			adPanel.setBounds(0, height, adPanel.getWidth(), adPanel.getHeight());
			adsPanel.add(adPanel);
			
			height += adPanel.getHeight()+gap;
		}
		
		adsScrollPane.setViewportView(adsPanel);
	}

	@Override
	protected void setupTopButtons() {
		
		//Log Out Button Section
		logoutButton.setSize(75, 20);
		logoutButton.setLocation(this.getWidth()-logoutButton.getWidth()-30, gap);	
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you want to logout?", 
						"Upgrade to Premium Plan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					currUser.setStatus(0);
					currFrame.dispose();
					new HomeScreen_Guest(db);
				}
			}
		});
		this.getContentPane().add(logoutButton);
		
		//My Profile Button Section
		myProfileButton.setSize(100, 20);
		myProfileButton.setLocation(logoutButton.getX()-myProfileButton.getWidth()-gap, gap);
		myProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyProfile(db, false, currUser, currFrame);
			}
		});
		this.getContentPane().add(myProfileButton);
		
		//Upgrade Premium Plan Button Section
		upgradePremiumPlanButton.setSize(170, 20);
		upgradePremiumPlanButton.setLocation(myProfileButton.getX()-upgradePremiumPlanButton.getWidth()-gap, gap);
		JFrame currentFrame = this;
		upgradePremiumPlanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you want to upgrade to Premium Plan?", 
						"Upgrade to Premium Plan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					upgradeToPremiumPlan(currentFrame);
				}
			}
		});
		this.getContentPane().add(upgradePremiumPlanButton);
		
		//WishList Button Section
		wishListButton.setSize(90, 20);
		wishListButton.setLocation(upgradePremiumPlanButton.getX()-wishListButton.getWidth()-gap, gap);
		wishListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdListFrame(currUser.getWishlist(), "Wishlist", currUser, db);
			}
		});
		this.getContentPane().add(wishListButton);		
	}
	
	protected void upgradeToPremiumPlan(JFrame currentFrame) {
		currentFrame.dispose();
		
		Premium premUser = new Premium(currUser);
		
		new HomeScreen_Premium(this.db, premUser);
	}
}
