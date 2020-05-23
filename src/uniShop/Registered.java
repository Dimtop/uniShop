package uniShop;

import java.util.ArrayList;
import java.util.List;
import java.util.*; 

public class Registered extends User {
	
	int status=1; //κατασταση χρήστη, συνδεδεμένος/μη συνδεδεμένος
	
	
	//παρακάτω φτιάχνω μια τοπική βάση απο ads
	
	ArrayList<String> tags1 = 
			new ArrayList<>(Arrays.asList("iphone", "phone", "6s"));
	
	ArrayList<String> tags2 = 
			new ArrayList<>(Arrays.asList("hp", "laptop", "pc"));
	
	ArrayList<String> tags3 = 
			new ArrayList<>(Arrays.asList("chair", "new", "confortable"));
	
	
	
	Ad ad1 = new Ad(22, "iphone 6s", tags1);
	Ad ad2 = new Ad(13, "Laptop HP", tags2);
	Ad ad3 = new Ad(222, "new chair", tags3);
	
	ArrayList<Ad> aDataBase = new ArrayList<Ad>(Arrays.asList(ad1, ad2, ad3));

	//τέλος δημιουργίας βάσης
	
	
	
	public Registered(int userId, String username, String email) {
		super(userId, username, email);
		
	}
	
	
	public void logout()
	{
		status = 0; //0 για αποσυνδεδεμένο
		new Guest(userId, username, email); 
	};
	
	public void viewProfile() {};
	
	
		
		
	public void createAd()
	{	 
		ArrayList<String> tags = 
				new ArrayList<>(Arrays.asList("phone", "samsung", "galaxy"));
		Ad anAd = new Ad(555, "samsung galaxy", tags);
		aDataBase.add(anAd);
	};
	
	
	public void deleteAd(Ad anAd)
	{
		
		anAd = ad1; //θεωρώ οτι υπάρχει ηδη στην βάση 
		aDataBase.remove(anAd);
	};
	
	
	
	
}
