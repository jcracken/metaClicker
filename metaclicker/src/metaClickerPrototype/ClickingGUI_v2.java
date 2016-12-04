package metaClickerPrototype;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import metaClickerPrototype.ClickingGUI_v2.ButtonListener;

import java.util.Timer;
import java.util.TimerTask;

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
	PassiveUpgrade_v2 passive6;
	
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
	JPanel passive6Panel;
	JButton passive6Button;
	JTextArea passive6Desc;
	
	Timer timer = new Timer();
	int endGame = 0;
	boolean harambePls = false;
	
	public ClickingGUI_v2() {
		//super("MetaClicker: The Clickening");
		topFrame = new JFrame("MetaClicker: The Clickening");
		//this.setSize(800,600);
		topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		topFrame.setLayout(new GridLayout(1,3));

		initializeUpgrades();
		buildGUI();
		topFrame.setVisible(true);
		
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				user.addClicks(user.getCPS());
				statisticTextField.setText(user.getStatistics());
				if(passive6.upgradePurchased)
				{
					if(user.getCounter() <= 0.0) {
						JOptionPane.showMessageDialog(null, "You lost the damn war and got exiled from space. Trump blew up Earth, so nowhere to go. You dumbass!", "Game Over", JOptionPane.ERROR_MESSAGE);
						//end the game somehow
					}
					else
						endGame++;
					if(endGame >= 1200) {
						JOptionPane.showMessageDialog(null, "You exterminated the xenomorphs and feasted on their corpses. Winner is you!!!", "You Win", JOptionPane.INFORMATION_MESSAGE);
						//win state, let player continue or exit out?
					}
					else if (endGame >= 600)
						harambePls = true;
						
				}
			}
		}, 0, 1000);
	}

	public void buildGUI() {
		
		// User
		user = new Player_v2();
		
		// Left pane, upgrades
		upgradePanel = new JPanel();
		upgradePanel.setLayout(new BoxLayout(upgradePanel, BoxLayout.Y_AXIS));
		this.createUpgradePanels();
		upgradeList = new JScrollPane(upgradePanel);
		upgradeList.setPreferredSize(new Dimension(225,225));
		upgradeArea = new JPanel(new BorderLayout());
		upgradeArea.add(new JLabel("Upgrades", SwingConstants.CENTER), BorderLayout.PAGE_START);
		upgradeArea.add(upgradeList);
		
		// Middle pane, click me
		clickMe = new JButton("Click me!");
		clickMe.addActionListener(new ButtonListener());
		clickSave = new JButton("Save");
		clickSave.addActionListener(new ButtonListener());
		clickLoad = new JButton("Load");
		clickLoad.addActionListener(new ButtonListener());
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
		if(user.getMultiplier() >= active1.getMult()){
			this.active1Panel.setVisible(true);
			this.active1Button.setVisible(false);
		}
		else
			this.active1Panel.setVisible(false);
		this.upgradePanel.add(this.active1Panel);
		
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
		if(user.getCPS() >= passive1.getCPS()){
			this.passive1Panel.setVisible(true);
			this.passive1Button.setVisible(false);
		}
		else
			this.passive1Panel.setVisible(false);
		this.upgradePanel.add(this.passive1Panel);
		
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
		if(user.getMultiplier() >= active2.getMult()){
			this.active2Panel.setVisible(true);
			this.active2Button.setVisible(false);
		}
		else
			this.active2Panel.setVisible(false);
		this.upgradePanel.add(this.active2Panel);
		
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
		if(user.getCPS() >= passive2.getCPS()){
			this.passive2Panel.setVisible(true);
			this.passive2Button.setVisible(false);
		}
		else
			this.passive2Panel.setVisible(false);
		this.upgradePanel.add(this.passive2Panel);
		
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
		if(user.getMultiplier() >= active3.getMult()){
			this.active3Panel.setVisible(true);
			this.active3Button.setVisible(false);
		}
		else
			this.active3Panel.setVisible(false);
		this.upgradePanel.add(this.active3Panel);
		
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
		if(user.getCPS() >= passive3.getCPS()){
			this.passive3Panel.setVisible(true);
			this.passive3Button.setVisible(false);
		}
		else
			this.passive3Panel.setVisible(false);
		this.upgradePanel.add(this.passive3Panel);
		
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
		if(user.getMultiplier() >= active4.getMult()){
			this.active4Panel.setVisible(true);
			this.active4Button.setVisible(false);
		}
		else
			this.active4Panel.setVisible(false);
		this.upgradePanel.add(this.active4Panel);
		
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
		if(user.getCPS() >= passive4.getCPS()){
			this.passive4Panel.setVisible(true);
			this.passive4Button.setVisible(false);
		}
		else
			this.passive4Panel.setVisible(false);
		this.upgradePanel.add(this.passive4Panel);
		
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
		if(user.getMultiplier() >= active5.getMult()){
			this.active5Panel.setVisible(true);
			this.active5Button.setVisible(false);
		}
		else
			this.active5Panel.setVisible(false);
		this.upgradePanel.add(this.active5Panel);
		
		this.passive6Panel = new JPanel(new BorderLayout());
		this.passive6Panel.add(new JLabel(passive6.getName()), BorderLayout.WEST);
		this.passive6Desc = new JTextArea(2,10);
		this.passive6Desc.setEditable(false);
		this.passive6Desc.setText(passive6.getDesc());
		this.passive6Desc.setLineWrap(true);
		this.passive6Panel.add(passive6Desc, BorderLayout.SOUTH);
		this.passive6Button = new JButton(this.passive6.getCost() + " Clicks");
		this.passive6Button.addActionListener(new ButtonListener());
		this.passive6Panel.add(passive6Button, BorderLayout.EAST);
		if(user.getCPS() <= passive6.getCPS()){
			this.passive6Panel.setVisible(true);
			this.passive6Button.setVisible(false);
		}
		else
			this.passive6Panel.setVisible(false);
		this.upgradePanel.add(this.passive6Panel);
		
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
		if(user.getCPS() <= passive5.getCPS()){
			this.passive5Panel.setVisible(true);
			this.passive5Button.setVisible(false);
		}
		else
			this.passive5Panel.setVisible(false);
		this.upgradePanel.add(this.passive5Panel);
	}
	
	private void initializeUpgrades() {
		
		active1 = new ActiveUpgrade_v2();
		active1.setName("Mouse Upgrade"); //first
		active1.setDesc("You bought a new mouse that clicks twice every time you click (Upgrades click rate to 2).");
		active1.setCost(50);
		active1.setMult(2);
		
		active2 = new ActiveUpgrade_v2();
		active2.setName("Run Cheat Engine"); //third
		active2.setDesc("Use Cheat Engine to speed up the game (Upgrades click rate to 5).");
		active2.setCost(400);
		active2.setMult(5);
		
		active3 = new ActiveUpgrade_v2();
		active3.setName("Faster Processor"); //fifth
		active3.setDesc("You bought a new CPU, congrats (Upgrades click rate to 20).");
		active3.setCost(1200);
		active3.setMult(20);
		
		active4 = new ActiveUpgrade_v2();
		active4.setName("Trumpacolypse"); //seventh
		active4.setDesc("Trump gets elected president and the world is about to end, but at least you won a bet (Upgrades click rate to 50).");
		active4.setCost(4800);
		active4.setMult(50);
		
		active5 = new ActiveUpgrade_v2();
		active5.setName("Utopia"); //nine
		active5.setDesc("You find a Xenomorph alien civilization with no war and everlasting peace (Upgrades click rate to 100).");
		active5.setCost(12000);
		active5.setMult(100);
		
		passive1 = new PassiveUpgrade_v2();
		passive1.setCost(200);
		passive1.setDesc("You used your knowledge in computer programming to set up a shoddy auto clicker (Increases passive clicks by one).");
		passive1.setName("Auto-Clicker"); //second
		passive1.setCPS(1);
		
		passive2 = new PassiveUpgrade_v2();
		passive2.setCost(800);
		passive2.setDesc("You properly understand coding syntax and create a second program to optimize. (Increases passive clicks by five).");
		passive2.setName("Execution Optimizer"); //fourth
		passive2.setCPS(5);
		
		passive3 = new PassiveUpgrade_v2();
		passive3.setCost(4000);
		passive3.setDesc("You install an ActionKey script that clicks in the background for you (Increases passive clicks by 20).");
		passive3.setName("ActionKey Script"); //sixth
		passive3.setCPS(20);
		
		passive4 = new PassiveUpgrade_v2();
		passive4.setCost(10000); //eight
		passive4.setDesc("You go to space (Increases passive clicks by 50).");
		passive4.setName("Space Exploration");
		passive4.setCPS(50);
		
		passive5 = new PassiveUpgrade_v2();
		passive5.setCost(0);
		passive5.setDesc("Harambe for the assist! Gives you an edge on those alien bastards who shot up your ride (Increases passive clicks to -1500).");
		passive5.setName("clicks out for Harambe"); //eleven
		passive5.setCPS(-1500);
		
		passive6 = new PassiveUpgrade_v2();
		passive6.setCost(50000);
		passive6.setDesc("KILL KILL KILL (Decreases passive clicks to -2000).");
		passive6.setName("Xenomorph War"); //ten
		passive6.setCPS(-2000); //if this upgrade is bought and hits zero, you lose. otherwise, you get a win dialog after 20 min.
		
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
			else if (source.equals(passive6Button)) {
				if (user.removeClicks(passive6.getCost())) {
					user.setCPS(passive6.getCPS());
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
			if (user.getCounter() >= passive6.getCost()) {
				passive6Panel.setVisible(true);
			}
			if (harambePls) {
				passive5Panel.setVisible(true);
			}
			
		}
		
	}

	
}