package uniShop;

public class Registered extends User {
	
	int status=1; //1 ��� �����������

	public Registered(int userId, String username, String email) {
		super(userId, username, email);
		
	}
	
	
	public void logout()
	{
		status = 0; //0 ��� ��������������
	};
	
	public void veiwProfile() {};

}
