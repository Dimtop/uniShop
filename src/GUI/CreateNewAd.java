package GUI;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

public class CreateNewAd extends JFrame{
	private JTextField textField;
	private JLabel lblMaxCharacters;
	protected JPanel panel;
	protected JButton btnCreate,btnPutPhoto;
	protected JTextArea textArea;
	private JLabel lblchrLabel;
	private JTextArea photolinkField;
	private JFrame frame;
	private JCheckBox chckbxNewCheckBox_1,chckbxNewCheckBox,chckbxNewCheckBox_2,chckbxNewCheckBox_3,chckbxNewCheckBox_4;
	private JLabel photodesplayer;
	
	private ArrayList<String> ImagePath= new ArrayList<>();
	private ArrayList<String>checkBoxes=new ArrayList<>();
	private	ArrayList<JCheckBox>tagCheckBox= new ArrayList<>();
	
	public CreateNewAd() {
		panel();
		groupLabelCheckboxes();
		JOptionPane.showMessageDialog(panel,"Don't overwrite to the description! ",
				"Message", JOptionPane.INFORMATION_MESSAGE);
		
		panelview();
	}
	
	public void panel() {
		panel= new JPanel();
		this.setContentPane(panel);	
	}	
	
	public void panelview()
	{
		this.setTitle("Create new add");
	    this.setVisible(true);
		this.setSize(485,700);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//layout of the window and all addings
	public void groupLabelCheckboxes() {
		
		//labels.
		JLabel lblProductname = new JLabel("Product Name");
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//Description field
		JLabel lblDercription = new JLabel("Dercription");
		lblDercription.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblMaxCharacters = new JLabel("Max 200 Characters");
		
		//Button.When Pressed creates new ad.
		btnCreate = new JButton("Create!");
		btnCreate.setBackground(Color.GREEN);
		
		buttonCreateUse(btnCreate);
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//Seller describes item's info and details
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		//total characters used.Dynamic show.
		lblchrLabel = new JLabel("Characters Used: 0");
		
		TextAreaLimit();
		
		JLabel lblPhotoLink = new JLabel("Photo Links");
		lblPhotoLink.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		photolinkField = new JTextArea();
		photolinkField.setEditable(false);
		photolinkField.setColumns(10);
		
		btnPutPhoto = new JButton("Put Photo");
		PhotoLink();
		
		JPanel panel_1 = new JPanel();
		
		photodesplayer= new JLabel("");
		photodesplayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		//layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProductname, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addComponent(lblDercription, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblMaxCharacters, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblchrLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
								.addComponent(textField, 207, 207, 207)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhotoLink, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
										.addComponent(btnPutPhoto, Alignment.LEADING)
										.addComponent(photolinkField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addComponent(photodesplayer, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTags, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductname, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(lblMaxCharacters)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblchrLabel)
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDercription, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
							.addComponent(lblPhotoLink)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(photolinkField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPutPhoto))
						.addComponent(photodesplayer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35)
					.addComponent(lblTags, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
				panel_1.setLayout(new GridLayout(0, 1, 0, 0));
						
				//checkBoxes.Returns a string array with the boxes checked
				chckbxNewCheckBox = new JCheckBox("Car");
				panel_1.add(chckbxNewCheckBox);
						
				chckbxNewCheckBox_1 = new JCheckBox("SmartPhone");
				panel_1.add(chckbxNewCheckBox_1);
				
				chckbxNewCheckBox_2 = new JCheckBox("Service");
				panel_1.add(chckbxNewCheckBox_2);
				
				chckbxNewCheckBox_3 = new JCheckBox("Bike");
				panel_1.add(chckbxNewCheckBox_3);
				
				chckbxNewCheckBox_4 = new JCheckBox("Other");
				panel_1.add(chckbxNewCheckBox_4);
				
				checkBoxesInitialize();
				
		getContentPane().setLayout(groupLayout);
	}
	
	//utilization of check boxes
	public void checkBoxesInitialize() { 
		tagCheckBox.add(chckbxNewCheckBox);
		tagCheckBox.add(chckbxNewCheckBox_1);
		tagCheckBox.add(chckbxNewCheckBox_2);
		tagCheckBox.add(chckbxNewCheckBox_3);
		tagCheckBox.add(chckbxNewCheckBox_4);
	}
	
	//method that returns the Tag list
	protected ArrayList<String> GetTagList(){
		return checkBoxes;
	}
	
	//button usage when pressed
	public void buttonCreateUse(JButton btnCreate) {
		btnCreate.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				for(JCheckBox box : tagCheckBox) {
					if(box.isSelected()) {
						checkBoxes.add(box.getText());
					}
				}
				setVisible(false);
				}
			});
	}
	
	protected String getProductName() {
		String ProductName=textField.getText();
		return ProductName;
	}
	
	
	public void TextAreaLimit() {

		//description limit 
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {	
				if(textArea.getText().length()>0) {
					lblchrLabel.setText("Characters used: "+ textArea.getText().length());
				}
				if(textArea.getText().length()>=200) {
					textArea.disable();
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(textArea.getText().length()>0) {
					lblchrLabel.setText("Characters used: "+ textArea.getText().length());
				}
				if(textArea.getText().length()>=200) {
					textArea.disable();
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				if(textArea.getText().length()>0) {
					lblchrLabel.setText("Characters used: "+ textArea.getText().length());
				}if(textArea.getText().length()>=200) {
					textArea.disable();
				}
				
			}
		});
	}
	
	//this method returns the first 200 characters from the description text area
	protected String getDesription() {
		
		char[] ch= new char[200];
		String Description =textArea.getText();
		
		
		for(int i=0;i<Description.length();i++) {
			if(Description.length()<200)
			ch[i]=Description.charAt(i);
		}
		
		Description = new String(ch);
		return Description;
		
	}
	
	public void PhotoLink() {
		//file chooser and path saver
		final JLabel label = new JLabel();
		 btnPutPhoto.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.addChoosableFileFilter(new ImageFilter());
	            fileChooser.setAcceptAllFileFilterUsed(false);

	            int option = fileChooser.showOpenDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION)
	            {
	               File file = fileChooser.getSelectedFile();
	               label.setText("File Selected: " + file.getName());
	               photolinkField.append(file.getAbsolutePath()+"\n");
	               
	               BufferedImage img = null;
				try {
					img = ImageIO.read(new File(file.getAbsolutePath()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
					Image dim=img.getScaledInstance(photodesplayer.getWidth(),photodesplayer.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon icon=new ImageIcon(dim);	              
					photodesplayer.setIcon(icon);
	               
					//imagePath array used on DB, contains all the paths of the user
	               ImagePath.add(file.getAbsolutePath());
	            }else{
	               label.setText("Open command canceled");
	            }
	         }
	      });
	}
	
	protected ArrayList<String> getAbsolutePath(){
		return ImagePath;
	}
	
	//abstract methods that extends to premium
	protected void Promoted() {
	}
	
	protected boolean getPromotion() {
		return false;
	}
}


//class use to filter files an choose only images 
class ImageFilter extends FileFilter {
   public final static String JPEG = "jpeg";
   public final static String JPG = "jpg";
   public final static String GIF = "gif";
   public final static String TIFF = "tiff";
   public final static String TIF = "tif";
   public final static String PNG = "png";
   
   public boolean accept(File f) {
      if (f.isDirectory()) {
         return true;
      }

      String extension = getExtension(f);
      if (extension != null) {
         if (extension.equals(TIFF) ||
            extension.equals(TIF) ||
            extension.equals(GIF) ||
            extension.equals(JPEG) ||
            extension.equals(JPG) ||
            extension.equals(PNG)) {
            return true;
         } else {
            return false;
         }
      }
      return false;
   }

   public String getDescription() {
      return "Image Only";
   }

   String getExtension(File f) {
      String ext = null;
      String s = f.getName();
      int i = s.lastIndexOf('.');
   
      if (i > 0 &&  i < s.length() - 1) {
         ext = s.substring(i+1).toLowerCase();
      }
      return ext;
   } 
}
