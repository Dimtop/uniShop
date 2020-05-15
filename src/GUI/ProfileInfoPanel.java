package GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ProfileInfoPanel extends JPanel {
	
	private JLabel usernameLabel = new JLabel("Username");
	private JTextField usernameField = new JTextField();
	
	private JLabel passwordLabel = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField();
	
	private JLabel emailLabel = new JLabel("E-mail");
	private JTextField emailField = new JTextField();
	
	private JLabel premiumLabel = new JLabel("Premium");
	private JTextField premiumField = new JTextField();
	
	private JLabel preferencesLabel = new JLabel("Preferences");
	private JScrollPane prefScroll = new JScrollPane();
	
	private boolean editable;
	
	public ProfileInfoPanel(boolean editable) {
		this.editable = editable;
		
		//User Name Section
		setupUsername();
		
		//Password Section
		setupPassword();
		
		//E-mail Section
		setupEmail();
		
		//Premium Section
		setupPremium();
		
		//Preferences Section
		setupPreferences();
		
		//Panel Properties
		setupPanelProperties();
	}
	
	private void setupUsername() {
		
		//User Name Label
		usernameLabel.setSize(90, 20);
		usernameLabel.setLocation(10, 20);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(usernameLabel);
		
		//User Name Field
		usernameField.setSize(230, 20);
		usernameField.setLocation(110, 20);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setEditable(editable);
		this.add(usernameField);
		
	}
	
	private void setupPassword() {
		
		//Password Label
		passwordLabel.setSize(90, 20);
		passwordLabel.setLocation(10, 60);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(passwordLabel);		
		
		//Password Field
		passwordField.setSize(230, 20);
		passwordField.setLocation(110, 60);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setEditable(editable);
		this.add(passwordField);
	}
	
	private void setupEmail() {
		
		//E-mail Label
		emailLabel.setSize(60, 20);
		emailLabel.setLocation(10, 100);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(emailLabel);
		
		//E-mail Field
		emailField.setSize(230, 20);
		emailField.setLocation(110, 100);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailField.setEditable(editable);
		this.add(emailField);
	}
	
	private void setupPremium() {
		
		//Premium Label
		premiumLabel.setSize(80, 20);
		premiumLabel.setLocation(10, 140);
		premiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(premiumLabel);
		
		//Premium Field
		premiumField.setSize(230, 20);
		premiumField.setLocation(110, 140);
		premiumField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		premiumField.setEditable(false);
		this.add(premiumField);
	}
	
	private void setupPreferences() {
		
		//Preferences Label
		preferencesLabel.setSize(110, 20);
		preferencesLabel.setLocation(10, 180);
		preferencesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(preferencesLabel);
		
		//Preferences Field
	}
	
	private void setupPanelProperties() {
		this.setSize(360, 350);
		this.setLayout(null);
	}
}
