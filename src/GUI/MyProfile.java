package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MyProfile extends JFrame {

	private JPanel mainPanel = new JPanel();
	private ProfileInfoPanel profileInfoPanel;
	
	private JButton editButton = new JButton("Edit");
	private JButton myAdsButton = new JButton("My Ads");
	private JButton deleteProfileButton = new JButton("Delete Profile");
	
	private JButton confirmButton = new JButton("Confirm");
	
	private boolean editable;
	
	public MyProfile(boolean editable) {
		this.editable = editable;
		
		//Main Panel
		setupMainPanel();
		
		//Profile Info Panel
		setupProfileInfoPanel();
		
		//Buttons Section
		if(editable)
			setupEditableButtons();
		else
			setupNonEditableButtons();
		
		//Frame Properties
		setupFrameProperties();
	}
	
	private void setupMainPanel() {
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
	}
	
	private void setupProfileInfoPanel(){
		profileInfoPanel = new ProfileInfoPanel(editable);
		
		//Titled Border
		TitledBorder titledBorder = new TitledBorder(new EtchedBorder(), "Profile Info");
		titledBorder.setTitleFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Profile Info Panel
		profileInfoPanel.setBorder(titledBorder);
		profileInfoPanel.setLocation(10, 20);
		mainPanel.add(profileInfoPanel);
	}
	
	private void setupEditableButtons() {
		//Confirm Button Section
		confirmButton.setBounds(380, 345, 120, 20);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyProfile(false);
				int i = 0;
				for(JCheckBox checkbox : profileInfoPanel.getCheckBoxList()) {
					if(checkbox.isSelected()) {
						System.out.println(profileInfoPanel.getTable().get(i)); //testing
						//adding the values to the user's preferences
					}
					i++;
				}
			}
		});
		mainPanel.add(confirmButton);
	}
	
	private void setupNonEditableButtons() {
		
		//Edit Button Section
		editButton.setBounds(400, 25, 90, 20);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyProfile(true);
			}
		});
		mainPanel.add(editButton);
		
		//My Ads Button Section
		myAdsButton.setBounds(380, 315, 120, 20);
		mainPanel.add(myAdsButton);
		
		//Delete Profile Button Section
		deleteProfileButton.setBounds(380, 345, 120, 20);
		deleteProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you want to delete your profile?", 
						"DELETING PROFILE", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					//to do
					System.out.println("Yes");
				}
				else {
					//to do
					System.out.println("No");
				}
			}
		});
		mainPanel.add(deleteProfileButton);
		
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(530, 420);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}


