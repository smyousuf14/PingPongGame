/*
 * A class that represents a ball. 
 */
package pingpong;

/**
 *
 * @author Syed Yousuf
 */
public class Ball extends MoveableObject
{
    // Instance Variables
    private double radius;
    
    /*
    * Constructor that creates an object with specific parameters 
    */
    public Ball(int xCoordinate, int yCoordinate, double radius)
    {
        super(xCoordinate, yCoordinate);
        this.radius = radius;
        
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
    * Providing a string representation of this class.
    *
    *@return The string representation of this class
    */
    @Override
    public String toString()
    {
        return "X: " + getX() + " Y: " + getY() + "Radius: " + radius;
    }
    
}
