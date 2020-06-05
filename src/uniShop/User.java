package uniShop;

import java.util.ArrayList;

public abstract class User {
	
	protected int userId;
	protected String username;
	protected String email;
	protected int premium;
	protected ArrayList<String> preferences;
	
	
	public User(int userId, String username, String email) {
		this.userId = userId;
		this.username = username;
		this.email = email;
	}


	public ArrayList<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return this.userId;
	}
	
	public void setId(int id) {
		this.userId = id;
	}
	
	//returns a text about int premium value
	public String premiumToText() {
		String text;
		
		if(premium==0)
			text = "Non premium user";
		else
			text = "Premium user";
		
		return text;
	}
	
	//abstract method search
	public abstract ArrayList<Ad> search(String text);
	
	//abstract method filter
	public abstract ArrayList<Ad> filter(ArrayList<String> tags);
	

}
