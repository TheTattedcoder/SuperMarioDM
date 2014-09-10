import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mario extends Mover

{
    //  you should have enough DATA FIELDS to describe the complete
    //  state of Mario at any given time
    private static final int jumpStrength = 18;
    private GreenfootImage image1;
    private GreenfootImage image2;   
    private GreenfootImage image3;
    private GreenfootImage image4;
    
    // eliminate any of these that end being redundant
    private boolean isMarioOnGround; // if not then you'd check for jumping / falling
    private boolean isMarioJumping; // if not, assume falling?
    private boolean isMarioOnTop;
    private boolean isMarioHit; // horizontal? or from below?
    
    private boolean isMarioHitFromAbove;
    private boolean isMarioHitFromTheSide;
    
    // go back and look at some of the other scenarios to see
    // how they model the state of an object
    private final int STATIONARY = 0;
    private final int FACING_LEFT = 1;
    private final int FACING_RIGHT = 2;
    private final int JUMPING = 3;
    private final int FALLING = 4;
    

    public mario()
    {
        // rename all of your images so that they precisely describe the pose that is depicted
        // e.g., use something like "marioLeftPose1.gif", "marioLeftPose2.gif" 
        image1 = new GreenfootImage("mario 1.gif");
        image2 = new GreenfootImage("mario1.gif");
        image3 = new GreenfootImage("mario_left.gif");
        image4 = new GreenfootImage("mario_move2.gif");
        
        // also consider using the mirrorHorizontally() method (see the GreenfootImage class)
        setImage(image1);
        isMarioJumping = false;
        isMarioOnTop = false;
        isMarioHit = false;
    }

    /**
     * Act - do whatever the mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act(){

        checkFall();
        checkKeys();
        correctYPosition();
        correctYPosition2();
        correctYPosition3();
        correctYPosition4();



        if ( isMarioJumping ) {
            tryBreakingBlock();

        }
        if(isMarioOnTop){
            landOnQuestionMark();
        }
        if(isMarioHit){
            checkMarioHit();
        }

    }

    public int getSpeed()
    {
        return (int) (getMovement().getLength() * 10);
    }

    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            switchImage();
            move(4);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            switchImage2();
            move(-4);

        }
        if(Greenfoot.isKeyDown("space"))
        {
            setImage("mario_jump.gif");
            if(onGround())
                jump();
            if(headBump())
                jump2();

        }
        if(Greenfoot.isKeyDown("down"))
        {
            setImage("mario_duck.gif");
        }
    }  

    /**
     * Alternate the crab's image between image1 and image2.
     */
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

    public void switchImage2()
    {
        if(getImage()== image3)
        {
            setImage(image4);
        }
        else
        {
            setImage(image3);
        }
    }

    private void jump()
    {
        isMarioJumping = true;
        setVSpeed(-jumpStrength);
        fall();
    }

    private void jump2()
    {
        isMarioJumping = true;
        setVSpeed(jumpStrength-9);
        fall();
    }

    private void checkFall()
    {
        if (onGround()) {
            setVSpeed(0);
            isMarioJumping = false;
            isMarioOnTop = true;
        }
        else {
            fall();
        }
    }

    public void correctYPosition() {
        Actor groundAroundMario = getOneIntersectingObject( ground.class );
        
        int thisX = getX();
        int thisY = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            thisY -= 4;
            setLocation( thisX, thisY );
        }
    }
    public void correctYPosition4() {
        Actor groundAroundMario = getOneIntersectingObject( pipe.class );
        
        int thisX = getX();
        int thisY = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            thisY -= 8;
            setLocation( thisX, thisY );
        }
    }

    public void correctYPosition2() {
        Actor groundAroundMario = getOneIntersectingObject( platform.class );
        int X = getX();
        int Y = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            Y -= 4;
            setLocation( X, Y );
        }

    }

    public void correctYPosition3() {
        Actor groundAroundMario = getOneIntersectingObject( question_mark.class );
        int X = getX();
        int Y = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            Y -= 4;
            setLocation( X, Y );
        }

    }

    public boolean headBump()
    { 
        Actor groundAroundMario = getOneIntersectingObject( platform.class );
        int X = getX();
        int Y = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            Y +=4;
            setLocation( X, Y );
        }
        return ( groundAroundMario != null );
    }

    public boolean headBump2()
    { 
        Actor groundAroundMario = getOneIntersectingObject( question_mark.class );
        int X = getX();
        int Y = getY();
        // TODO: Check to see if "if" or "while" works better here
        if ( groundAroundMario != null ) {
            Y +=4;
            setLocation( X, Y ); 
            return true;
        }
        else{

            return false;
        }
    }

    public void tryBreakingBlock() {
        // check for a platform or other breakable block overhead
        Actor hitQuestionBlock = getOneObjectAtOffset( 0, -14, question_mark.class );
        Actor groundAroundMario = getOneIntersectingObject( question_mark.class );
        int X = getX();
        int Y = getY();
        if ( hitQuestionBlock != null ) {
            Y +=4;
            setLocation( X, Y );
            if(headBump2()){
                jump2();
                getWorld().removeObject( hitQuestionBlock );

            }
        }
    }
        public void landOnQuestionMark() {
            Actor groundAroundMario = getOneIntersectingObject( question_mark.class );
            
            int X = getX();
            int Y = getY();
            // TODO: Check to see if "if" or "while" works better here
            if ( groundAroundMario != null ) {
                Y -= 4;
                setLocation( X, Y );
            }

        }
        public void checkMarioHit(){
            Actor hitTurtle = getOneObjectAtOffset( 0, 14, turtle2.class );
            Actor superMario = getOneIntersectingObject( mario.class );
            
           int X = getX();
           int Y = getY();
           if (hitTurtle != null){
               getWorld().removeObject(superMario);
        }

    }
}

