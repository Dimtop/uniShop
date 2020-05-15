package uniShop;

import java.util.ArrayList;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		//GUI TESTING (Achilleas)
		ArrayList<String> tags = new ArrayList<>();
		tags.add("1");
		tags.add("2");
		tags.add("3");
		tags.add("4");
		tags.add("5");
		tags.add("6");
		tags.add("7");
		tags.add("8");
		tags.add("9");
		tags.add("10");
		tags.add("11");
		tags.add("12");
		tags.add("13");
		tags.add("14");
		tags.add("15");
		tags.add("16");
		tags.add("17");
		tags.add("18");
		tags.add("19");
		//new HomeScreen_Guest(tags,tags);
		new HomeScreen_Registered(tags,tags);
		//new HomeScreen_Premium(tags,tags);

	}

}
