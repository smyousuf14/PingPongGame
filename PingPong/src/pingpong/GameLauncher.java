/*
 * Launches the ping pong game.
 */
package pingpong;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Syed Yousuf
 */
public class GameLauncher 
{
    
    // Instance variables
    private JFrame j1;
    private JLabel name;
    
    /*
    * The Default constructor
    */
    public GameLauncher()
    {
        //Create the JFrame.
        j1 = new JFrame("Ping Pong game");
        j1.setSize(900,900);
        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        name = new JLabel("Ping Pong");
        name.setBounds(5,5,200,200);
        
        j1.add(name);
        
        
    }
    
    
    /*
    * The main method
    */
    public static void main(String[]args)
    {
        GameLauncher g1 = new GameLauncher();
    }
}
