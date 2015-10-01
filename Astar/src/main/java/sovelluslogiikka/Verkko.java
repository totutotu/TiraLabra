
package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Verkko on listallinen solmuja.
 * Emme tarvitse erillisiä kaaria sovelluksessa, koska kaarien paino 
 * solmujen välillä on vakituinen kussakin solmussa (yhteen solmuun vievät
 * kaaret ovat vakipainoisia), ja viereiset, saavutettavat solmut saadaan
 * koordinaattien avulla.
 * 
 * Verkko sisältää myös tiedon alkusolmun ja loppusolmun indekseistä
 * solmut[]-taulukossa
 * 
 * Verkon luomiseen liittyvä virheenhallinta löytyy jo käyttöliittymästä,
 * joten ainakaan toistaiseksi verkolle ei ole tarpeen tehdä testejä:
 * väärää syötettä ei voi tulla vastaan.
 * 
 * @author tuomo
 */
public class Verkko {
    private Solmu[] solmut;
    private int alkuSolmu;
    private int loppuSolmu;
    private int korkeus;
    private int leveys;

    public Verkko(char[][] kentta) {
        solmut = new Solmu[kentta[0].length * kentta.length];
        this.leveys = -1;

        this.luoVerkko(kentta);
    }
    /**
     * Rakentaa kentästä verkon syötetyn kentän perusteella
     * @param kentta kenttä taulukkomuodossa
     */
    public void luoVerkko(char[][] kentta) {
                    
        int x = 0;
        int y = 0;
        int i = 0;
        for (char[] kentta1 : kentta) {
            for (char l : kentta1) {
                if(l != '#' && l != 'Y' && l != 'X') {
                    solmut[i] = new Solmu(x, y, Integer.parseInt(l + ""), i);
                } else if (l == '#') {
                    solmut[i] = new Solmu(x, y, 100000, i);
                } else if (l == 'X') {
                    solmut[i] = new Solmu(x, y, 0, i);
                    alkuSolmu = i;
                } else if (l == 'Y') {
                    solmut[i] = new Solmu(x, y, 0, i);
                    loppuSolmu = i;
            }
                x++;
                i++;
            }
            if(this.leveys == -1) {
                this.leveys = x;
            }
            y++;
            x = 0;
        }
        this.korkeus = y;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }
    
    
    public Solmu[] getSolmut() {
        return solmut;
    }
    
    public int getLoppuSolmu() {
        return loppuSolmu;
    }
    
    public int getAlkuSolmu() {
        return alkuSolmu;
    }

}
