package uniShop;

import java.util.ArrayList;

public class Registered extends User {
	
	protected ArrayList<Ad> wishList;
	protected ArrayList<Message> myMessages;
	protected ArrayList<Ad> myAds;
	

	public Registered(int user_id, String username, String email) {
		super(user_id, username, email);
		this.wishList = wishList;
		this.wishList = new ArrayList<Ad>();
		this.myMessages = new ArrayList<Message>();
		this.myAds = new ArrayList<Ad>();
		
	}
	
	
	

}
