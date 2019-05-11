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
    private Ball ball;
    private Thread ballMoving;
    private String winner;
    
    
    /*
    * Default Constructor
    */
    public Screen()
    {
        winner = "";
        userPaddle = new Paddle(400,600,30,90);
        opponentPaddle = new Paddle(400,20,30,90);
        ball = new Ball(400,400,10);
       
        setRecValues();
        // Move the ball.
        ballMoving = new Thread(ball);
        ballMoving.start();
        
        
        
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
    * Gets the ball.
    *
    *@return ball The ball that is used as a puck
    */
    public Ball getBall()
    {
        return ball;
    }
    
    /*
    * Gets the winner
    *
    *@return Winner of the game.
    */
    public String getWinner()
    {
        return winner;
    }
    
    /*
    * Sets the users and oppoenent rec values
    */
    public void setRecValues()
    {
        //Set the user paddle values
        ball.setRec(userPaddle.getXValue(), userPaddle.getYValue(), userPaddle.getWidthValue(), userPaddle.getLength());
        
        // Set the opponent paddle values
        ball.setRecOpponent(opponentPaddle.getXValue(), opponentPaddle.getYValue(), opponentPaddle.getWidthValue(), opponentPaddle.getLength());
        
    }
    
    /*
    * Set the value of the winner
    *
    *@param winner The value of the winner
    */
    public void setWinner(String winner)
    {
        this.winner = winner;
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
        g.fillRect((int)opponentPaddle.getXValue(), (int)opponentPaddle.getYValue(), (int)opponentPaddle.getWidthValue(), (int)opponentPaddle.getLength());
        
        // Create a red ball.
        g.setColor(Color.RED);
        g.fillOval((int)ball.getXValue(), (int)ball.getYValue(), (int)(2 * ball.getRadius()), (int)(2 * ball.getRadius()));
        
        // Create the scores.
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN,30));
        g.drawString("" + ball.getScoreUser(), 50, 400);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN,30));
        g.drawString("" + ball.getScoreOpponent(), 50, 50);
        
        // Set the winner if the game is over.
        if(ball.getifRunning() == false)
        {
            g.setFont(new Font("TimesRoman", Font.PLAIN,200));
            g.drawString("" + winner, 100, 350);
        }
    }
    
}
