package sovelluslogiikka;

import java.util.Stack;

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
