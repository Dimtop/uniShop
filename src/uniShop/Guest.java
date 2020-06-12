package uniShop;

import java.util.ArrayList;
import java.util.Collections;

import GUI.HomeScreen_Guest;

public class Guest extends User{

	public Guest(LocalDataBase db) {
		super(9999, "Guest", null, db);
		
	}	
	
	public ArrayList<Ad> filter(ArrayList<String> tags,LocalDataBase db){
		
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
	public ArrayList<Ad> search(String text,LocalDataBase db){
		
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
	
	

	@Override
	public void callHomePage() {
		new HomeScreen_Guest(db);
	}
	
	

}
