/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * la classe che gestisce l'evento dello slider
 * della classe Scommesse
 * @author Pierattini Francesco
 */
import javax.swing.*;
import javax.swing.event.*;
public class EventoSlider implements ChangeListener{
    private JLabel cavalloScommesso; //il label del cavallo scommesso
    private JSlider slider; //lo slider
    
    /**
     * costruttore che setta il label e lo slider
     * @param p il label
     * @param s lo slider
     */
    public EventoSlider(JLabel p,JSlider s){
        cavalloScommesso = p;
        slider=s;
    }
    
    /**
     * metodo che mette il cavallo che si è scommesso nel JLabel
     * @param e l'evento
     */
    public void stateChanged(ChangeEvent e){
        cavalloScommesso.setText(""+slider.getValue());
    }
}
