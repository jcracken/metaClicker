package metaClickerPrototype;

import java.io.*;

public class Driver implements Serializable{
	
	public Driver(){
//		clicks = null;
	}
	
//	public void setClicks(Clicker c){
//		clicks = c;
//	}
//	
//	public Clicker getClicks(){
//		return clicks;
//	}
	
	public static void saveGame(Clicker c){
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Clicker.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Clicker loadGame() {
		FileInputStream inFile = null;
		ObjectInputStream ois = null;
		Clicker c = null;
		try {
			inFile = new FileInputStream("Clicker.ser");
			ois = new ObjectInputStream(inFile);
			c = (Clicker) ois.readObject();
			ois.close();
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException u) {
			u.printStackTrace();
		}
		return c;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ClickingWindow electionRigger = new ClickingWindow();
	}
}
