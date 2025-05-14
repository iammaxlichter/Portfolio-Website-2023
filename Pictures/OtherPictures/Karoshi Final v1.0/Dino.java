import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dino extends JumpableEnemies
{
    private boolean movingRight = true;
    private int hSpeed = 3;
    private int walkDistance = 450;
    private int steps = 0;
    GreenfootImage[] runRight = new GreenfootImage[6]; 
    GreenfootImage[] runLeft = new GreenfootImage[6]; 
    public int animationCounter = 0;
    public long lastAdded  = System.currentTimeMillis(); 
    
    public Dino(){
        initAnimations();
    }
    public void act()
    {
        checkFalling();
        checkCollision();
        move();
    }
    
    private void move() {
        if (movingRight) {
            setLocation(getX() + hSpeed, getY());
            animateRunRight();
        } else {
            setLocation(getX() - hSpeed, getY());
            animateRunLeft();
        }
        
        steps += hSpeed;
        
        if (steps >= walkDistance) {
            steps = 0;
            movingRight = !movingRight;
        }
    }
    
    public void initAnimations(){
        for(int i = 0; i < 6; i++){
            String fileName = "dinoRun"+i+".png";
            runRight[i] = new GreenfootImage(fileName);
        }
        for(int i = 0; i < 6; i++){
            String fileName = "dinoRun"+i+".png";
            runLeft[i] = new GreenfootImage(fileName);
            runLeft[i].mirrorHorizontally();
        }
    }
    public void animateRunRight(){
        long curTime = System.currentTimeMillis();
        setImage(runRight[animationCounter % 6]);
        if(curTime >= lastAdded + 100){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
    public void animateRunLeft(){
        long curTime = System.currentTimeMillis();
        setImage(runLeft[animationCounter % 6]);
        if(curTime >= lastAdded + 100){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
}