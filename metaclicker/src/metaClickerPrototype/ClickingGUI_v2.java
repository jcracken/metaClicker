package metaClickerPrototype;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Objects;

public class ClickingGUI_v2 extends JFrame{
	
	JFrame topFrame;
	
	JPanel clickArea;
	JPanel statisticArea;
	JPanel upgradeArea;
	Player_v2 user;
	
	JScrollPane upgradeList;
	JPanel upgradePanel;
	JButton clickMe;
	JButton clickSave;
	JButton clickLoad;
	JTextArea statisticTextField;
	
	// Upgrades
	ActiveUpgrade_v2 active1;
	ActiveUpgrade_v2 active2;
	ActiveUpgrade_v2 active3;
	ActiveUpgrade_v2 active4;
	ActiveUpgrade_v2 active5;
	PassiveUpgrade_v2 passive1;
	PassiveUpgrade_v2 passive2;
	PassiveUpgrade_v2 passive3;
	PassiveUpgrade_v2 passive4;
	PassiveUpgrade_v2 passive5;
	
	// Upgrade panels
	JPanel active1Panel;
	JButton active1Button;
	JTextArea active1Desc;
	JPanel active2Panel;
	JButton active2Button;
	JTextArea active2Desc;
	JPanel active3Panel;
	JButton active3Button;
	JTextArea active3Desc;
	JPanel active4Panel;
	JButton active4Button;
	JTextArea active4Desc;
	JPanel active5Panel;
	JButton active5Button;
	JTextArea active5Desc;
	JPanel passive1Panel;
	JButton passive1Button;
	JTextArea passive1Desc;
	JPanel passive2Panel;
	JButton passive2Button;
	JTextArea passive2Desc;
	JPanel passive3Panel;
	JButton passive3Button;
	JTextArea passive3Desc;
	JPanel passive4Panel;
	JButton passive4Button;
	JTextArea passive4Desc;
	JPanel passive5Panel;
	JButton passive5Button;
	JTextArea passive5Desc;
	
	public ClickingGUI_v2() {
		//super("MetaClicker: The Clickening");
		topFrame = new JFrame("MetaClicker: The Clickening");
		//this.setSize(800,600);
		topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		topFrame.setLayout(new GridLayout(1,3));

		initializeUpgrades();
		buildGUI();
		topFrame.setVisible(true);
		
	}

	public void buildGUI() {
		
		// User
		user = new Player_v2();
		
		// Left pane, upgrades
		upgradePanel = new JPanel();
		upgradePanel.setLayout(new BoxLayout(upgradePanel, BoxLayout.Y_AXIS));
		this.createUpgradePanels();
		upgradeList = new JScrollPane(upgradePanel);
		upgradeList.setPreferredSize(new Dimension(225,100));
		upgradeArea = new JPanel(new BorderLayout());
		upgradeArea.add(new JLabel("Upgrades", SwingConstants.CENTER), BorderLayout.PAGE_START);
		upgradeArea.add(upgradeList);
		
		// Middle pane, click me
		clickMe = new JButton("Click me!");
		clickMe.addActionListener(new ButtonListener());
		clickSave = new JButton("Save");
		clickLoad = new JButton("Load");
		clickArea = new JPanel(new BorderLayout());
		clickArea.setPreferredSize(new Dimension(100,100));
		clickArea.add(new JLabel("Clicks", SwingConstants.CENTER), BorderLayout.PAGE_START);		
		clickArea.add(clickMe, BorderLayout.CENTER);
		JPanel tempPanel = new JPanel(new BorderLayout());
		tempPanel.add(clickSave, BorderLayout.WEST);
		tempPanel.add(clickLoad, BorderLayout.EAST);
		clickArea.add(tempPanel, BorderLayout.PAGE_END);
		
		// Right pane, stats
		statisticTextField = new JTextArea();
		statisticTextField.setEditable(false);
		//statisticTextField.setText(user.getStatistics());  //UNCOMMENT IF WANT INITIALIZED. LEAVE COMMENTED IF WANT ONLY AFTER FIRST CLICK
		statisticArea = new JPanel(new BorderLayout());
		statisticArea.add(new JLabel("Statistics", SwingConstants.CENTER), BorderLayout.PAGE_START);
		statisticArea.add(statisticTextField);
		
		topFrame.add(upgradeArea);
		topFrame.add(clickArea);
		topFrame.add(statisticArea);
		topFrame.pack();
	}
		
