package uniShop;

import java.util.ArrayList;
import GUI.*;

public class Premium extends Registered {

	private int tier;
	
	public Premium(int userId, String username, String email, ArrayList<String> preferences, int tier, LocalDataBase db) 
	{
		super(userId, username, email, db);
		this.premium = 1;
		this.preferences = preferences;
		this.tier = tier;
		
	}
	
	public Premium(Registered user) {
		super(user.getId(), user.getUsername(), user.getEmail(), user.getDb());
		this.premium = 1; //not sure
		this.preferences = user.getPreferences();
		this.tier = 1;
		this.myMessages = user.getMessages();
		this.myAds = user.getMyAds();
		this.wishlist = user.getWishlist();
		this.preferences = user.getPreferences();
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
	
	@Override
	public void callHomePage() {
		new HomeScreen_Premium(db, this);
	}

}
