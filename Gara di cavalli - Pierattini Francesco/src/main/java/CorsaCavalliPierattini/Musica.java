/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * la classe della musica
 * @author Pioerattini Francesco
 */
import sun.audio.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Musica{
    private static Clip clip; //il file che verrà riprodotto
    private static File file; //il percorso file
    
    /**
     * metodo che avvia la musica
     * @param musica il percorso file della musica
     */
    public static void musica(String musica){
        try{
            file = new File(musica);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){
            System.out.println("Errore");
        }
    }
    
    /**
     * metodo che stoppa la musica
     */
    public static void stopMusica(){
        clip.stop();
    }
}
