package uniShop;

import java.util.*; 

public class Registered extends User {
	
	protected int status=1; //κατασταση χρήστη, συνδεδεμένος/μη συνδεδεμένος
	protected ArrayList<Ad> myAds;
	protected ArrayList<Message> myMessages;
	protected ArrayList<Ad> wishlist;
	
	
	
	public Registered(int userId, String username, String email)
	{
		super(userId, username, email);	
		this.myAds = new ArrayList<>();
		this.myMessages = new ArrayList<>();
		this.wishlist = new ArrayList<>();
		
	}
	
	
	public void logout()//Guest HP GUI 
	{
		status = 0; //0 για αποσυνδεδεμένο
		new Guest(userId, username, email); 
	}
	
	public void viewProfile()//Profile GUI 
	{
		
	}
		
		
	/*public void createAd()//CreateAd GUI and insert in database
	{	 
		ArrayList<String> tags = 
				new ArrayList<>(Arrays.asList("phone", "samsung", "galaxy"));
		Ad anAd = new Ad(555, "samsung galaxy", tags);
		myAds.add(anAd);
	}*/
	
	
	public void deleteAd(Ad aAd)//??? GUI and delete in database
	{
		myAds.remove(aAd);
	}
	
	
	public void readAd(Ad aAd)//ProductView GUI
	{
		//dokimi
	}
	
	
	public void updateAd(Ad aAd)//Profile GUI myAds button and update in database
	{
		
	}
	
	public ArrayList<Message> viewMessages()//MyMessages GUI
	{
		return myMessages;
	}//from void to ArrayList<Message>
	
	
	/*public void replyMessages(Message aMessage)//MyMessages GUI and insert in database
	{
		Message reply = new Message();
		//υλοποιείται απάντηση στα γραφικα
		myMessages.add(reply);
	}*/
	
	public void deleteMessages(Message aMessage)//MyMessages GUI and delete in database
	{
		myMessages.remove(aMessage);
	}
	
	public void reviewBuyer(Registered aUser)//MyMessages GUI?? review for buyer in database??
	{
		
	}
	
	public void upgradePremiumPlan()//Registered HP GUI and change at database
	{
		//change this.premium
		//Create Premium object and create Premium HP GUI
		if(this.premium == 0) {
			new Premium(this.userId, this.username, this.email,1,this.preferences,0);
			//Premium_Gui
		}
		else if(this.premium==1) {
			//updatePremiumPlan();
		}
			
			
	}
	
