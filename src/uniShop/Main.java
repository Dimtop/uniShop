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
		ArrayList<Ad> ads2 = new ArrayList<Ad>();
		

		Guest g1 = new Guest(id,username,email);
		Registered r1 = new Registered(id,username,email);
		
		ads2 = r1.filterRegistered();
		ads = g1.filter();		
		g1.viewAds(ads);
		g1.viewAds(ads2);
	}

}
