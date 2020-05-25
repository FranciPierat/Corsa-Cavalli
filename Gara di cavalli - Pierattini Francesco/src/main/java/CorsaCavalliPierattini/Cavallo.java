/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * la classe dei cavalli
 * @author Pierattini Francesco
 */
import java.awt.*;
import javax.swing.*;
public class Cavallo extends JPanel{
    int cordx; //coordinata x
    int cordy; //coordinata y
    Image img; //immagine
    
    /**
     * il costruttore che setta le coordinate x e y e
     * inserisce le immagini dei cavalli
     * @param yy coordinata y
     * @param xx coordinata x
     */
    public Cavallo(int yy, int xx){
        this.cordx = 0;
        this.cordy = yy;
        setSize(80,80);
        Toolkit tk = Toolkit.getDefaultToolkit();
        switch(xx){
            case 1: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo1.png"); break;}
            case 2: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo2.png"); break;}
            case 3: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo3.png"); break;}
            case 4: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo4.png"); break;}
            case 5: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo5.png"); break;}
            case 6: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo6.png"); break;}
            case 7: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo7.png"); break;}
            case 8: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo8.png"); break;}
            case 9: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo9.png"); break;}
            case 10: {img = tk.getImage("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\cavallo10.png"); break;}
        }
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        try{mt.waitForID(1);}
        catch(InterruptedException e){}
    }
    
    /**
     * 
     * @param n coordinata x
     */
    public void setCordx(int n){
        this.cordx = n;
    }
    
    /**
     * 
     * @return coordinata x
     */
    public int getCordx(){
        return this.cordx;
    }
    
    /**
     * 
     * @param g la variabile per inserire le immagini
     * alle loro coordinate
     */
    public void paint(Graphics g){
        g.drawImage(img, cordx, cordy, null);
    }
}
