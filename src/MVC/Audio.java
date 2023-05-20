package MVC;

import javax.sound.sampled.*;
import java.io.IOException;

public  class Audio {
    private Clip clip;
    private static Audio instance;

    private Audio(){
    }
    public static Audio getInstance() {

        if (instance == null) {
            instance = new Audio();
        }
        return instance;
    }
    public  void playMusic(String audioLocation){
        try {
            AudioInputStream input= AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(audioLocation));;
            clip=AudioSystem.getClip();
            clip.open(input);
            
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERORR");
            ex.printStackTrace();
                        System.out.println("ERORR");

        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
                        System.out.println("ERORR");

        }
    }
    public void stop(){ clip.stop();}
    public void resume(){
    clip.start();
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}

