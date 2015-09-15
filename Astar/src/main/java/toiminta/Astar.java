package toiminta;

import java.util.PriorityQueue;
import sovelluslogiikka.MinimiKeko;
import sovelluslogiikka.Solmu;
import sovelluslogiikka.Verkko;

/**
 *This is where the magic happens
 * @author tuomo
 */
public class Astar {
    
    private Verkko verkko;
    private int[] alkuun;
    private int[] loppuun;
    private int[] polku;
    private int alkuSolmu;
    private int loppuSolmu;
    private MinimiKeko keko;
    
    public Astar(Verkko verkko) {
        this.verkko = verkko;
        this.alkuun = new int[verkko.getSolmut().length];
        this.loppuun = new int[verkko.getSolmut().length];
        this.polku = new int[verkko.getSolmut().length];
        this.alkuSolmu = verkko.getAlkuSolmu();
        this.loppuSolmu = verkko.getLoppuSolmu();
        this.keko = new MinimiKeko();
    }
    
    private char[][] etsiPolku() {
        alusta();
        
        
        
        return null;
    }
    /**
     * Asettaa algoritmille kaikkiin liittyviin solmuihin etäisyyden
     * alkuun alussa äärettömäksiu, loppuun arvion etäisyydestä,
     * ja poluksi -1 eli ei mahdollinen
     * 
     * Asettaa valmiit solmut minimikekoon, priorisoivana elementtinään
     * summa alkuun[i] + loppuun[i]
     */
    private void alusta() {
        
        int i = 0;
        Solmu[] solmut = verkko.getSolmut();
        
        
        for (Solmu solmu : solmut) {
            alkuun[i] = Integer.MAX_VALUE;
            loppuun[i] = Math.abs(solmu.getX() - solmut[loppuSolmu].getX()) +
                    Math.abs(solmu.getY() - solmut[loppuSolmu].getY());
            polku[i] = -1;
            
            //Asetetaan minimikekoon
            
            i++;
        }
        
        
        alkuun[alkuSolmu] = 0;
    }
    
    /**
     * Päivittää uusien saavutettavien vierussolmujen alkuun-arvot
     * ja polun, jota kautta tämä saavutettiin
     * 
     */
    private void paivitaVierusSolmut() {
        
    }
    
    
    /**
     * luo verkon, jossa lopullinen reitti ja tulostaa sen
     * sekä lopullisen reitin painon
     */
    private void piirraReitti() {
        //tähän voisi ehkä kopsata Verkko-luokan metodin
    }
    
    
}
