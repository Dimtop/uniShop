package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*	User Interface of the system's home screen
 * 	displayed on a Guest User 
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public class HomeScreen_Guest extends HomeScreen {

	protected JPanel buttonsPanel = new JPanel();
	protected JButton loginButton = new JButton("LogIn");
	protected JButton registerButton = new JButton("Register");	
	
	public HomeScreen_Guest(ArrayList<String> tags, ArrayList<String> ads) {
		super(tags,ads);
		
		//Top Buttons setup
		setupTopButtons();
	}

	@Override
	protected void setupTopButtons() {
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginWindow();
				System.out.println("test");
			}
		});
		
		//Login Button Section
		loginButton.setSize(70, 20);
		loginButton.setLocation(this.getWidth()-loginButton.getWidth()-30, gap);		
		this.getContentPane().add(loginButton);
		
		//Register Button Section
		registerButton.setSize(100, 20);
		registerButton.setLocation(loginButton.getX()-registerButton.getWidth()-gap, gap);
		this.getContentPane().add(registerButton);
		
	}
}
