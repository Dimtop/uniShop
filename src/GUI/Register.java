package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Register extends JFrame {

	private JPanel mainPanel = new JPanel();
	
	private JLabel usernameLabel = new JLabel("Username");
	private JTextField usernameField = new JTextField();
	
	private JLabel passwordLabel = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField();
	
	private JLabel emailLabel = new JLabel("E-mail");
	private JTextField emailField = new JTextField();
	
	private JLabel preferencesLabel = new JLabel("Preferences");
	private JScrollPane prefScroll = new JScrollPane();
	private JPanel preferencesPanel = new JPanel();
	private ArrayList<String> preferences = new ArrayList<>();
	private ArrayList<JCheckBox> checkboxList = new ArrayList<>();
	
	private JButton createAccButton = new JButton("Create Account!");
	
	public Register(ArrayList<String> pref) {
		this.preferences = pref;
		
		//User Name Section
		setupUsername();
		
		//Password Section
		setupPassword();
		
		//E-mail Section
		setupEmail();
		
		//Preferences Section
		setupPreferences();
		
		//Create Account Section
		setupCreateAccountButton();
		
		//Main Panel Section
		setupMainPanel();
		
		//Frame Properties
		setupFrameProperties();
	}
	
	private void setupUsername() {
		
		//User Name Label
		usernameLabel.setSize(90, 20);
		usernameLabel.setLocation(10, 20);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainPanel.add(usernameLabel);
		
		//User Name Field
		usernameField.setSize(230, 20);
		usernameField.setLocation(110, 20);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mainPanel.add(usernameField);
	}
	
	private void setupPassword() {
		
		//Password Label
		passwordLabel.setSize(90, 20);
		passwordLabel.setLocation(10, 60);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainPanel.add(passwordLabel);		
		
		//Password Field
		passwordField.setSize(230, 20);
		passwordField.setLocation(110, 60);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mainPanel.add(passwordField);
	}
	
	private void setupEmail() {
		
		//E-mail Label
		emailLabel.setSize(90, 20);
		emailLabel.setLocation(10, 100);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainPanel.add(emailLabel);		
		
		//E-mail Field
		emailField.setSize(230, 20);
		emailField.setLocation(110, 100);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mainPanel.add(emailField);
	}
	
	private void setupPreferences() {
		
		//Preferences Label
		preferencesLabel.setSize(110, 20);
		preferencesLabel.setLocation(10, 140);
		preferencesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainPanel.add(preferencesLabel);
		
		//Preferences Scroll Pane
		prefScroll.setBounds(130, 140, 210, 150);
		prefScroll.getVerticalScrollBar().setUnitIncrement(16); //increases the scroll speed
		mainPanel.add(prefScroll);
		
		//Preferences Panel
		preferencesPanel.setLocation(5, 5);
		preferencesPanel.setLayout(null);
		prefScroll.setViewportView(preferencesPanel);
		
		//Preferences Field
		preferencesPanel.setPreferredSize(new Dimension(190, preferences.size()*30-10));
		
		JCheckBox checkbox;
		JLabel label;
		int height = 0;
		for(String str : preferences) {
			checkbox = new JCheckBox();
			checkbox.setSize(20, 20);
			checkbox.setLocation(0, height);
			checkboxList.add(checkbox);
			preferencesPanel.add(checkbox);
			
			label = new JLabel(str);
			label.setSize(190, 20);
			label.setLocation(30, height);
			preferencesPanel.add(label);
			
			height+= 30;
		}
	}
	
	private void setupCreateAccountButton(){
		createAccButton.setSize(130, 20);
		createAccButton.setLocation(210, 310);
		createAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mainPanel.add(createAccButton);
	}
	
	private void setupMainPanel() {
		mainPanel.setLayout(null);
		this.setContentPane(mainPanel);
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setTitle("Register");
		this.setVisible(true);
		this.setSize(370, 385);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
}
