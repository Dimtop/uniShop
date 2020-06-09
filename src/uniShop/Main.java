package uniShop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		
	//Achilleas TESTING
		//Creating Tags
		ArrayList<String> tags = new ArrayList<>(); //needs db for the last version
		tags.add("Cars");
		tags.add("Tech");
		tags.add("House");
		tags.add("Clothes");
		tags.add("Example 1");
		tags.add("Example 2");
		tags.add("Example 3");
		//Creating Users
		Registered currUser = new Registered(10, "Current User", "currUser@gmail.com");
		Registered user1 = new Registered(0, "User1", "user1@gmail.com");
		Registered user2 = new Registered(1, "User2", "user2@gmail.com");
		//Getting current date
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date currDate = new Date(System.currentTimeMillis());
		//Creating Ads
		ArrayList<Ad> ads = new ArrayList<>(); //from the db on the last version
		Ad ad1 = new Ad(0,"Product1","Description","https://cdn.wccftech.com/wp-content/uploads/2018/10/Intel-X-Series-1-Custom-2060x1375.jpg",
				currDate,user1,user2,tags,ListingState.ACTIVE, ListingPromotionType.NOT_PROMOTED);
		Ad ad2 = new Ad(1,"Product2","Description","https://cdn.wccftech.com/wp-content/uploads/2018/10/Intel-X-Series-1-Custom-2060x1375.jpg",
				currDate,user2,user1,tags,ListingState.ACTIVE, ListingPromotionType.PROMOTION_LEVEL1);
		Ad ad3 = new Ad(2,"Product3","Description","https://cdn.wccftech.com/wp-content/uploads/2018/10/Intel-X-Series-1-Custom-2060x1375.jpg",
				currDate,currUser,user2,tags,ListingState.ACTIVE, ListingPromotionType.PROMOTION_LEVEL2);
		ads.add(ad1);
		ads.add(ad2);
		ads.add(ad3);
		
		//currUser Properties
		ArrayList<String> currPref = new ArrayList<>();
		currPref.add("Cars");
		currPref.add("Clothes");
		currUser.addMessage(new Message("Something", user1, currUser, ad1));
		currUser.setPreferences(currPref);
		currUser.addAd(ad3);
		currUser.addToWishlist(ad2);
		
		//new HomeScreen_Registered(tags,ads,currUser);
		new HomeScreen_Guest(tags,ads);
 
	}

}
