/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * la classe che gestisce le scommesse
 * @author Pierattini Francesco
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
public class Scommesse extends JFrame{
    Musica m = new Musica(); //musica
    private int n_Cavalli; //numero dei cavalli
    
    /**
     * costruttore che crea il frame delle scommesse
     * @param n il numero dei cavalli che partecipano
     */
    public Scommesse(int n){
        n_Cavalli = n;
        JFrame scom = new JFrame("Corsa dei cavalli");
        scom.setIconImage(new ImageIcon("img/cavallo1.png").getImage());
        scom.setSize(1200, 900);
        scom.setResizable(false);
        scom.setLayout(null);
        scom.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("img/sfondo3.png");
        JLabel sfondo3 = new JLabel("", img, JLabel.CENTER);
        sfondo3.setBounds(0, 0, 1200, 900);
        JButton btnSI = new JButton();
        btnSI.setIcon(new ImageIcon("img/btnSI.png"));
        btnSI.setBorderPainted(false);
        btnSI.setFocusPainted(false);
        btnSI.setContentAreaFilled(false);
        btnSI.setBounds(390, 400, 176, 72);
        sfondo3.add(btnSI);
        JButton btnNO = new JButton();
        btnNO.setIcon(new ImageIcon("img/btnNO.png"));
        btnNO.setBorderPainted(false);
        btnNO.setFocusPainted(false);
        btnNO.setContentAreaFilled(false);
        btnNO.setBounds(630, 400, 176, 72);
        sfondo3.add(btnSI);
        sfondo3.add(btnNO);
        scom.add(sfondo3);
        //al click cambia pagina
        btnSI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                scom.dispose();
                cambiaPagina();
            }
        });
        //al click apre la pista
        btnNO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                scom.dispose();
                m.stopMusica();
                Ippodromo i = new Ippodromo(n_Cavalli, 0);
            }
        });
        scom.setVisible(true);
        scom.setResizable(false);
    }
    
    /**
     * metodo che cambia la pagina per scommettere
     */
    public void cambiaPagina(){
        JFrame scommesse = new JFrame("Corsa dei cavalli");
        scommesse.setIconImage(new ImageIcon("img/cavallo1.png").getImage());
        JPanel pan = new JPanel();
        JLabel labSli = new JLabel("Su quale cavallo vuoi puntare?");
        pan.add(labSli);
        JSlider sli=new JSlider();
        sli.setMinimum(1);
        sli.setMaximum(n_Cavalli);
        sli.setValue(1);
        JLabel cavalloScommesso = new JLabel("1");
        JButton btnAvvio = new JButton();
        btnAvvio.setIcon(new ImageIcon("img/inizia.png"));
        btnAvvio.setBorderPainted(false);
        btnAvvio.setFocusPainted(false);
        btnAvvio.setContentAreaFilled(false);
        btnAvvio.setBounds(32, 400, 176, 72);
        EventoSlider actSli=new EventoSlider(cavalloScommesso, sli);
        sli.addChangeListener(actSli);
        pan.add(sli);
        pan.add(cavalloScommesso);
        pan.add(btnAvvio);
        scommesse.add(pan);
        scommesse.setSize(500,150);
        scommesse.setLocation(560, 420);
        scommesse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //al click apre la pista
        btnAvvio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                scommesse.dispose();
                m.stopMusica();
                int cScommesso = Integer.parseInt(cavalloScommesso.getText());
                Ippodromo i = new Ippodromo(n_Cavalli, cScommesso);
            }
        });
        scommesse.setVisible(true);
        scommesse.setResizable(false);
    }
}
