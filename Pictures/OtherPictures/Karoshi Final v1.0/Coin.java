import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    GreenfootImage[] spin = new GreenfootImage[4]; 
    private int animationCounter = 0;
    private long lastAdded  = System.currentTimeMillis();

    public Coin(){
        initAnimation();
    }
    public void act()
    {
        // Add your action code here.
        animate();
    }
        public void animate(){
        long curTime = System.currentTimeMillis();

        setImage(spin[animationCounter % 4]);
        if(curTime >= lastAdded + 600){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
    public void initAnimation(){
        for(int i = 0; i < 4; i++){
            String fileName = "coin"+i+".png";
            spin[i] = new GreenfootImage(fileName);
        }
    }
    
}       
