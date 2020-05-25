/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * classe che genera la pista
 * @author Pierattini Francesco
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
public class Campo extends JPanel{
    
    /**
     * il metodo che disegna la pista
     * @param g la variabile che diegna la pista
     */
    public void paint(Graphics g){
        g.setColor(Color.green); //l'erba
        g.fillRect(0, 0, 1000, 1020);
        
        g.setColor(Color.LIGHT_GRAY); //la base di partenza
        g.fillRect(0, 0, 90, 1020);
        
        g.setColor(Color.GRAY); //i separatori
        g.fillRect(0, 0, 1000, 10);
        g.fillRect(0, 100, 1000, 10);
        g.fillRect(0, 200, 1000, 10);
        g.fillRect(0, 300, 1000, 10);
        g.fillRect(0, 400, 1000, 10);
        g.fillRect(0, 500, 1000, 10);
        g.fillRect(0, 600, 1000, 10);
        g.fillRect(0, 700, 1000, 10);
        g.fillRect(0, 800, 1000, 10);
        g.fillRect(0, 900, 1000, 10);
        g.fillRect(0, 1000, 1000, 10);
        
        g.setColor(Color.BLACK); //la linea di partenza
        g.fillRect(85, 0, 10, 1020);
        
        int h=0,l=0;
        boolean c=false;
        while(h < 1020){ //genera la bandiera a scacchi
            for(int i = 0; i < 3;i++){
                if(c==false){
                    g.setColor(Color.BLACK);
                    c=true;
                }else{
                    g.setColor(Color.WHITE);
                    c=false;
                }
                g.fillRect((930+l),(0+h),10,10);
                l+=10;
            }
            l=0;
            h+=10;
        }
    }
}
