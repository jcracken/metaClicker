package metaClickerPrototype;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClickingWindow extends JFrame {
	
	private Clicker clicks = new Clicker();
	//private double clicks = 0;
	private JButton clickme = new JButton("stuff ballot");
	private JButton upgrades = new JButton("upgrades");
	private JPanel panel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private JPanel upgradePanel = new JPanel();
	private JLabel counts;
	private Upgrades upgradeScreen;
	//private boolean isClosed = false;
	
	public ClickingWindow() {
		
		super("election rigging: the clickening");
		
		setSize(350, 250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				isClosed = true;
			}
		});	*/
		
		buildPanel();
		
		add(panel);
		
		setLayout(new GridLayout(3, 1));
		
		add(labelPanel, BorderLayout.CENTER);
		
		
		//if(clicks.getCounter() > 10) addUpgrades();
		
		setVisible(true);
		
		/*while(!isClosed) {
			SwingUtilities.updateComponentTreeUI(this);
		}*/
	}
	
	public void addUpgrades() {
		upgrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upgradeScreen = new Upgrades();
			}
		});
		upgradePanel.add(upgrades);
		this.add(upgradePanel);
	}
	
	
	public void buildPanel() {
		counts = new JLabel(clicks.getCounter() + " ballots stuffed");
		clickme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					clicks.click();
					counts.setText(clicks.getCounter() + " ballots stuffed");
					if (clicks.getCounter() > 10) addUpgrades();
			}
		});
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(clickme);
		labelPanel.add(counts);
	}
}
