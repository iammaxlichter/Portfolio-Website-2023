import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound backgroundMusic = new GreenfootSound("mainMusic.mp3");
    boolean Active = true;
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        backgroundMusic.setVolume(30);
        
        if(Active){
            backgroundMusic.playLoop();
            Active = false;
        }
        if(Greenfoot.mouseClicked(this)){
            if(backgroundMusic.isPlaying()){
                backgroundMusic.pause();
                setImage("musicButtonOff.png");
            }
            else {
                backgroundMusic.playLoop();
                setImage("musicButtonOn.png");
            }
        }
    }
}
