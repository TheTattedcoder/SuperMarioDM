import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mover extends Actor
{
    private Vector movement = new Vector();
    public double x = 0;
    public double y = 0;
     private static final int acceleration = 2;      // down (gravity)
    private static final int speed = 7;             // running speed (sideways)
    
    private int vSpeed = 0;       
    public Mover() 
    {
    }    
    public Mover(Vector speed)
    {
        movement = speed;
    }
    public void move()
    {
        x = x + movement.getX();
        
        
        if(x >= getWorld().getWidth()) {
            x = 0;
        }
        if(x < 0) {
            x = getWorld().getWidth() - 1;
        }
        if(y >= getWorld().getHeight()) {
            y = 0;
        }
        if(y < 0) {
            y = getWorld().getHeight() + 1;
        }
        setLocation(x, y);
    }
    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }
    
    public void setLocation(int x, int y) 
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector s) 
    {
        movement.add(s);
    }
    
    /**
     * Return the current movement.
     */
    public Vector getMovement() 
    {
        return movement;
    }
    public boolean onGround()
    {
        //Object under = getOneObjectAtOffset(0, getImage().getHeight()/2-2 , null);
       // Actor groundUnderMario = getOneObjectAtOffset(0, 14 , ground.class);
       //return (under != null);
       // return ( groundUnderMario != null );
       
       /*
        * if mario is on the ground
        *   return true
        * else if mario is on a platform
        *   return true
        * else
        *   return
        */
       
       Actor groundUnderMario = getOneObjectAtOffset(0, getImage().getHeight()/2+2 , ground.class);
       Actor questionUnderMario = getOneObjectAtOffset(0, getImage().getHeight()/2+2 , question_mark.class);
       Actor platformUnderMario = getOneObjectAtOffset(0, getImage().getHeight()/2+2 , platform.class);
       return ( groundUnderMario != null || platformUnderMario != null || questionUnderMario != null );
    }
    public void setVSpeed(int speed)
    {
        vSpeed = speed;
    }
    public void fall()
    {
        setLocation ( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        
    }
}
    
