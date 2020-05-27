package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*	Panel appearing on the HomeScreen multiply times that
 * 	contains informations about an Ad
 * 	Input : variable ad type Ad
 */

public class AdPanel extends JPanel {

	private JLabel photo;
	private JLabel nameLabel = new JLabel();
	private JTextArea descText = new JTextArea();
	private JLabel tierLabel = new JLabel();
	private JLabel sellerName = new JLabel();
	
	public AdPanel(String text) {
		
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
		String testUrl = "https://cdn.wccftech.com/wp-content/uploads/2018/10/Intel-X-Series-1-Custom-2060x1375.jpg";
		
		BufferedImage image;
		try {
			image = ImageIO.read(new URL(testUrl));  //get url from ad
			Image resizedImage = resizeImage(image);
			photo = new JLabel(new ImageIcon(resizedImage)); 
		} catch (MalformedURLException e) {
			photo = new JLabel("No Photo found");
		} catch (IOException e) {
			photo = new JLabel("No Photo found");
		}
		
		photo.setSize(140, 140);
		photo.setLocation(10, 5);
		this.add(photo);

	}
	
	private void setupProductName() {
		
		nameLabel.setText("Product Name"); //ad.getName();
		nameLabel.setSize(725, 30);
		nameLabel.setLocation(160, 30);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(nameLabel);
	}
	
	private void setupProductDescription() {
		String str = "adadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdadadadadsdasdasdasdadasdasdasdasdad";
		descText.setText(str); //ad.getDesc();
		descText.setSize(720, 80);
		descText.setLocation(160, 65);
		descText.setEditable(false);
		descText.setLineWrap(true);
		descText.setWrapStyleWord(true);
		descText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descText);
	}
	
	private void setupTier() {
		tierLabel.setText("Tier #" + "1"); //ad.getTier();
		tierLabel.setSize(100, 20);
		tierLabel.setLocation(160, 12);
		tierLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tierLabel.setForeground(Color.LIGHT_GRAY);
		this.add(tierLabel);
	}
	
	private void setupSellerName() {
		sellerName.setText("Seller Name"); //ad.getSellerName();
		sellerName.setSize(225, 20);
		sellerName.setLocation(700, 5);
		sellerName.setHorizontalAlignment(SwingConstants.RIGHT);
		sellerName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		sellerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(sellerName.getText());
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