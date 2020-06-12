package GUI;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniShop.*;

public class AdPanelRegistered extends AdPanel {

	private JButton sendMessage = new JButton();
	private JButton addToWishlist = new JButton();
	
	private boolean onWishlist;
	private Ad myAd;
	private Registered currUser;
	
	private JPanel currPanel;
	
	public AdPanelRegistered(Ad ad, Registered user, LocalDataBase db) {
		super(ad, db);
		this.myAd = ad;
		this.currUser = user;
		this.onWishlist = currUser.getWishlist().contains(this.myAd);
		this.currPanel = this;
		
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
				new ViewOtherProfile(myAd.getSeller());
			}
		});
		this.add(sendMessage);
		
		//Add to Wish List Button
		addToWishlist.setSize(30, 30);
		addToWishlist.setLocation(892, 30);
		if(this.onWishlist)
			addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star_disable.png")));
		else
			addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star.png")));
		addToWishlist.setBackground(SystemColor.menu);
		addToWishlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(onWishlist) {
					currUser.removeFromWishlist(myAd);
					addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star.png")));
					onWishlist = false;
				}
				else {
					currUser.addToWishlist(myAd);
					addToWishlist.setIcon(new ImageIcon(AdPanelRegistered.class.getResource("/images/star_disable.png")));
					onWishlist = true;
				}
				addToWishlist.revalidate();
			}
		});
		this.add(addToWishlist);
	}

}
