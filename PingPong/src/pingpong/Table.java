/*
 * A table of a ping-pong game. Also, create the graphic components alongside the 
 */
package pingpong;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Syed Yousuf
 */
public class Table extends JPanel
{
    // Instance Variables
    
    
    /*
    * Default Constructor
    */
    public Table()
    {
       
    }
    
    /*
    * The paint method 
    */
    @Override 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // Set a background colour
        this.setBackground(Color.BLACK);
        
        g.setColor(Color.BLUE);
        g.fillRect(240, 240, 100, 50);
    }
    /*
    * A test method
    */
    public static void main(String[]args)
    {
        Table PongTable = new Table();
        
        // Create the frame 
        JFrame f1 = new JFrame("Ping Pong");
        f1.setSize(900,900);
        f1.setVisible(true);
        f1.add(PongTable);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
}
