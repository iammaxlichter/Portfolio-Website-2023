import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Npcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Npcs extends Actor
{
 
    String file_ = "";
    int width_ = 0;
    int height_ = 0;
    
    public void act(){
        player_interaction();
    }
    
    public Npcs(String text_file_, int width_, int height_){
        
        this.width_ = width_;
        this.height_ = height_;
        
        setImage(text_file_+".png");
        getImage().scale(this.width_,this.height_);
        this.file_ = text_file_;
    }
    
    public void player_interaction(){
        if(isTouching(Tom.class)) {          
            setImage(this.file_+"_1.png");
            getImage().scale(this.width_,this.height_);
        }
        else{
            setImage(this.file_+".png");
            getImage().scale(this.width_,this.height_);
        }
    }
        
}