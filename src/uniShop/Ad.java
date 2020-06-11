package uniShop;
import java.util.ArrayList;
import java.util.Date;

public class Ad implements Comparable{

	private int ad_id;
	private String name;
	private String description;
	private String photoLink;
	private Date date;
	private Registered seller;
	private Registered buyer;
	private ArrayList<String> tags;
	private ListingState status; //Ad status
	private ListingPromotionType promotionType;//Type of promoted ad
	
	public Ad(int id, String name, String description, String link, Date date, Registered seller, 
			Registered buyer, ArrayList<String> tags, ListingState status)
	{
		tags = new ArrayList<>();
		
		this.ad_id = id;
		this.name = name;
		this.description = description;
		this.photoLink = link;
		this.date = date;
		this.seller = seller;
		this.buyer = buyer;
		this.tags = tags;
		this.status = status;
		
		//Setting up promotion type
		if(this.seller.getTier() == 0)
			this.promotionType = ListingPromotionType.NOT_PROMOTED;
		else if(this.seller.getTier() == 1)
			this.promotionType = ListingPromotionType.PROMOTION_LEVEL1;
		else
			this.promotionType = ListingPromotionType.PROMOTION_LEVEL2;
		
		//Adding the add into the seller ads
		this.seller.addAd(this);
	}
	
	public int getAd_id() 
	{
		return ad_id;
	}
	
	public void setAd_id(int id)
	{
		this.ad_id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getPhotoLink() 
	{
		return photoLink;
	}
	public void setPhotoLink(String photoLink)
	{
		this.photoLink = photoLink;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public Registered getSeller() 
	{
		return seller;
	}
	
	public Registered getBuyer() 
	{
		return buyer;
	}
	public void setBuyer(Registered buyer)
	{
		this.buyer = buyer;
	}
	public ArrayList<String> getTags() 
	{
		return tags;
	}
	public void setTags(ArrayList<String> tags) 
	{
		this.tags = tags;
	}
	public ListingState getStatus() 
	{
		return status;
	}
	public void changeStatus(ListingState status)
	{
		this.status = status;
	}
	public ListingPromotionType getPromotionType() 
	{
		return promotionType;
	}
	public void setPromotionType(ListingPromotionType promotionType) 
	{
		this.promotionType = promotionType;
	}
	
	public void addTag(String aTag)
	{
		tags.add(aTag);
	}
	
	public void removeTag(String aTag)
	{
		tags.remove(aTag);
	}
	
	public int compareTo(Object o) {  //compare based on promotion
		if(o instanceof Ad) {
			Ad a = (Ad) o;
			return a.promotionType.ordinal()- this.promotionType.ordinal();
		}
			
		return -1;
	}
	
	 @Override
	 public boolean equals(Object obj) {
		 Ad ad = (Ad)obj;
		 if(this.ad_id == ad.ad_id)
	    	 return true;
	     else
	    	 return false;
	 }
}
