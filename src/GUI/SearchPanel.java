package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	
	public SearchPanel(int gap, ArrayList<String> tags, HomeScreen parent) {
	
		this.gap = gap;
		this.parent = parent;
		
		//Panel Properties
		this.setLayout(null);
		this.setSize(250, 260);
		
		//Home Button Setup
		homeButton.setSize(70, 20);
		homeButton.setLocation(0,0);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Refreshing
				parent.refreshAdsPanel();
			}
		});
		this.add(homeButton);
		
		//Search Bar Setup
		searchBar.setSize(170,20);
		searchBar.setLocation(homeButton.getWidth()+gap, 0);
		this.add(searchBar);
		
		//Tags' Panel Setup
		setupTagsPanel(tags);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("===========");
				int i = 0;
				for(JCheckBox box : tagsCheckBoxes) {
					if(box.isSelected()) {
						System.out.println(tags.get(i));					
					}
					i++;
				}
				System.out.println("===========");
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
