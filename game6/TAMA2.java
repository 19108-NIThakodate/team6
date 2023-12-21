import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TAMA2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TAMA2 extends Actor
{
    /**
     * Act - do whatever the TAMA2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isDestroyed = false;

    public void act() {
        if(!isDestroyed){
        int x = getX();
        int y = getY();
        setLocation(x + 10, y - 4);

        if (isAtEdge() && !isDestroyed) {
            getWorld().removeObject(this);
            isDestroyed = true;
        }

        checkCollision();
        }
    }

    private void checkCollision() {
        if(!isDestroyed){
        Actor enemy = getOneIntersectingObject(Enemy.class);

        if (enemy != null && !isDestroyed) {
            getWorld().removeObject(this);
            isDestroyed = true;
        }
        }
    }    
}
