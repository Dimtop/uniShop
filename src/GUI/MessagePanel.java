package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import uniShop.*;
import java.awt.Color;

public class MessagePanel extends JPanel {

	private Message currMsg;
	
	private JLabel profileName = new JLabel();
	private JTextArea textArea = new JTextArea();
	private JButton replyButton = new JButton();
	
	public MessagePanel(boolean isSeller, Message msg) {
		this.currMsg = msg;
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); //input Message message
		
		//Profile Name Section
		profileName.setText(currMsg.getSender().getUsername());
		profileName.setSize(250, 20);
		profileName.setLocation(5, 5);
		profileName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.add(profileName);
		
		//Text Area Section
		textArea.setText(msg.getText());
		textArea.setSize(355, 75);
		textArea.setLocation(5, 30);
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); //input Message message
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		this.add(textArea);
		
		if(isSeller) {
			//Reply Button Section
			replyButton.setText("Reply");
			replyButton.setSize(87, 20);
			replyButton.setLocation(374, 85);
		}
		else {
			//Read Reply Button Section
			replyButton.setText("Read Reply");
			replyButton.setSize(100, 20);
			replyButton.setLocation(368, 85);
		}
		this.add(replyButton);
		replyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReplyFrame(isSeller, null);
			}
		});
		
		//Panel Properties
		this.setSize(473, 110);
		this.setLayout(null);
	}
}
