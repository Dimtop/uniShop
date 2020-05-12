package uniShop;

import java.util.ArrayList;
import java.util.Collections;


public class Guest extends User{

	public Guest(int userId, String username, String email) {
		super(9999, "Guest", null);
		
	}
	
	
	public static ArrayList<Ad> filter(){
		
		boolean find = false;
		
		
		ArrayList<String> preferences1 = new ArrayList<String>();
		preferences1.add("sport");
		preferences1.add("art");
		preferences1.add("lessons");
		preferences1.add("cook");
		preferences1.add("english");
		
		ArrayList<String> preferences2 = new ArrayList<String>();
		preferences2.add("lessons");
		preferences2.add("english");
		
		ArrayList<String> preferences3 = new ArrayList<String>();
		preferences3.add("sport");
		
		ArrayList<String> preferences4 = new ArrayList<String>();
		preferences4.add("art");
		preferences4.add("lessons");
		
		ArrayList<String> preferences5 = new ArrayList<String>();
		preferences5.add("cook");
		
		ArrayList<Ad> Ads = new ArrayList<Ad>(); // get Ads from database
		Ad a1 = new Ad(1,"shoes sport",preferences3);
		Ad a2 = new Ad(2,"english lessons",preferences2);
		Ad a3 = new Ad(3,"art lessons",preferences4);
		Ad a4 = new Ad(4,"cooking",preferences5);
		a2.setPromotion(ListingPromotionType.PROMOTION_LEVEL2);
		a4.setPromotion(ListingPromotionType.PROMOTION_LEVEL1);
		a3.setPromotion(ListingPromotionType.NOT_PROMOTED);
		a1.setPromotion(ListingPromotionType.NOT_PROMOTED);
		Ads.add(a1);
		Ads.add(a2);
		Ads.add(a3);
		Ads.add(a4);
		
		User u = new User(99,"stampou","stampou@gmail.com");
		u.setPreferences(preferences1); // get preferences from database
		
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		
		outsideloop:
		for(Ad ad: Ads) {
			for(String preference: ad.getTags()) {
				if(u.getPreferences().contains(preference)) {
					find = true;
					foundAds.add(ad);
					continue outsideloop;
				}
			}	
		}
		
		if(find == true) {
			Collections.sort(foundAds);
			for(Ad ad: foundAds)
				System.out.println(ad.getName());
			return foundAds;
		}
		
		if(find == false) {
			Collections.sort(Ads);
			for(Ad ad: Ads) {
				System.out.println(ad.getName());
			}
		}
		return Ads;
		
	}
	
	

}
