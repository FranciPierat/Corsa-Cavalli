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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ippodromo extends JFrame{
    Musica m = new Musica();
    int[] arrnCavallo;
    int nCavallo;
    int n_Cavalli;
    int cavalloScommesso;
    int posizione;
    Cavallo[] cavalli;
    Gara[] partecipanti;
    Campo pista;
    Graphics offscreen;
    Image buffer_virtuale;
    
    public Ippodromo(int nCavalli, int cScommesso){
        super("Corsa dei cavalli");
        n_Cavalli = nCavalli;
        cavalloScommesso = cScommesso;
        switch(n_Cavalli){
            case 2:{setSize(1000,230); break;}
            case 3:{setSize(1000,330); break;}
            case 4:{setSize(1000,430); break;}
            case 5:{setSize(1000,530); break;}
            case 7:{setSize(1000,630); break;}
            case 8:{setSize(1000,830); break;}
            case 9:{setSize(1000,930); break;}
            case 10:{setSize(1000,1030); break;}
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista = new Campo();
        cavalli = new Cavallo[nCavalli];
        partecipanti = new Gara[nCavalli];
        posizione = 1;
        int partenza = 10;
        arrnCavallo = new int [nCavalli];
        for(int xx = 0; xx < nCavalli; xx++){
            nCavallo = (xx + 1);
            cavalli[xx] = new Cavallo(partenza, xx+1);
            partecipanti[xx] = new Gara(cavalli[xx], this);
            partenza = partenza + 100;
        }
        add(pista);
        setResizable(false);
        setVisible(true);
        m.musica("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\temi\\Race_theme.wav");
    }
    
    public int getnCavalli(){
        return this.n_Cavalli;
    }
    
    public synchronized int getPosizione(){
        return posizione++;
    }
    
    public synchronized void controllaArrivi(){
        boolean arrivati = true;
        for(int xx = 0; xx < n_Cavalli; xx++){
            if(partecipanti[xx].posizione == 0)
                arrivati = false;
        }
        if(arrivati){
            visualizzaClassifica();
        }
    }
    
    public void visualizzaClassifica(){
        JLabel[] arrivi;
        arrivi = new JLabel[n_Cavalli + 1];
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(500, 1000);
        classifica.setLocation(1040, 0);
        classifica.setBackground(Color.BLUE);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(13, 1));
        int i = 0;
        for(int xx = 1; xx < n_Cavalli + 1; xx++){
            for(int yy = 0; yy < n_Cavalli; yy++){
                if(partecipanti[yy].posizione == xx){
                    if(cavalloScommesso != 0 && i == 0){
                        if(arrnCavallo[yy] == cavalloScommesso){
                            arrivi[yy] = new JLabel("Bravo hai indovinato");
                            arrivi[yy].setFont(new Font("Times New Roman", Font.ITALIC, 25));
                            arrivi[yy].setBackground(Color.blue);
                            classifica.getContentPane().add(arrivi[yy]);
                            i++;
                        }
                        else{
                            arrivi[yy] = new JLabel("Mi dispiace non hai indovinato");
                            arrivi[yy].setFont(new Font("Times New Roman", Font.ITALIC, 25));
                            arrivi[yy].setBackground(Color.blue);
                            classifica.getContentPane().add(arrivi[yy]);
                            i++;
                        }
                    }
                    arrivi[yy + 1] = new JLabel(xx + "° classificato cavallo in " + (yy + 1) + "° corsia");
                    arrivi[yy + 1].setFont(new Font("Times New Roman", Font.ITALIC, 25));
                    arrivi[yy + 1].setBackground(Color.blue);
                    classifica.getContentPane().add(arrivi[yy + 1]);
                }
            }
        }
        JButton rigioca = new JButton();
        rigioca.setIcon(new ImageIcon("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\rigioca.png"));
        rigioca.setBorderPainted(false);
        rigioca.setFocusPainted(false);
        rigioca.setContentAreaFilled(false);
        rigioca.setBounds(250, 500, 172, 72);
        JButton esci = new JButton();
        esci.setIcon(new ImageIcon("C:\\Users\\Utente\\Desktop\\Corsa Cavalli\\Gara di cavalli - Pierattini Francesco\\src\\immagini\\esci.png"));
        esci.setBorderPainted(false);
        esci.setFocusPainted(false);
        esci.setContentAreaFilled(false);
        esci.setBounds(350, 750, 245, 72);
        classifica.add(rigioca);
        classifica.add(esci);
        classifica.setVisible(true);
        setResizable(false);
        rigioca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Ippodromo.this.dispose();
                classifica.dispose();
                m.stopMusica();
                Home h = new Home();
            }
        });
        esci.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        if(cavalli != null){
            Graphics2D screen = (Graphics2D)g;
            buffer_virtuale = createImage(1080, 1020);
            offscreen = buffer_virtuale.getGraphics();
            Dimension d = getSize();
            pista.paint(offscreen);
            for(int xx = 0; xx < n_Cavalli; xx++){
                cavalli[xx].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 20, this);
            offscreen.dispose();
        }
    }
}
