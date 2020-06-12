package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import uniShop.*;

/*	Panel with the search components 
 * 	of our system's home screens
 * 	Input : integer gap for the gap between panel's components
 * 			ArrayList<String> with the system's tags 
 */

public class SearchPanel extends JPanel {

	private JButton homeButton = new JButton("Home");
	private JTextField searchBar = new JTextField("Type your product");
	private JPanel tagsPanel = new JPanel(); 
	private JButton searchButton = new JButton("Search");
	private ArrayList<JCheckBox> tagsCheckBoxes = new ArrayList<>();
	
	private int gap;	
	
	private JFrame parent;
	
	private User currUser;
	private LocalDataBase db;
	
	public SearchPanel(int gap, ArrayList<String> tags, HomeScreen parent, User currUser,LocalDataBase db) {
	
		this.gap = gap;
		this.parent = parent;
		this.currUser = currUser;
		this.db = db;
		//Panel Properties
		this.setLayout(null);
		this.setSize(250, 260);
		
		//Home Button Setup
		homeButton.setSize(70, 20);
		homeButton.setLocation(0,0);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get random Ads from db
				ArrayList<Ad> newAds = new ArrayList<>();
				
				//Refreshing
				parent.refreshAdsPanel(newAds);
			}
		});
		this.add(homeButton);
		
		
		//Search Bar Setup
		searchBar.setSize(170,20);
		searchBar.setLocation(homeButton.getWidth()+gap, 0);
		searchBar.setForeground(SystemColor.scrollbar);
		Border searchBarBorder = searchBar.getBorder();
		searchBar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(searchBar.getText().isEmpty()) {
					searchBar.setText("Type your product");
					searchBar.setForeground(SystemColor.scrollbar);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(searchBar.getText().equals("Type your product")) {
					searchBar.setText("");
					searchBar.setForeground(new Color(0, 0, 0));
					searchBar.setBorder(searchBarBorder);
				}				
			}
		});
		this.add(searchBar);
		
		//Tags' Panel Setup
		setupTagsPanel(tags);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> newTags = new ArrayList<>();
				int i = 0;
				for(JCheckBox box : tagsCheckBoxes) {
					if(box.isSelected()) {
						newTags.add(tags.get(i));					
					}
					i++;
				}
				if(!searchBar.getText().equals("Type your product")) {
					if(newTags.isEmpty()) {
						//Product Name YES, Tags NO
						ArrayList<Ad> newAds = currUser.search(searchBar.getText(),db);
						parent.refreshAdsPanel(newAds);
					}
					else {
						//Product Name YES, Tags YES
						ArrayList<Ad> productNameAds = currUser.search(searchBar.getText(),db);
						ArrayList<Ad> tagsAds = currUser.filter(newTags,db);
						ArrayList<Ad> newAds = new ArrayList<>();
						newAds.addAll(productNameAds);
						for(Ad ad : tagsAds) {
							if(!newAds.contains(ad))
								newAds.add(ad);
						}
						Collections.shuffle(newAds);
						parent.refreshAdsPanel(newAds);
					}
				}
				else {
					if(newTags.isEmpty()) {
						//Product Name NO, Tags NO
						searchBar.setBorder(new LineBorder(Color.RED, 1));
					}
					else {
						//Product Name NO, Tags YES
						ArrayList<Ad> newAds = currUser.filter(newTags,db);
						parent.refreshAdsPanel(newAds);
					}
				}
			}
		});
		
		//Search Button Setup
		searchButton.setSize(150, 20);
		searchButton.setLocation((this.getWidth()-searchButton.getWidth())/2, this.getHeight()-searchButton.getHeight());
		this.add(searchButton);
		
	}
	
	
	
	private void setupTagsPanel(ArrayList<String> tags) {
		
		JScrollPane scrollPane = new JScrollPane();		
		
		tagsPanel.setLayout(null);
		tagsPanel.setSize(230, tags.size()*2*gap);
		tagsPanel.setPreferredSize(new Dimension(230, tags.size()*2*gap));
		
		JCheckBox checkBox;
		JLabel label;
		int objHeight = 0;
		for(String str : tags) {
			
			//setup CheckBox
			checkBox = new JCheckBox();
			checkBox.setSize(20, 20);
			checkBox.setLocation(0, objHeight);
			tagsCheckBoxes.add(checkBox);
			tagsPanel.add(checkBox);		
			
			//setup Label
			label = new JLabel(str);
			label.setSize(tagsPanel.getWidth()-20,20);
			label.setLocation(20+gap, objHeight);
			tagsPanel.add(label);
			
			objHeight+=2*gap;
		}
		
		scrollPane.setBounds(0, 30, 250, 270);
		scrollPane.setSize(250,200);
		scrollPane.setLocation(0, 30);
		scrollPane.setViewportView(tagsPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); //increases the scroll speed
		this.add(scrollPane);
	}
	
	//returning list with tags's check boxes
	public ArrayList<JCheckBox> getTagsCheckBoxes(){
		return this.tagsCheckBoxes;
	}
}
