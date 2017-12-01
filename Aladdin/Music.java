import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Music extends Actor
{
    public static boolean isMusicPlaying=true;
    GreenfootSound myMusic=new GreenfootSound("background.mp3");
    boolean firstTurn=true;
    
    public Music()
    {
        
    }
    
    public Music(String filename)
    {
        myMusic=new GreenfootSound(filename);
    }

    public GreenfootSound getMyMusic()
    {
        return myMusic;
    }
    
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(firstTurn)
        {
            myMusic.playLoop();
            firstTurn=false;
        }
        
        if(AladdinHero.music == false)
        {
            myMusic.pause();
            myMusic=new GreenfootSound("smb_bowserfalls.wav");
            myMusic.play();
            AladdinHero.music = true;
        }
        
        if(AladdinHero.level_qualified == true)
        {
            if( isMusicPlaying==true)
            {
            myMusic.pause();
            myMusic=new GreenfootSound("level_complete.mp3");
            myMusic.play();
            AladdinHero.music = true;
            AladdinHero.level_qualified = false;
        }
        }
        
        if(AladdinHero.game_over == true)
        {
            if( isMusicPlaying==true)
            {
            myMusic.pause();
            myMusic=new GreenfootSound("smb_bowserfalls.wav");
            myMusic.play();
            AladdinHero.music = true;
            AladdinHero.level_qualified = false;
            AladdinHero.game_over=false;
        }
        }

        if(Greenfoot.mouseClicked(this))
        {

            if(myMusic.isPlaying())
            {
                isMusicPlaying=false;
                myMusic.pause();
                setImage("mute.png");
            }
            else
            {
                isMusicPlaying=true;
                myMusic.playLoop();
                setImage("unmute.png");
            }
        }
    }    
}
