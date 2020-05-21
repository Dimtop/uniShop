package uniShop;

public class Message {
	
	private String text;
	private Registered sender;
	private Registered receiver;
	private Ad product ;
	
	public String getText() 
	{
		return text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}
	public Registered getSender() 
	{
		return sender;
	}
	public void setSender(Registered sender) 
	{
		this.sender = sender;
	}
	public Registered getReceiver() 
	{
		return receiver;
	}
	public void setReceiver(Registered receiver) 
	{
		this.receiver = receiver;
	}
	public Ad getProduct() 
	{
		return product;
	}
	public void setProduct(Ad product) 
	{
		this.product = product;
	}

	
	
}
