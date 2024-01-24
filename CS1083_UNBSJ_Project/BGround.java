// This class supports in colours and graphics
import java.awt.*;
import java.awt.event.*;

// This class supports in GUI
import javax.swing.*;
/********************************************************
 * Create the background class
 * @author Nguyen Thanh Khoi Tran
 * @date 23-01-2024
 * @version V1.0
 ********************************************************/

public class BGround extends JPanel 
{
    // Instantiation
    private ImageIcon obj = new ImageIcon("BGround.jpeg");
    private Image img = obj.getImage();
    
    // Constructor
    public BGround() 
    {
        this.setFocusable(true);

        // Make window open smoothly
        this.setDoubleBuffered(true);
        
    }

    @Override 
    public void paintComponent (Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Anti-aliasing 
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints (rh);
        
        // Set background
        
        g2d.drawImage (img, 0, 0, null);
        
        // Remove everything after close
        g.dispose();
    }
}
