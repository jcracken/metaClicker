package metaClickerPrototype;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayersGUI extends JFrame{
	
	// Statistics
	public PlayersGUI() {
		
		super("Statistics");
		
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
		playersPanel.add(new JLabel("Lifetime Clicks: "));
		playersPanel.add(new JLabel("Click Multiplier: "));
		playersPanel.add(new JLabel("Clicks per Second: " + "\n"));
		
		playersPanel.add(new JLabel("Total Upgrades Purchased: " + "/10"));
		
		this.add(playersPanel);
		setSize(800, 600);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		
	}
	
}
