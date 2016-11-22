package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClickingWindow extends JFrame {

	private Clicker clicks;
	// private double clicks = 0;
	private JButton clickme;
	private JButton upgrades;
	private JPanel panel;
	private JPanel labelPanel;
	private JPanel upgradePanel;
	private JLabel counts;
	private Upgrades upgradeScreen;
	private boolean isClosed = false;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	private JMenuItem fileExit;

	public ClickingWindow() {

		super("Meta Clicker: The Clickening");
		
		clicks = new Clicker();
		clickme = new JButton("Click me");
		upgrades = new JButton("Upgrades");
		panel = new JPanel();
		labelPanel = new JPanel();
		upgradePanel = new JPanel();

		setSize(400, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * this.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosed(WindowEvent e) { isClosed = true;
		 * } });
		 */

		buildPanel();

		add(panel, BorderLayout.CENTER);

		setLayout(new GridLayout(3, 1));

		add(labelPanel, BorderLayout.CENTER);

		// if(clicks.getCounter() > 10) addUpgrades();

		setVisible(true);

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
				if (clicks.getCounter() == 10)
					addUpgrades();
			}
		});
		// panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(clickme);
		labelPanel.add(counts);
	}

	public void addUpgrades() {
		upgrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isClosed == false) {
					upgradeScreen = new Upgrades();
					isClosed = true;
				}
			}
		});
		upgradePanel.add(upgrades);
		this.add(upgradePanel);
	}
	
	private class PanelListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
