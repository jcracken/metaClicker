package metaClickerPrototype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel(String url) {
       try {                
          image = ImageIO.read(new URL(url));
       } catch (IOException ex) {
    	   System.out.println("fuck you");
            // handle exception...
       }
       setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 100, 100, this); // see javadoc for more info on the parameters            
    }

}