package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Player_v2 extends JFrame implements Serializable {
	
	private double clickCounter;
	private double clickLifetime;
	private double clickMultiplier;
	private double clickPerSecond;
	private int upgradePurchased;
	private ArrayList<Upgrade_v2> upgradesOwned;
	
	public Player_v2() {
		this.clickCounter = 0;
		this.clickLifetime = 0;
		this.clickMultiplier = 1;
		this.clickPerSecond = 0;
		this.upgradePurchased = 0;
		upgradesOwned = new ArrayList<Upgrade_v2>();
	}
	
	public void click() {
		clickCounter = clickCounter + clickMultiplier;
		clickLifetime = clickLifetime + clickMultiplier;
	}
	
	public void addClicks(double clicks) {
		clickCounter = clickCounter + clicks;
		clickLifetime = clickLifetime + clicks;
	}
	
	public double getCounter() {
		return this.clickCounter;
	}
	
	public double getLifetime() {
		return this.getLifetime();
	}
	
	public boolean removeClicks(double num) {
		if (this.clickCounter >= num) {
			this.clickCounter = this.clickCounter - num;
			return true;
		}
		else {
			return false;
		}
		
	}
	public double getMultiplier() {
		return clickMultiplier;
	}
	public void setMultiplier(double num) {
		if (num >= this.clickMultiplier) {
			this.clickMultiplier = num;
		}
	}

	public double getCPS() {
		return this.clickPerSecond;
	}
	
	public void setCPS(double num) {
		if (num >= this.clickPerSecond || num == -2000 || num == -1500) {
			this.clickPerSecond = num; //TODO:shouldn't this be adding? or are we making the change setting instead of adding.
		}
	}
	
	public void incrementUpgrade() {
		this.upgradePurchased++;
	}

	public String getStatistics() {
		String temp = new String();
		
		temp = "Current Clicks: " + this.clickCounter + "\n"
				+ "Lifetime Clicks: " + this.clickLifetime + "\n"
				+ "Upgrades purchased: " + this.upgradePurchased + "\n\n"
				+ "Click Multiplier: " + this.clickMultiplier + "\n"
				+ "Clicks Per Second: +" + this.clickPerSecond + "\n";
		
		return temp;
	}
	
	public static void saveGame(Player_v2 c){
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Clicker.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Player_v2 loadGame() {
		FileInputStream inFile = null;
		ObjectInputStream ois = null;
		Player_v2 c = null;
		try {
			inFile = new FileInputStream("Clicker.ser");
			ois = new ObjectInputStream(inFile);
			c = (Player_v2) ois.readObject();
			ois.close();
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException u) {
			u.printStackTrace();
		}
		return c;
	}
}
