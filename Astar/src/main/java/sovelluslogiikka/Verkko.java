
package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Verkko on listallinen solmuja.
 * Emme tarvitse erillisiä kaaria sovelluksessa, koska kaarien paino 
 * solmujen välillä on vakituinen kussakin solmussa (yhteen solmuun vievät
 * kaaret ovat vakipainoisia), ja viereiset, saavutettavat solmut saadaan
 * koordinaattien avulla.
 * 
 * @author tuomo
 */
public class Verkko {
    private Solmu[] solmut;

    public Verkko(Solmu[] solmut) {  
        this.solmut = solmut;
    }

    
    
    
    public Verkko(char[][] kentta) {
        
//        int x = 0;
//        int y = 0;
//        for (char[] kentta1 : kentta) {
//            for (char l : kentta1) {
//                if(l != '#') {
//                    solmut.add(new Solmu(x, y, Integer.parseInt(l + "")));
//                } else {
//                    solmut.add(new Solmu(x, y, Integer.MAX_VALUE));
//                }
//                x++;
//            }
//            y++;
//            x = 0;
//        }
    }
    
}
