package uniShop;
import java.util.ArrayList;
import java.util.Date;

public class Ad {

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
	
	public int getAd_id() 
	{
		return ad_id;
	}
	public void setAd_id(int ad_id) 
	{
		this.ad_id = ad_id;
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
	public void setSeller(Registered seller) 
	{
		this.seller = seller;
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
	public ListingState changeStatus(ListingState status)
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
	
}
