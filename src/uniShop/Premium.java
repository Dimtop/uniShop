package uniShop;

import java.util.ArrayList;

public class Premium extends Registered {
	
	private int tier;

	public Premium(int user_id, String username, String email, int premium, ArrayList<String> preferences, int tier) {
		super(user_id, username, email);
		this.tier = tier;
	}
	
	

}
