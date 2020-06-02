package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	protected JPanel loadingPanel = new JPanel();
	protected JPanel adsPanel = new JPanel();
	
	protected JScrollPane adsScrollPane = new JScrollPane();
	
	protected ArrayList<String> ads = new ArrayList<>();//testing
	
	protected int gap = 10; //gap between subjects
	
	public HomeScreen(ArrayList<String> tags, ArrayList<String> ads) {
		this.ads = ads;
		
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
	
	//creating loading panel
	protected void creatingLoadingPanel() {
		loadingPanel.setPreferredSize(new Dimension(930, 600));
		loadingPanel.setLayout(new BorderLayout());
		
	    ImageIcon loading = new ImageIcon(AdPanelRegistered.class.getResource("/images/ajax-loader.gif"));
	    loadingPanel.add(new JLabel("loading... ", loading, JLabel.CENTER), BorderLayout.CENTER);	
	}
	
	//setting up ads' panel
	protected void setupAdsPanel(ArrayList<String> ads) {

		creatingLoadingPanel();
		
		adsScrollPane.setBounds(270, 40, 955, 620);
		adsScrollPane.setViewportView(loadingPanel);
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
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
		this.setTitle("UniShop");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//setting up buttons at the top of the frame
	protected abstract void setupTopButtons();	
	
	//creating a panel with ads from list ads
	protected abstract void creatingAdsPanel(ArrayList<String> ads);
	
	//refreshing the ads' panel
	public void refreshAdsPanel() {
				
		adsScrollPane.setViewportView(loadingPanel);
		creatingAdsPanel(ads); //randomize list with ads
		adsScrollPane.setViewportView(adsPanel);
	}

}
