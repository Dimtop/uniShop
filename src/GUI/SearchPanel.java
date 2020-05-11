package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class SearchPanel extends JPanel {

	private JButton homeButton;
	private JTextField searchBar;
	private JButton searchButton;
	private JPanel preferencePanel;
	
	private int gap = 10; //gap between objetcs
	
	public SearchPanel(ArrayList<String> preferences) {

		//Panel Properties
		this.setLayout(null);
		this.setSize(250,300);
		
		//HomeButton
		this.setUpHomeButton();
		
		//SearchBar
		this.setUpSearchBar();
		
		//Preference Section
		this.setUpPreferenceList(preferences);
		
		//SearchButton
		this.setUpSearchButton();
	}
	
	//setting up Home Button
	private void setUpHomeButton() {
		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		homeButton.setSize(65,20);
		homeButton.setLocation(0, 0);
		this.add(homeButton);
	}
	
	//setting up Search Bar
	private void setUpSearchBar() {
		searchBar = new JTextField("Type your product");
		searchBar.setForeground(new Color(204, 204, 204));
		searchBar.setSize(175,20);
		searchBar.setLocation(75, 0);
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(searchBar.getText().isEmpty()==true) {
					searchBar.setText("Type your product");
					searchBar.setCaretPosition(0);
					searchBar.setForeground(new Color(204, 204, 204));
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				removeText();
			}
		});
		searchBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeText();
			}			
		});
		this.add(searchBar);
	}
	
	//setting up Preference Section
	private void setUpPreferenceList(ArrayList<String> preferences) {
		this.preferencePanel = new JPanel();
		this.preferencePanel.setLayout(null);
		this.preferencePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.preferencePanel.setBounds(this.gap, 30, this.getWidth()-20, preferences.size()*25+5);
		
		JLabel label;
		JCheckBox checkBox;
		int labelsGap = 5; //gap between labels
		int startingHeight = labelsGap;
		for(String str: preferences) {
			checkBox = new JCheckBox();
			checkBox.setLocation(this.gap, startingHeight);
			checkBox.setSize(20,20);
			preferencePanel.add(checkBox);
			label = new JLabel(str);
			label.setLocation(40, startingHeight);
			label.setSize(100,20);
			startingHeight += 20 + labelsGap;
			preferencePanel.add(label);
		}
		this.add(preferencePanel);
	}
	
	//setting up Search Button
	private void setUpSearchButton() {
		int buttonHeight = 20;
		int buttonWidth = 150;
		
		searchButton = new JButton("Search");
		
		int x = (this.getWidth()-buttonWidth)/2;
		int y = this.preferencePanel.getY() + this.preferencePanel.getHeight()+this.gap;
		
		searchButton.setLocation(x, y);
		searchButton.setSize(buttonWidth, buttonHeight);
		this.add(searchButton);
	}
	
	//removing default message from a text field
	private void removeText() { 
		if(searchBar.getForeground() != Color.BLACK) {
			if(searchBar.getText().equals("Type your product")) {
				searchBar.setText("");
			}
			searchBar.setForeground(Color.BLACK);
		}
	}
}
