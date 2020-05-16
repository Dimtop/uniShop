package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessagePanel extends JPanel {

	private JLabel profileName = new JLabel();
	private JTextArea textArea = new JTextArea();
	private JButton replyButton = new JButton();
	
	public MessagePanel(boolean isSeller, String text) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); //input Message message
		
		//Profile Name Section
		profileName.setText("Profile Name"); //profileName.setText(message.getOwner());
		profileName.setSize(250, 20);
		profileName.setLocation(5, 5);
		profileName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.add(profileName);
		
		//Text Area Section
		textArea.setText(text); //textArea.setText(message.getText());
		textArea.setSize(355, 75);
		textArea.setLocation(5, 30);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
				new ReplyFrame(isSeller, text);
			}
		});
		
		//Panel Properties
		this.setSize(473, 110);
		this.setLayout(null);
	}
}
