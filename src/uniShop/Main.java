package uniShop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = 0;
		String username = null;
		String email = null;
		
		User u1 = new Guest(id,username,email);
		
		
		Guest g1 = new Guest(id,username,email);
		g1.filter();
	}

}
