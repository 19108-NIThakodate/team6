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
    private int score = 0;
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
        initializeSpawnPatterns();
        Greenfoot.playSound("stage.mp3");
        
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
        
        //showText("BOSSHP:" + score, 100, 20);
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
        spawnPatterns.add(new SpawnPattern(1, 2, 700, 200, 210, true));
        //wave3
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 100, 270, false));
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 50, 320, false));
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 150, 370, true));
        //wave4
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 390, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 410, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 100, 430, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 450, true));
        //wave5
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 479, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 150, 480, true));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 250, 481, false));
        //wave6
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 549, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 250, 550, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 579, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 250, 580, true));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 609, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 250, 610, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 50, 639, false));
        spawnPatterns.add(new SpawnPattern(1, 1, 700, 250, 640, true));
        //wave7
        spawnPatterns.add(new SpawnPattern(3, 1, 700, 250, 900, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 930, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 940, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 950, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 970, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 980, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 990, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1010, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1020, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1030, false));
        
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1100, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1110, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1120, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1130, false));
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 250, 1140, true));
        
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1230, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1240, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1250, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1270, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1280, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1290, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1310, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1320, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1330, false));
        
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1400, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1410, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1420, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1430, false));
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 250, 1440, true));
        
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1530, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1540, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1550, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1570, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1580, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1590, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1610, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1620, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1630, false));
        
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1700, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1710, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1720, false));
        spawnPatterns.add(new SpawnPattern(1, 4, 700, 250, 1730, false));
        spawnPatterns.add(new SpawnPattern(2, 1, 700, 250, 1740, true));
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
                case 3: //Boss_01
                    addObject(new Boss_01(pattern, drop_item), spawnX, spawnY);
                break;
                }
                countSpawnTable++;           
            }
        }
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
