package sovelluslogiikka;
/**
 * Minimikeko, joka on kaksiulotteinen taulukko, 
 * jossa jokainen taulukko edustaa yhtä solmua verkossa.
 * Solmulla ensimmäisena arvona taulukossa indeksi verkossa, toisena 
 * arvioita etäisyys lopusta, jonka perusteella haetaan aina "seuraavaksi paras
 * vaihtoehto".
 * 
 * Indeksejä käsitellään luokassa hämäävästi etenemään arvosta numero 1,
 * mikä helpottaa solmujen vanhempien ja jälkeläisten etsimistä, mutta koska
 * javan taulukot alkavat 0:sta, on kutsutuista indekseistä vähennettävä 1 
 * taulukosta kyseistä kappaletta hakiessa.
 *
 * @author tuomo
 */
public class MinimiKeko2 {
    private int[][] keko;
    private int koko;

    public MinimiKeko2(int koko) {
        this.keko = new int[koko][2];
        this.koko = 0;
    }
    
    /**
     * 
     * @param indeksi Solmun indeksi verkko-taulukossa
     * @param etaisyys solmun arvioitu etäisyys lopusta
     */
    public void asetaSolmu(int indeksi, int etaisyys) {
        this.koko++;    
        int i = this.koko;
        while(i > 1 && this.keko[parent(i) - 1][1] > etaisyys) {
            this.keko[i - 1] = this.keko[parent(i) - 1];
            i = parent(i);
        }
        this.keko[i - 1] = new int[2];
        this.keko[i - 1][0] = indeksi;
        this.keko[i - 1][1] = etaisyys;
        
    }
    
    /**
     * Palauttaa pieninpipainoisen Solmun indeksin verkossa,
     * korjaa kekoehdon ja laittaan jäljelläolevat solmut tärkeysjärjestykseen
     * @return 
     */
    public int pieninSolmu() {
        int pienin = this.keko[0][0];
        this.keko[0] = this.keko[koko - 1];
        koko--;
        korjaaKeko(1);
        return pienin;
    }
    
    /**
     * korjaa kekoehdon
     * @param i mistä kohdin lähdetään korjailemaan
     */
    private void korjaaKeko(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin;
        if (o <= this.koko) {
            if (this.keko[o - 1][1] < this.keko[v - 1][1]) {
                pienin = o;
            } else pienin = v;
            if(this.keko[i - 1][1] > this.keko[pienin - 1][1]) {
                int[] solmu = this.keko[i - 1];
                this.keko[i - 1] = this.keko[pienin - 1];
                this.keko[pienin - 1] = solmu;
                
                korjaaKeko(pienin);
            }
        }
        else if (v == this.koko && this.keko[i - 1][1] > this.keko[v - 1][1]) {
            int[] solmu = this.keko[i - 1];
            this.keko[i - 1] = this.keko[v - 1];
            this.keko[v - 1] = solmu;
        }
    }
    /**
     * Metodi toistaiseksi täysin tehoton, koska joudutaan käymään koko helvetin lista
     * lävitse, korjailen kun viisastun
     * @param i
     * @param uusiPaino 
     */
    public void laskePainoa(int i, int uusiPaino) {
        int haettu = -1;
        int nyt = 0;
        for (int[] keko1 : keko) {
            if (keko1[0] == i && haettu == -1) {
                haettu = nyt + 1;
            }
            nyt++;
        }
        
        if (uusiPaino < this.keko[haettu - 1][1]) {
            this.keko[haettu - 1][1] = uusiPaino;
            while (haettu > 1 && this.keko[parent(haettu) - 1][1] > this.keko[haettu - 1][1]) {
                int[] solmu = this.keko[haettu - 1];
                this.keko[haettu - 1] = this.keko[parent(haettu) - 1];
                this.keko[parent(haettu) - 1] = solmu;
                haettu = parent(haettu);
            }
        }
    }
    
    /**
     * 
     * @param i solmun indeksi
     * @return  solmun vanhemman indeksi + 1
     */
    public int parent(int i) {
        return i/2;
    }    
    /**
     * 
     * @param i solmun indeksi
     * @return  vasen jälkeläinen
     */
    private int vasen(int i) {
        return 2 * i;
    }
    
    /**
     * 
     * @param i solmun indeksi
     * @return oikea jälkeläinen
     */
    private int oikea(int i) {
        return 2 * i + 1;
    }
    

    public boolean tyhja() {
        return this.koko == 0;
    }
    
}
