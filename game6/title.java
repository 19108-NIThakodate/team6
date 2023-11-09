import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class title extends World
{

    /**
     * Constructor for objects of class title.
     * 
     */
    public title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public void act()
{
    if( Greenfoot.isKeyDown( "space" ) ){
         World game = new game();
        Greenfoot.setWorld( game );
    }
}
}
