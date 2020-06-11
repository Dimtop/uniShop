package uniShop;

import java.util.ArrayList;
import java.util.Collections;




public class Guest extends User{

	public Guest() {
		super(9999, "Guest", null);
		
	}	
	
	public ArrayList<Ad> filter(ArrayList<String> tags){
		
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
		Ad a1 = new Ad(1,"shoes sport",null,null,null,null,null,preferences3,null);
		Ad a2 = new Ad(2,"english lessons",null,null,null,null,null,preferences2,null);
		Ad a3 = new Ad(3,"art lessons",null,null,null,null,null,preferences4,null);
		Ad a4 = new Ad(4,"cooking",null,null,null,null,null,preferences5,null);
		
		Ads.add(a1);
		Ads.add(a2);
		Ads.add(a3);
		Ads.add(a4);
		
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		
		outsideloop:
		for(Ad ad: Ads) {
			for(String preference: ad.getTags()) {
				if(tags.contains(preference)) {
					find = true;
					foundAds.add(ad);
					continue outsideloop;
				}
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
	public ArrayList<Ad> search(String text){
		
		boolean find = false;
		
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
		
		ArrayList<Ad> Ads = new ArrayList<Ad>(); // get Ads from database
		Ad a1 = new Ad(1,"shoes sport",null,null,null,null,null,preferences3,null);
		Ad a2 = new Ad(2,"english lessons",null,null,null,null,null,preferences2,null);
		Ad a3 = new Ad(3,"art lessons",null,null,null,null,null,preferences4,null);
		Ad a4 = new Ad(4,"cooking",null,null,null,null,null,preferences5,null);
	
		Ads.add(a1);
		Ads.add(a2);
		Ads.add(a3);
		Ads.add(a4);
	
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		for(Ad ad: Ads) {
			
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
			Collections.sort(Ads);
		}
		return Ads;
	}
	
	public void viewAds(ArrayList<Ad> ads) {
		
		
		for(Ad ad: ads)
			System.out.println(ad.getName());
		
		//HomeScreen_Guest g = new HomeScreen_Guest(ads);
		
	}
	
	

}
