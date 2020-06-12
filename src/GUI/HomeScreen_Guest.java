package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uniShop.*;

/*	User Interface of the system's home screen
 * 	displayed on a Guest User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Guest extends HomeScreen {

	protected LocalDataBase db;
	
	protected JPanel buttonsPanel = new JPanel();
	protected JButton loginButton = new JButton("LogIn");
	protected JButton registerButton = new JButton("Register");
	
	protected JFrame currFrame;
	
	public HomeScreen_Guest(LocalDataBase db) {
		super(db, new Guest(db));
		this.db = db;
		this.currFrame = this;
		
		//Top Buttons setup
		setupTopButtons();
		
		//Adding Ads Panel
		creatingAdsPanel(ads);
		adsScrollPane.setViewportView(adsPanel);
	}
	
	@Override
	protected void creatingAdsPanel(ArrayList<Ad> ads) {
		
		adsPanel.setPreferredSize(new Dimension(937, ads.size()*(gap+150)-gap));
		adsPanel.setLayout(null);
		adsPanel.removeAll();
		
		AdPanel adPanel;
		int height = 0;
		for(Ad currAd : ads) {
			adPanel = new AdPanel(currAd, db);
			adPanel.setBounds(0, height, adPanel.getWidth(), adPanel.getHeight());
			adsPanel.add(adPanel);
			
			height += adPanel.getHeight()+gap;
		}
	}


	@Override
	protected void setupTopButtons() {
		
		//Login Button Section
		loginButton.setSize(70, 20);
		loginButton.setLocation(this.getWidth()-loginButton.getWidth()-30, gap);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginWindow(db , currFrame);
			}
		});
		this.getContentPane().add(loginButton);
		
		//Register Button Section
		registerButton.setSize(100, 20);
		registerButton.setLocation(loginButton.getX()-registerButton.getWidth()-gap, gap);
		JFrame currFrame = this;
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register(db, currFrame);
			}
		});
		this.getContentPane().add(registerButton);
		
	}
}
