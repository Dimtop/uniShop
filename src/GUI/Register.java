package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame{
	
	private JTextField UserNameJTX;
	private JTextField PasswordJTX;
	private JPanel panelcont;
	
	public Register() {
		 panel();
		 Panellayout();
		 panelArguments();
	}
	
	public void panel() {
		panelcont=new JPanel();
		this.setContentPane(panelcont);
	}
	
	public void panelArguments() 
	{
		this.setTitle("Register");
	    this.setVisible(true);
		this.setSize(485,490);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Panellayout() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{110, 301, 0};
		gridBagLayout.rowHeights = new int[]{0, 100, 100, 110, 80, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelcont.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelcont.add(lblNewLabel, gbc_lblNewLabel);
		
		UserNameJTX = new JTextField();
		GridBagConstraints gbc_UserNameJTX = new GridBagConstraints();
		gbc_UserNameJTX.insets = new Insets(0, 0, 5, 0);
		gbc_UserNameJTX.fill = GridBagConstraints.HORIZONTAL;
		gbc_UserNameJTX.gridx = 1;
		gbc_UserNameJTX.gridy = 1;
		panelcont.add(UserNameJTX, gbc_UserNameJTX);
		UserNameJTX.setColumns(10);
		
		JLabel PasswordLbl = new JLabel("Password");
		PasswordLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_PasswordLbl = new GridBagConstraints();
		gbc_PasswordLbl.anchor = GridBagConstraints.EAST;
		gbc_PasswordLbl.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordLbl.gridx = 0;
		gbc_PasswordLbl.gridy = 2;
		panelcont.add(PasswordLbl, gbc_PasswordLbl);
		
		PasswordJTX = new JTextField();
		GridBagConstraints gbc_PasswordJTX = new GridBagConstraints();
		gbc_PasswordJTX.insets = new Insets(0, 0, 5, 0);
		gbc_PasswordJTX.fill = GridBagConstraints.HORIZONTAL;
		gbc_PasswordJTX.gridx = 1;
		gbc_PasswordJTX.gridy = 2;
		panelcont.add(PasswordJTX, gbc_PasswordJTX);
		PasswordJTX.setColumns(10);
		
		JLabel preferenceslbl = new JLabel("Preferences");
		preferenceslbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_preferenceslbl = new GridBagConstraints();
		gbc_preferenceslbl.anchor = GridBagConstraints.NORTHEAST;
		gbc_preferenceslbl.insets = new Insets(0, 0, 5, 5);
		gbc_preferenceslbl.gridx = 0;
		gbc_preferenceslbl.gridy = 3;
		panelcont.add(preferenceslbl, gbc_preferenceslbl);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		panelcont.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JCheckBox chPr1 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr1 = new GridBagConstraints();
		gbc_chPr1.insets = new Insets(0, 0, 5, 5);
		gbc_chPr1.gridx = 0;
		gbc_chPr1.gridy = 0;
		panel.add(chPr1, gbc_chPr1);
		
		JCheckBox chPr5 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr5 = new GridBagConstraints();
		gbc_chPr5.insets = new Insets(0, 0, 5, 0);
		gbc_chPr5.gridx = 1;
		gbc_chPr5.gridy = 0;
		panel.add(chPr5, gbc_chPr5);
		
		JCheckBox chPr2 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr2 = new GridBagConstraints();
		gbc_chPr2.insets = new Insets(0, 0, 5, 5);
		gbc_chPr2.gridx = 0;
		gbc_chPr2.gridy = 1;
		panel.add(chPr2, gbc_chPr2);
		
		JCheckBox chPr6 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr6 = new GridBagConstraints();
		gbc_chPr6.insets = new Insets(0, 0, 5, 0);
		gbc_chPr6.gridx = 1;
		gbc_chPr6.gridy = 1;
		panel.add(chPr6, gbc_chPr6);
		
		JCheckBox chPr3 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr3 = new GridBagConstraints();
		gbc_chPr3.insets = new Insets(0, 0, 5, 5);
		gbc_chPr3.gridx = 0;
		gbc_chPr3.gridy = 2;
		panel.add(chPr3, gbc_chPr3);
		
		JCheckBox chPr7 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr7 = new GridBagConstraints();
		gbc_chPr7.insets = new Insets(0, 0, 5, 0);
		gbc_chPr7.gridx = 1;
		gbc_chPr7.gridy = 2;
		panel.add(chPr7, gbc_chPr7);
		
		JCheckBox chPr4 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr4 = new GridBagConstraints();
		gbc_chPr4.insets = new Insets(0, 0, 0, 5);
		gbc_chPr4.gridx = 0;
		gbc_chPr4.gridy = 3;
		panel.add(chPr4, gbc_chPr4);
		
		JCheckBox chPr8 = new JCheckBox("New check box");
		GridBagConstraints gbc_chPr8 = new GridBagConstraints();
		gbc_chPr8.gridx = 1;
		gbc_chPr8.gridy = 3;
		panel.add(chPr8, gbc_chPr8);
		
		JButton btnCreateAccount = new JButton("Create Account!");
		btnCreateAccount.setBackground(new Color(0, 255, 0));
		btnCreateAccount.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
		gbc_btnCreateAccount.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnCreateAccount.gridx = 1;
		gbc_btnCreateAccount.gridy = 4;
		panelcont.add(btnCreateAccount, gbc_btnCreateAccount);
	}
}
