import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public LevelSelect(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 693, 1); 
        
        //Create the button to launch level one
        Button levelOneButton = new Button("level1Button.png", new LevelOne());
        addObject(levelOneButton, 320, 346);
        
        //Create the button to launch level two
        Button levelTwoButton = new Button("level2Button.png", new LevelTwo());
        addObject(levelTwoButton, 640, 346);
    }
}
