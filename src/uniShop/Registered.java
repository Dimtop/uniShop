package uniShop;

import java.util.*; 
import GUI.*;

public class Registered extends User {
	
	protected int status=0; //κατασταση χρήστη, συνδεδεμένος/μη συνδεδεμένος
	protected String password;
	protected ArrayList<Ad> myAds;
	protected ArrayList<Message> myMessages;
	protected ArrayList<Ad> wishlist;
	
	
	
	public Registered(int userId, String username, String email, LocalDataBase db)
	{
		super(userId, username, email, db);	
		this.myAds = new ArrayList<>();
		this.myMessages = new ArrayList<>();
		this.wishlist = new ArrayList<>();
		this.premium = 0;
		
	}	
	
	public void logout()//Guest HP GUI 
	{
		status = 0; //0 για αποσυνδεδεμένο
		new Guest(db); 
	}
	
	public void viewProfile()//Profile GUI 
	{
		
	}
		
		
	/*public void createAd()//CreateAd GUI and insert in database
	{	 
		ArrayList<String> tags = 
				new ArrayList<>(Arrays.asList("phone", "samsung", "galaxy"));
		Ad anAd = new Ad(555, "samsung galaxy", tags);
		myAds.add(anAd);
	}*/
	
	
	public void deleteAd(Ad aAd)//??? GUI and delete in database
	{
		myAds.remove(aAd);
	}
	
	//Adding a Ad into User's ads list
	public void addMyAd(Ad ad) {
		myAds.add(ad);
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
	
	
	/*public void replyMessages(Message aMessage)//MyMessages GUI and insert in database
	{
		Message reply = new Message();
		//υλοποιείται απάντηση στα γραφικα
		myMessages.add(reply);
	}*/
	
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
		if(this.premium == 0) {
			new Premium(this.userId, this.username, this.email,this.preferences,0, this.db);
			//Premium_Gui
		}
		else if(this.premium==1) {
			//updatePremiumPlan();
		}
			
			
	}
	
	public ArrayList<Ad> search(String text,LocalDataBase db)//Registered HP GUI and database search
	{
		
		boolean find = false;
		
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		for(Ad ad: db.getSystemAds()) {
			if(ad.getName().contains(text)) {
				foundAds.add(ad);
				find = true;
			}		
		}
		if(find == true) {
			Collections.sort(foundAds);
			return foundAds;
		}
		if(find == false) {
			Collections.sort(this.db.getSystemAds());
		}
		
		return this.db.getSystemAds();	
		
	}
	
	public ArrayList<Ad> filter(ArrayList<String> tags,LocalDataBase db)//Registered HP GUI and database search 
	{
		boolean found = false;
		
			
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
			
		outsideloop:
		for(Ad ad: db.getSystemAds()) {
			for(String preference: ad.getTags()) {
				if(tags.contains(preference)) {
					found = true;
					foundAds.add(ad);
					continue outsideloop;
				}
			}	
		}
			
		if(found == true) {
			Collections.sort(foundAds);
			return foundAds;
		}
			
		if(found == false)
			Collections.sort(this.db.getSystemAds());
		
		return this.db.getSystemAds();
			
	}	
	
	public void viewProducts(ArrayList<Ad> ads)//Product view GUI and search database
	{
		for(Ad ad: ads)
			System.out.println(ad.getName());
		
		//HomeScreenRegistered g = new HomeScreenRegistered(ads); ???
	}
	
	public void viewOtherProfiles(Registered aUser)//ViewOtherProfiles GUI and search database
	{
		ArrayList<Registered> profiles = new ArrayList<Registered>(); //υποθετική βάση
		
		//Registered R1 = new Registered(11, "george", "ge@gmail.com");
		//Registered R2 = new Registered(5, "Mike9", "mike@gmail.com");
		//Registered R3 = new Registered(999, "helen99", "helen9@gmail.com");
		
		//profiles.add(R1);
		//profiles.add(R2);
		//profiles.add(R3);
		
		//for(Registered R: profiles) if aUser is connected with R return R
		
		
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
	
	public ArrayList<Ad> getWishlist(){
		return this.wishlist;
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
		
		
		ArrayList<Ad> ads = new ArrayList<>(); // needs ads from db
		ArrayList<Ad> prefAds = new ArrayList<>(); //preferred ads 
		boolean found = false;
		
		outsideloop:
		for(Ad ad: ads) {
			for(String pref: this.preferences) {
				if(ad.getTags().contains(pref)){
					prefAds.add(ad);
					found = true;
					continue outsideloop;
				}
			}
		}
		
		if(found==true) {
			Collections.sort(prefAds);
			//return prefAds; ?????????
		}
		else {
			Collections.sort(ads);
			//return ads; ???????
		}
			
		
	}
	
	public ArrayList<Message> getMessages(){
		return this.myMessages;
	}
	
	public ArrayList<Ad> getMyAds(){
		return this.myAds;
	}
	
	//ads a message to myMessages list
	public void addMessage(Message msg) {
		this.myMessages.add(msg);
	}
	
	public void addAd(Ad ad) {
		this.myAds.add(ad);
	}
		
	public int getTier() {
		return 0;
	}
	
	@Override
	public void callHomePage() {
		new HomeScreen_Registered(db, this);
	}
	
	public LocalDataBase getDb() {
		return this.db;
	}


	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
