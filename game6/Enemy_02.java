import greenfoot.*;

/**
 * Write a description of class Enemy_02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_02 extends Enemy
{
    //status
    private boolean isDestroyed;
    private int health;
    private int speed;
    private int timer;
    private int pattern;
    private boolean drop_item;
    
    //image
    private GreenfootImage originalImage = null;
    private int originalWidth;
    private int originalHeight;
    
    private double scalePercentage;
    private int newWidth;
    private int newHeight;
    
    
    public Enemy_02(int pattern, boolean drop_item) {
        //parameter
        isDestroyed = false;
        health = 3;
        speed = 5;
        scalePercentage = 0.1;
        this.pattern = pattern;
        this.drop_item = drop_item;
        
        timer = 0;
        
        //original
        originalImage = new GreenfootImage( getImage() );
        
        originalWidth = originalImage.getWidth();
        originalHeight = originalImage.getHeight();
        
        getImage().scale(originalWidth, originalHeight);
        //scaled
        newWidth = (int)(originalWidth * scalePercentage);
        newHeight = (int)(originalHeight * scalePercentage);
        
        GreenfootImage scaledImage = new GreenfootImage(originalImage);
        scaledImage.scale(newWidth, newHeight);
        setImage(scaledImage);
    }
    
    public void act() {
        if(!isDestroyed){
        int x = getX();
        int y = getY();
        
        move_pattern(x, y, timer, pattern);
        timer++;
        
        if (isAtEdge() && !isDestroyed) {
            getWorld().removeObject(this);
            isDestroyed = true;
        }
        getDamage();
        }
    }
    
    // function of move a enemy.
    private void move_pattern(int x, int y, int timer, int pattern){
        switch(pattern){
        case 1:
            if(timer < 40){
                trackPlayer();
            }else{
                setLocation( x-speed, y );
            }
        break;
        }
    }
    
    // function of move
    private void trackPlayer(){
        player subject = (player)getWorld().getObjects(player.class).get(0);
        
        int subjectY = subject.getY();
        
        setLocation( getX()-speed, subjectY );
    }
    
    // function of checking enemy status.
    
    private void getDamage(){
        if(!isDestroyed){
        Actor hit_bullet = getOneIntersectingObject(TAMA.class);
        Actor hit_bullet2 = getOneIntersectingObject(TAMA2.class);
        if(hit_bullet != null || hit_bullet2 != null){
            health--;
            if( !isDestroyed && health <= 0 ){
                if(drop_item){
                    //addObject();
                    getWorld().addObject(new item01(), getX(), getY());
                }
                
                getWorld().removeObject(this);
                Sound_explosion.play();
                
                isDestroyed = true;
            }else if(!isDestroyed){
                Sound_hit.play();
            }
        }
        }
    }
}
