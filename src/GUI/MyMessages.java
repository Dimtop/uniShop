package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class MyMessages extends JFrame {

	private JPanel mainPanel = new JPanel();
	private JSeparator separator = new JSeparator();
	
	private ArrayList<String> sellerMessages = new ArrayList<>();
	private JScrollPane sellerScroll = new JScrollPane();
	private ArrayList<String> buyerMessages = new ArrayList<>();
	private JScrollPane buyerScroll = new JScrollPane();
	
	private ArrayList<MessagePanel> messagePanels = new ArrayList<>();
	
	public MyMessages() {
		
		//testing
		setupTables();
		
		//Main Panel Section
		setupMainPanel();
		
		//Seller Messages Section
		setupSellerMessage();
		
		//Separator Section
		separator.setBounds(5, 350, 485, 2);
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
		
		//Seller Scroll Pane
		sellerScroll.setSize(480, 330);
		sellerScroll.setLocation(10, 10);
		mainPanel.add(sellerScroll);
		
		for(String str : sellerMessages) {
			
		}
	}
	
	private void setupBuyerMessage() {
		
		//Buyer Scroll Pane
		buyerScroll.setSize(480, 330);
		buyerScroll.setLocation(10, 360);
		mainPanel.add(buyerScroll);
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(500, 720);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	//for testing
	public void setupTables() {
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		sellerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
		buyerMessages.add("asdasdkjahskdjahksjdhakjsdhkajshdkajshkdjashkdjahksdjhakjsdhaksjdhakhgfjakdgfajksdghafjkdhsgfjkasdghfjkadghsfjkashdgfjkasfajsfjsfsdghafkjsf");
	}
}
