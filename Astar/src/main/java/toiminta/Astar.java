package toiminta;

import sovelluslogiikka.MinimiKeko2;
import sovelluslogiikka.Pino;
import sovelluslogiikka.Solmu;
import sovelluslogiikka.Verkko;

/**
 *This is where the magic happens
 * @author tuomo
 */
public class Astar {
    
    final Verkko verkko;
    final int[] alkuun;
    final int[] loppuun;
    final int[] polku;
    final int alkuSolmu;
    final int loppuSolmu;
    final int korkeus;
    final int leveys;
    final MinimiKeko2 keko;
    private boolean saavutettu;
    
    public Astar(Verkko verkko) {
        this.verkko = verkko;
        this.alkuun = new int[verkko.getSolmut().length];
        this.loppuun = new int[verkko.getSolmut().length];
        this.polku = new int[verkko.getSolmut().length];
        this.alkuSolmu = verkko.getAlkuSolmu();
        this.loppuSolmu = verkko.getLoppuSolmu();
        this.keko = new MinimiKeko2(verkko.getSolmut().length);
        this.leveys = verkko.getLeveys();
        this.korkeus = verkko.getKorkeus();
        this.saavutettu = false;
        
    }
    
    
    // Toistaiseksi ei ole valmistautunut siihen, ettei maalisolmu ole saavutettavissa!!!!!
    public char[][] etsiPolku() {
        alusta();
        Solmu[] solmut = verkko.getSolmut();
        
        
        // niin kauan kuin maalisolmu ei ole joukossa!! yksi boolean, kenties?
        while (!this.saavutettu) {
            Solmu solmu = solmut[keko.pieninSolmu()];
            System.out.println(saavutettu);
            paivitaVierusSolmut(solmu);            
        }
        
        Pino pino = new Pino(verkko.getSolmut().length);
        
        int i = loppuSolmu;
        
        while(i != alkuSolmu) {
            pino.lisaa(polku[i]);
        }
        
        
        while(!pino.tyhja()) {
            System.out.println(pino.pop());
        }
        
        // tässä vaiheessa asetetaan ehkäpä pinoon maalisolmusta reitti
        // alkusolmuun, luodaan kaksiulotteinen char[][] kenttä nolla-arvoilla,
        // popataan pinosta halutut indeksit ja asetetaan ne kenttään reitin
        // merkiksi ja palautetaan kenttä. 
        
        // Kokopaino on vain alkuun[loppusolmu];
        
        
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
            alkuun[i] = 1000;
            loppuun[i] = Math.abs(solmu.getX() - solmut[loppuSolmu].getX()) +
                    Math.abs(solmu.getY() - solmut[loppuSolmu].getY() + solmu.getPaino());
            polku[i] = -1;
            
            keko.asetaSolmu(i, loppuun[i] + alkuun[i]);
            
            i++;
        }
        
        
        alkuun[alkuSolmu] = 0;
        keko.laskePainoa(alkuSolmu, 0);
    }
    
    /**
     * Päivittää uusien saavutettavien vierussolmujen alkuun-arvot
     * ja polun, jota kautta tämä saavutettiin.
     * 
     * 
     */
    private void paivitaVierusSolmut(Solmu solmu) {
        int x = solmu.getX();
        int y = solmu.getY();
        System.out.println(x + "" + y + this.leveys + "loppari" + this.loppuSolmu);
        
        //taulukko, jossa päivitettävien indeksit. Jos -1, ei päivitetä
        int[] paivitettavat = new int[] { -1, -1, -1, -1 };
        
        
        //indeksi verkossa saadaan laskemalla x + korkeus * y,
        // eli x:n vierukset lisäämällä +-1,
        // y:n vierukset lisäämällä 1korkeus * (y +-1)
        if(x < this.leveys - 1) {
            if (x > 0) {
              //päivitetään vasen sekä oikea
                paivitettavat[0] = x + this.korkeus * y + 1;
                paivitettavat[1] = x + this.korkeus * y - 1;
                 
            } else {
                paivitettavat[0] = x + this.korkeus * y + 1;
                //vain oikea
            }
        } else {
            paivitettavat[1] = x + this.korkeus * y - 1;
            //vain vasen    
        }
   
        if (y < this.korkeus - 1) {
            if (y > 0) {
                //päivitetään ylä- ja alapuoli
                paivitettavat[2] = korkeus * (y + 1);
                paivitettavat[3] = korkeus * (y - 1);
                
            } else {
                //päivitetään vain alapuoli
                paivitettavat[2] = korkeus * (y + 1);
            }
        } else {
            //päivitetään vain yläpuoli
             paivitettavat[3] = korkeus * (y - 1);
        }
        
        for (int q : paivitettavat) {
            System.out.println(q + " " + alkuun[solmu.getIndeksi()] );
            if (q != -1) {
                if (alkuun[q] > alkuun[solmu.getIndeksi()] + verkko.getSolmut()[q].getPaino()) {
                    alkuun[q] = alkuun[solmu.getIndeksi()] + verkko.getSolmut()[q].getPaino();
                    System.out.println(alkuun[q] + " päivitetty");
                    polku[q] = solmu.getIndeksi();
                    keko.laskePainoa(q, alkuun[q] + loppuun[q]);
                    if (q == loppuSolmu) {
                        saavutettu = true;
                    }
                }
            }
        }
        
    }
    
    
    /**
     * luo verkon, jossa lopullinen reitti ja tulostaa sen
     * sekä lopullisen reitin painon
     */
    private void piirraReitti() {
        //tähän voisi ehkä kopsata Verkko-luokan metodin
    }
    
    
}