	private void createUpgradePanels() {
		
		this.active1Panel = new JPanel(new BorderLayout());
		this.active1Panel.add(new JLabel(active1.getName()), BorderLayout.WEST);
		this.active1Desc = new JTextArea(2,10);
		this.active1Desc.setEditable(false);
		this.active1Desc.setText(active1.getDesc());
		this.active1Desc.setLineWrap(true);
		this.active1Panel.add(active1Desc, BorderLayout.SOUTH);
		this.active1Button = new JButton(this.active1.getCost() + " Clicks");
		this.active1Button.addActionListener(new ButtonListener());
		this.active1Panel.add(active1Button, BorderLayout.EAST);
		this.active1Panel.setVisible(false);
		this.upgradePanel.add(this.active1Panel);
		
		this.active2Panel = new JPanel(new BorderLayout());
		this.active2Panel.add(new JLabel(active2.getName()), BorderLayout.WEST);
		this.active2Desc = new JTextArea(2,10);
		this.active2Desc.setEditable(false);
		this.active2Desc.setText(active2.getDesc());
		this.active2Desc.setLineWrap(true);
		this.active2Panel.add(active2Desc, BorderLayout.SOUTH);
		this.active2Button = new JButton(this.active2.getCost() + " Clicks");
		this.active2Button.addActionListener(new ButtonListener());
		this.active2Panel.add(active2Button, BorderLayout.EAST);
		this.active2Panel.setVisible(false);
		this.upgradePanel.add(this.active2Panel);
		
		this.active3Panel = new JPanel(new BorderLayout());
		this.active3Panel.add(new JLabel(active3.getName()), BorderLayout.WEST);
		this.active3Desc = new JTextArea(2,10);
		this.active3Desc.setEditable(false);
		this.active3Desc.setText(active3.getDesc());
		this.active3Desc.setLineWrap(true);
		this.active3Panel.add(active3Desc, BorderLayout.SOUTH);
		this.active3Button = new JButton(this.active3.getCost() + " Clicks");
		this.active3Button.addActionListener(new ButtonListener());
		this.active3Panel.add(active3Button, BorderLayout.EAST);
		this.active3Panel.setVisible(false);
		this.upgradePanel.add(this.active3Panel);
		
		this.active4Panel = new JPanel(new BorderLayout());
		this.active4Panel.add(new JLabel(active4.getName()), BorderLayout.WEST);
		this.active4Desc = new JTextArea(2,10);
		this.active4Desc.setEditable(false);
		this.active4Desc.setText(active4.getDesc());
		this.active4Desc.setLineWrap(true);
		this.active4Panel.add(active4Desc, BorderLayout.SOUTH);
		this.active4Button = new JButton(this.active4.getCost() + " Clicks");
		this.active4Button.addActionListener(new ButtonListener());
		this.active4Panel.add(active4Button, BorderLayout.EAST);
		this.active4Panel.setVisible(false);
		this.upgradePanel.add(this.active4Panel);
		
		this.active5Panel = new JPanel(new BorderLayout());
		this.active5Panel.add(new JLabel(active5.getName()), BorderLayout.WEST);
		this.active5Desc = new JTextArea(2,10);
		this.active5Desc.setEditable(false);
		this.active5Desc.setText(active5.getDesc());
		this.active5Desc.setLineWrap(true);
		this.active5Panel.add(active5Desc, BorderLayout.SOUTH);
		this.active5Button = new JButton(this.active5.getCost() + " Clicks");
		this.active5Button.addActionListener(new ButtonListener());
		this.active5Panel.add(active5Button, BorderLayout.EAST);
		this.active5Panel.setVisible(false);
		this.upgradePanel.add(this.active5Panel);
		
		this.passive1Panel = new JPanel(new BorderLayout());
		this.passive1Panel.add(new JLabel(passive1.getName()), BorderLayout.WEST);
		this.passive1Desc = new JTextArea(2,10);
		this.passive1Desc.setEditable(false);
		this.passive1Desc.setText(passive1.getDesc());
		this.passive1Desc.setLineWrap(true);
		this.passive1Panel.add(passive1Desc, BorderLayout.SOUTH);
		this.passive1Button = new JButton(this.passive1.getCost() + " Clicks");
		this.passive1Button.addActionListener(new ButtonListener());
		this.passive1Panel.add(passive1Button, BorderLayout.EAST);
		this.passive1Panel.setVisible(false);
		this.upgradePanel.add(this.passive1Panel);
		
		this.passive2Panel = new JPanel(new BorderLayout());
		this.passive2Panel.add(new JLabel(passive2.getName()), BorderLayout.WEST);
		this.passive2Desc = new JTextArea(2,10);
		this.passive2Desc.setEditable(false);
		this.passive2Desc.setText(passive2.getDesc());
		this.passive2Desc.setLineWrap(true);
		this.passive2Panel.add(passive2Desc, BorderLayout.SOUTH);
		this.passive2Button = new JButton(this.passive2.getCost() + " Clicks");
		this.passive2Button.addActionListener(new ButtonListener());
		this.passive2Panel.add(passive2Button, BorderLayout.EAST);
		this.passive2Panel.setVisible(false);
		this.upgradePanel.add(this.passive2Panel);
		
		this.passive3Panel = new JPanel(new BorderLayout());
		this.passive3Panel.add(new JLabel(passive3.getName()), BorderLayout.WEST);
		this.passive3Desc = new JTextArea(2,10);
		this.passive3Desc.setEditable(false);
		this.passive3Desc.setText(passive3.getDesc());
		this.passive3Desc.setLineWrap(true);
		this.passive3Panel.add(passive3Desc, BorderLayout.SOUTH);
		this.passive3Button = new JButton(this.passive3.getCost() + " Clicks");
		this.passive3Button.addActionListener(new ButtonListener());
		this.passive3Panel.add(passive3Button, BorderLayout.EAST);
		this.passive3Panel.setVisible(false);
		this.upgradePanel.add(this.passive3Panel);
		
		this.passive4Panel = new JPanel(new BorderLayout());
		this.passive4Panel.add(new JLabel(passive4.getName()), BorderLayout.WEST);
		this.passive4Desc = new JTextArea(2,10);
		this.passive4Desc.setEditable(false);
		this.passive4Desc.setText(passive4.getDesc());
		this.passive4Desc.setLineWrap(true);
		this.passive4Panel.add(passive4Desc, BorderLayout.SOUTH);
		this.passive4Button = new JButton(this.passive4.getCost() + " Clicks");
		this.passive4Button.addActionListener(new ButtonListener());
		this.passive4Panel.add(passive4Button, BorderLayout.EAST);
		this.passive4Panel.setVisible(false);
		this.upgradePanel.add(this.passive4Panel);
		
		this.passive5Panel = new JPanel(new BorderLayout());
		this.passive5Panel.add(new JLabel(passive5.getName()), BorderLayout.WEST);
		this.passive5Desc = new JTextArea(2,10);
		this.passive5Desc.setEditable(false);
		this.passive5Desc.setText(passive5.getDesc());
		this.passive5Desc.setLineWrap(true);
		this.passive5Panel.add(passive5Desc, BorderLayout.SOUTH);
		this.passive5Button = new JButton(this.passive5.getCost() + " Clicks");
		this.passive5Button.addActionListener(new ButtonListener());
		this.passive5Panel.add(passive5Button, BorderLayout.EAST);
		this.passive5Panel.setVisible(false);
		this.upgradePanel.add(this.passive5Panel);
	}
	
