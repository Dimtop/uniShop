package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AdPanel extends JPanel {

	private JLabel tempLabel = new JLabel();
	
	public AdPanel(String text) {
		
		//temp
		tempLabel.setText(text);
		tempLabel.setSize(300,100);
		tempLabel.setFont(new Font("Tahoma", Font.PLAIN, 51));
		tempLabel.setLocation(340, 25);
		
		this.add(tempLabel);
		
		//Panel Properties
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setLayout(null);
		this.setSize(937, 150);	
	}
}