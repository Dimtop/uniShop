package uniShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



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
		/* anti gia user prepei na pairnei apo ta grafika tis epiloges tou guest
		 * kai na sygkrinei aytes tis epiloges me to ArrayList apo ads ths kathe diafhmishs
		 * de kserw ti paizei me grafika gia ayto exw kanei enan user wste na blepw oti douleuei  
		 */
		
		
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
			/*for(Ad ad: foundAds)
				System.out.println(ad.getName());*/
			return foundAds;
		}
		
		if(find == false) {
			Collections.sort(Ads);
			/*for(Ad ad: Ads) {
				System.out.println(ad.getName());
			}*/
		}
		return Ads;
		
	}
public static ArrayList<Ad> SearchAds(){
		
		Scanner in = new Scanner(System.in);
		
		boolean find = false;
		String Search;
		
		ArrayList<String> preferences1 = new ArrayList<String>();
		preferences1.add("sport");
		preferences1.add("art");
		preferences1.add("lessons");
		
		ArrayList<String> preferences2 = new ArrayList<String>();
		preferences2.add("lessons");
		
		ArrayList<String> preferences3 = new ArrayList<String>();
		preferences3.add("sport");
		
		ArrayList<String> preferences4 = new ArrayList<String>();
		preferences4.add("art");
		
		ArrayList<String> preferences5 = new ArrayList<String>();
		preferences5.add("cook");
		
		ArrayList<Ad> Ads = new ArrayList<Ad>();
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
	
		System.out.print("Search:");
		Search=in.nextLine();
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		for(Ad ad: Ads) {
			
			if(ad.getName().equals(Search)) {
				foundAds.add(ad);
				find = true;
			}
				
		}
		if(find == true) {
			Collections.sort(foundAds);
			return foundAds;
		}
		if(find == false) {
			Collections.sort(Ads);
		}
		return Ads;
	}
	
	public static void viewAds(ArrayList<Ad> ads) {
		
		
		for(Ad ad: ads)
			System.out.println(ad.getName());
		
		//HomeScreen_Guest g = new HomeScreen_Guest(ads);
		
	}
	
	

}
