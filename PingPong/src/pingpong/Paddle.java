/*
 * A class that represents a paddle
 */
package pingpong;

/**
 *
 * @author Syed Yousuf
 */
public class Paddle extends MoveableObject
{
    // Instance variables
    private double length;
    private double width;
    
    
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
        super(xCoordinate, yCoordinate);
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
    public double getWidth()
    {
        return width;
    }
    
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
        Paddle p1 = new Paddle(4,5,20.0, 30.0);
        System.out.println(p1);
        p1.setX(3);
        System.out.println(p1);
    }
    
    
    
}
