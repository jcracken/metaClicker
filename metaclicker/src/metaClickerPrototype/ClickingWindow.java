package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

public class ClickingWindow extends JFrame {

	protected Clicker clicks;
	// private double clicks = 0;
	private JFrame frame;
	private JButton clickme;
	private JButton players;
	private JButton upgrades;
	private JPanel panel;
	private JPanel labelPanel;
	private JPanel playerPanel;
	private JPanel upgradePanel;
	private JLabel counts;
	// private UpgradesGUI upgradeScreen;
	// private PlayersGUI playerScreen;
	private boolean isClosedUpgrades = false;
	private boolean isClosedPlayers = false;
	private boolean upgradeCheck; // prevents GUI from making lots of upgrade
									// buttons

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	
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
	private PassiveUpgrades passive6;
	
	private JPanel firstUpgrade;
	private JLabel firstUpgradeTitle;
	private JLabel firstUpgradeDesc;
	private JButton firstUpgradeButton;
	
	private Timer timer = new Timer();
	private double CPS = 0;
	private int endGame = 0;

	public ClickingWindow() {
		
		upgradeCheck = false;

		frame = new JFrame("Meta Clicker: The Clickening");

		clicks = new Clicker();
		clickme = new JButton("Click me");
		upgrades = new JButton("Upgrades");
		players = new JButton("Statistics");
		panel = new JPanel();
		labelPanel = new JPanel();
		playerPanel = new JPanel();
		upgradePanel = new JPanel();
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileSave = new JMenuItem("Save");
		fileLoad = new JMenuItem("Load");
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		
		frame.setSize(400, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * this.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosed(WindowEvent e) { isClosed = true;
		 * } });
		 */
		
		fileSave.addActionListener(new PanelListener());
		fileLoad.addActionListener(new PanelListener());

		buildPanel();
		frame.setLayout(new GridLayout(2,3));
		
		frame.add(panel, BorderLayout.CENTER);

		

		frame.add(labelPanel, BorderLayout.CENTER);

		frame.add(playerPanel, BorderLayout.CENTER);
		// if(clicks.getCounter() > 10) addUpgrades();

		frame.setVisible(true);

