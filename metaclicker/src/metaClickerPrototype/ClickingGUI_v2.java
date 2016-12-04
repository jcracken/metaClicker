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
	JPanel active2Panel;
	JButton active2Button;
	JPanel active3Panel;
	JButton active3Button;
	JPanel active4Panel;
	JButton active4Button;
	JPanel active5Panel;
	JButton active5Button;
	JPanel passive1Panel;
	JPanel passive2Panel;
	JPanel passive3Panel;
	JPanel passive4Panel;
	JPanel passive5Panel;
	
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
		this.active1Panel.add(new JLabel(active1.getDesc()), BorderLayout.SOUTH);
		this.active1Button = new JButton(this.active1.getCost() + " Clicks");
		this.active1Button.addActionListener(new ButtonListener());
		this.active1Panel.add(active1Button, BorderLayout.EAST);
		this.active1Panel.setVisible(false);
		this.upgradePanel.add(this.active1Panel);
		
		this.active2Panel = new JPanel(new BorderLayout());
		this.active2Panel.add(new JLabel(active2.getName()), BorderLayout.WEST);
		this.active2Panel.add(new JLabel(active2.getDesc()), BorderLayout.SOUTH);
		this.active2Button = new JButton(this.active2.getCost() + " Clicks");
		this.active2Button.addActionListener(new ButtonListener());
		this.active2Panel.add(active2Button, BorderLayout.EAST);
		this.active2Panel.setVisible(false);
		this.upgradePanel.add(this.active2Panel);
		
		this.active3Panel = new JPanel(new BorderLayout());
		this.active3Panel.add(new JLabel(active3.getName()), BorderLayout.WEST);
		this.active3Panel.add(new JLabel(active3.getDesc()), BorderLayout.SOUTH);
		this.active3Button = new JButton(this.active3.getCost() + " Clicks");
		this.active3Button.addActionListener(new ButtonListener());
		this.active3Panel.add(active3Button, BorderLayout.EAST);
		this.active3Panel.setVisible(false);
		this.upgradePanel.add(this.active3Panel);
		
		this.active4Panel = new JPanel(new BorderLayout());
		this.active4Panel.add(new JLabel(active4.getName()), BorderLayout.WEST);
		this.active4Panel.add(new JLabel(active4.getDesc()), BorderLayout.SOUTH);
		this.active4Button = new JButton(this.active4.getCost() + " Clicks");
		this.active4Button.addActionListener(new ButtonListener());
		this.active4Panel.add(active4Button, BorderLayout.EAST);
		this.active4Panel.setVisible(false);
		this.upgradePanel.add(this.active4Panel);
		
		this.active5Panel = new JPanel(new BorderLayout());
		this.active5Panel.add(new JLabel(active5.getName()), BorderLayout.WEST);
		this.active5Panel.add(new JLabel(active5.getDesc()), BorderLayout.SOUTH);
		this.active5Button = new JButton(this.active5.getCost() + " Clicks");
		this.active5Button.addActionListener(new ButtonListener());
		this.active5Panel.add(active5Button, BorderLayout.EAST);
		this.active5Panel.setVisible(false);
		this.upgradePanel.add(this.active5Panel);
	}
	
	private void initializeUpgrades() {
		
		active1 = new ActiveUpgrade_v2();
		active1.setName("Click Multiplier");
		active1.setDesc("Modify the button to increment by 2.");
		active1.setCost(10);
		active1.setMult(2);
		
		active2 = new ActiveUpgrade_v2();
		active2.setName("Click Multiplier 2");
		active2.setDesc("Modify the button to increment by 4.");
		active2.setCost(15);
		active2.setMult(4);
		
		active3 = new ActiveUpgrade_v2();
		active3.setName("Click Multiplier 3");
		active3.setDesc("Modify the button to increment by 8.");
		active3.setCost(20);
		active3.setMult(8);
		
		active4 = new ActiveUpgrade_v2();
		active4.setName("Click Multiplier 4");
		active4.setDesc("Modify the button to increment by 16.");
		active4.setCost(25);
		active4.setMult(16);
		
		active5 = new ActiveUpgrade_v2();
		active5.setName("Click Multiplier 5");
		active5.setDesc("Modify the button to increment by 32.");
		active5.setCost(30);
		active5.setMult(32);
		
		passive1 = new PassiveUpgrade_v2();
		passive1.setCost(15);
		passive1.setDesc("You used your knowledge in computer programming to set up a shoddy auto clicker.");
		passive1.setName("Auto-Clicker");
		passive1.setCPS(1);
		
		passive2 = new PassiveUpgrade_v2();
		passive2.setCost(25);
		passive2.setDesc("You properly understand coding syntax and create a second program to optimize");
		passive2.setName("Optimizer");
		passive2.setCPS(2);
		
		passive3 = new PassiveUpgrade_v2();
		passive3.setCost(35);
		passive3.setDesc("You decide this game sucks and cheat by modifying game files to run multiple instances");
		passive3.setName("Clone");
		passive3.setCPS(3);
		
		passive4 = new PassiveUpgrade_v2();
		passive4.setCost(45);
		passive4.setDesc("You cheat by hiring a bunch of monkeys to click for you");
		passive4.setName("Monkeys");
		passive4.setCPS(4);
		
		passive5 = new PassiveUpgrade_v2();
		passive5.setCost(55);
		passive5.setDesc("Harambe, our lord and savior, felt insulted that you went after his kin, therefore he took over the whole operation.");
		passive5.setName("Good ol' Harambe");
		passive5.setCPS(5);
		
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
			
			// update on any action
			statisticTextField.setText(user.getStatistics());
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
			
		}
		
	}

	
}