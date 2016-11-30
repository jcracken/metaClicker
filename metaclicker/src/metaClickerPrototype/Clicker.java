package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Clicker extends JFrame {

	private double counter;
	private double countRate;
	private double lifetimeCounter;

	public Clicker() {
		counter = 0;
		lifetimeCounter = 0;
		countRate = 1;
	}

	public void click() {
		counter = counter + countRate;
		lifetimeCounter++;
	}

	public double getCounter() {
		return counter;
	}
	
	public void addClicks(double clicks) {
		counter = counter + clicks;
	}
	
	public void setClickRate(double cr) {
		countRate = cr;
	}
	
	public double getLifetimeCounter() {
		return this.lifetimeCounter;
	}
	
	public boolean removeClicks(int num) {
		if (counter >= num) {
			counter = counter - num;
			return true;
		}
		else
			return false;
	}

//	public static void main(String[] args) {
//		ClickingWindow electionrigger = new ClickingWindow();
//	}

}
