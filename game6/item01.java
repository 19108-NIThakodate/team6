import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class item01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class item01 extends Item
{
    /**
     * Act - do whatever the item01 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation( x-2,y );
        if( isAtEdge() ){
            getWorld().removeObject( this );
        }
    }    
}
