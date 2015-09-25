
package sovelluslogiikka;

import junit.framework.TestCase;

public class MinimiKekoTest extends TestCase {
    
    private MinimiKeko keko;
    private Solmu[] solmut;
    
    public MinimiKekoTest(String testName) {
        super(testName);
    }
    
    public static void setUpClass() throws Exception {
        
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //luodaan solmutaulukko, jossa solmut painoilla
        //3, 6, 2, 5, 1, 4, 0
        this.keko = new MinimiKeko(7);
        this.solmut = new Solmu[7];
        for (int i = 1; i <= 7; i++) {
            solmut[i - 1] = new Solmu(2, 4, (i * 3 ) % 7, 1);
        }
    }
    
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testPalauttaaYhdenSyotetynSolmun() {
        this.keko.asetaSolmu(this.solmut[0]);
        
        assertEquals(this.solmut[0], keko.pieninSolmu());
    }
    
    public void testPalauttaaPienimmanSolmunKolmestaSyotetysta() {
        for (int i = 0; i < 3; i++) {
            this.keko.asetaSolmu(this.solmut[i]);
        }
        
        assertEquals(this.solmut[2], keko.pieninSolmu());
    }
    
    public void testPalauttaaKolmePienintaSolmuaJarjestyksessa() {
        for (int i = 0; i < 3; i++) {
            this.keko.asetaSolmu(this.solmut[i]);
        }
        
        assertEquals(this.solmut[2], keko.pieninSolmu());
        assertEquals(this.solmut[0], keko.pieninSolmu());
        assertEquals(this.solmut[1], keko.pieninSolmu());
    }
    
//    public void testPalauttaaViisiPienintaSolmuaJarjestyksessa() {
//        for (int i = 0; i < 5; i++) {
//            this.keko.asetaSolmu(this.solmut[i]);
//        }
//        
//        assertEquals(this.solmut[4].getPaino(), keko.pieninSolmu().getPaino());
//        assertEquals(this.solmut[2].getPaino(), keko.pieninSolmu().getPaino());
//        assertEquals(this.solmut[0].getPaino(), keko.pieninSolmu().getPaino());
//        assertEquals(this.solmut[3].getPaino(), keko.pieninSolmu().getPaino());
//        assertEquals(this.solmut[1].getPaino(), keko.pieninSolmu().getPaino());
//    
//    }
//    
//    public void testPystyySyottamaanKeonTayteen() {
//        for (int i = 0; i < 7; i++) {
//            this.keko.asetaSolmu(this.solmut[i]);
//        }
//    }
//    
//    public void testTaysiKekoOnJarjestyksessa() {
//        for (int i = 0; i < 7; i++) {
//            this.keko.asetaSolmu(this.solmut[i]);
//        }
//        assertEquals(this.solmut[6], keko.pieninSolmu());
//        assertEquals(this.solmut[4], keko.pieninSolmu());
//        assertEquals(this.solmut[2], keko.pieninSolmu());        
//        assertEquals(this.solmut[0], keko.pieninSolmu());
//        assertEquals(this.solmut[5], keko.pieninSolmu());
//        assertEquals(this.solmut[3], keko.pieninSolmu());
//        assertEquals(this.solmut[1], keko.pieninSolmu());
//
//    }
//    
//    public void testPalauttaaOikeatSolmutArvojaKasvatettua() {
//        
//    }


    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
 
}
