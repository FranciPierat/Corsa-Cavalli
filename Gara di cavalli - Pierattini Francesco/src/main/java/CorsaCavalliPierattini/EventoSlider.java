/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 *
 * @author Utente
 */
import javax.swing.*;
import javax.swing.event.*;
public class EventoSlider implements ChangeListener{
    private JLabel cavalloScommesso;
    private JSlider slider;
    
    public EventoSlider(JLabel p,JSlider s){
        cavalloScommesso = p;
        slider=s;
    }
    
    public void stateChanged(ChangeEvent e){
        cavalloScommesso.setText(""+slider.getValue());
    }
}
