package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class ProductView extends JFrame{

	private Image imageFav;
	private JTextField textField;
	private JButton FavButton = new JButton("");
	private JButton nextBtn = new JButton("Next");
	private JButton prevBtn = new JButton("Prev.");
	private BufferedImage img=null;
	private JLabel PhotoOfTheProduct = new JLabel("");
	private int nextTP=0,PrevTP=0;
	private JLabel favlabel = new JLabel("");
	
	public ProductView(ArrayList<String>imagepath) {
		
		imageFav=new ImageIcon(this.getClass().getResource("/Images/star.png")).getImage();
		getContentPane().setLayout(null);	
		
		FavButtonSetUp();
		
		JLabel NameLabel = new JLabel("Product Name\r\n");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(0, 11, 659, 41);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		getContentPane().add(NameLabel);
		
		JLabel LinkToSeller = new JLabel("Sellers Name");
		LinkToSeller.setBounds(533, 93, 102, 14);
		getContentPane().add(LinkToSeller);
		
		JLabel lblDateAdded = new JLabel("Date added:");
		lblDateAdded.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDateAdded.setBounds(10, 87, 167, 23);
		getContentPane().add(lblDateAdded);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textPane.setBounds(10, 121, 344, 194);
		textPane.setEditable(false);
		getContentPane().add(textPane);
		
		PhotoOfTheProduct.setHorizontalAlignment(SwingConstants.CENTER);
		PhotoOfTheProduct.setBounds(364, 121, 272, 194);
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
		favlabel.setBounds(533, 49, 102, 14);
		getContentPane().add(favlabel);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTags.setBounds(4, 328, 66, 17);
		getContentPane().add(lblTags);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(80, 329, 230, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		FavButtonSetUp();
		
		nextNprevButtonsSetup(imagepath);
		
		panelProperties();
	}
	
	public void panelProperties() {
		
		this.setVisible(true);
		this.setTitle("Product View");
		this.setSize(675,415);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}

	public void FavButtonSetUp() {
		getContentPane().add(FavButton);
		FavButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fav= true;
				favlabel.setForeground(Color.RED);
				favlabel.setText("Added on your fav list!");
			}
		});
		FavButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		FavButton.setBounds(608, 11, 27, 27);
		FavButton.setIcon(new ImageIcon(imageFav));
	}
	
	public void nextNprevButtonsSetup(ArrayList<String>imagepath) {
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
	}
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
