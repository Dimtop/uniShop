package uniShop;

public class Premium extends Registered {

	private int tier;
	
	public Premium(int userId, String username, String email, int premium, ArrayList<String> preferences, int tier) 
	{
		super(userId, username, email);
		this.premium = premium;
		this.preferences = preferences;
		this.tier = tier;
		
	}
	
	public void  viewPremiumPlan()//Premium Plan GUI 
	{
		
	}
	
	public void updatePremiumPlan()//Premium Plan GUI update in database
	{
		this.tier++;
	}
	
	public void deletePremiumPlan()//Premium Plan GUI delete in database
	{
		this.premium = 0;
	}

}
