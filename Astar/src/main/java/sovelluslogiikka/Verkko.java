
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
 * 
 * 
 * @author tuomo
 */
public class Verkko {
    private Solmu[] solmut;
    private int alkuSolmu;
    private int loppuSolmu;

    public Verkko(char[][] kentta) {
        solmut = new Solmu[kentta[0].length * kentta.length];
        this.luoVerkko(kentta);
    }

    public void luoVerkko(char[][] kentta) {
                
        
        int x = 0;
        int y = 0;
        int i = 0;
        for (char[] kentta1 : kentta) {
            for (char l : kentta1) {
                if(l != '#' && l != 'Y' && l != 'X') {
                    solmut[i] = new Solmu(x, y, Integer.parseInt(l + ""));
                } else if (l == '#') {
                    solmut[i] = new Solmu(x, y, Integer.MAX_VALUE);
                } else if (l == 'X') {
                    solmut[i] = new Solmu(x, y, 0);
                    alkuSolmu = i;
                } else if (l == 'Y') {
                    solmut[i] = new Solmu(x, y, 0);
                    loppuSolmu = i;
            }
                x++;
                i++;
            }
            y++;
            x = 0;
        }
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

    
//    Onko tarpeellinen? Verkon läpikäynti riveittäin onnistuu näin
//    public void tulostaVerkko() {
//        int rivi = solmut[0].getY();
//        for (Solmu solmut1 : solmut) {
//            if(solmut1.getY() > rivi){
//                System.out.println("");
//                rivi++;
//            }
//            System.out.print(solmut1.getPaino());
//            
//        }
//    }
    
}
