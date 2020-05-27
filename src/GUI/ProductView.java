package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.colorchooser.ColorChooserComponentFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView extends JFrame{

	private Image imageFav;
	private JTextField textField;
	
	public ProductView() {
		
		imageFav=new ImageIcon(this.getClass().getResource("/Images/heartFav.png")).getImage();
		getContentPane().setLayout(null);	
		JButton FavButton = new JButton("");
		FavButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		FavButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		FavButton.setBounds(608, 11, 41, 41);
		FavButton.setIcon(new ImageIcon(imageFav));
		getContentPane().add(FavButton);
		//FavButton.setBorder(new RoundedBorder(10));
		//FavButton.setBackground(Color.gray);

		JLabel NameLabel = new JLabel("Product Name\r\n");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(0, 11, 659, 41);
		NameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		getContentPane().add(NameLabel);
		
		JLabel LinkToSeller = new JLabel("Sellers Name");
		LinkToSeller.setBounds(484, 63, 102, 14);
		getContentPane().add(LinkToSeller);
		
		JLabel lblDateAdded = new JLabel("Date added:");
		lblDateAdded.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDateAdded.setBounds(10, 58, 167, 23);
		getContentPane().add(lblDateAdded);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 86, 300, 165);
		textPane.setEditable(false);
		getContentPane().add(textPane);
		
		JLabel PhotoOfTheProduct = new JLabel("Photo");
		PhotoOfTheProduct.setHorizontalAlignment(SwingConstants.CENTER);
		PhotoOfTheProduct.setBounds(386, 86, 200, 165);
		getContentPane().add(PhotoOfTheProduct);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTags.setBounds(10, 267, 66, 17);
		getContentPane().add(lblTags);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(80, 268, 230, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(520, 262, 66, 23);
		getContentPane().add(nextBtn);
		
		JButton btnNewButton = new JButton("Prev.");
		btnNewButton.setBounds(386, 262, 66, 23);
		getContentPane().add(btnNewButton);
		
		this.setVisible(true);
		this.setTitle("Product View");
		this.setSize(675,450);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
