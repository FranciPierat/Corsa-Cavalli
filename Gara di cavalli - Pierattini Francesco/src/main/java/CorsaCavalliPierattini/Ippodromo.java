/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * classe dell'ippodromo
 * @author Pierattini Francesco
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ippodromo extends JFrame{
    Musica m = new Musica(); //musica
    int[] arrnCavallo; //array con i numeri dei cavalli
    int nCavallo; //numero del cavallo partecipante
    int n_Cavalli; //numero dei cavalli
    int cavalloScommesso; //numero del cavallo scommesso
    int posizione; //posizione del cavallo
    Cavallo[] cavalli; //array dei cavalli
    Gara[] partecipanti; //array dei partecipanti
    Campo pista; //la pista
    Graphics offscreen;     //per la gestione del
    Image buffer_virtuale;  //doppio buffering
    
    /**
     * costruttore che posizione e disegna il percorso
     * @param nCavalli il numero dei cavalli che partecipano
     * @param cScommesso il numero del cavallo che ha scommesso
     */
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
        setIconImage(new ImageIcon("img/cavallo1.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista = new Campo();
        cavalli = new Cavallo[nCavalli];
        partecipanti = new Gara[nCavalli];
        posizione = 1;
        int partenza = 10;
        arrnCavallo = new int [nCavalli];
        for(int xx = 0; xx < nCavalli; xx++){
            arrnCavallo[xx] = (xx + 1);
            nCavallo = (xx + 1);
            cavalli[xx] = new Cavallo(partenza, xx+1);
            partecipanti[xx] = new Gara(cavalli[xx], this);
            partenza = partenza + 100;
        }
        add(pista);
        setResizable(false);
        setVisible(true);
        m.musica("temi/Race_theme.wav");
    }
    
    /**
     * metodo che fa ritornare il numero dei cavalli che partecipano
     * @return il numero dei cavalli che partecipano
     */
    public int getnCavalli(){
        return this.n_Cavalli;
    }
    
    /**
     * metodo che assegna la posizione al cavallo che ha appena raggiunto il traguardo
     * @return la posizione del cavallo
     */
    public synchronized int getPosizione(){
        return posizione++;
    }
    
    /**
     * metodo che verifica se tutti i concorrenti abbiano raggiunto il traguardo
     */
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
    
    /**
     * metodo che realizza la classifica
     */
    public void visualizzaClassifica(){
        JLabel[] arrivi;
        arrivi = new JLabel[n_Cavalli + 1];
        JFrame classifica = new JFrame("Classifica");
        classifica.setIconImage(new ImageIcon("img/cavallo1.png").getImage());
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
                    arrivi[yy + 1] = new JLabel(xx + "° classificato: " + " cavallo " + arrnCavallo[yy]);
                    arrivi[yy + 1].setFont(new Font("Times New Roman", Font.ITALIC, 25));
                    arrivi[yy + 1].setBackground(Color.blue);
                    classifica.getContentPane().add(arrivi[yy + 1]);
                }
            }
        }
        JButton rigioca = new JButton();
        rigioca.setIcon(new ImageIcon("img/rigioca.png"));
        rigioca.setBorderPainted(false);
        rigioca.setFocusPainted(false);
        rigioca.setContentAreaFilled(false);
        rigioca.setBounds(250, 500, 172, 72);
        JButton esci = new JButton();
        esci.setIcon(new ImageIcon("img/esci.png"));
        esci.setBorderPainted(false);
        esci.setFocusPainted(false);
        esci.setContentAreaFilled(false);
        esci.setBounds(350, 750, 245, 72);
        classifica.add(rigioca);
        classifica.add(esci);
        classifica.setVisible(true);
        setResizable(false);
        //al click torni alla home
        rigioca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Ippodromo.this.dispose();
                classifica.dispose();
                m.stopMusica();
                Home h = new Home();
            }
        });
        //al click termina il programma
        esci.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
    
    /**
     * metodo relativo al disegno sullo schermo
     * @param g la pista che verrà disegnata
     */
    public void update(Graphics g){
        paint(g);
    }
    
    /**
     * metodo che elimina lo sfarfallio delle immagini con la tecnica del doppio buffering
     * @param g la pista che verrà modificata
     */
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
