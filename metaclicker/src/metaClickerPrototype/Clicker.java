package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Clicker extends JFrame {

	private double counter;

	public Clicker() {
		counter = 0;
	}

	public void click() {
		counter++;
	}

	public double getCounter() {
		return counter;
	}

//	public static void main(String[] args) {
//		ClickingWindow electionrigger = new ClickingWindow();
//	}

}
