package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Player_v2 extends JFrame implements Serializable {
	
	private double clickCounter;
	private double clickLifetime;
	private double clickMultiplier;
	private int upgradePurchased;
	
	public Player_v2() {
		this.clickCounter = 0;
		this.clickLifetime = 0;
		this.clickMultiplier = 1;
		this.upgradePurchased = 0;
	}
	
	public void click() {
		clickCounter = clickCounter + clickMultiplier;
		clickLifetime = clickLifetime + clickMultiplier;
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
	
	public void setMultiplier(double num) {
		if (num >= this.clickMultiplier) {
			this.clickMultiplier = num;
		}
	}

	public void incrementUpgrade() {
		this.upgradePurchased++;
	}

	public String getStatistics() {
		String temp = new String();
		
		temp = "Current Clicks: " + this.clickCounter + "\n"
				+ "Lifetime Clicks: " + this.clickLifetime + "\n"
				+ "Click Multiplier: " + this.clickMultiplier + "\n"
				+ "Upgrades purchased: " + this.upgradePurchased + "\n";
		
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
