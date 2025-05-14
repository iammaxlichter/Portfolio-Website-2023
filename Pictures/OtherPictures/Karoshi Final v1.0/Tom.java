import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tom extends Actor
{
    private World level;
    private double hSpeed = 0;
    private int vSpeed = 5; 
    private int tomHealth = 3;
    private int xdir = 1;
    private int ydir = 0;
    private int accel = 1; 
    private int jumpStren = -22; 
    private int invincTime;
    private boolean onGround; 
    private boolean Invincible = false;
    private boolean isHit = false;
    private long lastAdded  = System.currentTimeMillis();
    private long lastHitTime;
    GreenfootImage[] idleRight = new GreenfootImage[2]; 
    GreenfootImage[] idleLeft = new GreenfootImage[2];
    GreenfootImage[] runRight = new GreenfootImage[8];
    GreenfootImage[] runLeft = new GreenfootImage[8];
    GreenfootImage[] jumpingRight = new GreenfootImage[1];
    GreenfootImage[] jumpingLeft = new GreenfootImage[1];
    GreenfootImage[] fallingRight = new GreenfootImage[1];
    GreenfootImage[] fallingLeft = new GreenfootImage[1];
    private int animationCounter = 0;
    public int score;
    GreenfootSound L1Music = new GreenfootSound("level1music.mp3");
    GreenfootSound L2Music = new GreenfootSound("level2music.mp3");
    
    public Tom(World w){
        level = w;
        initAnimationSprites(); 
        score = 0; 
    }
    
    /**
     * Act - do whatever the Tom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        pause();
        checkKeys();
        checkFalling();
        checkCollision();
        checkDamage();
        invincTimer();
        checkAttack();
        checkCoins();
        checkWin();
    }
    
       public void pause()
    {
        if(Greenfoot.isKeyDown("p"))
        {
            PauseMenu pauseMenu = new PauseMenu(level);
            Greenfoot.setWorld(pauseMenu);
        }
    }
    
        public void checkKeys(){
        if(Greenfoot.isKeyDown("right")){
            moveRight();
            if(Greenfoot.isKeyDown("space") && onGround){
                animateJumpingRight();
            }
            else{
                animateRunRight();
            }
        }
        
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
            if(Greenfoot.isKeyDown("space") && onGround){
                animateJumpingLeft();
            }
            else{
                animateRunLeft();
            }
        }
        
        if(!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")){
            if(hSpeed > 0){
                hSpeed -= .2; 
            }
        }
        
        if(Greenfoot.isKeyDown("space") && onGround){
            jump();
            ydir = 1;
            onGround = false;
        }

        if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("space")){
            if(xdir == 1){
                animateIdleRight();
            }
            else if(xdir == -1){
                animateIdleLeft();
            }
        }
    }
    
    public void moveRight(){
        if(hSpeed < 5){
                hSpeed+=.45;
            }
        setLocation(getX() + (int)hSpeed, getY());
        animateRunRight();
        xdir = 1;
        ydir = 0;
    }
    
    public void moveLeft(){
        if(hSpeed < 5){
                hSpeed+=.45;
            }
        setLocation(getX() - (int)hSpeed, getY());
        animateRunLeft();
        xdir = -1;
        ydir = 0;
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed += accel; 
        ydir = -1;
        if(xdir == 1){
            animateFallingRight();
        }
        else if(xdir == -1){
            animateFallingLeft();
        }
    }
    
    public void jump() {
        vSpeed = jumpStren;
        if(xdir == 1) {
            animateJumpingRight();
        }
        else if(xdir == -1) {
            animateJumpingLeft();
        }
        fall();
    }

        
    
        private void checkFalling() {
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

    
    private void checkCollision(){
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
    private void checkAttack() {
        if (isTouching(Bushly.class) || isTouching(Dino.class)) {          
            if (vSpeed > 0) { 
                removeTouching(JumpableEnemies.class);
                vSpeed = -10; 
                Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
                score ++;
                counter.setValue(score);
            }
        }
         if (isTouching(Boss.class)) { 
            if(vSpeed > 0){
            vSpeed = -18;
            Boss.removeHealth();
            if(Boss.getHealth() == 0){
                removeTouching(Boss.class); 
                hSpeed -= 6;
                Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
                score += 5;
                counter.setValue(score);
            }
          } 
        
        }
    }

    private void checkDamage(){
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, JumpableEnemies.class) != null 
            || getOneObjectAtOffset (getImage().getWidth()/2, 0, JumpableEnemies.class) != null) 
        {
            if (!Invincible) {
                tomHealth--;
                hSpeed = -6;
                Invincible = true;
                isHit = true;
                lastHitTime = System.currentTimeMillis();
            }
        }
        if(this.getWorld().getClass() == LevelOne.class){
            L1Music.setVolume(30);
            L1Music.playLoop();
            
            if(tomHealth == 3){
                ((LevelOne) getWorld()).healthBar.setImage("ThreeHealth.png");
            }
            else if(tomHealth == 2){
                ((LevelOne) getWorld()).healthBar.setImage("TwoHealth.png");
            }
            else if(tomHealth == 1){
                ((LevelOne) getWorld()).healthBar.setImage("OneHealth.png");
            }
            else if(tomHealth == 0){
                L1Music.pause();
                Greenfoot.setWorld(new GameOver(1, score));
            }
    }
        if(this.getWorld().getClass() == LevelTwo.class){
            L2Music.setVolume(30);
            L2Music.playLoop();
            if(tomHealth == 3){
                ((LevelTwo) getWorld()).healthBar.setImage("ThreeHealth.png");
            }
            else if(tomHealth == 2){
                ((LevelTwo) getWorld()).healthBar.setImage("TwoHealth.png");
            }
            else if(tomHealth == 1){
                ((LevelTwo) getWorld()).healthBar.setImage("OneHealth.png");
            }
            else if(tomHealth == 0){
                L2Music.pause();
                Greenfoot.setWorld(new GameOver(2, score));
            }
    }
}

    public void checkCoins(){
        if(isTouching(Coin.class)){
            removeTouching(Coin.class);
            Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
            score++;
            counter.setValue(score);
        }
    }
    
    public void invincTimer(){
        if (isHit) {
            long curTime = System.currentTimeMillis();
            if (curTime <= lastHitTime + 2000) {
                Invincible = true;
            } else {
                Invincible = false;
                isHit = false;
            }
        }
    }
    
    
    public void initAnimationSprites(){
        for(int i = 0; i < 2; i++){
            String fileName = "tomIdle"+i+".png";
            idleRight[i] = new GreenfootImage(fileName);
        }
        
        for(int i = 0; i < 2; i++){
            String fileName = "tomIdle"+i+".png";
            idleLeft[i] = new GreenfootImage(fileName);
            idleLeft[i].mirrorHorizontally();
        }
        
        for(int i = 0; i < 8; i++){
            String fileName = "run"+i+".png";
            runRight[i] = new GreenfootImage(fileName);
        }
        
        for(int i = 0; i < 8; i++){
            String fileName = "run"+i+".png";
            runLeft[i] = new GreenfootImage(fileName);
            runLeft[i].mirrorHorizontally(); 

        }
        
        for(int i = 0; i < 1; i++){
            jumpingRight[i] = new GreenfootImage("Jumping0.png");
        }
        
        for(int i = 0; i < 1; i++){
            jumpingLeft[i] = new GreenfootImage("Jumping0.png");
            jumpingLeft[i].mirrorHorizontally();
        }
        for(int i = 0; i < 1; i++){
            fallingRight[i] = new GreenfootImage("falling0.png");
        }
        for(int i = 0; i < 1; i++){
            fallingLeft[i] = new GreenfootImage("falling0.png");
            fallingLeft[i].mirrorHorizontally();
        }
    }
    
    public void animateIdleRight(){
        long curTime = System.currentTimeMillis();

        setImage(idleRight[animationCounter % 2]);
        if(curTime >= lastAdded + 600){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
    
    public void animateIdleLeft(){
        long curTime = System.currentTimeMillis();

        setImage(idleLeft[animationCounter % 2]);
        if(curTime >= lastAdded + 600){
            animationCounter ++;
            lastAdded = curTime; 
        }
        
    }
    
    public void animateRunRight(){
        long curTime = System.currentTimeMillis();

        setImage(runRight[animationCounter % 8]);
        if(curTime >= lastAdded + 195){
            animationCounter ++;
            lastAdded = curTime; 
        }
    }
    
    public void animateRunLeft(){
        long curTime = System.currentTimeMillis();

        setImage(runLeft[animationCounter % 8]);
        if(curTime >= lastAdded + 195){
            animationCounter ++;
            lastAdded = curTime;
        }
    }
    
    public void animateJumpingRight(){
        setImage(jumpingRight[animationCounter % 1]);
    }
    
    public void animateJumpingLeft(){
        setImage(jumpingLeft[animationCounter % 1]);
    }
    
    public void animateFallingRight(){
        long curTime = System.currentTimeMillis();

        setImage(fallingRight[animationCounter % 1]);
        if(curTime >= lastAdded + 195){
            animationCounter ++;
            lastAdded = curTime;
        }
    }
    
    public void animateFallingLeft(){
        long curTime = System.currentTimeMillis();

        setImage(fallingLeft[animationCounter % 1]);
        if(curTime >= lastAdded + 195){
            animationCounter ++;
            lastAdded = curTime;
        }
    }
    
        public void checkWin(){
            if(isTouching(Goal.class) && Boss.getHealth() == 0){
                Greenfoot.setWorld(new LevelCleared(score));
                L1Music.pause();
                L2Music.pause();
            }
    }
}
