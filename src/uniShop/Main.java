package uniShop;

import java.util.ArrayList;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		//GUI TESTING (Achilleas)
		ArrayList<String> tags = new ArrayList<>();
		tags.add("1");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		tags.add("2");
		//new HomeScreen_Guest(tags,tags);
		//new HomeScreen_Registered(tags,tags);
		new HomeScreen_Premium(tags,tags);

	}

}
