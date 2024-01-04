import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class enter extends Actor
{
    private GreenfootImage originalImage = null;
    private int originalWidth;
    private int originalHeight;
    
    private double scalePercentage;
    private int newWidth;
    private int newHeight;
    public enter (){
        scalePercentage = 0.6;
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
    /**
     * Act - do whatever the enter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     // Add your action code here.
    }    
}

