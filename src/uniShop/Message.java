package uniShop;

public class Message {
	
	private String text;
	private Registered sender;
	private Registered receiver;
	private Ad product ;
	
	public Message(String text ,Registered sender ,Registered receiver, Ad product )
	{
		this.text = text;
		this.sender = sender;
		this.receiver = receiver;
		this.product = product;
				
	}
	
	public String getText() 
	{
		return text;
	}
	
	public Registered getSender() 
	{
		return sender;
	}
	
	public Registered getReceiver() 
	{
		return receiver;
	}
	
	public Ad getProduct() 
	{
		return product;
	}
	
	
	
}
