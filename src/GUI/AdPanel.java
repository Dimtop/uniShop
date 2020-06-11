package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import uniShop.*;

/*	Panel appearing on the HomeScreen multiply times that
 * 	contains informations about an Ad
 * 	Input : variable ad type Ad
 */

public class AdPanel extends JPanel {

	private Ad myAd;
	
	private JLabel photo;
	private JLabel nameLabel = new JLabel();
	private JTextArea descText = new JTextArea();
	private JLabel tierLabel = new JLabel();
	private JLabel sellerName = new JLabel();
	
	public AdPanel(Ad ad) {
		this.myAd = ad;
		
		//Photo Section
		setupPhoto();
		
		//Product Name Section
		setupProductName();
		
		//Product Description Section
		setupProductDescription();
		
		//Premium Tier Section
		setupTier();
		
		//Seller Name Section
		setupSellerName();
		
		//Panel Properties
		setupPanelProperties();
	}
	
	private void setupPhoto() {
		
		BufferedImage image;
		try {
			image = ImageIO.read(new URL(myAd.getPhotoLink()));  //get url from ad
			Image resizedImage = resizeImage(image);
			photo = new JLabel(new ImageIcon(resizedImage)); 
		} catch (MalformedURLException e) {
			photo = new JLabel(new ImageIcon(this.getClass().getResource("/images/no_image_found.png")));
		} catch (IOException e) {
			photo = new JLabel(new ImageIcon(this.getClass().getResource("/images/no_image_found.png")));
		}
		
		photo.setSize(140, 140);
		photo.setLocation(10, 5);
		this.add(photo);

	}
	
	private void setupProductName() {
		
		nameLabel.setText(myAd.getName());
		nameLabel.setSize(600, 30);
		nameLabel.setLocation(160, 30);
		nameLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Testing 
				ArrayList<String> strTest = new ArrayList<>();
				strTest.add("Test1");
				strTest.add("Test2");
				strTest.add("Test3");
				strTest.add("Test4");
				new ProductView(strTest);
			}
		});
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(nameLabel);
	}
	
	private void setupProductDescription() {
		descText.setText(myAd.getDescription());
		descText.setSize(720, 80);
		descText.setLocation(160, 65);
		descText.setBackground(new Color(240, 240, 240));
		descText.setEditable(false);
		descText.setLineWrap(true);
		descText.setWrapStyleWord(true);
		descText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descText);
	}
	
	private void setupTier() {
		tierLabel.setText(myAd.getPromotionType().toString());
		tierLabel.setSize(350, 20);
		tierLabel.setLocation(160, 12);
		tierLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tierLabel.setForeground(Color.LIGHT_GRAY);
		this.add(tierLabel);
	}
	
	private void setupSellerName() {
		sellerName.setText(myAd.getSeller().getUsername());
		sellerName.setSize(225, 20);
		sellerName.setLocation(700, 5);
		sellerName.setHorizontalAlignment(SwingConstants.RIGHT);
		sellerName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		sellerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ViewOtherProfile(myAd.getSeller());
			}
		});
		this.add(sellerName);
	}
	
	private void setupPanelProperties() {
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setLayout(null);
		this.setSize(937, 150);	
	}
	
	//converting a BufferedImage to an Image and resizing it
	protected Image resizeImage(BufferedImage img) {
		Image image;
		
		int newHeight;
		int newWidth;
		
		if(img.getHeight()>img.getWidth()) {
			newHeight = 180;
			newWidth = (int) (img.getWidth()*(double) newHeight/img.getHeight());
		}
		else {
			newWidth = 180;
			newHeight = (int) (img.getHeight()*(double) newWidth/img.getWidth());
		}
		image = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
				
		return image;
	}
}