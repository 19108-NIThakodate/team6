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
        }// Add your action code here.
    }    
}