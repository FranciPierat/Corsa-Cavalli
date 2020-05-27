/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * classe della home
 * @author Pierattini Francesco
 */
public class Home extends JFrame{
    /**
     * costruttore che costruisce il Jframe della home
     */
    public Home(){
        Musica m = new Musica();
        //creazione Frame per la home
        JFrame home = new JFrame("Corsa dei cavalli");
        home.setIconImage(new ImageIcon("img/cavallo1.png").getImage());
        home.setSize(1200, 900);
        home.setResizable(false);
        home.setLayout(null);
        home.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //inserimento immagine come sfondo
        ImageIcon img = new ImageIcon("img/sfondo.png");
        JLabel sfondo = new JLabel("", img, JLabel.CENTER);
        sfondo.setBounds(0, 0, 1200, 900);
        //inserimento bottone Gioca
        JButton gioca = new JButton();
        gioca.setIcon(new ImageIcon("img/button_gioca.png"));
        gioca.setBorderPainted(false);
        gioca.setFocusPainted(false);
        gioca.setContentAreaFilled(false);
        gioca.setBounds(500, 400, 176, 72);
        sfondo.add(gioca);  //aggiunto il bottone allo sfondo
        home.add(sfondo);   //aggiunto lo sfondo alla finestra
        home.setVisible(true);  //rende visibile la finestra
        m.musica("temi/home_theme.wav");
        gioca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                home.remove(sfondo);
                home.revalidate();
                home.repaint();
                ImageIcon img = new ImageIcon("img/sfondo2.png");
                JLabel sfondo2 = new JLabel("", img, JLabel.CENTER);
                sfondo2.setBounds(0, 0, 1200, 900);
                JButton bottone2 = new JButton("2");
                bottone2.setIcon(new ImageIcon("img/bottone2.png"));
                bottone2.setBorderPainted(false);
                bottone2.setFocusPainted(false);
                bottone2.setContentAreaFilled(false);
                bottone2.setBounds(32, 400, 176, 72);
                sfondo2.add(bottone2);
                JButton bottone3 = new JButton("3");
                bottone3.setIcon(new ImageIcon("img/bottone3.png"));
                bottone3.setBorderPainted(false);
                bottone3.setFocusPainted(false);
                bottone3.setContentAreaFilled(false);
                bottone3.setBounds(272, 400, 176, 72);
                sfondo2.add(bottone3);
                JButton bottone4 = new JButton("4");
                bottone4.setIcon(new ImageIcon("img/bottone4.png"));
                bottone4.setBorderPainted(false);
                bottone4.setFocusPainted(false);
                bottone4.setContentAreaFilled(false);
                bottone4.setBounds(512, 400, 176, 72);
                sfondo2.add(bottone4);
                JButton bottone5 = new JButton("5");
                bottone5.setIcon(new ImageIcon("img/bottone5.png"));
                bottone5.setBorderPainted(false);
                bottone5.setFocusPainted(false);
                bottone5.setContentAreaFilled(false);
                bottone5.setBounds(752, 400, 176, 72);
                sfondo2.add(bottone5);
                JButton bottone6 = new JButton("6");
                bottone6.setIcon(new ImageIcon("img/bottone6.png"));
                bottone6.setBorderPainted(false);
                bottone6.setFocusPainted(false);
                bottone6.setContentAreaFilled(false);
                bottone6.setBounds(992, 400, 176, 72);
                sfondo2.add(bottone6);
                JButton bottone7 = new JButton("7");
                bottone7.setIcon(new ImageIcon("img/bottone7.png"));
                bottone7.setBorderPainted(false);
                bottone7.setFocusPainted(false);
                bottone7.setContentAreaFilled(false);
                bottone7.setBounds(150, 550, 176, 72);
                sfondo2.add(bottone7);
                JButton bottone8 = new JButton("8");
                bottone8.setIcon(new ImageIcon("img/bottone8.png"));
                bottone8.setBorderPainted(false);
                bottone8.setFocusPainted(false);
                bottone8.setContentAreaFilled(false);
                bottone8.setBounds(390, 550, 176, 72);
                sfondo2.add(bottone8);
                JButton bottone9 = new JButton("9");
                bottone9.setIcon(new ImageIcon("img/bottone9.png"));
                bottone9.setBorderPainted(false);
                bottone9.setFocusPainted(false);
                bottone9.setContentAreaFilled(false);
                bottone9.setBounds(630, 550, 176, 72);
                sfondo2.add(bottone9);
                JButton bottone10 = new JButton("10");
                bottone10.setIcon(new ImageIcon("img/bottone10.png"));
                bottone10.setBorderPainted(false);
                bottone10.setFocusPainted(false);
                bottone10.setContentAreaFilled(false);
                bottone10.setBounds(870, 550, 176, 72);
                sfondo2.add(bottone10);
                home.add(sfondo2);
                home.repaint();
                //al click apre il frame delle scommesse
                bottone2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone2.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone3.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone4.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone5.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone5.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone6.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone6.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone7.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone7.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone8.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone8.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone9.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone9.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
                //al click apre il frame delle scommesse
                bottone10.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(bottone10.getText());
                        home.dispose();
                        Scommesse s = new Scommesse(n);
                    }
                });
            }
        });
    }
}