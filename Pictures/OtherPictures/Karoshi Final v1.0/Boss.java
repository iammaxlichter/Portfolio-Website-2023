import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends JumpableEnemies{
    GreenfootImage[] walkRight = new GreenfootImage[6]; 
    GreenfootImage[] walkLeft = new GreenfootImage[6]; 
    public int animationCounter = 0;
    public long lastAdded  = System.currentTimeMillis(); 
    public boolean movingRight = false;
    public int hSpeed;
    private int walkDistance = 550;
    private int steps = 0; 
    public static int health;
    int level;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boss(int h, int s){
        health = h;
        hSpeed = s;
        level = level;
        initAnimations();
    }
    public void act(){
        checkFalling();
        checkCollision();
        move();

    } 
    public void move() {
        if (movingRight) {
            setLocation(getX() + hSpeed, getY());
            animateWalkRight();
        } else {
            setLocation(getX() - hSpeed, getY());
            animateWalkLeft();
        }
        
        steps += hSpeed;
        
        if (steps >= walkDistance) {
            steps = 0;
            movingRight = !movingRight;
        }
    }

    public static int getHealth(){
        return health; 
        
    }
    public static void removeHealth(){
        health--; 
        
    }
    public void initAnimations(){
        for(int i = 0; i < 6; i++){
            String fileName = "menace"+i+".png";
            walkRight[i] = new GreenfootImage(fileName);
        }
        for(int i = 0; i < 6; i++){
            String fileName = "menace"+i+".png";
            walkLeft[i] = new GreenfootImage(fileName);
            walkLeft[i].mirrorHorizontally();
        }
    }
    public void animateWalkRight(){
        long curTime = System.currentTimeMillis();
        setImage(walkRight[animationCounter % 6]);
        if(curTime >= lastAdded + 100){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
    public void animateWalkLeft(){
        long curTime = System.currentTimeMillis();
        setImage(walkLeft[animationCounter % 6]);
        if(curTime >= lastAdded + 100){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
}