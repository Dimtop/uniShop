package GUI;
import java.util.ArrayList;

public class InfoOfNewAd {
	
	private String ProductName,Description;
	private  ArrayList<String>Paths=new ArrayList<>();
	private ArrayList<String>Tags=new ArrayList<>();
	private boolean promo;
	
	public InfoOfNewAd(String productName,String Descrition,ArrayList<String>Paths,ArrayList<String>Tags,boolean promo) {
		this.ProductName=productName;
		this.Description=Descrition;
		this.Paths.addAll(Paths);
		this.Tags.addAll(Tags);
		this.promo=promo;
		printinfo();
	}
	
	private void printinfo() {
		System.out.println(this.ProductName+"\n"+ this.Description+"\n"+this.Paths+"\n"+this.Tags+"\n"+this.promo);
	}
}
