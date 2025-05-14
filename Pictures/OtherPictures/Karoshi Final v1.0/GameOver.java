import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int level, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 693, 1); 
        
        Button levelSelectButton = new Button("levelSelectButton.png",new LevelSelect());
        addObject(levelSelectButton, 300, 500);
        
        Button mainMenuButton = new Button("mainMenuButton.png",new StartScreen());
        addObject(mainMenuButton, 600, 500);
        
        if(level == 1){
        Button retryButton = new Button("retryButton.png" ,new LevelOne());
        addObject(retryButton, 450, 600);
        }
        
        if(level == 2){
        Button retryButton = new Button("retryButton.png" ,new LevelTwo());
        addObject(retryButton, 450, 600);
        }
        
        Counter finalScore = new Counter();
        finalScore.setValue(score);
        addObject(finalScore, 100, 100);
    }
}
