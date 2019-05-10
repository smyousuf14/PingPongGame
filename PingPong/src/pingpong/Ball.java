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
    private String velocityDirection;
    private int time;
    
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
        
        // Set the time
        time = 5;
        
        // Set the velocity direction
        velocityDirection = "";
        
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
    * Gets the value of the velocity direction
    *
    *@return the direction of the velocity
    */
    public String getVelocityDirection()
    {
        return velocityDirection;
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
    * Set the value of the velocity direction.
    *
    *@param newDirection the new direction
    */
    public void setVelocityDirection(String newDirection)
    {
        // only set if "", "left", or "right"
        if(newDirection.equals(""))
        {
            this.velocityDirection = "";
        }
        else
        if(newDirection.equals("right"))
        {
            this.velocityDirection = "right";
        }
        else
        if(newDirection.equals("left"))
        {
            this.velocityDirection = "left";
        }
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
                Thread.sleep(time);
            }
            catch(Exception e)
            {
                
            }
            
            // Now check for collisions with the user rectangle and perform appropriate action.
            if(collisionRecCir(xRec,yRec,recWidth, (recLenght + 50),xCoordinate, yCoordinate, radius))
            {
                // Check if there is any velocity direction involved
                if(velocityDirection.equals(""))
                {
                    YSpeed = - YSpeed;
                }
                else
                if(velocityDirection.equals("right"))
                {
                    // Move diagonal
                    XSpeed = 2;
                    YSpeed = -YSpeed;
                }
                else
                if(velocityDirection.equals("left"))
                {
                    //Move diagonal
                    XSpeed = -2;
                    YSpeed = -YSpeed;
                }
                
            }
            
            // Now check for collisions with the opponent rectangle and perform appropriate actions.
            if(collisionRecCir(xRecOpponent,yRecOpponent,(recWidthOpponent - 50), (recLenghtOpponent + 50),xCoordinate, yCoordinate, radius))
            {
                // Check if there is any velocity direction involved
                if(velocityDirection.equals(""))
                {
                    YSpeed = - YSpeed;
                }
                else
                if(velocityDirection.equals("right"))
                {
                    // Move diagonal
                    XSpeed = 2;
                    YSpeed = -YSpeed;
                }
                else
                if(velocityDirection.equals("left"))
                {
                    //Move diagonal
                    XSpeed = -2;
                    YSpeed = -YSpeed;
                }
                
            }
            
            // Now test for boundary conditions. Assume that the screen is always 900*900
            if(xCoordinate <= 0)
            {
                XSpeed = 2;
                
            }
            
            if(xCoordinate >= 890)
            {
                XSpeed = -2;
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
       /* if((xCir + radiusCir) <= (xRec + lengthRec) && ((xCir - radiusCir) >= xRec))
        {
            isCollision = true;
        }
        
        if(((yCir + radiusCir) <= yRec) &&(yCir - radiusCir) >= (yRec + widthRec) )
        {
            isCollision = true;
        }
        
        */
       
       // If the circle is to the right of the rectangle, check against the right edge
       // If the circle is to the left of the square, check against the left edge
       // If the circle, is above the square, check against the te top edge
       // If the circle is to the below the square, check against the bottom edge
       if(((xCir + radiusCir) <= (xRec + lengthRec)) && ( (xCir + radiusCir) >= xRec )  )
       {
          
           if(((yCir + radiusCir)  > yRec ) && ((yCir + radiusCir) <= (yRec + widthRec)) )
           {
               isCollision = true;
           }
       }
       
       if(((xCir) <= (xRec + lengthRec)) && ( (xCir) >= xRec )  )
       {
          
           if(((yCir + radiusCir)  > yRec ) && ((yCir + radiusCir) <= (yRec + widthRec)) )
           {
               isCollision = true;
           }
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
