import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class turtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class turtle extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;   
    /**
     * Act - do whatever the turtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public turtle()
    {
        image1 = new GreenfootImage("turtle.gif");
        image2 = new GreenfootImage("turtle2.gif");
    }
    public void act() 
    {
       switchImage();
    }    
    public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
            move(-4);
        }

        else
        {
            setImage(image1);
        }
    }
}
