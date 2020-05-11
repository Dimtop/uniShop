package uniShop;

import java.util.ArrayList;

public class User {
	
	protected int userId;
	protected String username;
	protected String email;
	protected int premium;
	protected ArrayList<String> preferences = new ArrayList<String>();
	
	public User(int user_id, String username, String email) {
		
		this.userId = user_id;
		this.username = username;
		this.email = email;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public ArrayList<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	
	

}
