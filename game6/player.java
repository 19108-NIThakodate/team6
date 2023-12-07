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
    private int shoot_type = 0;
    int speed=3;
    int count=-1;
    public void act() 
    {
        int x = getX();
        int y = getY();
        
        setRotation(270);
        if( x>=30 && Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-speed+1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+speed-1,y );
        }
        if(Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-speed );
        }
        if(y<=360 && Greenfoot.isKeyDown( "down" )){
            setLocation( x,y+speed );
        }
        
        
        if( flag_tama > 0 ) flag_tama--;
        if( Greenfoot.isKeyDown( "space" ) ){
            Greenfoot.playSound("8bitshot3.mp3");
            if( flag_tama == 0 ){
                getWorld().addObject( new TAMA(), getX(), getY() );
                if(shoot_type==1) 
                    getWorld().addObject( new TAMA2(), getX(), getY() );
                flag_tama = 9;
            }
        }
        
        
        
        Actor actor = getOneIntersectingObject( item01.class );
        if( actor != null ){
            getWorld().removeObject( actor );
            count++;
            if(count==12) count=0;
            if(count%3==0){//add sub
                speed=3;
                shoot_type=0;
                getWorld().addObject( new sub(), getX()-20, getY()+30 );
            }else if(count%3==1){//speed up
                speed=5;
                shoot_type=0;
            }else if(count%3==2){//add range
                speed=3;
                shoot_type=1;
            }
        }    
    }    
}
 

