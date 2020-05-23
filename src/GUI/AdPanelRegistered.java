package GUI;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class AdPanelRegistered extends AdPanel {

	private JButton sendMessage = new JButton();
	private JButton addToWishlist = new JButton();
	
	public AdPanelRegistered(String text) {
		super(text);
		
		//Registered Buttons about an Ad
		setupButtons();
	}
	
	private void setupButtons() {
		
		//Send Message Button
		sendMessage.setSize(30, 30);
		sendMessage.setLocation(852, 30);
		sendMessage.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/message.png")));
		sendMessage.setBackground(SystemColor.menu);
		this.add(sendMessage);
		
		//Add to Wish List Button
		addToWishlist.setSize(30, 30);
		addToWishlist.setLocation(892, 30);
		addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star.png")));
		addToWishlist.setBackground(SystemColor.menu);
		this.add(addToWishlist);
	}

}
