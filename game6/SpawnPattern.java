/**
 * Write a description of class SpawnPattern here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpawnPattern  
{
    private int enemyType;
    private int pattern;
    private int spawnX;
    private int spawnY;
    private int spawnTime;
    private boolean drop_item;
    
    public SpawnPattern(int enemyType, int pattern, int spawnX, int spawnY, int spawnTime, boolean drop_item)
    {
        this.enemyType = enemyType;
        this.pattern = pattern;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.spawnTime = spawnTime;
        this.drop_item = drop_item;
    }
    
    public int getEnemyType(){
        return enemyType;
    }
    
    public int getPattern(){
        return pattern;
    }
    
    public int getSpawnX(){
        return spawnX;
    }
    
    public int getSpawnY(){
        return spawnY;
    }
    
    public int getSpawnTime(){
        return spawnTime;
    }
    
    public boolean getDrop_item(){
        return drop_item;
    }
}
