package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class HomeScreen extends JFrame {

	protected JPanel mainPanel = new JPanel();
	protected SearchPanel searchPanel;
	protected JPanel topButtonsPanel = new JPanel();
	
	protected int gap = 10; //gap between subjects
	
	public HomeScreen(ArrayList<String> preferences) {
		
		//Main Panel setup
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		//Search Panel set up
		searchPanel = new SearchPanel(preferences);
		searchPanel.setLocation(gap, gap);
		mainPanel.add(searchPanel);
		
		//Top Buttons' Panel
		topButtonsPanel.setLayout(new FlowLayout(10));
		topButtonsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		topButtonsPanel.setLocation(270, 10);
		topButtonsPanel.setSize(964, 40);
		mainPanel.add(topButtonsPanel);
		
		//Frame Properties
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(1250, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//setting up buttons at the top of the frame
	protected abstract void setUpTopButtons();	
}
