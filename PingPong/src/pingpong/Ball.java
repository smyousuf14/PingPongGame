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
    
    // User Rectangle value
    private double xRec;
    private double yRec;
    private double recWidth;
    private double recLenght;
    
    // Opponent Rectangle value
    private double xRecOpponent;
    private double yRecOpponent;
    private double recWidthOpponent;
    private double recLenghtOpponent;
    
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
    * Set the values of the rectangle.
    *
    *@param xRec the x of the rectangle
    *@param yRec the y value fo the rectangle
    *@param widthRec the width of rec
    *@param lengthRec the length of rec
    */
    public void setRec(double xRec, double yRec, double widthRec, double lengthRec)
    {
        this.xRec = xRec;
        this.yRec = yRec;
        this.recWidth = widthRec;
        this.recLenght = lengthRec;
    }
    
    /*
    * Set the values of the rectangle.
    *
    *@param xRec the x of the rectangle
    *@param yRec the y value fo the rectangle
    *@param widthRec the width of rec
    *@param lengthRec the length of rec
    */
    public void setRecOpponent(double xRec, double yRec, double widthRec, double lengthRec)
    {
        this.xRecOpponent = xRec;
        this.yRecOpponent = yRec;
        this.recWidthOpponent = widthRec;
        this.recLenghtOpponent = lengthRec;
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
            
            // Now check for collisions with the user rectangle and perform appropriate action.
            if(collisionRecCir(xRec,yRec,recWidth, recLenght,xCoordinate, yCoordinate, radius))
            {
                YSpeed = - YSpeed;
                
            }
        }
    }
    
    /*
    * A collision detection method between a rectangle and circle.
    *
    *@param XRec The x value of the rectangle
    *@param YRec The y value of the rectangle
    *@param WidthRec The width of the rectangle
    *@param LengthRec the length of the rectangle
    *@param XCir The x value of the circle
    *@param YCir the y value of the circle
    *@param RadiusCir the radius of the circle
    *@return isCollide If the rectangle and circle collide
    */
    private boolean collisionRecCir(double xRec, double yRec, double widthRec, 
            double lengthRec, double xCir, double yCir, double radiusCir)
    {
        // Local Variable
        boolean isCollision = false;
        
        // check if the circle is within the boundries of the rectangle.
        if((xCir + radiusCir) <= (xRec + lengthRec) && (xCir - radiusCir) >= xRec)
        {
            isCollision = true;
        }
        
        if(((yCir + radiusCir) <= yRec) &&(yCir - radiusCir) >= (yRec + widthRec) )
        {
            isCollision = true;
        }
        
        
        return isCollision;
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
        Ball p1 = new Ball(5,5, 5);
        
        /*JFrame f1 = new JFrame("Ping Pong");
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
        f1.repaint();*/
        
        p1.setRec(10, 10,2, 2);
        System.out.println(p1.collisionRecCir(5, 5, 2, 2, 5, 5, 5));
        
    }
    
}
