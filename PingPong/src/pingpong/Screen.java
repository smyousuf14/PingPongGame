/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Syed Yousuf
 */
public class Screen extends JPanel
{
    // Instance Variables
    private Paddle userPaddle;
    private Paddle opponentPaddle;
    
    /*
    * Default Constructor
    */
    public Screen()
    {
        userPaddle = new Paddle(400,600,30,90);
        opponentPaddle = new Paddle(400,20,30,90);
        
        
    }
    
    
    /*
    * Returns the userpaddle
    *
    *@return userPaddle the paddle the user will use
    */
    public Paddle getUserPaddle()
    {
        return userPaddle;
    }
    
    /*
    * Gets the opponentPaddle
    *
    *@return opponentPaddle the paddle that the opponent will use
    */
    public Paddle getOpponentPaddle()
    {
        return opponentPaddle;
    }
    
    /*
    * Paints the screen
    */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // Set a background colour
        this.setBackground(Color.BLACK);
        
        // Create a blue user paddle on the screen
        g.setColor(Color.BLUE);
        g.fillRect((int)userPaddle.getXValue(), (int)userPaddle.getYValue(), (int)userPaddle.getWidthValue(), (int)userPaddle.getLength());
        
        // Create a blue opponent paddle on the screen.
        g.setColor(Color.BLUE);
        g.fillRect((int)opponentPaddle.getXValue(), (int)opponentPaddle.getYValue(), (int)opponentPaddle.getWidthValue(), (int)opponentPaddle.getLength());
        
    }
    
}
