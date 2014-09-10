import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class monster extends Mover
{
    private GreenfootImage image1;
    private GreenfootImage image2;  
    /**
     * Act - do whatever the monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public monster()
    {
        this(45);
        image1 = new GreenfootImage("monster.png");
        image2 = new GreenfootImage("monster2.png");
      
      setImage("monster.png");
    }
    public monster(int size)
    {
        this(size, new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    private monster(int size, Vector speed)
    {
        super(speed);
       
    }
    public void act() 
    {
      move();
      switchImage();

    } 
     public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }

        else
        {
            setImage(image1);
        }
    }
}
