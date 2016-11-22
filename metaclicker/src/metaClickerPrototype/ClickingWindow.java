package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ClickingWindow extends JFrame {

	private Clicker clicks;
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
	private boolean isClosed;
	private boolean upgradeCheck;		//prevents GUI from making lots of upgrade buttons

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem fileSave;
	private JMenuItem fileLoad;

	public ClickingWindow() {
		
		upgradeCheck = false;
;

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

		frame.setLayout(new GridLayout(4, 1));

		frame.add(labelPanel, BorderLayout.CENTER);

		frame.add(playerPanel, BorderLayout.CENTER);
		// if(clicks.getCounter() > 10) addUpgrades();

		frame.setVisible(true);

		/*
		 * while(!isClosed) { SwingUtilities.updateComponentTreeUI(this); }
		 */
	}

	public void buildPanel() {
		counts = new JLabel(clicks.getCounter() + " clicks counted");

		clickme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks.click();
				
				counts.setText(clicks.getCounter() + " clicks counted");
				if (clicks.getCounter() >= 10 && upgradeCheck == false){
					addUpgrades();
					
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
				if (isClosed == false) {
					upgradeScreen = new UpgradesGUI();
					isClosed = true;
				}
			}
		});
		upgradePanel.add(upgrades); //
		frame.add(upgradePanel);
	}
	
	public void addPlayers() {
		players.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					playerScreen = new PlayersGUI();
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
}
