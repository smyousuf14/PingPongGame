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
public class Screen extends JPanel implements Runnable
{
    // Instance Variables
    private Paddle userPaddle;
    private Paddle opponentPaddle;
    private Ball ball;
    private Thread ballMoving;
    private String winner;
    private boolean isRunning;
    private boolean isSinglePlayer;
    
    
    /*
    * Default Constructor
    */
    public Screen(boolean isSinglePlayer)
    {
        winner = "";
        this.isSinglePlayer = isSinglePlayer;
        isRunning = true;
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
    * Gets if the game is running
    *
    * @return if the game is running
    */
    public boolean getIsRunning()
    {
        return isRunning;
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
    * Sets the value of if it is running
    *
    *@param isRunning if the game is running
    */
    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
        
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
        g.setFont(new Font("TimesRoman", Font.PLAIN,70));
        g.drawString("" + ball.getScoreUser(), 50, 400);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN,70));
        g.drawString("" + ball.getScoreOpponent(), 50, 50);
        
        // Set the winner if the game is over.
        if(ball.getifRunning() == false)
        {
            g.setFont(new Font("TimesRoman", Font.PLAIN,200));
            g.drawString("" + winner, 50, 350);
        }
    }
    
    
    /*
    * Runs on a seperate thread. Allows the second player/computer to play on a 
    * seperate thread. This allows for more smoother gameplay.
    */
    public void run()
    {
        // Local Variables
        int randomNum;
        
        while(isRunning && isSinglePlayer)
        {
            // Generate a random number every second and perform the corresponding actions..
            try 
            {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ie) 
            {
                //None.

            }

            randomNum = (int)(Math.random()* 100);

            /*
            * 50 percent chance that the cpu will perfrom a good move. 30 percentage 
            * chance that it will perfrom a bad move. 20 percent chance it will do nothing 
            */
            if(randomNum >= 0 && randomNum <= 50)
            {
                // Check the position of the ball.
                if(ball.getXValue() >= 450)
                {
                    // Change the angle accordingly
                    ball.setAngle((opponentPaddle.getPaddleSpeed()  / 10) - 1 );

                    // Move the opponent paddle to the right
                    opponentPaddle.moveX(opponentPaddle.getPaddleSpeed());

                    // Also set the velocity direction
                    ball.setVelocityDirection("right");
                }
                else
                if(ball.getXValue() < 450)
                {
                    // Change the angle accordingly
                    ball.setAngle((opponentPaddle.getPaddleSpeed()  / 10) - 1 );

                    // Move the opponent paddle to the left
                    opponentPaddle.moveX(-(opponentPaddle.getPaddleSpeed()));

                    // Also set the velocity direction
                    ball.setVelocityDirection("left");

                    // Now increase the paddle speed if possible
                    if(opponentPaddle.getPaddleSpeed() >= 60)
                    {
                        // Set to 60
                        opponentPaddle.setPaddleSpeed(60);
                    }
                    else
                    {
                        opponentPaddle.setPaddleSpeed((opponentPaddle.getPaddleSpeed()) + 3);
                    }
                }
                    

            }
            else
            if(randomNum > 50 && randomNum <= 80)
            {
                 // Make a bad choise
                 if(ball.getXValue() >= 450)
                 {
                     // Change the angle accordingly
                    ball.setAngle((opponentPaddle.getPaddleSpeed()  / 10) - 1 );

                    // Move the opponent paddle to the left
                    opponentPaddle.moveX(-(opponentPaddle.getPaddleSpeed()));

                    // Also set the velocity direction
                    ball.setVelocityDirection("left");

                    // Now increase the paddle speed if possible
                    if(opponentPaddle.getPaddleSpeed() >= 60)
                    {
                        // Set to 60
                        opponentPaddle.setPaddleSpeed(60);
                    }
                    else
                    {
                        opponentPaddle.setPaddleSpeed((opponentPaddle.getPaddleSpeed()) + 3);
                    }
                 }
                 else
                 if(ball.getXValue() < 450)
                 {
                     // Change the angle accordingly
                    ball.setAngle((opponentPaddle.getPaddleSpeed()  / 10) - 1 );

                    // Move the opponent paddle to the right
                    opponentPaddle.moveX(opponentPaddle.getPaddleSpeed());

                    // Also set the velocity direction
                    ball.setVelocityDirection("right");
                 }

            }
            else
            if(randomNum > 80 && randomNum <= 100)
            {
                // Do nothing

            }
        }
    }
    
}
