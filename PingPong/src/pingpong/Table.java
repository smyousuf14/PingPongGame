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
public class Table extends JPanel implements KeyListener
{
    // Instance Variables
    private Paddle userPaddle;
    private JFrame f1; // The Jframe
        
    /*
    * Default Constructor
    */
    public Table()
    {
        // Create a new window
        f1 = new JFrame("Ping Pong");
        f1.setSize(900,900);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Now create the user's paddle
        userPaddle = new Paddle(20,600,30,90);
        f1.add(userPaddle);
        
        // Add the key listeners to the frame.
        f1.addKeyListener(this);
        f1.setFocusable(true);
        f1.setFocusTraversalKeysEnabled(false);
        
        
       
    }
    
    /*
    * The events to run when the key is pressed
    */
    @Override
    public void keyPressed(KeyEvent e)
    {
        // The key code
        
        
        // When the user presses the right key the users paddle should move to the right.
        if(e.getKeyCode() == 39)
        {
            
            // Move the user paddle to the right.
            userPaddle.moveX(10);
            
            // Now repaint
            f1.repaint();
            
            e.consume();
        }
        else
        if(e.getKeyCode() == 37)
        {
            // Move the user paddle to the left
            userPaddle.moveX(-10);
            
            // Now repaint
            f1.repaint();
            
            e.consume();
        }
        
    }
    
    /*
    * The events to run when a key is released
    */
    @Override
    public void keyReleased(KeyEvent e)
    {
        // Nothing
        e.consume();
    }
    
    /*
    * The events to run when a key is typed
    */
    @Override
    public void keyTyped(KeyEvent e)
    {
        // Nothing
        e.consume();
    }
    
    
    /*
    * A test method
    */
    public static void main(String[]args)
    {
        Table PongTable = new Table();
        
        
    }
    
    
    
}