	private void initializeUpgrades() {
		
		active1 = new ActiveUpgrade_v2();
		active1.setName("Mouse Upgrade"); //first
		active1.setDesc("You bought a new mouse that clicks twice every time you click (Upgrades click rate to 2).");
		active1.setCost(10);
		active1.setMult(2);
		
		active2 = new ActiveUpgrade_v2();
		active2.setName("Run Cheat Engine"); //third
		active2.setDesc("Use Cheat Engine to speed up the game (Upgrades click rate to 5).");
		active2.setCost(50);
		active2.setMult(5);
		
		active3 = new ActiveUpgrade_v2();
		active3.setName("Faster Processor"); //fifth
		active3.setDesc("You bought a new CPU, congrats (Upgrades click rate to 20).");
		active3.setCost(250);
		active3.setMult(20);
		
		active4 = new ActiveUpgrade_v2();
		active4.setName("Trumpacolypse"); //seventh
		active4.setDesc("Trump gets elected president and the world is about to end, but at least you won a bet (Upgrades click rate to 50).");
		active4.setCost(750);
		active4.setMult(50);
		
		active5 = new ActiveUpgrade_v2();
		active5.setName("Utopia"); //nine
		active5.setDesc("You find a Xenomorph alien civilization with no war and everlasting peace (Upgrades click rate to 100).");
		active5.setCost(10000);
		active5.setMult(100);
		
		passive1 = new PassiveUpgrade_v2();
		passive1.setCost(20);
		passive1.setDesc("You used your knowledge in computer programming to set up a shoddy auto clicker (Increases passive clicks by one).");
		passive1.setName("Auto-Clicker"); //second
		passive1.setCPS(1);
		
		passive2 = new PassiveUpgrade_v2();
		passive2.setCost(100);
		passive2.setDesc("You properly understand coding syntax and create a second program to optimize. (Increases passive clicks by five).");
		passive2.setName("Execute Optimizer"); //fourth
		passive2.setCPS(5);
		
		passive3 = new PassiveUpgrade_v2();
		passive3.setCost(500);
		passive3.setDesc("You install an ActionKey script that clicks in the background for you (Increases passive clicks by ten).");
		passive3.setName("ActionKey Script"); //sixth
		passive3.setCPS(10);
		
		passive4 = new PassiveUpgrade_v2();
		passive4.setCost(10000); //eight
		passive4.setDesc("You go to space (Increases passive clicks by 20).");
		passive4.setName("Space Exploration");
		passive4.setCPS(20);
		
		passive5 = new PassiveUpgrade_v2();
		passive5.setCost(1000000);
		passive5.setDesc("Harambe for the assist! Gives you an edge on those alien bastards who shot up your ride (Increases passive clicks to -150).");
		passive5.setName("clicks out for Harambe"); //eleven
		passive5.setCPS(86);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(clickMe))
			{
				user.click();
			}
			else if (source.equals(clickSave))
			{
				Player_v2.saveGame(user);
			}
			else if (source.equals(clickLoad)) {
				user = Player_v2.loadGame();
			}
			else if (source.equals(active1Button)) {
				if (user.removeClicks(active1.getCost())) {
					user.setMultiplier(active1.getMult());
					user.incrementUpgrade();
					active1Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(active2Button)) {
				if (user.removeClicks(active2.getCost())) {
					user.setMultiplier(active2.getMult());
					user.incrementUpgrade();
					active2Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(active3Button)) {
				if (user.removeClicks(active3.getCost())) {
					user.setMultiplier(active3.getMult());
					user.incrementUpgrade();
					active3Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(active4Button)) {
				if (user.removeClicks(active4.getCost())) {
					user.setMultiplier(active4.getMult());
					user.incrementUpgrade();
					active4Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(active5Button)) {
				if (user.removeClicks(active5.getCost())) {
					user.setMultiplier(active5.getMult());
					user.incrementUpgrade();
					active5Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(passive1Button)) {
				if (user.removeClicks(passive1.getCost())) {
					user.setCPS(passive1.getCPS());
					user.incrementUpgrade();
					passive1Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(passive2Button)) {
				if (user.removeClicks(passive2.getCost())) {
					user.setCPS(passive2.getCPS());
					user.incrementUpgrade();
					passive2Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(passive3Button)) {
				if (user.removeClicks(passive3.getCost())) {
					user.setCPS(passive3.getCPS());
					user.incrementUpgrade();
					passive3Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(passive4Button)) {
				if (user.removeClicks(passive4.getCost())) {
					user.setCPS(passive4.getCPS());
					user.incrementUpgrade();
					passive4Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (source.equals(passive5Button)) {
				if (user.removeClicks(passive5.getCost())) {
					user.setCPS(passive5.getCPS());
					user.incrementUpgrade();
					passive5Button.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "You do not have enough clicks.", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			// Update stats on every action
			statisticTextField.setText(user.getStatistics());

			// On every action, see if cost is enough to make upgrade show up
			if (user.getCounter() >= active1.getCost()) {
				active1Panel.setVisible(true);
			}
			if (user.getCounter() >= active2.getCost()) {
				active2Panel.setVisible(true);
			}
			if (user.getCounter() >= active3.getCost()) {
				active3Panel.setVisible(true);
			}
			if (user.getCounter() >= active4.getCost()) {
				active4Panel.setVisible(true);
			}
			if (user.getCounter() >= active5.getCost()) {
				active5Panel.setVisible(true);
			}
			if (user.getCounter() >= passive1.getCost()) {
				passive1Panel.setVisible(true);
			}
			if (user.getCounter() >= passive2.getCost()) {
				passive2Panel.setVisible(true);
			}
			if (user.getCounter() >= passive3.getCost()) {
				passive3Panel.setVisible(true);
			}
			if (user.getCounter() >= passive4.getCost()) {
				passive4Panel.setVisible(true);
			}
			if (user.getCounter() >= passive5.getCost()) {
				passive5Panel.setVisible(true);
			}
			
		}
		
	}

	
}