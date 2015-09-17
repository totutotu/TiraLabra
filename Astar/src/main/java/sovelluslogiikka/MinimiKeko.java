package sovelluslogiikka;

public class MinimiKeko {
    //vai sittenkin kaksiulotteinen taulukko, jokaisella kaksi osaa, eka avain, 
    //toka paino? 
   final Solmu[] solmut;
    private int koko;

    public MinimiKeko(int pituus) {
       this.solmut = new Solmu[pituus];
       this.koko = 0;
    }  
    public void asetaSolmu(Solmu solmu) {
        this.koko++;
        int i = this.koko;
        while(i > 1 && this.solmut[parent(i) - 1].getPaino() < solmu.getPaino()) {
            this.solmut[i - 1] = this.solmut[parent(i) - 1];
            i = parent(i);
        }
        this.solmut[i - 1] = solmu;
    }
    
    public Solmu pieninSolmu() {
        this.koko--;
        return this.solmut[koko];
    }
    
    private int parent(int i) {
        return i/2;
    }
    
    private int vasen(int i) {
        return 2 * i;
    }
    
    private int oikea(int i) {
        return 2 * i + 1;
    }
    
    public void kasvataPainoa(int i, int uusiPaino) {
        if (uusiPaino > this.solmut[i].getPaino()) {
            this.solmut[i].setPaino(uusiPaino);
            while (i > 0 && this.solmut[parent(i)].getPaino() < this.solmut[i].getPaino()) {
                Solmu solmu = this.solmut[i];
                this.solmut[i] = this.solmut[parent(i)];
                this.solmut[parent(i)] = solmu;
                i = parent(i);
            }
        }
    }
   
    private void korjaaKeko(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int suurin;
        if (o <= this.koko) {
            if (this.solmut[o].getPaino() > this.solmut[v].getPaino()) {
                suurin = o;
            } else suurin = v;
            if(this.solmut[i].getPaino() < this.solmut[suurin].getPaino()) {
                Solmu solmu = this.solmut[i];
                this.solmut[i] = this.solmut[suurin];
                this.solmut[suurin] = solmu;
                
                korjaaKeko(suurin);
            }
        } else if (v == this.koko && solmut[i].getPaino() < solmut[v].getPaino()) {
            Solmu solmu = this.solmut[i];
            this.solmut[i] = this.solmut[v];
            this.solmut[v] = solmu;
        }
        
    }
    
}
