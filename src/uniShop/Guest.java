package uniShop;

import java.util.ArrayList;
import java.util.Collections;

import GUI.HomeScreen_Guest;

public class Guest extends User{

	public Guest(LocalDataBase db) {
		super(9999, "Guest", null, db);
		
	}	
	
	public ArrayList<Ad> filter(ArrayList<String> tags){
		
		boolean find = false;
		
		
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		
		outsideloop:
		for(Ad ad: db.getSystemAds()) {
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
			Collections.sort(this.db.getSystemAds());
		}
		return this.db.getSystemAds();
		
	}
	public ArrayList<Ad> search(String text){
		
		boolean find = false;
		
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		for(Ad ad: this.db.getSystemAds()) {
			
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
	
	public void viewAds(ArrayList<Ad> ads) {
		
		
		for(Ad ad: ads)
			System.out.println(ad.getName());
		
		//HomeScreen_Guest g = new HomeScreen_Guest(ads);
		
	}

	@Override
	public void callHomePage() {
		new HomeScreen_Guest(db);
	}
	
	

}
