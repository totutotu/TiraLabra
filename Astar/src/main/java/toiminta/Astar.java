package toiminta;

import sovelluslogiikka.MinimiKeko2;
import sovelluslogiikka.Pino;
import sovelluslogiikka.Solmu;
import sovelluslogiikka.Verkko;

/**
 * This is where the magic happens
 *
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
    
    /**
     * Etsii polun, algoritmin ydintoiminta
     * @return kenttä, joka sisältää lopullisen reitin
     */
    public char[][] etsiPolku() {
        alusta();
        Solmu[] solmut = verkko.getSolmut();

        while (!this.saavutettu) {

            Solmu solmu = solmut[keko.pieninSolmu()];
            if (solmu.getPaino() != 1000) {
                paivitaVierusSolmut(solmu);
            } else {
                break;
            }
        }

        if (saavutettu) {
            Pino pino = new Pino(verkko.getSolmut().length);

            int i = loppuSolmu;

            while (i != alkuSolmu) {
                pino.lisaa(i);
                i = polku[i];
            }
            pino.lisaa(i);
            
            System.out.println("Reitin kokonaispaino: " + alkuun[loppuSolmu]);
            
            char[][] kentta = luo(pino);
            tulostaKentta(kentta);
            return kentta;
        } else {
            System.out.println("Ei tullut nyt kyllä vittuakaan, syötä kenttä, joka on ratkaistavissa.");
        }

        return null;
    }

    /**
     * Asettaa algoritmille kaikkiin liittyviin solmuihin etäisyyden alkuun
     * alussa äärettömäksiu, loppuun arvion etäisyydestä, ja poluksi -1 eli ei
     * mahdollinen
     *
     * Asettaa valmiit solmut minimikekoon, priorisoivana elementtinään summa
     * alkuun[i] + loppuun[i]
     */
    private void alusta() {

        int i = 0;
        Solmu[] solmut = verkko.getSolmut();

        for (Solmu solmu : solmut) {
            alkuun[i] = 1000;
            loppuun[i] = Math.abs(solmu.getX() - solmut[loppuSolmu].getX())
                    + Math.abs(solmu.getY() - solmut[loppuSolmu].getY() + solmu.getPaino());
            polku[i] = -1;

            keko.asetaSolmu(i, loppuun[i] + alkuun[i]);

            i++;
        }

        alkuun[alkuSolmu] = 0;
        keko.laskePainoa(alkuSolmu, 0);
    }

    /**
     * Päivittää uusien saavutettavien vierussolmujen alkuun-arvot ja polun,
     * jota kautta tämä saavutettiin.
     *
     *
     */
    private void paivitaVierusSolmut(Solmu solmu) {
        int x = solmu.getX();
        int y = solmu.getY();

        //taulukko, jossa päivitettävien indeksit. Jos -1, ei päivitetä
        int[] paivitettavat = new int[]{-1, -1, -1, -1};

        //indeksi verkossa saadaan laskemalla x + korkeus * y,
        // eli x:n vierukset lisäämällä +-1,
        // y:n vierukset lisäämällä 1korkeus * (y +-1)
        if (x < this.leveys - 1) {
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
                paivitettavat[2] = korkeus * (y + 1) + x;
                paivitettavat[3] = korkeus * (y - 1) + x;

            } else {
                //päivitetään vain alapuoli
                paivitettavat[2] = korkeus * (y + 1) + x;
            }
        } else {
            //päivitetään vain yläpuoli
            paivitettavat[3] = korkeus * (y - 1) + x;
        }

        for (int q : paivitettavat) {
            if (q != -1) {
                if (alkuun[q] > alkuun[solmu.getIndeksi()] + verkko.getSolmut()[q].getPaino()) {
                    alkuun[q] = alkuun[solmu.getIndeksi()] + verkko.getSolmut()[q].getPaino();
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
     * Luo kentän, jossa merkattu lopullinen kevyin reitti
     * @param pino, jossa reitissä läpikäytyjen solmujen indeksit
     * @return lopullinen kenttä
     */
    private char[][] luo(Pino pino) {
        char[][] kentta = new char[korkeus][leveys];
        int i = -1;
        while (!pino.tyhja()) {
            i = pino.pop();
            kentta[i / korkeus][i % korkeus] = 'R';
        }

        return kentta;
    }

    
    /**
     * Tulostaa valmiin reitin 
     * @param kentta 
     */
    private void tulostaKentta(char[][] kentta) {
        for (char[] kentta1 : kentta) {
            for (char l : kentta1) {
                System.out.print(l);
            }
            System.out.println("");
        }
    }

}
