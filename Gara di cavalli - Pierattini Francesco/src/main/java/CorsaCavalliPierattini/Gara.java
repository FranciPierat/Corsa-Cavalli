/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorsaCavalliPierattini;

/**
 * classe che gestisce la gara
 * @author Pierattini Francesco
 */
public class Gara implements Runnable{
    private Cavallo cavallo; //il cavallo
    private Ippodromo ippodromo; //il campo
    int velocita; //la velocità
    Thread t; //il thread
    int conta; //ogni 10 spostamenti aumenta la velocità
    int posizione; //coordinata x espressa in pixel
    Campo c = new Campo(); //l'oggetto campo
    
    /**
     * costruttore dove parte la gara
     * @param c identificativo del cavallo
     * @param i campo di gara
     */
    public Gara(Cavallo c, Ippodromo i){
        cavallo = c;
        ippodromo = i;
        conta = 0;
        velocita = 2;
        t = new Thread(this);
        t.setName("" + i.nCavallo);
        t.start();
        posizione = 0;
    }
    
    /**
     * metodo che muove il cavallo lungo il percorso, cambiando la velocità
     */
    public void run(){
        int dimImmagine = 45;
        int dimPista = 960;
        while((cavallo.getCordx() + dimImmagine) < dimPista){
            if((conta % 10) == 0)
                velocita = (int)(Math.random()*4 + 1);
            cavallo.setCordx(cavallo.getCordx() + velocita);
            conta++;
            try{Thread.sleep(75);}
            catch(Exception e){}
            ippodromo.repaint();
        }
        posizione = ippodromo.getPosizione();
        ippodromo.controllaArrivi();
    }
}
