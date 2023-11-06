/**
 * Write a description of class SpawnPattern here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpawnPattern  
{
    private String enemyType;
    private String pattern;
    private int spawnX;
    private int spawnY;
    private int spawnTime;
    
    public SpawnPattern(String enemyType, String pattern, int spawnX, int spawnY, int spawnTime)
    {
        this.enemyType = enemyType;
        this.pattern = pattern;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.spawnTime = spawnTime;
    }
    
    public String getEnemyType(){
        return enemyType;
    }
    
    public String getPattern(){
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
}
