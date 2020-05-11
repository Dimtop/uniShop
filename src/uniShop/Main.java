package uniShop;

import java.util.ArrayList;

import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		//Testing GUI (Achilleas)
		ArrayList<String> preferences = new ArrayList<>();
		preferences.add("Car");
		preferences.add("Smartphone");
		preferences.add("CPU");
		preferences.add("Music");
		preferences.add("Mouse");		
		
		HomeScreen hs = new HomeScreen_R(preferences);
		//HomeScreen hs1 = new HomeScreen_G(preferences);

	}

}
