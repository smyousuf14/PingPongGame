/*
 * A class that represents a ball. 
 */
package pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Syed Yousuf
 */
public class Ball extends JPanel implements Runnable
{
    // Instance Variables
    private double radius;
    private double xCoordinate;
    private double yCoordinate;
    private double XSpeed;
    private double YSpeed;
    private boolean isRunning;
    
    
    /*
    * Constructor that creates an object with specific parameters 
    */
    public Ball(int xCoordinate, int yCoordinate, double radius)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.radius = radius;
        
        
        // Set the default values of x and y speed
        XSpeed = 0;
        YSpeed = 2;
        
        // Set the isRunning boolean value
        isRunning = true;
        
    }
    
    /*
    * Gets the value of the radius of this ball
    *
    *@return the radius of this ball
    */
    public double getRadius()
    {
        return radius;
    }
    
    /*
    * A getter method which gets the value of the x coordinate
    *
    *@return the x coordinate value of this moveable object
    */
    public double getXValue()
    {
        return xCoordinate;
    }
    
    /*
    * A getter method which gets the value of the y coordinate
    *
    *@return the y coordinate value of this moveable object
    */
    public double getYValue()
    {
        return yCoordinate;
    }
    
    /*
    * A setter method which sets the x coordinate value of the moveable object
    *
    *@param xCoordinate The new x coordinate value
    */
    public void setX(int xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }
    
    /*
    * A setter method which sets the y coordinate value of the moveable object
    *
    *@param yCoordinate The new y coordinate value
    */
    public void setY(int yCoordinate)
    {
        this.yCoordinate = yCoordinate;
    }
    
    /*
    * Move the moveable object in the x direction
    *
    *@param xDisplacement The amount of displacement the object must move in the x direction
    */
    public void moveX(int xDisplacement)
    {
        xCoordinate += xDisplacement;
    } 
    
    /*
    * Move the moveable object in the y direction
    *
    *@param yDisplacement The amount of displacement the object must move in the y direction
    */
    public void moveY(int yDisplacement)
    {
        yCoordinate += yDisplacement;
    }
    
    
    /*
    * The override paint method which will paint this paddle.
    */
    /*@Override 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        // Set a background colour
        this.setBackground(Color.BLACK);
        g.setColor(Color.RED);
        g.fillOval((int)xCoordinate, (int)yCoordinate, (int)(2 * radius), (int)(2 * radius));
        
    }
    */
     /*
    * The method that will run a seperate thread.
    */
    @Override
    public void run()
    {
        /*Move the ball accordingly and make sure to check if it collides with any of the two paddles*/
        while(isRunning)
        {
            //Move the ball with its x and y speeds.
            xCoordinate += XSpeed;
            yCoordinate += YSpeed;
            
            //Pause for a second.
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    
    /*
    * Providing a string representation of this class.
    *
    *@return The string representation of this class
    */
    @Override
    public String toString()
    {
        return "X: " + getX() + " Y: " + getY() + "Radius: " + radius;
    }
    
    /*
    * Test Method
    */
    public static void main(String[]args)
    {
        Ball p1 = new Ball(10,20, 50);
        
        JFrame f1 = new JFrame("Ping Pong");
        f1.setSize(900,900);
        f1.setVisible(true);
        f1.add(p1);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try 
        {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ie) 
        {
            //None.
            
        }
        
        p1.moveX(200);
        
        f1.validate();
        f1.repaint();
        
    }
    
}
