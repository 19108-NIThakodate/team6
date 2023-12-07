import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sub extends Actor
{
    /**
     * Act - do whatever the sub wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int flag_tama = 0;
    public void act() 
    {
        int x = getX();
        int y = getY();
        int speed = 3;
        if( x>=10 && Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-speed+1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+speed-1,y );
        }
        if( y>=30 &&  Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-speed );
        }
        if( y<=390 && Greenfoot.isKeyDown( "down" ) ){
               setLocation( x,y+speed );
        }
        
        
        
        
        if( flag_tama > 0 ) flag_tama--;
        if( Greenfoot.isKeyDown( "space" ) ){
            if( flag_tama == 0 ){
                getWorld().addObject( new TAMA(), x,y  );
                flag_tama = 9;
            }
        }// Add your action code here.
    }    
}
