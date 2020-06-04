package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uniShop.*;

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
	private JPanel preferencesPanel = new JPanel();
	private ArrayList<String> preferences = new ArrayList<>();
	private ArrayList<JCheckBox> checkboxList = new ArrayList<>();
	private ArrayList<String> userPreferences = new ArrayList<>();
	
	private boolean editable;
	
	private Registered currUser;
	
	public ProfileInfoPanel(boolean editable, Registered user) {
		this.editable = editable;
		this.currUser = user;
		
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
		usernameField.setText(currUser.getUsername());
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
		emailField.setText(currUser.getEmail());
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
		premiumField.setText(currUser.premiumToText());
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
		
		//Preferences Scroll Pane
		prefScroll.setBounds(130, 180, 210, 150);
		prefScroll.getVerticalScrollBar().setUnitIncrement(16); //increases the scroll speed
		this.add(prefScroll);
		
		//Testing
		preferences.add("Cars");   
		preferences.add("Tech");   
		preferences.add("House");  
		preferences.add("Clothes");
				
		userPreferences = currUser.getPreferences();
		
		//Preferences Panel
		preferencesPanel.setLocation(5, 5);
		preferencesPanel.setLayout(null);
		prefScroll.setViewportView(preferencesPanel);
		
		//Preferences Field
		if(editable) {
			preferencesPanel.setPreferredSize(new Dimension(190, preferences.size()*30));
			
			//preferences = server.getPreferences;
			JCheckBox checkbox;
			JLabel label;
			int height = 0;
			for(String str : preferences) {
				checkbox = new JCheckBox();
				checkbox.setSize(20, 20);
				checkbox.setLocation(0, height);
				if(userPreferences.contains(str)) {
					checkbox.setSelected(true);
				}
				checkboxList.add(checkbox);
				preferencesPanel.add(checkbox);
				
				label = new JLabel(str);
				label.setSize(190, 20);
				label.setLocation(30, height);
				preferencesPanel.add(label);
				
				height+= 30;
			}
			
		}
		else {
			preferencesPanel.setPreferredSize(new Dimension(190, userPreferences.size()*30));
			
			//preferences = user.getPreferences();
			JLabel label;
			int height = 0;
			//for(String str : preferences) {
			for(String str : userPreferences) {
				label = new JLabel(str);
				label.setSize(190, 20);
				label.setLocation(10, height);
				preferencesPanel.add(label);
				
				height+= 30;
			}
		}
	}
	
	private void setupPanelProperties() {
		this.setSize(360, 350);
		this.setLayout(null);
	}
	
	//returning list of check boxes from preferences
	public ArrayList<JCheckBox> getCheckBoxList(){
		return this.checkboxList;
	}
	
	//returns strings with preferences from check boxes
	public ArrayList<String> getTable() {
		return preferences;
	}
	
	public String getNewUsername() {
		return usernameField.getText();
	}
	
	public String getNewPassword() {
		return passwordField.getText();
	}
	
	public String getNewEmail() {
		return emailField.getText();
	}
}
