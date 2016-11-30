package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;

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
	private UpgradesGUI upgradeScreen;
	private PlayersGUI playerScreen;
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
	
	private JPanel firstUpgrade;
	private JLabel firstUpgradeTitle;
	private JLabel firstUpgradeDesc;
	private JButton firstUpgradeButton;

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

		frame.add(panel, BorderLayout.CENTER);

		frame.setLayout(new GridLayout(5,1));

		frame.add(labelPanel, BorderLayout.CENTER);

		frame.add(playerPanel, BorderLayout.CENTER);
		// if(clicks.getCounter() > 10) addUpgrades();

		frame.setVisible(true);

		/*
		 * while(!isClosed) { SwingUtilities.updateComponentTreeUI(this); }
		 */
		active1 = new ActiveUpgrades();
		active1.setName("Click Multiplier");
		active1.setDesc("You modified the button to increment by two.");
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
		createUpgradesPanel();
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
					playerScreen = new PlayersGUI();
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
	
	private void setClicks(Clicker click){
		clicks = click;
	}
	
	private Clicker getClicks(){
		return clicks;
	}
	
	public void createUpgradesPanel() {
		//in which we draw the ui for purchasing upgrades
		firstUpgradeTitle = new JLabel(active1.upgradeName);
		firstUpgradeDesc = new JLabel(active1.upgradeDescription);
		firstUpgrade = new JPanel();
		firstUpgradeButton = new JButton("10 Clicks");
		firstUpgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks.removeClicks(10);
				firstUpgradeButton.setVisible(false);
				}
			});
		firstUpgrade.add(firstUpgradeTitle);
		firstUpgrade.add(firstUpgradeDesc);
		firstUpgrade.add(firstUpgradeButton);
	}
}
