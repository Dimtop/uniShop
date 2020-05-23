package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*	User Interface of the system's home screen
 * 	displayed on a Guest User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Guest extends HomeScreen {

	protected JPanel buttonsPanel = new JPanel();
	protected JButton loginButton = new JButton("LogIn");
	protected JButton registerButton = new JButton("Register");	
	
	protected ArrayList<String> tags = new ArrayList<>(); //testing
	
	public HomeScreen_Guest(ArrayList<String> tags, ArrayList<String> ads) {
		super(tags,ads);
		
		//Testing
		this.tags = tags;
		
		//Top Buttons setup
		setupTopButtons();
		
		//Ads Panel setup
		setupAdsPanel(ads);
	}
	
	@Override
	protected void setupAdsPanel(ArrayList<String> ads)  {
		JScrollPane adsScrollPane = new JScrollPane();
		
		adsPanel.setPreferredSize(new Dimension(937, ads.size()*(gap+150)-gap));
		adsPanel.setLayout(null);
		
		AdPanel adPanel;
		int height = 0;
		for(String str : ads) {
			adPanel = new AdPanel(str);
			adPanel.setBounds(0, height, adPanel.getWidth(), adPanel.getHeight());
			adsPanel.add(adPanel);
			
			height += adPanel.getHeight()+gap;
		}
		
		adsScrollPane.setBounds(270, 40, 955, 620);
		adsScrollPane.setViewportView(adsPanel);
		adsScrollPane.getVerticalScrollBar().setUnitIncrement(16); //increase scroll speed
		mainPanel.add(adsScrollPane);
	}

	@Override
	protected void setupTopButtons() {
		
		//Login Button Section
		loginButton.setSize(70, 20);
		loginButton.setLocation(this.getWidth()-loginButton.getWidth()-30, gap);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginWindow();
				System.out.println("test");
			}
		});
		this.getContentPane().add(loginButton);
		
		//Register Button Section
		registerButton.setSize(100, 20);
		registerButton.setLocation(loginButton.getX()-registerButton.getWidth()-gap, gap);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register(tags);
				System.out.println("test");
			}
		});
		this.getContentPane().add(registerButton);
		
	}
}
