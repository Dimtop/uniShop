package uniShop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class LocalDataBase {

	private ArrayList<Registered> systemUsers;
	private ArrayList<Ad> systemAds;
	private ArrayList<String> systemPreferences;
	
	private int nextAdId;
	private int nextUserId;
	
	private int adsTier2;
	private int adsTier1;
	
	public LocalDataBase() {
		
		this.systemUsers = new ArrayList<>();
		this.systemAds = new ArrayList<>();
		this.nextAdId = 0;
		this.nextUserId = 0;
		this.systemPreferences = new ArrayList<>();
		this.adsTier1 = 0;
		this.adsTier2 = 0;
		
		setupSystemPreferences();
		setupSystemUsers();
		setupSystemAds();
	}
	
	//Creating some Users
	private void setupSystemUsers() {
		
		//Registered users
		Registered user1 = new Registered(nextUserId, "User 1", "user1@unishop.com");
		user1.setPreferences(getSomePreferences(1));
		user1.setPassword("user1");
		this.nextUserId++;
		Registered user2 = new Registered(nextUserId, "User 2", "user2@unishop.com");
		user2.setPreferences(getSomePreferences(2));
		user2.setPassword("user2");
		this.nextUserId++;
		Registered user3 = new Registered(nextUserId, "User 3", "user3@unishop.com");
		user3.setPreferences(getSomePreferences(3));
		user1.setPassword("user3");
		this.nextUserId++;
		Registered user4 = new Registered(nextUserId, "User 4", "user4@unishop.com");
		user4.setPreferences(getSomePreferences(4));
		user1.setPassword("user4");
		this.nextUserId++;
		Registered user5 = new Registered(nextUserId, "User 5", "user5@unishop.com");
		user5.setPreferences(getSomePreferences(5));
		user1.setPassword("user5");
		this.nextUserId++;
		
		//Premium users
		Registered user6 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(6), 1);
		user1.setPassword("user6");
		this.nextUserId++;
		Registered user7 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(7), 1);
		user1.setPassword("user7");
		this.nextUserId++;
		Registered user8 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(8), 1);
		user1.setPassword("user8");
		this.nextUserId++;
		Registered user9 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(9), 2);
		user1.setPassword("user9");
		this.nextUserId++;
		Registered user10 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(10), 2);
		user1.setPassword("user10");
		this.nextUserId++;
		Registered user11 = new Premium(nextUserId, "User 6", "user6@unishop.com", this.getSomePreferences(11), 2);
		user1.setPassword("user11");
		this.nextUserId++;
		
		//Adding Users on database
		this.systemUsers.add(user1);
		this.systemUsers.add(user2);
		this.systemUsers.add(user3);
		this.systemUsers.add(user4);
		this.systemUsers.add(user5);
		this.systemUsers.add(user6);
		this.systemUsers.add(user7);
		this.systemUsers.add(user8);
		this.systemUsers.add(user9);
		this.systemUsers.add(user10);
		this.systemUsers.add(user11);
		
	}
	
	//Creating some Ads
	private void setupSystemAds() {
		
		//Getting current date
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date currDate = new Date(System.currentTimeMillis());
		
		String descriptionText = "This is the Description for Product ";
		
		String ad1Link = "https://images-na.ssl-images-amazon.com/images/I/51EJdvzHJeL._AC_US160_.jpg";
		Ad ad1 = new Ad(nextAdId, "Product 1", descriptionText + "1", ad1Link, currDate, 
				this.systemUsers.get(1), this.systemUsers.get(2), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad2Link = "https://www.amazon.com/SAMSUNG-75-inch-Crystal-TU-8000-Built/dp/B084JBN6W9/ref=gbps_img_m-9_475e_6aa0e70d?smid=ATVPDKIKX0DER&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad2 = new Ad(nextAdId, "Product 2", descriptionText + "2", ad2Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(3), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad3Link = "https://www.amazon.com/Bedsure-Sherpa-Fleece-Blanket-Microfiber/dp/B0747BDTBD/ref=gbps_img_m-9_475e_50a2659a?smid=A3LDROY0BE4ISH&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad3 = new Ad(nextAdId, "Product 3", descriptionText + "3", ad3Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(4), this.getSomePreferences(1), ListingState.ON_HOLD);
		this.nextAdId++;
		String ad4Link = "https://www.amazon.com/s/browse/ref=gbps_img_m-9_475e_ce1a3533?ie=UTF8&node=12223424011&smid=ATVPDKIKX0DER&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad4 = new Ad(nextAdId, "Product 4", descriptionText + "4", ad4Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(7), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		String ad5Link = "https://www.amazon.com/gp/slredirect/picassoRedirect.html?qualifier=1591891420&id=8564832007589610&adId=A00227111MYAT5ZDTTYMR&widgetName=sp_gb_main_supple&url=https%3A%2F%2Fwww.amazon.com%2FPURA-DOR-Energizing-Revitalizer-Ingredients%2Fdp%2FB07J55YHGD%2Fref%3Dgbps_img_m-9_475e_7f87089f%3Fsmid%3DA2W9BJCKST9EWU%26pf_rd_p%3D5d86def2-ec10-4364-9008-8fbccf30475e%26pf_rd_s%3Dmerchandised-search-9%26pf_rd_t%3D101%26pf_rd_i%3D15529609011%26pf_rd_m%3DATVPDKIKX0DER%26pf_rd_r%3DNNH0B066VC80VVSDKKBC";
		Ad ad5 = new Ad(nextAdId, "Product 5", descriptionText + "5", ad5Link, currDate, 
				this.systemUsers.get(8), this.systemUsers.get(10), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad6Link = "https://www.amazon.com/UBeesize-Ringlight-YouTube-Photography-Compatible/dp/B07GDC39Y2/ref=gbps_img_m-9_475e_e388c56a?smid=A3JPZCPPKKCO75&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad6 = new Ad(nextAdId, "Product 6", descriptionText + "6", ad6Link, currDate, 
				this.systemUsers.get(10), this.systemUsers.get(1), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad7Link = "https://www.amazon.com/Bare-Home-Fitted-Bottom-Sheet/dp/B011W64E8O/ref=gbps_img_m-9_475e_e6e27391?smid=A3UBXJ2R9SZ9Z4&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad7 = new Ad(nextAdId, "Product 7", descriptionText + "7", ad7Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(7), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad8Link = "https://www.amazon.com/TENVIS-Wireless-Surveillance-Security-Auto-Cruise/dp/B071DDBT7M/ref=gbps_img_m-9_475e_f00cac82?smid=A18FTUOLO656PB&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad8 = new Ad(nextAdId, "Product 8", descriptionText + "8", ad8Link, currDate, 
				this.systemUsers.get(10), this.systemUsers.get(4), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad9Link = "https://www.amazon.com/deal/80c31c43/ref=gbps_img_m-9_475e_80c31c43?showVariations=true&smid=ATVPDKIKX0DER&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad9 = new Ad(nextAdId, "Product 9", descriptionText + "9", ad9Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(10), this.getSomePreferences(7), ListingState.ACTIVE);
		this.nextAdId++;
		String ad10Link = "https://www.amazon.com/PURA-DOR-Anti-Thinning-Moisturizing-Conditioner/dp/B07BHCB9Y2/ref=gbps_img_m-9_475e_170fee72?smid=A2W9BJCKST9EWU&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad10 = new Ad(nextAdId, "Product 10", descriptionText + "10", ad10Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(6), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		String ad11Link = "https://www.amazon.com/deal/8db4468d/ref=gbps_img_m-9_475e_8db4468d?smid=ATVPDKIKX0DER&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad11 = new Ad(nextAdId, "Product 11", descriptionText + "11", ad11Link, currDate, 
				this.systemUsers.get(7), this.systemUsers.get(3), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad12Link = "https://www.amazon.com/BEBONCOOL-Controller-DualShock-Playstation-PlayStation4/dp/B071WNWHZ7/ref=gbps_img_m-9_475e_398dc6b3?smid=ATD293HIUAW1A&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad12 = new Ad(nextAdId, "Product 12", descriptionText + "12", ad12Link, currDate, 
				this.systemUsers.get(1), this.systemUsers.get(10), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad13Link = "https://www.amazon.com/Miusey-Sleeveless-Classic-Versatile-Textured/dp/B079BNM8C1/ref=gbps_img_m-9_475e_3e8e6d3d?smid=A1YYI53EEY1YMY&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad13 = new Ad(nextAdId, "Product 13", descriptionText + "13", ad13Link, currDate, 
				this.systemUsers.get(2), this.systemUsers.get(4), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad14Link = "https://www.amazon.com/Cleansing-PIXNOR-Waterproof-Exfoliating-Blackhead/dp/B07SPJJ7D5/ref=gbps_img_m-9_475e_3695e444?smid=A1XQWCA8UWTYMI&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad14 = new Ad(nextAdId, "Product 14", descriptionText + "14", ad14Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(7), this.getSomePreferences(2), ListingState.ACTIVE);
		this.nextAdId++;
		String ad15Link = "https://www.amazon.com/Boyata-Multi-Angle-Heat-Vent-Adjustable-Compatible/dp/B07WRC9B86/ref=gbps_img_m-9_475e_d4dd6ffa?smid=ACDXJI6L8IN7K&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad15 = new Ad(nextAdId, "Product 15", descriptionText + "15", ad15Link, currDate, 
				this.systemUsers.get(9), this.systemUsers.get(4), this.getSomePreferences(5), ListingState.ACTIVE);
		this.nextAdId++;
		String ad16Link = "https://www.amazon.com/Upgraded-Wireless-Controller-KUTIME-Nintendo/dp/B081Q33VQT/ref=gbps_img_m-9_475e_53636850?smid=A2EW7E9HR4F2AI&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad16 = new Ad(nextAdId, "Product 16", descriptionText + "16", ad16Link, currDate, 
				this.systemUsers.get(5), this.systemUsers.get(3), this.getSomePreferences(4), ListingState.ACTIVE);
		this.nextAdId++;
		String ad17Link = "https://www.amazon.com/sponeed-Cycling-Compresson-Underwear-Coolmax/dp/B01LY3R2I6/ref=gbps_img_m-9_475e_af38cde4?smid=A2WLIKPPW4D7PD&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad17 = new Ad(nextAdId, "Product 17", descriptionText + "17", ad17Link, currDate, 
				this.systemUsers.get(8), this.systemUsers.get(9), this.getSomePreferences(3), ListingState.ACTIVE);
		this.nextAdId++;
		String ad18Link = "https://www.amazon.com/deal/7b0a60f2/ref=gbps_img_m-9_475e_7b0a60f2?&searchAlias=fashion&smid=ATVPDKIKX0DER&pf_rd_p=5d86def2-ec10-4364-9008-8fbccf30475e&pf_rd_s=merchandised-search-9&pf_rd_t=101&pf_rd_i=15529609011&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=NNH0B066VC80VVSDKKBC";
		Ad ad18 = new Ad(nextAdId, "Product 18", descriptionText + "18", ad18Link, currDate, 
				this.systemUsers.get(3), this.systemUsers.get(6), this.getSomePreferences(1), ListingState.ACTIVE);
		this.nextAdId++;
		
		this.systemAds.add(ad1);
		this.systemAds.add(ad2);
		this.systemAds.add(ad3);
		this.systemAds.add(ad4);
		this.systemAds.add(ad5);	
		this.systemAds.add(ad6);
		this.systemAds.add(ad7);
		this.systemAds.add(ad8);
		this.systemAds.add(ad9);
		this.systemAds.add(ad10);
		this.systemAds.add(ad11);
		this.systemAds.add(ad12);
		this.systemAds.add(ad13);
		this.systemAds.add(ad14);
		this.systemAds.add(ad15);
		this.systemAds.add(ad16);
		this.systemAds.add(ad17);
		this.systemAds.add(ad18);
		
		setupAdsTierX();
	}
	
	//Creating system Preferences
	private void setupSystemPreferences() {
		
		this.systemPreferences.add("Arts & Crafts");
		this.systemPreferences.add("Automotive");
		this.systemPreferences.add("Baby");
		this.systemPreferences.add("Beauty & Personal Care");
		this.systemPreferences.add("Books");
		this.systemPreferences.add("Computers");
		this.systemPreferences.add("Electronics");
		this.systemPreferences.add("Fashion");
		this.systemPreferences.add("Health & Household");
		this.systemPreferences.add("Home & Kitchen");
		this.systemPreferences.add("Luggage");
		this.systemPreferences.add("Movies & Television");
		this.systemPreferences.add("Software");
		this.systemPreferences.add("Tools & Home Improvement");
		this.systemPreferences.add("Video Games");
	}
	
	//Randomize Users Preferences
	private ArrayList<String> getSomePreferences(int prefSize){
		ArrayList<String> currList = new ArrayList<>();
		
		int i = 0;
		while(i < prefSize) {
			int randNum = new Random().nextInt(this.systemPreferences.size());
			
			if(!currList.contains(this.systemPreferences.get(randNum))) {
				currList.add(this.systemPreferences.get(i));
				i++;
			}
			
			currList.add(this.systemPreferences.get(i));
		}
		
		return currList;
	}
	
	private void setupAdsTierX() {
		for(Ad ad : this.systemAds) {
			if(ad.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL1))
				this.adsTier1++;
			else if(ad.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL2))
				this.adsTier2++;
		}
	}
	
	//Returns a random List of system's Ads
	public ArrayList<Ad> randomizeAds(){
		ArrayList<Ad> adList = new ArrayList<>();
		
		int systemAdsCounter = this.systemAds.size();
		int adsTier1Counter = this.adsTier1;
		int adsTier2Counter = this.adsTier2;
		
		int i = 0;
		while(i < systemAdsCounter) {
			int randNum = new Random().nextInt(systemAdsCounter);
			
			Ad adToAdd = this.systemAds.get(randNum);
			if(adsTier2Counter>0) {
				if(adToAdd.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL2) && !adList.contains(adToAdd)) {
					adList.add(adToAdd);
					i++;
					adsTier2Counter--;
				}
			}
			else if(adsTier1Counter>0) {
				if(adToAdd.getPromotionType().equals(ListingPromotionType.PROMOTION_LEVEL1) && !adList.contains(adToAdd)) {
					adList.add(adToAdd);
					i++;
					adsTier1Counter--;
				}
			}
			else {
				if(!adList.contains(this.systemAds.get(randNum))) {
					adList.add(this.systemAds.get(randNum));
					i++;
				}
			}
			
		}
		
		return adList;
	}
	
	//Adding an Ad into the database
	public void addAd(Ad ad) {
		if(!this.systemAds.contains(ad))
			this.systemAds.add(ad);
	}
	
	//Removing an ad from the database
	public void removingAd(Ad ad) {
		for(Ad currAd : this.systemAds) {
			if(currAd.equals(ad))
				this.systemAds.remove(currAd);
		}
	}
	
	//Adding User into the database
	public void addUser(Registered user) {
		if(!this.systemUsers.contains(user))
			this.systemUsers.add(user);
	}
	
	//Removing a user from the database
	public void removingUser(Registered user) {
		for(Registered currUser : this.systemUsers) {
			if(currUser.equals(user))
				this.systemAds.remove(currUser);
		}
	}
}
