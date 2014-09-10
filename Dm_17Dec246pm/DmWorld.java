import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DmWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DmWorld extends World
{

    /**
     * Constructor for objects of class DmWorld.
     * 
     */
    public DmWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new mario(),10,340);

        addObject(new ground(),595,365);
        addObject(new pipe(),375,337);
         addObject(new turtle(),350,347);
        addObject(new platform(),300,300);
        addObject(new question_mark(),50,300);
        addObject(new question_mark(),475,300);
        addObject(new question_mark(),494,300);
        
        populateWorld();

    }

    public void populateWorld()
    {
        for(int i=0;i<5;i++)
        {
            addObject(new cloud(),Greenfoot.getRandomNumber(200),Greenfoot.getRandomNumber(200));
        }
        for(int i=0;i<6;i++)
        {
            addObject(new monster(),Greenfoot.getRandomNumber(350),Greenfoot.getRandomNumber(200));
        }
        int d = 10;
        int x=595;
        
        for(int i=0;i<=60;i++){
            x-=d;
            int y=365;
            addObject(new ground(),x,y);
            for(int j=0;j<=i;j++){
                y+=d;
                addObject(new ground(),x,y);
            }
        }
        int c = 15;
        int p=300;
        for(int i=0;i<=7;i++){
            p-=c;
            int y=300;
            addObject(new platform(),p,y);

        }
    }
}

