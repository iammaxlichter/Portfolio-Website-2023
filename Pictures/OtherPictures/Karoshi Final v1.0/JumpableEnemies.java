import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JumpableEnemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JumpableEnemies extends Enemy
{
    private int hSpeed = 5;
    private boolean onGround; 
    private int vSpeed = 1; 
    private int accel = 1; 



    /**
     * Act - do whatever the JumpableEnemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    public void checkFalling() {
        if (!onGround) {
            fall();
        } else if (onGround) {
            if (getOneObjectAtOffset(0, getImage().getHeight() / 2, Terrain.class) == null) {
                onGround = false;
                fall();
            } else {
                vSpeed = 0;
            }
        }
    }   
        public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed += accel; 
        
    }
    public void checkCollision(){
         while (getOneObjectAtOffset (getImage().getWidth()/2, 0, Terrain.class) != null)
        {
            setLocation(getX()-1, getY());

            hSpeed = 0;
        }

        while (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Terrain.class) != null)
        {
            setLocation(getX()+1, getY());

            hSpeed = 0;
        }    
        
        while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, Terrain.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            vSpeed = 0;
        }
        
        
        while (getOneObjectAtOffset (-14, getImage().getHeight()/2 - 2, Terrain.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            vSpeed = 0;
        }

        while (getOneObjectAtOffset (0, -getImage().getHeight()/2+1, Terrain.class)!= null)
        {
            setLocation(getX(), getY()+1);
            vSpeed = 0;
        }
    }
}
