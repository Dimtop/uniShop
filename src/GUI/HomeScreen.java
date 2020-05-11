package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*	Common objects of
 * 	different home screens
 */

public abstract class HomeScreen extends JFrame {

	protected JPanel mainPanel = new JPanel();
	protected SearchPanel searchPanel;
	protected JPanel topButtonsPanel = new JPanel();
	protected JPanel adsPanel = new JPanel();
	
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
		searchPanel = new SearchPanel(gap, tags);
		searchPanel.setLocation(gap, gap);
		mainPanel.add(searchPanel);
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
	
	//setting up ads' panel
	private void setupAdsPanel(ArrayList<String> ads) {
		JScrollPane adsScrollPane = new JScrollPane();
		
		adsPanel.setPreferredSize(new Dimension(937, ads.size()*(gap+150)-gap));
		adsPanel.setLayout(null);
		
		AdPanel adPanel;
		int height = 0;
		for(String str : ads) {
			adPanel = new AdPanel(str);
			adPanel.setBounds(0, height, adPanel.getWidth(), adPanel.getHeight());
			adsPanel.add(adPanel);
			
			height += adPanel.getHeight()+gap;
		}
		
		adsScrollPane.setBounds(270, 40, 955, 620);
		adsScrollPane.setViewportView(adsPanel);
		adsScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		mainPanel.add(adsScrollPane);
	}
	
	//setting up buttons at the top of the frame
	protected abstract void setupTopButtons();	
}
