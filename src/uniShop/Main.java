package uniShop;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		LocalDataBase db = new LocalDataBase();
		
		new HomeScreen_Guest(db);
	}

}