		/*
		 * while(!isClosed) { SwingUtilities.updateComponentTreeUI(this); }
		 */
		initializeUpgrades();
		createUpgradesPanel();
		
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				clicks.addClicks(CPS);
				if(passive6.upgradePurchased)
				{
					if(clicks.getCounter() <= 0.0) {
						JOptionPane.showMessageDialog(null, "You lost the damn war and got exiled from space. Trump blew up Earth, so nowhere to go. You dumbass!", "Game Over", JOptionPane.ERROR_MESSAGE);
						//end the game somehow
					}
					else
						endGame++;
					if(endGame >= 1200) {
						JOptionPane.showMessageDialog(null, "You exterminated the xenomorphs and feasted on their corpses. Winner is you!!!", "You Win", JOptionPane.INFORMATION_MESSAGE);
						//win state, let player continue or exit out?
					}
				}
			}
		}, 0, 1000);
	}

	public void buildPanel() {
		counts = new JLabel(clicks.getCounter() + " clicks counted");

		clickme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks.click();
				
				counts.setText(clicks.getCounter() + " clicks counted");
				if (clicks.getCounter() >= 10 && upgradeCheck == false){
					frame.add(firstUpgrade);
					upgradeCheck = true;
				}
				
			}
		});
		// panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addPlayers();
		panel.add(clickme);
		labelPanel.add(counts);
	}

	public void addUpgrades() {
		upgrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isClosedUpgrades == false) {
					//blargh
					isClosedUpgrades = true;
				}
			}
		});
		upgradePanel.add(upgrades); //
		frame.add(upgradePanel);
	}
	
	public void addPlayers() {
		players.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isClosedPlayers == false) {
					//playerScreen = new PlayersGUI();
					isClosedPlayers = true;
				}
			}
		});
		playerPanel.add(players);
		this.add(playerPanel);	
 	}

	private class PanelListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem) (e.getSource());
			if (source.equals(fileSave))
				handleFileSave();
			else if (source.equals(fileLoad))
				handleFileLoad();

		}
		
		private void handleFileSave() {
			if (clicks != null) {
				Driver.saveGame(clicks);
			} else {
				JOptionPane.showMessageDialog(null, "No clicker", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			
		}

		private void handleFileLoad() {
			clicks = Driver.loadGame();
			counts.setText(clicks.getCounter() + " clicks counted");
			if (clicks.getCounter() >= 10 && upgradeCheck == false){
				addUpgrades();
				upgradeCheck = true;
			}
		}

	}
	
	private void initializeUpgrades() {
		active1 = new ActiveUpgrades();
		active1.setName("Mouse Upgrade"); //first
		active1.setDesc("You bought a new mouse that clicks twice every time you click (Upgrades click rate to 2).");
		active1.setCost(10);
		active1.setMult(2);
		
		active2 = new ActiveUpgrades();
		active2.setName("Run Cheat Engine"); //third
		active2.setDesc("Use Cheat Engine to speed up the game (Upgrades click rate to 5).");
		active2.setCost(50);
		active2.setMult(5);
		
		active3 = new ActiveUpgrades();
		active3.setName("Faster Processor"); //fifth
		active3.setDesc("You bought a new CPU, congrats (Upgrades click rate to 20).");
		active3.setCost(250);
		active3.setMult(20);
		
		active4 = new ActiveUpgrades();
		active4.setName("Trumpacolypse"); //seventh
		active4.setDesc("Trump gets elected president and the world is about to end, but at least you won a bet (Upgrades click rate to 50).");
		active4.setCost(750);
		active4.setMult(50);
		
		active5 = new ActiveUpgrades();
		active5.setName("Utopia"); //nine
		active5.setDesc("You find a Xenomorph alien civilization with no war and everlasting peace (Upgrades click rate to 100).");
		active5.setCost(10000);
		active5.setMult(100);
		
		passive1 = new PassiveUpgrades();
		passive1.setCost(20);
		passive1.setDesc("You used your knowledge in computer programming to set up a shoddy auto clicker (Increases passive clicks by one).");
		passive1.setName("Auto-Clicker"); //second
		passive1.setCPS(1);
		
		passive2 = new PassiveUpgrades();
		passive2.setCost(100);
		passive2.setDesc("You properly understand coding syntax and create a second program to optimize. (Increases passive clicks by five).");
		passive2.setName("Execute Optimizer"); //fourth
		passive2.setCPS(5);
		
		passive3 = new PassiveUpgrades();
		passive3.setCost(500);
		passive3.setDesc("You install an ActionKey script that clicks in the background for you (Increases passive clicks by ten).");
		passive3.setName("ActionKey Script"); //sixth
		passive3.setCPS(10);
		
		passive4 = new PassiveUpgrades();
		passive4.setCost(10000); //eight
		passive4.setDesc("You go to space (Increases passive clicks by 20).");
		passive4.setName("Space Exploration");
		passive4.setCPS(20);
		
		passive5 = new PassiveUpgrades();
		passive5.setCost(1000000);
		passive5.setDesc("Harambe for the assist! Gives you an edge on those alien bastards who shot up your ride (Increases passive clicks to -150).");
		passive5.setName("clicks out for Harambe"); //eleven
		passive5.setCPS(86);
		
		passive6 = new PassiveUpgrades();
		passive6.setCost(500000);
		passive6.setDesc("KILL KILL KILL (Decreases passive clicks to -200).");
		passive6.setName("Xenomorph War"); //ten
		passive6.setCPS(-236); //if this upgrade is bought and hits zero, you lose. otherwise, you get a win dialog after 20 min.
	}
	
	public void createUpgradesPanel() {
		//in which we draw the ui for purchasing upgrades
		firstUpgradeTitle = new JLabel(active1.upgradeName);
		firstUpgradeDesc = new JLabel(active1.upgradeDescription);
		firstUpgrade = new JPanel();
		firstUpgradeButton = new JButton("10 Clicks");
		firstUpgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (clicks.removeClicks(10) == false)
						JOptionPane.showMessageDialog(null, "You don't have the money, you piece of trash. Go fuck yourself", "Error", JOptionPane.ERROR_MESSAGE);
					else {
						firstUpgradeButton.setVisible(false);
						clicks.setClickRate(2);
					} //to add more upgrades we need to do the above over and over. blargh.
				}
			});
		firstUpgrade.add(firstUpgradeTitle);
		firstUpgrade.add(firstUpgradeDesc);
		firstUpgrade.add(firstUpgradeButton);
	}
}
