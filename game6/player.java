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
    int speed=3;
    int count=-1;
    public void act() 
    {
        int x = getX();
        int y = getY();
        
        setRotation(270);
        if( Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-speed+1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+speed-1,y );
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-speed );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+speed );
        }
        
        if( flag_tama > 0 ) flag_tama--;
        if( Greenfoot.isKeyDown( "space" ) ){
            Greenfoot.playSound("8bitshot3.mp3");
            if( flag_tama == 0 ){
                getWorld().addObject( new TAMA(), getX(), getY() );
                flag_tama = 9;
            }
        }
        
        Actor actor = getOneIntersectingObject( item01.class );
        
        if( actor != null ){
            getWorld().removeObject( actor );
            count++;
            if(count%2==0){
                speed=3;
                getWorld().addObject( new sub(), getX()-20, getY()+40 );
            }else if(count%2==1){
                speed=5;
            }
            
        }    
    }    
}
 

