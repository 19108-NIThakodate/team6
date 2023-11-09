import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TAMA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TAMA extends Actor
{
    /**
     * Act - do whatever the TAMA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        setLocation( x+10,y );
        if(isAtEdge()){
         getWorld().removeObject( this );
        }
    }    
    
    
}
