import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends ScrollWorld
{
    public Health healthBar;

    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
    {
        super(960, 793, 1, 4000, 4000);
        
        addObject(new SnowGround(), -1450, 861);
        addObject(new SnowGround(), -960, 861);
        addObject(new SnowGround(), -320, 861);
        for(int i = 1; i <= 8; i++)
        {
            addObject(new SnowDirtGround(), -1450 + 320*i, 983);
            addObject(new SnowDirtGround(), -1450 + 320*i, 922);
        }
        for(int i = 1; i <= 2; i++)
        {
            addObject(new SnowDirtGround(), 0 + 320*i, 861);
            addObject(new SnowDirtGround(), 0 + 320*i, 800);
            addObject(new SnowDirtGround(), 0 + 320*i, 739);
            addObject(new SnowDirtGround(), 0 + 320*i, 678);
            addObject(new SnowDirtGround(), 0 + 320*i, 617);
            addObject(new SnowDirtGround(), 0 + 320*i, 556);
            addObject(new SnowDirtGround(), 0 + 320*i, 495);
            addObject(new SnowDirtGround(), 0 + 320*i, 434);
            addObject(new SnowDirtGround(), 0 + 320*i, 373);
            addObject(new SnowGround(), 0 + 320*i, 312);
        }
        
        for(int i = 1; i <= 4; i++)
        {
            addObject(new SnowDirtGround(), 960 + 320*i, 861);
            addObject(new SnowDirtGround(), 960 + 320*i, 800);
            addObject(new SnowDirtGround(), 960 + 320*i, 739);
            addObject(new SnowDirtGround(), 960 + 320*i, 678);
            addObject(new SnowDirtGround(), 960 + 320*i, 617);
            addObject(new SnowDirtGround(), 960 + 320*i, 556);
            addObject(new SnowDirtGround(), 960 + 320*i, 495);
            addObject(new SnowDirtGround(), 960 + 320*i, 434);
            addObject(new SnowDirtGround(), 960 + 320*i, 373);
            addObject(new SnowDirtGround(), 960 + 320*i, 312);
            addObject(new SnowDirtGround(), 960 + 320*i, 251);
            addObject(new SnowDirtGround(), 960 + 320*i, 190);
            addObject(new SnowDirtGround(), 960 + 320*i, 129);
            addObject(new SnowDirtGround(), 960 + 320*i, 68);
            addObject(new SnowDirtGround(), 960 + 320*i, 7);
            addObject(new SnowDirtGround(), 960 + 320*i, -54);
            addObject(new SnowGround(), 960 + 320*i, -115);
        }

        
        addObject(new Brick(), -640, 661);
        addObject(new Brick(), -576, 661);
        addObject(new Brick(), -512, 661);
        addObject(new Brick(), -448, 661);
        addObject(new Brick(), -384, 661);
        addObject(new Brick(), -320, 661);
        addObject(new Brick(), -256, 661);
        addObject(new Brick(), -192, 661);
        
        addObject(new Brick(), -780, 441);
        addObject(new Brick(), -716, 441);
        
        addObject(new Brick(), -540, 301);
        
        addObject(new Brick(), -280, 301);
        
        
        addObject(new Brick(), 280, 100);
        addObject(new Brick(), 344, 100);
        addObject(new Brick(), 408, 100);
        
        addObject(new Brick(), 40, 0);
        addObject(new Brick(), -24, -64);
        addObject(new Brick(), -88, -128);
        
        addObject(new Brick(), 100, -292);
        addObject(new Brick(), 300, -400);
        addObject(new Brick(), 600, -292);
        
        addObject(new Brick(), 1100, -350);
        addObject(new Brick(), 1164, -350);
        addObject(new Brick(), 1228, -350);
        addObject(new Brick(), 1900, -350);
        addObject(new Brick(), 1964, -350);
        addObject(new Brick(), 2028, -350);
        
        addObject(new Goal(), 2450, -178);
        
        // Coins
        int i = 960;
        for(int x = 0; x < 3; x++){
            addObject(new Coin(), -i, 580);
            i += 65;
        }
 
        i = 200;
        for(int x = 0; x < 5; x++){
            addObject(new Coin(), -i, 780);
            i += 65;
        }
        
        i = 0;
        for(int x = 0; x < 3; x++){
            addObject(new Coin(), i, 160);
            i += 65;
        }
        
        addObject(new Coin(), 100, -360);
        addObject(new Coin(), 300, -470);
        addObject(new Coin(), 600, -360);

        i = 1100;
        for(int x = 0; x < 3; x++){
            addObject(new Coin(), i, -420);
            i += 65;
        }
        
        i = 1900;
        for(int x = 0; x < 3; x++){
            addObject(new Coin(), i, -420);
            i += 65;
        }
        
        // Add NPC'S
        addObject(new Npcs("Cars", 300, 366),-1100, 670);
        addObject(new Npcs("Pauly", 300, 366),50, 115);
        addObject(new Npcs("Cockroach", 300, 366),900, -318);         
        // Main Character
        Tom player = new Tom(this);
        setMainActor(player, 250, 300); 
        mainActor.setLocation(-1450, 675);
        GreenfootImage bg = new GreenfootImage("winterBG.png");
        setScrollingBackground(bg);
        
        //Enemies
        addObject(new Bushly(), -1100, 580);
        addObject(new Dino(),-1000, 580);
        addObject(new Bushly(), -900, 580);

        
        addObject(new Dino(),100, 200);
        addObject(new Dino(),500, 200);
        
        addObject(new Dino(), -200, 620);

        
        
        addObject(new Bossv2(11, 4), 1850, -350);
        

        //Add health bar
        healthBar = new Health();
        addObject(healthBar, getWidth() / 13, 30, false);
        
        // Add Score counter
        Counter counter = new Counter();
        addObject(counter, getWidth()- 50, 30, false);
    }
}
