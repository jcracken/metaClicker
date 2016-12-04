package metaClickerPrototype;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Driver_v2 {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClickingGUI_v2 mainGUI = new ClickingGUI_v2();
	}
}
