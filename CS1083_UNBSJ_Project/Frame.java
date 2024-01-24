import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/********************************************************
 * JFrame class
 * @author Nguyen Thanh Khoi Tran
 * @date 01-01-2024
 * @version V1.0
 ********************************************************/

public class Frame 
{
    public static void main(String[] args) 
    {
        JFrame f = new JFrame();
        JButton startBut = new JButton ("START");
        int w = 1024;
        int h = 800;

        // Set a frame size
        f.setSize(w, h);
        
        // set a frame name
        f.setTitle("CARD SHARK GAME");
        
        // Set font "START" bigger
        Font ft = new Font ("Tahoma", Font.BOLD, 16);
        
        // Add Start button
        startBut.setFont(ft);
        startBut.setBounds (475, 650, 100, 50);
        f.add(startBut);
        
        // Apply the background
        BGround bg = new BGround ();
        f.add(bg);       
        
        // Move to another background (Rule game)
        //  ?????????
        // Action after closed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // set a frame at the center of screen
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
    }
}