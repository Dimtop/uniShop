package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import uniShop.*;

public class AdPanelRegistered extends AdPanel {

	private JButton sendMessage = new JButton();
	private JButton addToWishlist = new JButton();
	
	public AdPanelRegistered(Ad ad) {
		super(ad);
		
		//Registered Buttons about an Ad
		setupButtons();
	}
	
	private void setupButtons() {
		
		//Send Message Button
		sendMessage.setSize(30, 30);
		sendMessage.setLocation(852, 30);
		sendMessage.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/message.png")));
		sendMessage.setBackground(SystemColor.menu);
		sendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Send Message");
			}
		});
		this.add(sendMessage);
		
		//Add to Wish List Button
		addToWishlist.setSize(30, 30);
		addToWishlist.setLocation(892, 30);
		addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star.png")));
		addToWishlist.setBackground(SystemColor.menu);
		addToWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add to Wishlist");
			}
		});
		this.add(addToWishlist);
	}

}
