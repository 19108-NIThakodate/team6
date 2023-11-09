import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TAMA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TAMA extends Actor {
    private boolean isDestroyed = false;

    public void act() {
        if(!isDestroyed){
        int x = getX();
        int y = getY();
        setLocation(x + 10, y);

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

