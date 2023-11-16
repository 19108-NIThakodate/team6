import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
   
    private int flag_tama = 0;
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        setRotation(270);
        if( Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-2,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+2,y );
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-4 );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+4 );
        }
        if( Greenfoot.isKeyDown( "space" ) ){
            setRotation(0);
            move(1);
        }
        if( flag_tama > 0 ) flag_tama--;
        if( Greenfoot.isKeyDown( "space" ) ){
            Greenfoot.playSound("8bitshot3.mp3");
            if( flag_tama == 0 ){
                getWorld().addObject( new TAMA(), getX(), getY() );
                flag_tama = 50;
            }
        }
    }    
}
 

