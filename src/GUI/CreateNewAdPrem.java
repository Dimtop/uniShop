package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;

public class CreateNewAdPrem extends CreateNewAd{

	private JToggleButton PromoButton=new JToggleButton("Promote!");
	private boolean booleanpromo=false;
	
	public CreateNewAdPrem() {
		
		GroupLayout groupLayout = (GroupLayout) getContentPane().getLayout();
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 464, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 461, Short.MAX_VALUE)
		);
		Promoted();
		
	}
	
	protected void Promoted() {
		panel.add(PromoButton);
		PromoButton.setSize(btnCreate.getWidth(),20);
		PromoButton.setLocation(btnCreate.getX(),btnCreate.getY()-30);
	}
	
	protected boolean getPromotion() {
		
		ActionListener actionListener = new ActionListener() {
			
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  
		          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		          booleanpromo=abstractButton.isSelected();
		        }
		      };
		PromoButton.addActionListener(actionListener);
		    
		return booleanpromo;
	}
}
