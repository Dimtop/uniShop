package uniShop;

import java.util.ArrayList;

public class Premium extends Registered {

	private int tier;
	
	public Premium(int userId, String username, String email, int premium, ArrayList<String> preferences, int tier) 
	{
		super(userId, username, email);
		this.premium = premium;
		this.preferences = preferences;
		this.tier = tier;
		
	}
	
	public Premium(Registered user) {
		super(user.getId(), user.getUsername(), user.getEmail());
		this.premium = 1; //not sure
		this.preferences = user.getPreferences();
		this.tier = 1;
	}
	
	public void  viewPremiumPlan()//Premium Plan GUI 
	{
		
	}
	
	public void updatePremiumPlan()//Premium Plan GUI and update in database
	{
		this.tier++;
	}
	
	public void deletePremiumPlan()//Premium Plan GUI and delete in database
	{
		this.premium = 0;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
	
	
	

}
