package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

import uniShop.*;

public class LoginWindow extends JFrame{
	
	private LocalDataBase db;
	
	private JPanel panel;
	private JLabel labeliconimage;
	private JTextField usernameField;
	private JPasswordField pwdPassword;
	
	private JFrame currFrame;
	private JFrame parentFrame;
	
	//it should get data from the base
	public LoginWindow(LocalDataBase db, JFrame parent) {
		this.db = db;
		this.currFrame = this;
		this.parentFrame = parent;
		
		jpanel();
		setimage();
		userInfoField();
		buttonsetup();
		panelView();
	}
	
	//the login panel
	private void jpanel()
	{
		panel=new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel.setForeground(Color.WHITE);
		this.setContentPane(panel);	
	}	
	
	private void panelView() {
		this.setResizable(false);
		this.setTitle("LogIn");
		this.setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(430,370);
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
	
	//image setup
	private void setimage(){
		panel.setLayout(null);
		labeliconimage=new JLabel("");
		labeliconimage.setBounds(140,11, 140,140);
		labeliconimage.setIcon(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")));
		panel.add(labeliconimage);	
	}		
	
	
	//Jtextfield username, password
	private void userInfoField() {
		
		usernameField = new JTextField("");
		usernameField.setBounds(190, 166, 155, 26);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setToolTipText("Password");
		pwdPassword.setEchoChar('*');
		pwdPassword.setBounds(190, 203, 155, 26);
		panel.add(pwdPassword);
		
	}
	
	//button setup
	private void buttonsetup() {
		JButton btnLogin = new JButton("Login!");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(0,255,40));;
		btnLogin.setBounds(132, 272, 148, 48);
		panel.add(btnLogin);
		
		JLabel labelmessage = new JLabel("");
		labelmessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		labelmessage.setBounds(144, 240, 126, 21);
		panel.add(labelmessage);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(69, 159, 111, 39);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(69, 196, 111, 36);
		panel.add(lblPassword);
		
		btnLogin.addActionListener(new ActionListener() {
			
			//when the login button pressed it should do the check with data base if the password and the username are correct
			public void actionPerformed(ActionEvent e) {
				String username=usernameField.getText();
				String password=String.valueOf(pwdPassword.getPassword());
				Registered currUser = db.login(username, password);
				//if the username and the password dont match then print failed else change homescreen to premium
				if(currUser == null) {
					labelmessage.setText("Login failed!");
					labelmessage.setForeground(Color.RED);
				}
				else {
					currUser.callHomePage();
					currFrame.dispose();
					parentFrame.dispose();
				}
			}});
			
	}
}
