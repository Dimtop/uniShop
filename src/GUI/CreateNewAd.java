package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

import com.sun.jdi.connect.Connector.SelectedArgument;

import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.GridLayout;

public abstract class CreateNewAd extends JFrame{
	private JTextField textField;
	private JLabel lblMaxCharacters;
	protected JPanel panel;
	protected JButton btnCreate,btnPutPhoto;
	protected JTextArea textArea;
	private JLabel lblchrLabel;
	private JTextArea photolinkField;
	private JFrame frame;
	private JCheckBox chckbxNewCheckBox_1,chckbxNewCheckBox,chckbxNewCheckBox_2,chckbxNewCheckBox_3,chckbxNewCheckBox_4;
	
	private ArrayList<String> ImagePath= new ArrayList<>();
	private ArrayList<String>checkBoxes=new ArrayList<>();
	private ArrayList<Boolean>s=new ArrayList<>();
	
	public CreateNewAd() {
		panel();
		groupLabelCheckboxes();
		JOptionPane.showMessageDialog(panel,"Dont overwrite to the description! ",
				"Message", JOptionPane.INFORMATION_MESSAGE);
		
		panelview();
	}
	
	private void panel() {
		panel= new JPanel();
		this.setContentPane(panel);	
	}	
	
	private void panelview()
	{
		this.setTitle("Create new add");
	    this.setVisible(true);
		this.setSize(485,670);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
		this.setIconImage(new ImageIcon(this.getClass().getResource("shopping-bags-512.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void groupLabelCheckboxes() {
		
		//labels 
		JLabel lblProductname = new JLabel("Product Name");
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//Description field
		JLabel lblDercription = new JLabel("Dercription");
		lblDercription.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblMaxCharacters = new JLabel("Max 200 Characters");
		
		//Button
		btnCreate = new JButton("Create!");
		btnCreate.setBackground(Color.GREEN);
		
		buttonCreateUse(btnCreate);
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
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
		
		//layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
									.addComponent(btnPutPhoto)
									.addGap(10))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPhotoLink, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
											.addGap(31))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblProductname, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
												.addComponent(lblDercription, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblMaxCharacters, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblchrLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
										.addComponent(photolinkField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
										.addComponent(textField, 207, 207, 207)))))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTags, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
									.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))))
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
							.addComponent(lblchrLabel))
						.addComponent(lblDercription, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhotoLink)
						.addComponent(photolinkField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPutPhoto)
					.addGap(11)
					.addComponent(lblTags, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
				panel_1.setLayout(new GridLayout(0, 1, 0, 0));
						
							//checkBoxes
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
	
	private void checkBoxesInitialize() { 
		
		ActionListener actionListener = new ActionListener() {
			
	      public void actionPerformed(ActionEvent actionEvent) {
	    	  
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          String Tag= abstractButton.getText();
	    
	          if(!checkBoxes.contains(Tag))
	          {
	        	  checkBoxes.add(Tag);
	        	  abstractButton.setEnabled(false);
	       	  }
	        }
	      };
	      
		chckbxNewCheckBox.addActionListener(actionListener);
		chckbxNewCheckBox_1.addActionListener(actionListener);
		chckbxNewCheckBox_2.addActionListener(actionListener);
		chckbxNewCheckBox_3.addActionListener(actionListener);
		chckbxNewCheckBox_4.addActionListener(actionListener);
	}
	
	protected ArrayList<String> GetTagList(){
		return checkBoxes;
	}
	
	private void buttonCreateUse(JButton btnCreate) {
		btnCreate.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				InfoOfNewAd I = new InfoOfNewAd(getProductName(), getDesription(), getAbsolutePath(),GetTagList(),getPromotion());
				
				setVisible(false);
				}
			});
	}
	
	protected String getProductName() {
		String ProductName=textField.getText();
		return ProductName;
	}
	
	private void TextAreaLimit() {

		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
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
				// TODO Auto-generated method stub
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
	
	private void PhotoLink() {
		
		final JLabel label = new JLabel();
		 btnPutPhoto.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.addChoosableFileFilter(new ImageFilter());
	            fileChooser.setAcceptAllFileFilterUsed(false);

	            int option = fileChooser.showOpenDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               label.setText("File Selected: " + file.getName());
	               photolinkField.append(file.getAbsolutePath()+"\n");	     
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
	
	protected abstract void Promoted();
	
	protected abstract boolean getPromotion();
}



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
