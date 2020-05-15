package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class MessagePanel extends JPanel {

	private JLabel profileName = new JLabel();
	private JTextArea textArea = new JTextArea();
	private JButton replyButton = new JButton("Reply");
	private JButton readReplyButton = new JButton("Read Reply");
	
	public MessagePanel(boolean seller, String text) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); //input Message message
		
		//Profile Name Section
		profileName.setText("Profile Name"); //profileName.setText(message.getOwner());
		profileName.setSize(250, 20);
		profileName.setLocation(5, 5);
		profileName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.add(profileName);
		
		//Text Area Section
		textArea.setText(text); //textArea.setText(message.getText());
		textArea.setSize(380, 75);
		textArea.setLocation(5, 30);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.add(textArea);
				
		if(seller) {
			//Reply Button Section
			replyButton.setSize(87, 20);
			replyButton.setLocation(368, 85);
			this.add(replyButton);
		}
		else {
			//Read Reply Button Section
			readReplyButton.setSize(87, 20);
			readReplyButton.setLocation(368, 85);
			this.add(readReplyButton);
		}
		//Panel Properties
		this.setSize(460, 110);
		this.setLayout(null);
	}
}
