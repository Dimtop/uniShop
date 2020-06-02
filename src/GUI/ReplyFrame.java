package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReplyFrame extends JFrame {

	private JPanel mainPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea textArea = new JTextArea();
	private JButton replyCloseButton = new JButton();
	
	public ReplyFrame(boolean isSeller, String text) {
		
		//Main Panel Section
		setupMainPanel();
		
		//Components Section
		setupComponents(isSeller, text);
		//Frame Properties
		setupFrameProperties();
	}
	
	private void setupMainPanel() {
		mainPanel.setLayout(null);
		this.setContentPane(mainPanel);
	}

	private void setupComponents(boolean isSeller, String text) {
		
		//Scroll Panel
		scrollPane.setSize(500, 300);
		scrollPane.setLocation(10, 10);
		mainPanel.add(scrollPane);
		
		//Text Area
		textArea.setPreferredSize(new Dimension(475, 295));
		textArea.setLocation(0, 0);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		//Reply Button
		replyCloseButton.setSize(70, 20);
		replyCloseButton.setLocation(520, 290);
		mainPanel.add(replyCloseButton);
		
		if(isSeller) {
			replyCloseButton.setText("Reply");
			replyCloseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//to do
				}
			});
		}
		else {
			textArea.setText(text);
			textArea.setEditable(false);
			replyCloseButton.setText("Close");
			replyCloseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
	}
	
	private void setupFrameProperties() {
		this.setResizable(false);
		this.setTitle("Reply");
		this.setVisible(true);
		this.setSize(620, 360);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.setIconImage(new ImageIcon(this.getClass().getResource("/images/shopping-bags-512.png")).getImage());
	}
}
