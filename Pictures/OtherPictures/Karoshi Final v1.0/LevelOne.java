import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends ScrollWorld
{
    public Health healthBar;

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {
        super(960, 793, 1, 4000, 991);

        //Create Ground along the entire level
        addObject(new GrassGround(), -1350, 861);
        addObject(new GrassGround(), -960, 861);
        addObject(new GrassGround(), -320, 861);

        addObject(new DirtGround(), 320, 861);
        addObject(new DirtGround(), 320, 800);
        addObject(new DirtGround(), 320, 739);
        addObject(new DirtGround(), 320, 678);
        addObject(new DirtGround(), 320, 617);
        addObject(new GrassGround(), 320, 556);

        addObject(new DirtGround(), 960, 861);
        addObject(new DirtGround(), 960, 800);
        addObject(new DirtGround(), 960, 739);
        addObject(new DirtGround(), 960, 678);
        addObject(new DirtGround(), 960, 617);
        addObject(new GrassGround(), 960, 556);

        addObject(new GrassGround(), 1600, 861);
        addObject(new GrassGround(), 2240, 861);
        addObject(new GrassGround(), 2880, 861);

        //Create finish line
        addObject(new Goal(), 2400, 800);
        addObject(new Boss(10,7), 2100, 800);

        //Create Platforming obstacles 
        addObject(new Coin(), -1090, 582);
        addObject(new Brick(), -1090, 650);

        addObject(new Coin(), -1026, 582);
        addObject(new Brick(), -1026, 650);

        addObject(new Coin(), -962, 582);
        addObject(new Brick(), -962, 650);

        addObject(new Coin(), -450, 582);
        addObject(new Brick(), -450, 650);
        addObject(new Coin(), -300, 462);
        addObject(new Brick(), -300, 530);
        addObject(new Coin(), -150, 342);
        addObject(new Brick(), -150, 410);

        addObject(new Coin(), 150, 242);
        addObject(new Brick(), 150, 310);
        addObject(new Coin(), 214, 242);
        addObject(new Brick(), 214, 310);
        addObject(new Coin(), 278, 242);
        addObject(new Brick(), 278, 310);

        addObject(new Coin(), 550, 242);
        addObject(new Brick(), 550, 310);
        addObject(new Coin(), 614, 242);
        addObject(new Brick(), 614, 310);
        addObject(new Coin(), 678, 242);
        addObject(new Brick(), 678, 310);

        addObject(new Coin(), 950, 242);
        addObject(new Brick(), 950, 310);
        addObject(new Coin(), 1014, 242);
        addObject(new Brick(), 1014, 310);
        addObject(new Coin(), 1078, 242);
        addObject(new Brick(), 1078, 310);

        addObject(new Coin(), 1500, 472);
        addObject(new Brick(), 1500, 540);
        addObject(new Coin(), 1700, 472);
        addObject(new Brick(), 1700, 540);
        addObject(new Coin(), 1900, 472);
        addObject(new Brick(), 1900, 540);

        //Spawn enemies
        addObject(new Bushly(), -880, 681);
        addObject(new Bushly(), 200, 380);
        addObject(new Bushly(), 700, 380); 
        
        addObject(new Dino(), -500, 681);
        addObject(new Dino(), 200, 380);
        addObject(new Dino(), 600, 380);
        

        //NPCs
        addObject(new Npcs("kanye", 200, 266),-1350, 710);
        addObject(new Npcs("redbull", 200, 266),100, 400);
        addObject(new Npcs("dwight", 200, 266),1250, 400);
        
        
        //Main Character
        Tom player = new Tom(this);
        setMainActor(player, 250, 300); 
        mainActor.setLocation(-1450, 675);
        GreenfootImage bg = new GreenfootImage("grassBg.png");
        setScrollingBackground(bg);
        
        //Add health bar
        healthBar = new Health();
        addObject(healthBar, getWidth() / 13, 30, false);

        // Add Score counter
        Counter counter = new Counter();
        addObject(counter, getWidth()- 50, 30, false);
    }
}
