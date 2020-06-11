package GUI;

import java.awt.Color;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import uniShop.*;

public class Register extends JFrame {
	
	private LocalDataBase db;
	
	private JFrame parentFrame;
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel usernameLabel = new JLabel("Username");
	private JTextField usernameField = new JTextField();
	
	private JLabel passwordLabel = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField();
	
	private JLabel emailLabel = new JLabel("E-mail");
	private JTextField emailField = new JTextField();
	
	private JLabel errorLabel = new JLabel("");
	
	private JLabel preferencesLabel = new JLabel("Preferences");
	private JScrollPane prefScroll = new JScrollPane();
	private JPanel preferencesPanel = new JPanel();
	private ArrayList<String> preferences = new ArrayList<>();
	private ArrayList<JCheckBox> checkboxList = new ArrayList<>();
	
	private JButton createAccButton = new JButton("Create Account!");
	
	private Border defaultBorder;
	
	public Register(LocalDataBase db, JFrame parentFrame) {
		this.db = db;
		this.parentFrame = parentFrame;
		this.preferences = db.getSystemPreferences();
		
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
		
		defaultBorder = usernameField.getBorder();
		
		//User Name Field
		usernameField.setSize(230, 20);
		usernameField.setLocation(110, 20);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				usernameField.setBorder(defaultBorder);
			}
		});		
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
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				passwordField.setBorder(defaultBorder);
			}
		});	
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
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				emailField.setBorder(defaultBorder);
			}
		});	
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
		prefScroll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prefScroll.setBorder(defaultBorder);
			}
		});
		mainPanel.add(prefScroll);
		
		//Preferences Panel
		preferencesPanel.setLocation(5, 5);
		preferencesPanel.setLayout(null);
		prefScroll.setViewportView(preferencesPanel);
		
		//Preferences Field
		preferencesPanel.setPreferredSize(new Dimension(180, preferences.size()*30-10));
		
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
		
		//Error label
		errorLabel.setSize(300, 20);
		errorLabel.setLocation(20, 310);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		mainPanel.add(errorLabel);
		
		//Create Button
		createAccButton.setSize(130, 20);
		createAccButton.setLocation(210, 310);
		createAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formValidation())
					registerButtonClicked();
				else {
					errorLabel.setForeground(Color.RED);
					errorLabel.setText("Complete all the forms");
				}
			}
		});
		mainPanel.add(createAccButton);		
		
	}
	
	//Checking if the from is empty
	private boolean formValidation() {
		
		
		boolean flag = true;
		
		if(usernameField.getText().equals("")) {
			
			usernameField.setBorder(new LineBorder(Color.RED, 1));
			
			flag = false;
		}
		if(String.valueOf(passwordField.getPassword()).equals("")) {
			
			passwordField.setBorder(new LineBorder(Color.RED, 1));
			
			flag = false;
		}
		if(emailField.getText().equals("")) {
			
			emailField.setBorder(new LineBorder(Color.RED, 1));
			
			flag = false;
			
		}
		if(isCheckBoxesListEmpty()) {
			
			prefScroll.setBorder(new LineBorder(Color.RED, 1));
			
			flag = false;			
			
		}
		
		return flag;
	}
	
	private boolean isCheckBoxesListEmpty() {
		boolean flag = true;
		
		for(JCheckBox box : checkboxList) {
			if(box.isSelected())
				flag = false;
		}
		
		return flag;
	}
	
	private void registerButtonClicked() {
		//check if there is a user with the same user name on the db
		if(!db.containsThisName(usernameField.getText())) {	
			//if there is not
			int id = db.getNextUserId();
			Registered newUser = new Registered(id, usernameField.getText(), String.valueOf(passwordField.getPassword()), db);
			db.increaseUserId();
			db.addUser(newUser);
			newUser.setPreferences(getCheckBoxesText());
			
			dispose();
			parentFrame.dispose();
			
			new HomeScreen_Registered(this.db, newUser);
		}
		else {
			//if there is not
			errorLabel.setForeground(Color.RED);
			errorLabel.setText("Username already taken");
		}
	}
	
	private ArrayList<String> getCheckBoxesText(){
		ArrayList<String> list = new ArrayList<>();
		
		int counter = 0;
		for(JCheckBox box : checkboxList) {
			if(box.isSelected()) {
				list.add(preferences.get(counter));
				counter++;
			}
		}
		
		System.out.println(list);
		
		return list;
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
		this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
}
