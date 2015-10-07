package toiminta;

import junit.framework.TestCase;
import sovelluslogiikka.Verkko;

public class AstarTest extends TestCase {
    private Verkko verkko;
    private Astar star;
    private Astar star2;
    private Astar star3;
    
    public AstarTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        star = new Astar(new Verkko(new char[][] { 
                { '1', '#', '1', 'Y'}, {'X', '#', '3', '8'}, 
        {'3', '3', '2', '4'}, {'#', '1', '1', '1'} }) );
        star2 = new Astar(new Verkko(new char[][] { 
                { 'X', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'}, 
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '9'}, 
                { '#', '#', '#', '#', '#', '#', '1', '2', '3', '2', '4'}, 
                { '#', '#', '#', '#', '#', '#', '1', '1', '1', '1', '9'}, 
		{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '9'},           
		{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '9'}, 
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '9'},           
		{ 'Y', '#', '#', '#', '#', '#', '#', '1', '1', '1', '9'}, 
                { '9', '#', '1', '2', '1', '3', '1', '3', '1', '#', '9'}, 
                { '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'}, 
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'} }) );
        star3 = new Astar(new Verkko(new char[][] { {'X', '#', '#'}, {'#', '#', '#'}, {'Y', '#', '#'}}));
        
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testPalauttaaOikeanReitin() {
        char[][] reitti = star.etsiPolku();
        char[][] maali = new char[4][4];
        
        maali[0][2] = 'R';
        maali[0][3] = 'R';
        maali[1][0] = 'R';
        maali[1][2] = 'R';
        maali[2][0] = 'R';
        maali[2][1] = 'R';
        maali[2][2] = 'R';
        int i = 0;
        int j = 0;
        
        for (char[] reitti1 : reitti) {
            for (char s : reitti1) {
                assertEquals(maali[j][i], s);
                i++;
            }
            i = 0;
            j++;
        }
    }
    
    public void testPalauttaaOikeanReitin2() {
        char[][] reitti = star2.etsiPolku();
        char[][] maali = new char[11][11];
        
        maali[0][0] = 'R';
        maali[0][1] = 'R';
        maali[0][2] = 'R';
        maali[0][3] = 'R';
        maali[0][4] = 'R';
        maali[0][5] = 'R';
        maali[0][6] = 'R';
        maali[0][7] = 'R';
        maali[0][8] = 'R';
        maali[0][9] = 'R';
        maali[0][10] = 'R';
        maali[1][10] = 'R';
        maali[2][10] = 'R';
        maali[3][10] = 'R';
        maali[4][10] = 'R';
        maali[5][10] = 'R';
        maali[6][10] = 'R';
        maali[7][10] = 'R';
        maali[7][9] = 'R';
        maali[7][8] = 'R';
        maali[8][8] = 'R';
        maali[9][8] = 'R';
        maali[10][8] = 'R';
        maali[10][7] = 'R';
        maali[10][6] = 'R';
        maali[10][5] = 'R';
        maali[10][4] = 'R';
        maali[10][3] = 'R';
        maali[10][2] = 'R';
        maali[10][1] = 'R';
        maali[10][0] = 'R';
        maali[9][0] = 'R';
        maali[8][0] = 'R';
        maali[7][0] = 'R';
    
        int i = 0;
        int j = 0;
        for (char[] reitti1 : reitti) {
            for (char s : reitti1) {
                assertEquals(maali[j][i], s);
                i++;
            }
            i = 0;
            j++;
        }
    }
    public void testRatkaisutonKenttaEiKaadaOhjelmaa() {
        char[][] reitti = star3.etsiPolku();
        assertEquals(reitti, null);
    }
}
