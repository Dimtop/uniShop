package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*	Common objects of
 * 	different home screens
 * 	Input : ArrayList of String with the server's tags of the system
 * 			ArrayList of Ads given by the system for display on the screen
 */

public abstract class HomeScreen extends JFrame {

	protected JPanel mainPanel = new JPanel();
	protected SearchPanel searchPanel;
	protected JPanel topButtonsPanel = new JPanel();
	protected JPanel adsPanel = new JPanel();
	
	protected JScrollPane adsScrollPane = new JScrollPane();
	
	protected int gap = 10; //gap between subjects
	
	public HomeScreen(ArrayList<String> tags, ArrayList<String> ads) {
		
		//Main Panel setup
		setupMainPanel();
		
		//Search Panel setup
		setupSearchPanel(tags);
		
		//Ads Panel setup
		setupAdsPanel(ads);
		
		//Frame Properties setup
		setupFrameProperties();
	}
	
	//setting up main panel
	private void setupMainPanel() {
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
	}
	
	//setting up search panel
	private void setupSearchPanel(ArrayList<String> tags) {
		searchPanel = new SearchPanel(gap, tags, this);
		searchPanel.setLocation(gap, gap);
		mainPanel.add(searchPanel);
	}
	
	//setting up ads' panel
	protected void setupAdsPanel(ArrayList<String> ads) {

		creatingAdsPanel(ads);
		
		adsScrollPane.setBounds(270, 40, 955, 620);
		adsScrollPane.setViewportView(adsPanel);
		adsScrollPane.getVerticalScrollBar().setUnitIncrement(16); //increase scroll speed
		mainPanel.add(adsScrollPane);
	}
	
	//setting up frame properties
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(1250, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//setting up buttons at the top of the frame
	protected abstract void setupTopButtons();	
	
	//creating a panel with ads from list ads
	protected abstract void creatingAdsPanel(ArrayList<String> ads);
	
	//refreshing the ads' panel
	public abstract void refreshAdsPanel(ArrayList<String> newAds);

}
