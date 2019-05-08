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
    private JFrame f1; // The Jframe
    private Paddle opponentPaddle;
    private Thread ballThread;
    private Ball ball;
    private Screen s1;
        
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
        //userPaddle = new Paddle(20,600,30,90);
        
        s1 = new Screen();
        f1.add(s1);
        
        /*ball = new Ball(20,20,30);
        ballThread = new Thread(ball);
        ballThread.start();
        */
        
        // Add the key listeners to the frame.
        f1.addKeyListener(this);
        f1.setFocusable(true);
        f1.setFocusTraversalKeysEnabled(false);
        
        f1.validate();
        f1.repaint();
        
        
       
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
            s1.getUserPaddle().moveX(10);
            
            // Now repaint
            f1.repaint();
            
            e.consume();
        }
        else
        if(e.getKeyCode() == 37)
        {
            // Move the user paddle to the left
            s1.getUserPaddle().moveX(-10);
            
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
