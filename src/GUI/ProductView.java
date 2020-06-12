package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import uniShop.Ad;
import uniShop.LocalDataBase;

public class ProductView extends JFrame{

	private Image imageFav;
	private JButton FavButton = new JButton("");
	private JButton nextBtn = new JButton("Next");
	private JButton prevBtn = new JButton("Prev.");
	private BufferedImage img=null;
	private JLabel PhotoDesp = new JLabel("");
	private int nextTP=0,PrevTP=0;
	private JLabel favlabel = new JLabel("");
	private boolean fav= false;
	
	private Ad ad;
	
	public ProductView(Ad ad) {
		
		this.ad=ad;
		
		imageFav=new ImageIcon(this.getClass().getResource("/Images/star.png")).getImage();
		getContentPane().setLayout(null);	
		
		
		JLabel NameLabel = new JLabel(ad.getName());
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(0, 11, 659, 41);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(NameLabel);
		
		JLabel LinkToSeller = new JLabel(ad.getSeller().getUsername());
		LinkToSeller.setBounds(679, 117, 102, 14);
		getContentPane().add(LinkToSeller);
		
		JLabel lblDateAdded = new JLabel(ad.getDate().toString());
		lblDateAdded.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDateAdded.setBounds(10, 87, 344, 23);
		getContentPane().add(lblDateAdded);
		
		JLabel textPane = new JLabel(ad.getDescription());
		textPane.setVerticalAlignment(SwingConstants.TOP);
		textPane.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textPane.setBounds(10, 153, 344, 194);
		getContentPane().add(textPane);
		
		PhotoDesp.setHorizontalAlignment(SwingConstants.CENTER);
		PhotoDesp.setBounds(364, 121, 272, 194);
		
		BufferedImage image;
		try {
			image = ImageIO.read(new URL(ad.getPhotoLink()));  //get url from ad
			Image resizedImage = resizeImage(image);
			PhotoDesp = new JLabel(new ImageIcon(resizedImage)); 
		} catch (MalformedURLException e) {
			PhotoDesp = new JLabel(new ImageIcon(this.getClass().getResource("/images/no_image_found.png")));
		} catch (IOException e) {
			PhotoDesp = new JLabel(new ImageIcon(this.getClass().getResource("/images/no_image_found.png")));
		}
		
		/*try {
			img=ImageIO.read(new File(imagepath.get(0)));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//puts the 1st image
		Image dim=img.getScaledInstance(PhotoOfTheProduct.getWidth(),PhotoOfTheProduct.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(dim);
		PhotoOfTheProduct.setIcon(icon);
		
		getContentPane().add(PhotoOfTheProduct);*/
		favlabel.setFont(new Font("Tahoma", Font.ITALIC, 9));
		
		favlabel.setHorizontalAlignment(SwingConstants.CENTER);
		favlabel.setBounds(679, 52, 102, 14);
		getContentPane().add(favlabel);
		
		JLabel lblTags_1 = new JLabel("Tags");
		lblTags_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTags_1.setBounds(10, 350, 57, 30);
		getContentPane().add(lblTags_1);
		
		JLabel TagsLbl=new JLabel("Tags");
		
		int i =lblTags_1.getX()+10;
		for(String Tag: ad.getTags()) 
		{
			TagsLbl.setText(Tag);
			TagsLbl.setBounds(i, 350,150,30);
			TagsLbl.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(TagsLbl);
			i+=10;
		}
		
		
		PhotoDesp.setBounds(437, 142, 344, 224);
		getContentPane().add(PhotoDesp);
		
		panelProperties();
	}
	
	public Image resizeImage(BufferedImage img) {
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
	
	public void panelProperties() {
		
		this.setVisible(true);
		this.setTitle("Product View");
		this.setSize(755,455);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}

	/*/public void FavButtonSetUp() {
		System.out.println(ad.getBuyer().getId());
		//if()FavButton.setVisible(false);
		
		getContentPane().add(FavButton);
		FavButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fav= true;
				favlabel.setForeground(Color.RED);
				favlabel.setText("Added on your fav list!");
			}
		});
		FavButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		FavButton.setBackground(SystemColor.menu);
		FavButton.setBounds(751, 11, 30, 30);
		FavButton.setIcon(new ImageIcon(imageFav));
	}
	
	public boolean isFav() {
		return fav;
	}/*/
	
	/*/public void nextNprevButtonsSetup(ArrayList<String>imagepath) {
		nextBtn.setBounds(569, 327, 66, 23);
		getContentPane().add(nextBtn);
		prevBtn.setBounds(364, 327, 66, 23);
		getContentPane().add(prevBtn);
			
		prevBtn.setVisible(false);
		if(imagepath.size()==1)nextBtn.setVisible(false);
		
		//next image button
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTP++;
				if(nextTP==0)prevBtn.setVisible(false);
				else prevBtn.setVisible(true);
				if(nextTP+1==imagepath.size()) {
					nextBtn.setVisible(false);
				}
				
				try {
					img=ImageIO.read(new File(imagepath.get(nextTP)));
				} catch (IOException i) {
					// TODO Auto-generated catch block
					i.printStackTrace();
				}
				Image dim=img.getScaledInstance(PhotoOfTheProduct.getWidth(),PhotoOfTheProduct.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon icon=new ImageIcon(dim);
				PhotoOfTheProduct.setIcon(icon);
			}
		});
		
		//prev image button

		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTP--;
				if(nextTP==0)prevBtn.setVisible(false);
				else prevBtn.setVisible(true);
				nextBtn.setVisible(true);
				
				try {
					img=ImageIO.read(new File(imagepath.get(nextTP)));
				} catch (IOException i) {
					// TODO Auto-generated catch block
					i.printStackTrace();
				}
				Image dim=img.getScaledInstance(PhotoOfTheProduct.getWidth(),PhotoOfTheProduct.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon icon=new ImageIcon(dim);
				PhotoOfTheProduct.setIcon(icon);
			}
		});
	}/*/
}

 class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
