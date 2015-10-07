package sovelluslogiikka;

import java.util.Stack;
/**
 * Toimii kuin tietorakenne pino.
 * Taulukkoon saadaan popilla palautettua viimeksi lisätty alkio.
 * Tietorakenne ei sisällä virheenhallintaa, koska tässä käytössä se ei ole tar-
 * peellista.
 * @author tuomo
 */
public class Pino {
    private Stack pino;
    private int[] taulu;
    private int katto;

    public Pino(int koko) {
        katto = -1;
        taulu = new int[koko];
    }
    
    public void lisaa(int i) {
        taulu[katto + 1] = i;
        katto++;
    }
    
    public int pop() {
        int pois = taulu[katto];
        katto--;
        return pois;
        
    }
    
    public boolean tyhja() {
        return katto==-1;
    }
    
}
