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
    
    GreenfootImage back;
    GreenfootImage back_flop;
    int back_dx = -1; // スクロール速度(マイナスにすると左から右)
    int back_x = 0;
    int back_width;
    boolean flop = false;
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
        Greenfoot.playSound("stage.mp3");
        initializeSpawnPatterns();
        
        back = new GreenfootImage( "./images/雲海夜景.jpg" );
        back_flop = new GreenfootImage( "./images/雲海反転夜景.jpg" );
        back_width = back.getWidth();
    }
    
    public void act(){
        timer++;
        spawnEnemy();
        
        back_x += back_dx;
        if( back_x > 0){
            back_x -= back_width;
            flop = !flop;
        }
        if( back_x < -back_width ){
            back_x += back_width;
            flop = !flop;
        }
        getBackground().drawImage( flop ? back_flop : back, back_x, 0 );
        getBackground().drawImage( flop ? back : back_flop, back_x+back_width, 0 );
    
    }
    
    // control spawning.
    private void initializeSpawnPatterns(){
        //wave1
        spawnPatterns.add(new SpawnPattern(0, 0, 100, 100, 1, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 50, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 70, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 90, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 110, true));
        //wave2
        spawnPatterns.add(new SpawnPattern(1, 2, 700, 200, 150, false));
        spawnPatterns.add(new SpawnPattern(1, 2, 700, 200, 170, false));
        spawnPatterns.add(new SpawnPattern(1, 2, 700, 200, 190, false));
        spawnPatterns.add(new SpawnPattern(1, 2, 700, 200, 210, false));
        //wave3
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 100, 270, false));
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
                case 2: //Enemy_02
                    addObject(new Enemy_02(pattern, drop_item), spawnX, spawnY);
                break;
                }
                countSpawnTable++;           
            }
        }
    }
}
