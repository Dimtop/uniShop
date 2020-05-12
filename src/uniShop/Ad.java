package uniShop;

import java.util.ArrayList;

public class Ad implements Comparable {
	
	private int adId;
	private String name;
	private ArrayList<String> tags;
	private ListingPromotionType promotion ;
	
	public ListingPromotionType getPromotion() {
		return promotion;
	}

	public void setPromotion(ListingPromotionType promotion) {
		this.promotion = promotion;
	}

	public Ad(int adId, String name, ArrayList<String> tags) {
		this.adId = adId;
		this.name = name;
		this.tags = tags;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public int compareTo(Object o) {  //compare based on promotion
		if(o instanceof Ad) {
			Ad a = (Ad) o;
			return a.promotion.ordinal()- this.promotion.ordinal();
		}
			
		return -1;
	}

	

	
	
	

}
