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
	
	private JPanel firstUpgrade;
	private JLabel firstUpgradeTitle;
	private JLabel firstUpgradeDesc;
	private JButton firstUpgradeButton;
	
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
		active1 = new ActiveUpgrades();
		active1.setName("Upgrade 1");
		active1.setDesc("Temp description");
		active1.setCost(10);
		active1.setMult(1.5);
		
		active2 = new ActiveUpgrades();
		active2.setName("Upgrade 2");
		active2.setDesc("Temp description");
		active2.setCost(20);
		active2.setMult(2.0);
		
		active3 = new ActiveUpgrades();
		active3.setName("Upgrade 3");
		active3.setDesc("Temp description");
		active3.setCost(30);
		active3.setMult(3.0);
		
		active4 = new ActiveUpgrades();
		active4.setName("Upgrade 4");
		active4.setDesc("Temp description");
		active4.setCost(40);
		active4.setMult(4.0);
		
		active5 = new ActiveUpgrades();
		active5.setName("Upgrade 5");
		active5.setDesc("Temp description");
		active5.setCost(50);
		active5.setMult(5.0);
		
		passive1 = new PassiveUpgrades();
		passive1.setCost(15);
		passive1.setDesc("You used your knowledge in computer programming to set up a shoddy auto clicker.");
		passive1.setName("Auto-Clicker");
		passive1.setCPS(1);
		
		passive2 = new PassiveUpgrades();
		passive2.setCost(25);
		passive2.setDesc("You properly understand coding syntax and create a second program to optimize");
		passive2.setName("Optimizer");
		passive2.setCPS(2);
		
		passive3 = new PassiveUpgrades();
		passive3.setCost(35);
		passive3.setDesc("You decide this game sucks and cheat by modifying game files to run multiple instances");
		passive3.setName("Clone");
		passive3.setCPS(3);
		
		passive4 = new PassiveUpgrades();
		passive4.setCost(45);
		passive4.setDesc("You cheat by hiring a bunch of monkeys to click for you");
		passive4.setName("Monkeys");
		passive4.setCPS(4);
		
		passive5 = new PassiveUpgrades();
		passive5.setCost(55);
		passive5.setDesc("Harambe, our lord and savior, felt insulted that you went after his kin, therefore he took over the whole operation.");
		passive5.setName("Good ol' Harambe");
		passive5.setCPS(5);
		
	}
	
	public void createUpgradesPanel() {
		//in which we draw the ui for purchasing upgrades
		firstUpgradeTitle = new JLabel(active1.upgradeName);
		firstUpgradeDesc = new JLabel(active1.upgradeDescription);
		firstUpgrade = new JPanel();
		firstUpgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				}
			});
		
	}

}
