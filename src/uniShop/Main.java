package uniShop;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = 0;
		String username = null;
		String email = null;
		
		User u1 = new Guest(id,username,email);
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ArrayList<Ad> ads_2 = new ArrayList<Ad>();
		
		
		Guest g1 = new Guest(id,username,email);
		ads_2=g1.SearchAds();
		g1.viewAds(ads_2);
		ads = g1.filter();
		g1.viewAds(ads);
	}

}
