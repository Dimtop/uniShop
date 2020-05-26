package uniShop;

import java.util.ArrayList;
import java.util.List;
import java.util.*; 

public class Registered extends User {
	
	protected int status=1; //κατασταση χρήστη, συνδεδεμένος/μη συνδεδεμένος
	protected ArrayList<Ad> myAds;
	protected ArrayList<Message> myMessages;
	protected ArrayList<Ad> wishlist;
	
	
	
	public Registered(int userId, String username, String email)
	{
		this.myAds = new ArrayList<>();
		this.myMessages = new ArrayList<>();
		this.wishlist = new ArrayList<>();
		super(userId, username, email);	
	}
	
	
	public void logout()//Guest HP GUI 
	{
		status = 0; //0 για αποσυνδεδεμένο
		new Guest(userId, username, email); 
	}
	
	public void viewProfile()//Profile GUI 
	{
		
	}
		
		
	public void createAd()//CreateAd GUI and insert in database
	{	 
		ArrayList<String> tags = 
				new ArrayList<>(Arrays.asList("phone", "samsung", "galaxy"));
		Ad anAd = new Ad(555, "samsung galaxy", tags);
		myAds.add(anAd);
	}
	
	
	public void deleteAd(Ad aAd)//??? GUI and delete in database
	{
		myAds.remove(aAd);
	}
	
	
	public void readAd(Ad aAd)//ProductView GUI
	{
		//dokimi
	}
	
	
	public void updateAd(Ad aAd)//Profile GUI myAds button and update in database
	{
		
	}
	
	public ArrayList<Message> viewMessages()//MyMessages GUI
	{
		return myMessages;
	}//from void to ArrayList<Message>
	
	
	public void replyMessages(Message aMessage)//MyMessages GUI and insert in database
	{
		Message reply = new Message();
		//υλοποιείται απάντηση στα γραφικα
		myMessages.add(reply);
	}
	
	public void deleteMessages(Message aMessage)//MyMessages GUI and delete in database
	{
		myMessages.remove(aMessage);
	}
	
	public void reviewBuyer(Registered aUser)//MyMessages GUI?? review for buyer in database??
	{
		
	}
	
	public void upgradePremiumPlan()//Registered HP GUI and change at database
	{
		//change this.premium
		//Create Premium object and create Premium HP GUI
	}
	
	public ArrayList<Ad> searchAds()//Registered HP GUI and database search
	{
		
	}
	
	public ArrayList<Ad> filterRegistered()//Registered HP GUI and database search 
	{
		
	}
	
	public void viewProducts(Ad aProduct)//Product view GUI and search database
	{
		
	}
	
	public void viewOtherProfiles(Registered aUser)//ViewOtherProfiles GUI and search database
	{
		
	}
	
	public void sendMessages(Registered aUser)//Registered HP GUI and insert in database
	{
		
	}
	
	public void reviewSeller(Registered aUser)//ViewOtherProfiles GUI and review in database??
	{
		
	}
	
	public void addToWishlist(Ad aProduct)//Registered HP GUI and insert to database
	{
		this.wishlist.add(aProduct);
	}
	
	public void viewWishlist()//Registered HP GUI wishList button
	{
		
	}
	
	public void removeFromWishlist(Ad aProduct)//Registered HP GUI and delete from database
	{
		this.wishlist.remove(aProduct);
	}
	
	public void addPreferences(String aPreference)//Profile GUI and insert in the database
	{
		this.preferences.add(aPreference);
	}
	
	public void removePreferences(String aPreference)//Profile GUI and delete from the database
	{
		this.preferences.remove(aPreference);
	}
	
	public void updateProfile()//Profile GUI and change in the database
	{
		
	}
	
	public void deleteProfile()//Profile GUI and delete in the database
	{
		
	}
	
	public void viewAdsHistory()//Profile GUI and search in database
	{
		
	}
	
	public void matchPreferences()//Search in database
	{
		
	}
	
	
	
	

	
}
