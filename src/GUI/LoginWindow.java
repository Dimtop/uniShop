package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;

public class LoginWindow extends JFrame{
	
	private JPanel panel;
	private Image imageUnishopic;
	private JLabel labeliconimage;
	private JTextField usernameField;
	private JPasswordField pwdPassword;
	
	public LoginWindow() {
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
		
		this.setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(290,300);
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		this.setIconImage(new ImageIcon(this.getClass().getResource("shopping-bags-512.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//image setup
	private void setimage(){
		imageUnishopic=new ImageIcon(this.getClass().getResource("shopping-bags-512.png")).getImage();
		panel.setLayout(null);
		labeliconimage=new JLabel("");
		labeliconimage.setBounds(89,17, 106,104);
		labeliconimage.setIcon(new ImageIcon(imageUnishopic));
		panel.add(labeliconimage);	
	}		
	
	
	//Jtextfield username, password
	private void userInfoField() {
		
		usernameField = new JTextField("");
		usernameField.setBounds(109, 132, 106, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setToolTipText("Password");
		pwdPassword.setEchoChar('*');
		pwdPassword.setBounds(109, 163, 106, 20);
		panel.add(pwdPassword);
		
	}
	
	//button setup
	private void buttonsetup() {
		JButton btnLogin = new JButton("Login!");
		btnLogin.setBackground(new Color(0,255,40));;
		btnLogin.setBounds(89, 219, 106, 31);
		panel.add(btnLogin);
		
		JLabel labelmessage = new JLabel("");
		
		labelmessage.setBounds(112, 194, 70, 14);
		panel.add(labelmessage);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(20, 135, 79, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(20, 166, 69, 14);
		panel.add(lblPassword);
		
		btnLogin.addActionListener(new ActionListener() {
				 
			public void actionPerformed(ActionEvent e) {
				String text=usernameField.getText();
				if(text.equals("Username")) {
					labelmessage.setText("Login failed!");
					labelmessage.setForeground(Color.RED);
					//setVisible(false);
				}
			}});
			
	}
}
