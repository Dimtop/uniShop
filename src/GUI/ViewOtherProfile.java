package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewOtherProfile extends JFrame {

	private JPanel mainPanel = new JPanel();
	
	private JLabel usernameLabel = new JLabel("Username");
	private JTextField usernameField = new JTextField();
	private JLabel emailLabel = new JLabel("E-mail");
	private JTextField emailField = new JTextField();
	
	private JSeparator separator = new JSeparator();
	private JScrollPane reviewScroll = new JScrollPane();
	private JTextArea reviewText = new JTextArea();
	
	private JButton reviewButton = new JButton("Review !");
	
	public ViewOtherProfile() {
		
		//Profile View Section
		setupProfileView();
		
		//Review Section
		setupReview();
		
		//Main Panel Section
		setupMainPanel();
		
		//Frame Properties
		setupFrameProperties();
	}
	
	private void setupProfileView() {
		
		//User Name Label
		usernameLabel.setSize(90, 20);
		usernameLabel.setLocation(20, 20);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mainPanel.add(usernameLabel);
		
		//User Name Field
		usernameField.setSize(230, 20);
		usernameField.setLocation(110, 20);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameField.setEditable(false);
		mainPanel.add(usernameField);
		
		//E-mail Label
		emailLabel.setSize(90, 20);
		emailLabel.setLocation(20, 60);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mainPanel.add(emailLabel);
		
		//E-mail Field
		emailField.setSize(230, 20);
		emailField.setLocation(110, 60);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailField.setEditable(false);
		mainPanel.add(emailField);
	}
	
	private void setupReview() {
		
		//Separator
		separator.setBounds(10, 100, 330, 2);
		mainPanel.add(separator);
		
		//Review Scroll Pane
		reviewScroll.setSize(330, 180);
		reviewScroll.setLocation(10, 110);
		mainPanel.add(reviewScroll);
		
		//Review Text Area
		reviewText.setPreferredSize(new Dimension(315, 175));
		reviewText.setLocation(0, 0);
		reviewText.setLineWrap(true);
		reviewText.setWrapStyleWord(true);
		reviewScroll.setViewportView(reviewText);		
		
		//Review Button
		reviewButton.setSize(90, 20);
		reviewButton.setLocation(250, 300);
		reviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mainPanel.add(reviewButton);
	}
	
	private void setupMainPanel() {
		mainPanel.setLayout(null);
		this.setContentPane(mainPanel);
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setTitle("Profile"); //this.setTitle(user.getName() + "'s Profile");
		this.setVisible(true);
		this.setSize(370, 370);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
}
