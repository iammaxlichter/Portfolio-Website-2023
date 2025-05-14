import greenfoot.*;

public class Bossv2 extends Boss {
    private long lastAttacked = System.currentTimeMillis();
    private long attackTime;
    private long lastSpinAnimation = System.currentTimeMillis();
    private int spinAnimationCounter = 0;
    private boolean attacking; 
    GreenfootImage[] spinRight = new GreenfootImage[8];
    GreenfootImage[] spinLeft = new GreenfootImage[8];

    public Bossv2(int h, int s) {
        super(h, s);
        initSpinAnimation();
    }

    public void act() {
        attack();
        checkFalling();
        checkCollision();
        move();
        if(attacking){
            if(movingRight){
                animateSpinRight();
            }
            else{
                animateSpinLeft();
            }
        }
    }

    public void attack() {
        long curTime = System.currentTimeMillis();
        if (curTime >= lastAttacked + 7000) {
            hSpeed *= 2;
            attacking = true;
            lastAttacked = curTime;
        }
    
        if (curTime >= attackTime + 3000) {
            hSpeed = 4;
            attacking = false;
            attackTime = curTime;
        }
        
    }

    public void initSpinAnimation() {
        for (int i = 0; i < 8; i++) {
            String fileName = "roboSpin" + i + ".png";
            spinRight[i] = new GreenfootImage(fileName);
        }
        for (int i = 0; i < 8; i++) {
            String fileName = "roboSpin" + i + ".png";
            spinLeft[i] = new GreenfootImage(fileName);
            spinLeft[i].mirrorHorizontally();
        }
    }

    public void animateSpinRight() {
        long curTime = System.currentTimeMillis();
        setImage(spinRight[spinAnimationCounter % 8]);
        if (curTime >= lastSpinAnimation + 100) {
            spinAnimationCounter++;
            lastSpinAnimation = curTime;
        }
    }

    public void animateSpinLeft() {
        long curTime = System.currentTimeMillis();
        setImage(spinLeft[spinAnimationCounter % 8]);
        if (curTime >= lastSpinAnimation + 100) {
            spinAnimationCounter++;
            lastSpinAnimation = curTime;
        }
    }
}
