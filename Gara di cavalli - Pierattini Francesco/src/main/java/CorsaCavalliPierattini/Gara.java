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
public class Gara implements Runnable{
    private Cavallo cavallo;
    private Ippodromo ippodromo;
    int velocita;
    Thread t;
    int conta;
    int posizione;
    Campo c = new Campo();
    
    public Gara(Cavallo c, Ippodromo i){
        cavallo = c;
        ippodromo = i;
        conta = 0;
        velocita = 2;
        t = new Thread(this);
        t.start();
        posizione = 0;
    }
    
    public void run(){
        int dimImmagine = 35;
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
