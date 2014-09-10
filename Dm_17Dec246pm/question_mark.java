import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class question_mark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class question_mark extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;   
    private GreenfootImage image3;
    /**
     * Act - do whatever the question_mark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public question_mark()
    {
        image1 = new GreenfootImage("question1.png");
        image2 = new GreenfootImage("question2.png");
        image3 = new GreenfootImage("question3.png");
        setImage(image1);
    }
    public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }
        else if(getImage()==image2)
        {
            setImage(image3);
        }
        else
        {
            setImage(image1);
        }
    }  
    public void act()
    {
        switchImage();
    }
}
