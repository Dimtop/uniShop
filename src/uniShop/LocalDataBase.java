package uniShop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class LocalDataBase {

	private ArrayList<Registered> systemUsers;
	private ArrayList<Ad> systemAds;
	private ArrayList<String> systemPreferences;
	
	private int nextAdId;
	private int nextUserId;
	
	private int adsTier2;
	private int adsTier1;
	
	public LocalDataBase() {
		
		this.systemUsers = new ArrayList<>();
		this.systemAds = new ArrayList<>();
		this.nextAdId = 0;
		this.nextUserId = 0;
		this.systemPreferences = new ArrayList<>();
		this.adsTier1 = 0;
		this.adsTier2 = 0;
		
		setupSystemPreferences();
		setupSystemUsers();
		setupSystemAds();
	}
	
	//Creating some Users
	private void setupSystemUsers() {
		
		//Registered users
		Registered user1 = new Registered(nextUserId, "User 1", "user1@unishop.com");
		user1.setPreferences(getSomePreferences(1));
		user1.setPassword("user1");
		this.nextUserId++;
		Registered user2 = new Registered(nextUserId, "User 2", "user2@unishop.com");
		user2.setPreferences(getSomePreferences(2));
		user2.setPassword("user2");
		this.nextUserId++;
		Registered user3 = new Registered(nextUserId, "User 3", "user3@unishop.com");
		user3.setPreferences(getSomePreferences(3));
		user1.setPassword("user3");
		this.nextUserId++;
		Registered user4 = new Registered(nextUserId, "User 4", "user4@unishop.com");
		user4.setPreferences(getSomePreferences(4));
		user1.setPassword("user4");
		this.nextUserId++;
		Registered user5 = new Registered(nextUserId, "User 5", "user5@unishop.com");
		user5.setPreferences(getSomePreferences(5));
		user1.setPassword("user5");
		this.nextUserId++;
		
		//Premium users
		Registered user6 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(6), 1);
		user1.setPassword("user6");
		this.nextUserId++;
		Registered user7 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(7), 1);
		user1.setPassword("user7");
		this.nextUserId++;
		Registered user8 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(8), 1);
		user1.setPassword("user8");
		this.nextUserId++;
		Registered user9 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(9), 2);
		user1.setPassword("user9");
		this.nextUserId++;
		Registered user10 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(10), 2);
		user1.setPassword("user10");
		this.nextUserId++;
		Registered user11 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(11), 2);
		user1.setPassword("user11");
		this.nextUserId++;
		
		//Adding Users on database
		this.systemUsers.add(user1);
		this.systemUsers.add(user2);
		this.systemUsers.add(user3);
		this.systemUsers.add(user4);
		this.systemUsers.add(user5);
		this.systemUsers.add(user6);
		this.systemUsers.add(user7);
		this.systemUsers.add(user8);
		this.systemUsers.add(user9);
		this.systemUsers.add(user10);
		this.systemUsers.add(user11);
		
	}
	
	//Creating some Ads
	private void setupSystemAds() {
		
		//Getting current date
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date currDate = new Date(System.currentTimeMillis());
		
		String descriptionText = "This is the Description for Product ";
		
		String ad1Link = "https://images-na.ssl-images-amazon.com/images/I/51EJdvzHJeL._AC_US160_.jpg";
		Ad ad1 = new Ad(nextAdId, "Product 1", descriptionText + "1", ad1Link, currDate, 
				this.systemUsers.get(1), this.systemUsers.get(2), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad2Link = "https://images-na.ssl-images-amazon.com/images/I/71RiQZ0J2SL._AC_SL1000_.jpg";
		Ad ad2 = new Ad(nextAdId, "Product 2", descriptionText + "2", ad2Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(3), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad3Link = "https://images-na.ssl-images-amazon.com/images/I/81n%2BlyIdOVL._AC_SL1500_.jpg";
		Ad ad3 = new Ad(nextAdId, "Product 3", descriptionText + "3", ad3Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(4), this.getSomePreferences(1), ListingState.ON_HOLD);
		this.nextAdId++;
		String ad4Link = "https://images-na.ssl-images-amazon.com/images/I/714Y-S1r7ML._AC_SL1500_.jpg";
		Ad ad4 = new Ad(nextAdId, "Product 4", descriptionText + "4", ad4Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(7), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		String ad5Link = "https://images-na.ssl-images-amazon.com/images/I/71iV%2BfLoJCL._AC_SL1500_.jpg";
		Ad ad5 = new Ad(nextAdId, "Product 5", descriptionText + "5", ad5Link, currDate, 
				this.systemUsers.get(8), this.systemUsers.get(10), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad6Link = "https://images-na.ssl-images-amazon.com/images/I/91a2QToQOIL._SL1500_.jpg";
		Ad ad6 = new Ad(nextAdId, "Product 6", descriptionText + "6", ad6Link, currDate, 
				this.systemUsers.get(10), this.systemUsers.get(1), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad7Link = "https://images-na.ssl-images-amazon.com/images/I/61Nwtf2xc6L._AC_SL1500_.jpg";
		Ad ad7 = new Ad(nextAdId, "Product 7", descriptionText + "7", ad7Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(7), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad8Link = "https://images-na.ssl-images-amazon.com/images/I/71aPkUJQmFL._AC_SL1500_.jpg";
		Ad ad8 = new Ad(nextAdId, "Product 8", descriptionText + "8", ad8Link, currDate, 
				this.systemUsers.get(10), this.systemUsers.get(4), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad9Link = "https://images-na.ssl-images-amazon.com/images/I/51Se9eTnyNL._AC_SL1000_.jpg";
		Ad ad9 = new Ad(nextAdId, "Product 9", descriptionText + "9", ad9Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(10), this.getSomePreferences(7), ListingState.ACTIVE);
		this.nextAdId++;
		String ad10Link = "https://images-na.ssl-images-amazon.com/images/I/71GdlYQC1UL._AC_SL1100_.jpg";
		Ad ad10 = new Ad(nextAdId, "Product 10", descriptionText + "10", ad10Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(6), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		String ad11Link = "https://images-na.ssl-images-amazon.com/images/I/81nuCG0VLtL._AC_SL1500_.jpg";
		Ad ad11 = new Ad(nextAdId, "Product 11", descriptionText + "11", ad11Link, currDate, 
				this.systemUsers.get(7), this.systemUsers.get(3), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad12Link = "https://images-na.ssl-images-amazon.com/images/I/61WqyW4li2L._AC_SL1000_.jpg";
		Ad ad12 = new Ad(nextAdId, "Product 12", descriptionText + "12", ad12Link, currDate, 
				this.systemUsers.get(1), this.systemUsers.get(10), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad13Link = "https://images-na.ssl-images-amazon.com/images/I/81oEB3azOrL._AC_SL1500_.jpg";
		Ad ad13 = new Ad(nextAdId, "Product 13", descriptionText + "13", ad13Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(4), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad14Link = "https://images-na.ssl-images-amazon.com/images/I/81vQEfcB29L._AC_SL1500_.jpg";
		Ad ad14 = new Ad(nextAdId, "Product 14", descriptionText + "14", ad14Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(7), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad15Link = "https://images-na.ssl-images-amazon.com/images/I/81ZB62prn-L._AC_SL1500_.jpg";
		Ad ad15 = new Ad(nextAdId, "Product 15", descriptionText + "15", ad15Link, currDate, 
				this.systemUsers.get(9), this.systemUsers.get(4), this.getSomePreferences(5), ListingState.ACTIVE);
		this.nextAdId++;
		String ad16Link = "https://i.ebayimg.com/images/g/aEoAAOSw6hZcnWYe/s-l300.png";
		Ad ad16 = new Ad(nextAdId, "Product 16", descriptionText + "16", ad16Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(3), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad17Link = "https://images-na.ssl-images-amazon.com/images/I/71MNCkCo82L._AC_SL1500_.jpg";
		Ad ad17 = new Ad(nextAdId, "Product 17", descriptionText + "17", ad17Link, currDate, 
				this.systemUsers.get(8), this.systemUsers.get(9), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad18Link = "https://images-na.ssl-images-amazon.com/images/I/71wSuNVCtvL._AC_SL1500_.jpg";
		Ad ad18 = new Ad(nextAdId, "Product 18", descriptionText + "18", ad18Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(6), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		
		this.systemAds.add(ad1);
		this.systemAds.add(ad2);
		this.systemAds.add(ad3);
		this.systemAds.add(ad4);
		this.systemAds.add(ad5);	
		this.systemAds.add(ad6);
		this.systemAds.add(ad7);
		this.systemAds.add(ad8);
		this.systemAds.add(ad9);
		this.systemAds.add(ad10);
		this.systemAds.add(ad11);
		this.systemAds.add(ad12);
		this.systemAds.add(ad13);
		this.systemAds.add(ad14);
		this.systemAds.add(ad15);
		this.systemAds.add(ad16);
		this.systemAds.add(ad17);
		this.systemAds.add(ad18);
		
		setupAdsTierX();
	}
	
	//Creating system Preferences
	private void setupSystemPreferences() {
		
		this.systemPreferences.add("Arts & Crafts");
		this.systemPreferences.add("Automotive");
		this.systemPreferences.add("Baby");
		this.systemPreferences.add("Beauty & Personal Care");
		this.systemPreferences.add("Books");
		this.systemPreferences.add("Computers");
		this.systemPreferences.add("Electronics");
		this.systemPreferences.add("Fashion");
		this.systemPreferences.add("Health & Household");
		this.systemPreferences.add("Home & Kitchen");
		this.systemPreferences.add("Luggage");
		this.systemPreferences.add("Movies & Television");
		this.systemPreferences.add("Software");
		this.systemPreferences.add("Tools & Home Improvement");
		this.systemPreferences.add("Video Games");
	}
	
	//Randomize Users Preferences
	private ArrayList<String> getSomePreferences(int prefSize){
		ArrayList<String> currList = new ArrayList<>();
		
		int i = 0;
		while(i < prefSize) {
			int randNum = new Random().nextInt(this.systemPreferences.size());
			
			if(!currList.contains(this.systemPreferences.get(randNum))) {
				currList.add(this.systemPreferences.get(i));
				i++;
			}
			
			currList.add(this.systemPreferences.get(i));
		}
		
		return currList;
	}
	
	private void setupAdsTierX() {
		for(Ad ad : this.systemAds) {
			if(ad.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL1))
				this.adsTier1++;
			else if(ad.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL2))
				this.adsTier2++;
		}
	}
	
	//Returns a random List of system's Ads
	public ArrayList<Ad> randomizeAds(){
		ArrayList<Ad> adList = new ArrayList<>();
		
		int systemAdsCounter = this.systemAds.size();
		int adsTier1Counter = this.adsTier1;
		int adsTier2Counter = this.adsTier2;
		
		int i = 0;
		while(i < systemAdsCounter) {
			int randNum = new Random().nextInt(systemAdsCounter);
			
			Ad adToAdd = this.systemAds.get(randNum);
			if(adsTier2Counter>0) {
				if(adToAdd.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL2) && !adList.contains(adToAdd)) {
					adList.add(adToAdd);
					i++;
					adsTier2Counter--;
				}
			}
			else if(adsTier1Counter>0) {
				if(adToAdd.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL1) && !adList.contains(adToAdd)) {
					adList.add(adToAdd);
					i++;
					adsTier1Counter--;
				}
			}
			else {
				if(!adList.contains(this.systemAds.get(randNum))) {
					adList.add(this.systemAds.get(randNum));
					i++;
				}
			}
			
		}
		
		return adList;
	}
	
	//Adding an Ad into the database
	public void addAd(Ad ad) {
		if(!this.systemAds.contains(ad))
			this.systemAds.add(ad);
	}
	
	//Removing an ad from the database
	public void removingAd(Ad ad) {
		for(Ad currAd : this.systemAds) {
			if(currAd.equals(ad))
				this.systemAds.remove(currAd);
		}
	}
	
	//Adding User into the database
	public void addUser(Registered user) {
		if(!this.systemUsers.contains(user))
			this.systemUsers.add(user);
	}
	
	//Removing a user from the database
	public void removingUser(Registered user) {
		for(Registered currUser : this.systemUsers) {
			if(currUser.equals(user))
				this.systemAds.remove(currUser);
		}
	}

	public ArrayList<Registered> getSystemUsers() {
		return systemUsers;
	}

	public ArrayList<Ad> getSystemAds() {
		return systemAds;
	}

	public ArrayList<String> getSystemPreferences() {
		return systemPreferences;
	}

}
