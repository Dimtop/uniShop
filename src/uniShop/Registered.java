package uniShop;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.message.Message;

import java.util.*; 

public class Registered extends User {
	
	private int status=1; //��������� ������, ������������/�� ������������
	private ArrayList<Ad> myAds = new ArrayList<Ad>();
	private ArrayList<Message> myMessages;
	private ArrayList<Ad> wishlist;
	
	
	
	public Registered(int userId, String username, String email) {
		super(userId, username, email);	
	}
	
	
	public void logout()
	{
		status = 0; //0 ��� ��������������
		new Guest(userId, username, email); 
	}
	
	public void viewProfile() 
	{
		//�������
	}
		
		
	public void createAd()
	{	 
		ArrayList<String> tags = 
				new ArrayList<>(Arrays.asList("phone", "samsung", "galaxy"));
		Ad anAd = new Ad(555, "samsung galaxy", tags);
		myAds.add(anAd);
	}
	
	
	public void deleteAd(Ad aAd)
	{
		myAds.remove(aAd);
	}
	
	
	public void readAd(Ad aAd)
	{
		//���� ��� �� ������ �� ���������� ���������� ��� �������; ���� ��
	}
	
	
	public void updateAd(Ad aAd)
	{
		//����� �� ���� �������� �� ��������������� ���������� �� setters ��� ad?
	}
	
	public ArrayList<Message> viewMessages()
	{
		return myMessages;
	}//��� void ��� ����� ArrayList<Message>
	
	
	public void replyMessages(Message aMessage)
	{
		Message reply = new Message();
		//����������� �������� ��� �������
		myMessages.add(reply);
	}
	
	public void deleteMessages(Message aMessage)
	{
		myMessages.remove(aMessage);
	}
	
	
	

	
}
