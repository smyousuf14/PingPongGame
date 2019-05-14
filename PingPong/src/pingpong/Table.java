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
public class Table extends JPanel implements KeyListener,Runnable
{
    // Instance Variables
    private JFrame f1; // The Jframe
    private Thread ballThread;
    private Screen s1;
    private boolean isRunning;
    private boolean isSinglePlayer;
    private boolean opponentRightButtonDown;
    private boolean opponentLeftButtonDown;
    
    /*
    * Default Constructor
    */
    public Table(boolean isSinglePlayer)
    {
        // Set isRunning to true.
        isRunning = false;
        
        this.isSinglePlayer = isSinglePlayer;
        
        // Set the default values to the opponent buttons.
        opponentRightButtonDown = false;
        opponentLeftButtonDown = false;
        
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
        
        try 
        {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ie) 
        {
            //None.
            
        }
        
        
        // Add the key listeners to the frame.
        f1.addKeyListener(this);
        f1.setFocusable(true);
        f1.setFocusTraversalKeysEnabled(false);
        
        
        f1.validate();
        f1.repaint();
        
        // Start the ball.
        s1.getBall().setIsRunning(true);
        isRunning = true;
        
       
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
            // Change the angle accordingly
            s1.getBall().setAngle((s1.getUserPaddle().getPaddleSpeed()  / 10) - 1 );
            
            // Move the user paddle to the right.
            s1.getUserPaddle().moveX(s1.getUserPaddle().getPaddleSpeed());
            
            // Also set the velocity direction
            s1.getBall().setVelocityDirection("right");
            
            // Now increase the paddle speed if possible
            if(s1.getUserPaddle().getPaddleSpeed() >= 60)
            {
                // Set to 60
                s1.getUserPaddle().setPaddleSpeed(60);
            }
            else
            {
                s1.getUserPaddle().setPaddleSpeed((s1.getUserPaddle().getPaddleSpeed()) + 3);
            }
            // Now repaint
            f1.repaint();
            
            e.consume();
        }
        else
        if(e.getKeyCode() == 37)
        {
            
            // Change the angle accordingly
            s1.getBall().setAngle((s1.getUserPaddle().getPaddleSpeed()  / 10) - 1 );
            
            
            // Move the user paddle to the left
            s1.getUserPaddle().moveX(-(s1.getUserPaddle().getPaddleSpeed()));
            
            // Also set the velocity direction
            s1.getBall().setVelocityDirection("left");
            
            // Now increase the paddle speed if possible
            if(s1.getUserPaddle().getPaddleSpeed() >= 60)
            {
                // Set to 60
                s1.getUserPaddle().setPaddleSpeed(60);
            }
            else
            {
                s1.getUserPaddle().setPaddleSpeed((s1.getUserPaddle().getPaddleSpeed()) + 3);
            }
            
            // Now repaint
            f1.repaint();
            
            e.consume();
        }
        else
        if(e.getKeyCode() == 65)
        {
            opponentLeftButtonDown = true;
            
            e.consume();
        }
        else
        if(e.getKeyCode() == 68)
        {
            opponentRightButtonDown = true;          
            e.consume();
        }
            
        
    }
    
    /*
    * The events to run when a key is released
    */
    @Override
    public void keyReleased(KeyEvent e)
    {
        // Also set the velocity direction
        s1.getBall().setVelocityDirection("");
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
    * It runs on a seperate thread
    */
    @Override
    public void run()
    {
        // Continuously repaint the window and set rec values
        // Also, check if the score has reached the limit. either player gets a score of 5 to win.
        // And check if the opponent buttons have been pressed or not.
        while(isRunning)
        {
            f1.repaint();
            s1.setRecValues();
            
            // Set the user and opponent score
            
            
            // Check the score for each player
            if(s1.getBall().getScoreUser() == 5)
            {
                // User wins
                s1.setWinner("You win!");
                isRunning = false;
                s1.getBall().setIsRunning(false);
            }
            else
            if(s1.getBall().getScoreOpponent() == 5)
            {
                // Opponent wins
                s1.setWinner("You Lose!");
                isRunning = false;
                s1.getBall().setIsRunning(false);
            }
            
            if(opponentRightButtonDown)
            {
                // Change the angle accordingly
                s1.getBall().setAngle((s1.getOpponentPaddle().getPaddleSpeed()  / 10) - 1 );

                // Move the opponent paddle to the right
                s1.getOpponentPaddle().moveX(s1.getOpponentPaddle().getPaddleSpeed());

                // Also set the velocity direction
                s1.getBall().setVelocityDirection("right");


                f1.repaint();
                
                // Set it back to false.
                opponentRightButtonDown = false;
  
            }
            
            if(opponentLeftButtonDown)
            {
                // Change the angle accordingly
                s1.getBall().setAngle((s1.getOpponentPaddle().getPaddleSpeed()  / 10) - 1 );

                // Move the opponent paddle to the left
                s1.getOpponentPaddle().moveX(-(s1.getOpponentPaddle().getPaddleSpeed()));

                // Also set the velocity direction
                s1.getBall().setVelocityDirection("left");

                // Now increase the paddle speed if possible
                if(s1.getOpponentPaddle().getPaddleSpeed() >= 60)
                {
                    // Set to 60
                    s1.getOpponentPaddle().setPaddleSpeed(60);
                }
                else
                {
                    s1.getOpponentPaddle().setPaddleSpeed((s1.getOpponentPaddle().getPaddleSpeed()) + 3);
                }


                f1.repaint();
                
                opponentLeftButtonDown = false;
            
            }
        }
    }
   
    
    
    /*
    * A test method
    */
    public static void main(String[]args)
    {
        Table PongTable = new Table(false);
        
        
        Thread screenThread = new Thread(PongTable);
        
        screenThread.start();
        
        
    }
    
    
    
}
