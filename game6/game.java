import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class game extends World
{
    private int timer;
    private int countSpawnTable;
    private ArrayList<SpawnPattern> spawnPatterns = new ArrayList<>();
    
    /**
     * Constructor for objects of class game.
     * 
     */
    public game()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        timer = 0;
        countSpawnTable = 0;

        initializeSpawnPatterns();
    }
    
    public void act(){
        timer++;
        
        spawnEnemy();
    }
    
    // control spawning.
    private void initializeSpawnPatterns(){
        spawnPatterns.add(new SpawnPattern(0, 0, 100, 100, 1, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 50, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 70, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 90, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 110, true));
    }
    
    private void spawnEnemy(){
        if(countSpawnTable < spawnPatterns.size()){
            if(spawnPatterns.get(countSpawnTable).getSpawnTime() == timer){
                //write down code of spawning.
                SpawnPattern currentPattern = spawnPatterns.get(countSpawnTable);
                
                int enemyType = currentPattern.getEnemyType();
                int pattern = currentPattern.getPattern();
                int spawnX = currentPattern.getSpawnX();
                int spawnY = currentPattern.getSpawnY();
                boolean drop_item = currentPattern.getDrop_item();
                
                switch(enemyType){
                case 0: //player
                    addObject(new player(), spawnX, spawnY);
                break;
                case 1: //Enemy_01
                    addObject(new Enemy_01(pattern, drop_item), spawnX, spawnY);
                break;
                }
                countSpawnTable++;           
            }
        }
    }
}
