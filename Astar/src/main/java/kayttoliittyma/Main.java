package kayttoliittyma;

import sovelluslogiikka.MinimiKeko;
import sovelluslogiikka.MinimiKeko2;
import sovelluslogiikka.Solmu;
import sovelluslogiikka.Verkko;
import toiminta.Astar;

public class Main {
    public static void main(String[] args) {

        char[][] kentta = new char[][] { 
                { '1', '#', '1', 'Y'}, {'X', '#', '3', '8'}, 
        {'3', '3', '2', '4'}, {'#', '1', '1', '1'} };
        
        Verkko verkko = new Verkko(kentta);
        Astar star = new Astar(verkko);
        star.etsiPolku();
        
        
    }

}
