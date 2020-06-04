package GUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import uniShop.*;

public class MyMessages extends JFrame {

	private JPanel mainPanel = new JPanel();
	private JSeparator separator = new JSeparator();
	
	private ArrayList<Message> sellerMessages = new ArrayList<>();
	private JScrollPane sellerScroll = new JScrollPane();
	private JPanel sellerPanel = new JPanel();
	
	private ArrayList<Message> buyerMessages = new ArrayList<>(); //must change, waiting for Registered.java to add replies
	private JScrollPane buyerScroll = new JScrollPane();
	private JPanel buyerPanel = new JPanel();
	
	private Registered currUser;
	
	//private ArrayList<MessagePanel> messagePanels = new ArrayList<>();
	
	public MyMessages(Registered currUser) {
		this.currUser = currUser;
		
		//Main Panel Section
		setupMainPanel();
		
		//Seller Messages Section
		setupSellerMessage();
		
		//Separator Section
		separator.setBounds(5, 350, 498, 2);
		mainPanel.add(separator);
		
		//Buyer Messages Section
		setupBuyerMessage();
		
		//Frame Properties
		setupFrameProperties();
	}
	
	private void setupMainPanel() {
		mainPanel.setLayout(null);
		this.setContentPane(mainPanel);
	}
	
	private void setupSellerMessage() {
		sellerMessages = currUser.getMessages();
		
		//Seller Scroll Pane
		sellerScroll.setSize(500, 330);
		sellerScroll.setLocation(10, 10);
		sellerScroll.setBorder(new TitledBorder("Seller Section"));
		sellerScroll.getVerticalScrollBar().setUnitIncrement(16); //increase scroll speed
		sellerScroll.setViewportView(sellerPanel);
		sellerScroll.getVerticalScrollBar().setValue(1); //begins scrolling at the top
		mainPanel.add(sellerScroll);
		
		//Seller Panel
		sellerPanel.setPreferredSize(new Dimension(473, sellerMessages.size()*120-10));
		sellerPanel.setLocation(10, 10);
		sellerPanel.setLayout(null);
		
		//Messages Panels
		MessagePanel messagePanel;
		int height = 0;
		for(Message currMsg : sellerMessages) {
			messagePanel = new MessagePanel(true, currMsg);
			messagePanel.setLocation(0, height);
			sellerPanel.add(messagePanel);
			
			height+=120;
		}
		
		//starting the scrollPane on the top
		SwingUtilities.invokeLater(new Runnable()
		{
		    public void run()
		    {
		    	sellerScroll.getViewport().setViewPosition( new Point(0, 0) );
		    }
		});
	}
	
	private void setupBuyerMessage() {
		
		//Buyer Scroll Pane
		buyerScroll.setSize(500, 330);
		buyerScroll.setLocation(10, 360);
		buyerScroll.setBorder(new TitledBorder("Buyer Section"));
		buyerScroll.getVerticalScrollBar().setUnitIncrement(16); //increase scroll speed
		buyerScroll.setViewportView(buyerPanel);
		buyerScroll.getVerticalScrollBar().setValue(1); //begins scrolling at the top
		mainPanel.add(buyerScroll);
		
		//Buyer Panel
		buyerPanel.setPreferredSize(new Dimension(473, sellerMessages.size()*120-10));
		buyerPanel.setLocation(10, 10);
		buyerPanel.setLayout(null);
		
		//Testing
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date currDate = new Date(System.currentTimeMillis());
		Ad ad = new Ad(0,"Product1","Description","https://cdn.wccftech.com/wp-content/uploads/2018/10/Intel-X-Series-1-Custom-2060x1375.jpg",
				currDate,currUser,currUser,new ArrayList<String>(),ListingState.ACTIVE, ListingPromotionType.NOT_PROMOTED);
		buyerMessages.add(new Message("Text", currUser, currUser, ad));
		
		//Messages Panels
		MessagePanel messagePanel;
		int height = 0;
		for(Message str : buyerMessages) {
			messagePanel = new MessagePanel(false, str);
			messagePanel.setLocation(0, height);
			buyerPanel.add(messagePanel);
			
			height+=120;
		}
		
		//starting the scrollPane on the top
		SwingUtilities.invokeLater(new Runnable()
		{
		    public void run()
		    {
		    	buyerScroll.getViewport().setViewPosition( new Point(0, 0) );
		    }
		});
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setTitle("My Messages");
		this.setVisible(true);
		this.setSize(535, 740);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
	
}
