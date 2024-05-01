package hunt.main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[]=new URL[30];
    public Sound(){
        soundURL[0]=getClass().getResource("/res/Sound/BlueBoyAdventure.wav");
        soundURL[1]=getClass().getResource("/res/Sound/coin.wav");
        soundURL[2]=getClass().getResource("/res/Sound/powerup.wav");
        soundURL[3]=getClass().getResource("/res/Sound/unlock.wav");
        soundURL[4]=getClass().getResource("/res/Sound/fanfare.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais= AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}
