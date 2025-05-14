import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PauseMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseMenu extends World
{

    /**
     * Constructor for objects of class PauseMenu.
     * 
     */
    public PauseMenu(World level)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 693, 1); 
        Button resume = new Button("resumeButton.png", level);
        addObject(resume, 480, 342);
        Text paused = new Text("paused.png");
        addObject(paused, 480, 150);
    }
}
