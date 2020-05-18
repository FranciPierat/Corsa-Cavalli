/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Utente
 */
public class Home {
    public Home() {
        //creazione Frame per la home
        JFrame home = new JFrame("Corsa dei cavalli");
        home.setSize(1200, 900);
        home.setResizable(false);
        home.setLayout(null);
        home.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //inserimento immagine come sfondo
        ImageIcon img = new ImageIcon("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\sfondo.jpg");
        JLabel sfondo = new JLabel("", img, JLabel.CENTER);
        sfondo.setBounds(0, 0, 1200, 900);
        //inserimento bottone Gioca
        JButton gioca = new JButton();
        gioca.setIcon(new ImageIcon("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\button_gioca.png"));
        gioca.setBorderPainted(false);
        gioca.setFocusPainted(false);
        gioca.setContentAreaFilled(false);
        gioca.setBounds(500, 400, 150, 100);
        sfondo.add(gioca);  //aggiunto il bottone allo sfondo
        home.add(sfondo);   //aggiunto lo sfondo alla finestra
        home.setVisible(true);  //rende visibile la finestra
    }
}
