import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 693, 1); 
        Text title = new Text("Title.png");
        addObject(title, 480, 150);

        //Create the button that will lead to the level select screen
        Button playButton = new Button("playButton.png",new LevelSelect());
        addObject(playButton, 480, 300);
        
        

    }
}

