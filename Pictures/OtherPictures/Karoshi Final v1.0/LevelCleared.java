import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCleared here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCleared extends World
{

    /**
     * Constructor for objects of class LevelCleared.
     * 
     */
    public LevelCleared(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 693, 1); 
        Button levelSelectButton = new Button("levelSelectButton.png",new LevelSelect());
        addObject(levelSelectButton, 300, 400);
        
        Button mainMenuButton = new Button("mainMenuButton.png",new StartScreen());
        addObject(mainMenuButton, 600, 400);
        
        
        Counter finalScore = new Counter();
        finalScore.setValue(score);
        addObject(finalScore, 100, 100);
    }
}