	public ArrayList<Ad> searchProducts()//Registered HP GUI and database search
	{
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
		
		
		ArrayList<Ad> Ads = new ArrayList<Ad>(); // get Ads from database
		Ad a1 = new Ad(1,"shoes sport",null,null,null,null,null,preferences3,null,ListingPromotionType.NOT_PROMOTED);
		Ad a2 = new Ad(2,"english lessons",null,null,null,null,null,preferences2,null,ListingPromotionType.PROMOTION_LEVEL2);
		Ad a3 = new Ad(3,"art lessons",null,null,null,null,null,preferences4,null,ListingPromotionType.NOT_PROMOTED);
		Ad a4 = new Ad(4,"cooking",null,null,null,null,null,preferences5,null,ListingPromotionType.PROMOTION_LEVEL1);
		//a2.setPromotionType(ListingPromotionType.PROMOTION_LEVEL2);
		//a4.setPromotionType(ListingPromotionType.PROMOTION_LEVEL1);
		//a3.setPromotionType(ListingPromotionType.NOT_PROMOTED);
		//a1.setPromotionType(ListingPromotionType.NOT_PROMOTED);
		Ads.add(a1);
		Ads.add(a2);
		Ads.add(a3);
		Ads.add(a4);
	
		System.out.print("Search:");
		Search=in.nextLine();
		
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
		for(Ad ad: Ads) {
			if(ad.getName().contains(Search)) {
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
	
	public ArrayList<Ad> filterRegistered()//Registered HP GUI and database search 
	{
		boolean found = false;
		
		
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
		Ad a1 = new Ad(1,"shoes sport",null,null,null,null,null,preferences3,null,ListingPromotionType.NOT_PROMOTED);
		Ad a2 = new Ad(2,"english lessons",null,null,null,null,null,preferences2,null,ListingPromotionType.PROMOTION_LEVEL2);
		Ad a3 = new Ad(3,"art lessons",null,null,null,null,null,preferences4,null,ListingPromotionType.NOT_PROMOTED);
		Ad a4 = new Ad(4,"cooking",null,null,null,null,null,preferences5,null,ListingPromotionType.PROMOTION_LEVEL1);
		//a2.setPromotionType(ListingPromotionType.PROMOTION_LEVEL2);
		//a4.setPromotionType(ListingPromotionType.PROMOTION_LEVEL1);
		//a3.setPromotionType(ListingPromotionType.NOT_PROMOTED);
		//a1.setPromotionType(ListingPromotionType.NOT_PROMOTED);
		Ads.add(a1);
		Ads.add(a2);
		Ads.add(a3);
		Ads.add(a4);
			
		Registered user = new Registered(99,"stampou","stampou@gmail.com");
		user.setPreferences(preferences1); // get preferences from database
		/* anti gia user prepei na pairnei apo ta grafika tis epiloges tou registered
		* kai na sygkrinei aytes tis epiloges me to ArrayList apo ads ths kathe diafhmishs
		* de kserw ti paizei me grafika gia ayto exw kanei enan user wste na blepw oti douleuei  
		 */
			
			
		ArrayList<Ad> foundAds = new ArrayList<Ad>();
			
		outsideloop:
		for(Ad ad: Ads) {
			for(String preference: ad.getTags()) {
				if(user.getPreferences().contains(preference)) {
					found = true;
					foundAds.add(ad);
					continue outsideloop;
				}
			}	
		}
			
		if(found == true) {
			Collections.sort(foundAds);
			return foundAds;
		}
			
		if(found == false)
			Collections.sort(Ads);
		
		return Ads;
			
	}	
	
	public void viewProducts(ArrayList<Ad> ads)//Product view GUI and search database
	{
		for(Ad ad: ads)
			System.out.println(ad.getName());
		
		//HomeScreenRegistered g = new HomeScreenRegistered(ads); ???
	}
	
	public void viewOtherProfiles(Registered aUser)//ViewOtherProfiles GUI and search database
	{
		
	}
	
	public void sendMessages(Registered aUser)//Registered HP GUI and insert in database
	{
		
	}
	
	public void reviewSeller(Registered aUser)//ViewOtherProfiles GUI and review in database??
	{
		
	}
	
	public void addToWishlist(Ad aProduct)//Registered HP GUI and insert to database
	{
		this.wishlist.add(aProduct);
	}
	
	public void viewWishlist()//Registered HP GUI wishList button
	{
		
	}
	
	public void removeFromWishlist(Ad aProduct)//Registered HP GUI and delete from database
	{
		this.wishlist.remove(aProduct);
	}
	
	public void addPreferences(String aPreference)//Profile GUI and insert in the database
	{
		this.preferences.add(aPreference);
	}
	
	public void removePreferences(String aPreference)//Profile GUI and delete from the database
	{
		this.preferences.remove(aPreference);
	}
	
	public void updateProfile()//Profile GUI and change in the database
	{
		
	}
	
	public void deleteProfile()//Profile GUI and delete in the database
	{
		
	}
	
	public void viewAdsHistory()//Profile GUI and search in database
	{
		
	}
	
	public void matchPreferences()//Search in database
	{
		
	}
	
	public ArrayList<Message> getMessages(){
		return this.myMessages;
	}
	
	public ArrayList<Ad> getMyAds(){
		return this.myAds;
	}
	
	//ads a message to myMessages list
	public void addMessage(Message msg) {
		this.myMessages.add(msg);
	}
	
	public void addAd(Ad ad) {
		this.myAds.add(ad);
	}
		
}
