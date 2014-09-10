import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cloud extends Mover
{
    /**
     * Act - do whatever the cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     */

    public cloud()
    {
        this(45);
    }
    
    /**
     * Create an asteroid with a given size and default speed.
     */
    public cloud(int size)
    {
        this(size, new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    
    /**
     * Create an asteroid with a given size size and speed.
     */
    private cloud(int size, Vector speed)
    {
        super(speed);
       
    }
    public void act() 
    {
      move();
      setImage("cloud.png");
       
    }    
    
}
