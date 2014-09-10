/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
 double dx = 10;
   
    int direction = 10;
    double length;
    
    public Vector()
    {
    }

    public Vector(int direction, double length)
    {
       this.length = length;
       this.direction = direction;
       dx = length * Math.sin(Math.toRadians(direction));
       
    }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(int direction) {
        this.direction = direction;
        dx = length * Math.sin(Math.toRadians(direction));
         
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) {
        dx += other.dx;
        
        this.direction = (int) Math.toDegrees(Math.atan2(1, dx));
        this.length = Math.sqrt(dx*dx+1);
    }   
    
    /**
     * Return the x offset of this vector.
     */
    public double getX() {
        return dx;
    }
     
    /**
     * Return the y offset of this vector.
     */
    
    
    /**
     * Return the current direction (in degrees).
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * Return the current length of the vector.
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() {
        Vector copy = new Vector();
        copy.dx = dx;
      
        copy.direction = direction;
        copy.length = length;
        return copy;
    }    
    
}
