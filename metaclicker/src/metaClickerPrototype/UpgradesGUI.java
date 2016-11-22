package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpgradesGUI extends JFrame{
	
	private ActiveUpgrades active1;
	private ActiveUpgrades active2;
	private ActiveUpgrades active3;
	private ActiveUpgrades active4;
	private ActiveUpgrades active5;
	
	private PassiveUpgrades passive1;
	private PassiveUpgrades passive2;
	private PassiveUpgrades passive3;
	private PassiveUpgrades passive4;
	private PassiveUpgrades passive5;
	
	public UpgradesGUI() {
		super("Upgrades");
		
		setSize(800, 600);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setVisible(true);
		
		createUpgrades();
		
		createUpgradesPanel();
		
	}
	
	public void createUpgrades() {
		//in which we create all of the upgrades and initialize their values
	}
	
	public void createUpgradesPanel() {
		//in which we draw the ui for purchasing upgrades
	}

}
