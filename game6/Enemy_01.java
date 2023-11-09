import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_01 extends Actor
{
    //status
    private int health;
    private int speed;
    private int timer;
    private int pattern;
    
    //image
    private GreenfootImage originalImage = null;
    private int originalWidth;
    private int originalHeight;
    
    private double scalePercentage;
    private int newWidth;
    private int newHeight;
    
    
    public Enemy_01(int pattern) {
        //parameter
        health = 1;
        speed = 3;
        scalePercentage = 0.1;
        this.pattern = pattern;
        
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
        getDamage();
        checkBoundary();
        
        int x = getX();
        int y = getY();
        
        move_pattern(x, y, timer, pattern);
        timer++;
    }
    
    // function of move a enemy.
    private void move_pattern(int x, int y, int timer, int pattern){
        switch(pattern){
        case 1:
            if(timer < 50){
                setLocation( x-speed,y );
            }else if(timer < 100){
                setLocation( x+speed,y+speed);
            }
        break;
        }
    }
    
    // function of checking enemy status.
    
    private void getDamage(){
        Actor hit_player = getOneIntersectingObject(player.class);
        if(hit_player != null){
            getWorld().removeObject(hit_player);
        }
    }
    
    private void checkBoundary(){
        if(getX() > getWorld().getWidth()){
            getWorld().removeObject(this);
        }
    }
}
