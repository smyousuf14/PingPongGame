/*
 * A class that represents a paddle
 */
package pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Syed Yousuf
 */
public class Paddle extends JPanel 
{
    // Instance variables
    private double length;
    private double width;
    private double xCoordinate;
    private double yCoordinate;
    
    
    /*
    * A constructor that creates a paddle with an initial x and y coordinate, as well as setting an initial
    * length and width.
    *
    *@param xCoordinate The initial x coordinate of the paddle
    *@param yCoordinate The initial y coordinate of the paddle
    *@param length The length of the paddle.
    *@param width The width of the paddle.
    */
    public Paddle(int xCoordinate, int yCoordinate, double length, double width)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.length = length;
        this.width = width;
        
    }
    
    /*
    * A getter method which gets the length of this paddle.
    *
    *@return The length of this paddle.
    */
    public double getLength()
    {
        return length;
    }
    
    /*
    * A getter method which gets the width of this paddle.
    *
    *@return The width of this paddle.
    */
    public double getWidthValue()
    {
        return width;
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
        
        g.setColor(Color.BLUE);
        g.fillRect((int)xCoordinate, (int)yCoordinate, (int)width, (int)length);
    }
    */
   
    
    /*
    * Providing a string representation of this class.
    *
    *@return The string representation of this class
    */
    @Override
    public String toString()
    {
        return "X: " + getX() + " Y: " + getY() + " Length: " + length + " Width: " + width;
    }
    
    /*
    * Test Method to test this class
    */
    public static void main(String []args)
    {
        Paddle p1 = new Paddle(40,50,200.0, 300.0);
        /*
        System.out.println(p1);
        p1.setX(3);
        System.out.println(p1);*/
        
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
