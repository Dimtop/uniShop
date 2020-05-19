package uniShop;

public class Registered extends User {
	
	int status=1; //1 για συνδεδεμένο

	public Registered(int userId, String username, String email) {
		super(userId, username, email);
		
	}
	
	
	public void logout()
	{
		status = 0; //0 για αποσυνδεδεμένο
	};
	
	public void veiwProfile() {};

}
