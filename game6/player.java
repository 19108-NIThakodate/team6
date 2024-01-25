import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    private int flag_damage;
    private int shoot_type = 0;
    private GreenfootImage img  = null; 
    int speed=3;
    int count=-1;
    int hp=3;
    public void act() 
    {
        int x = getX();
        int y = getY();
        
        setRotation(270);
        if( x>=30 && (Greenfoot.isKeyDown( "left" ) || Greenfoot.isKeyDown( "a" ) )){
            setLocation( x-speed+1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) || Greenfoot.isKeyDown( "d" ) ){
            setLocation( x+speed-1,y );
        }
        if(Greenfoot.isKeyDown( "up" ) || Greenfoot.isKeyDown( "w" )){
            setLocation( x,y-speed );
        }
        if(y<=360 && (Greenfoot.isKeyDown( "down" ) || Greenfoot.isKeyDown( "s" ))){
            setLocation( x,y+speed );
        }
        
        
        if( flag_tama > 0 ) flag_tama--;
        if( Greenfoot.isKeyDown( "space" ) ){
            
            if( flag_tama == 0 ){
                getWorld().addObject( new TAMA(), getX(), getY() );
                Greenfoot.playSound("8bitshot3.mp3");
                if(shoot_type==1){//shoot speed
                    flag_tama = 9;
                }else{
                    flag_tama=16;
                }
                
                if(shoot_type==2){//naname tama
                    getWorld().addObject( new TAMA2(), getX(), getY() );
                }
            }
        }
        
        
        
        Actor actor = getOneIntersectingObject( item01.class );
        if( actor != null ){
            getWorld().removeObject( actor );
            count++;
            Greenfoot.playSound("get_item.mp3");
            if(count==12) count=0;
            if(count%3==0){//add sub
                speed=3;
                shoot_type=0;
                getWorld().addObject( new sub(), getX()-20, getY()+30 );
            }else if(count%3==1){//speed up
                speed=5;
                shoot_type=1; 
                List<sub> subs = getWorld().getObjects(sub.class);
                for (sub s : subs) {
                    getWorld().removeObject(s);
                }
            }else if(count%3==2){//add range
                speed=3;
                shoot_type=2;
            }
        }    
        
        
        Actor damage1 = getOneIntersectingObject( Enemy_01.class );
        Actor damage2 = getOneIntersectingObject( Enemy_02.class );
        if( flag_damage > 0 ) flag_damage--;
        if(flag_damage ==0){
           if( damage1 != null || damage2 != null){
                 hp--;
                 flag_damage=20;
                 Greenfoot.playSound("8bitdamage.mp3");
           } 
        }
        if(hp==0){
            //getWorld().removeObject( this );
            getWorld().showText( "GAME OVER", 100, 50 );
            Greenfoot.stop();
            Greenfoot.playSound("dead.mp3");
            img = new GreenfootImage( "images/dead.png" ); 
            setImage(img); 
        }
    

    
         
            
    }    
}
 

