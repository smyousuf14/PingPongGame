/*
 * A moveable object with no defined shape.
 */
package pingpong;

/**
 *
 * @author Syed Yousuf
 */
public abstract class MoveableObject 
{
    // Instance Variables.
    private int xCoordinate;
    private int yCoordinate;
    
    
    /*
    * A constructor the creates a moveable object with inital coordinates.
    *
    *@param xCoordinate The initial x coordinate value of the moveable object
    *@param yCoordinate The initial y coordinate value of the moveable object
    */
    public MoveableObject(int xCoordinate, int yCoordinate)
    {
        // Set the initial x and y coordinate.
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
             
    }
    
    /*
    * A getter method which gets the value of the x coordinate
    *
    *@return the x coordinate value of this moveable object
    */
    public int getX()
    {
        return xCoordinate;
    }
    
    /*
    * A getter method which gets the value of the y coordinate
    *
    *@return the y coordinate value of this moveable object
    */
    public int getY()
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
    
    
}
