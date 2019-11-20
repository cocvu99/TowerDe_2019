package TowerDefense.GamePlay;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundLoader {

    public static void play(String name) {
        try {
            File f = new File("res/sound/" + name);
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void loop(String name) {
        try {
            File f = new File("res/sound/" + name);
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
