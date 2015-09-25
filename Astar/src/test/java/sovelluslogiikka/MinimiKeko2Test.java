/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import junit.framework.TestCase;

/**
 *
 * @author tuomo
 */
public class MinimiKeko2Test extends TestCase {
    private MinimiKeko2 keko;
    private Solmu[] solmut;
    
    public MinimiKeko2Test(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //luodaan solmutaulukko, jossa solmut painoilla
        //3, 6, 2, 5, 1, 4, 0
        this.keko = new MinimiKeko2(7);
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
        this.keko.asetaSolmu(0, this.solmut[0].getPaino());
        
        assertEquals(0, keko.pieninSolmu());
    }
    
        public void testPalauttaaPienimmanSolmunKolmestaSyotetysta() {
        for (int i = 0; i < 3; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }
        
        assertEquals(2, keko.pieninSolmu());
    }
        
    public void testPalauttaaKolmePienintaSolmuaJarjestyksessa() {
        for (int i = 0; i < 3; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }

        assertEquals(2, keko.pieninSolmu());
        assertEquals(0, keko.pieninSolmu());
        assertEquals(1, keko.pieninSolmu());
    }

    public void testPalauttaaViisiPienintaSolmuaJarjestyksessa() {
        for (int i = 0; i < 5; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }

        assertEquals(4, keko.pieninSolmu());
        assertEquals(2, keko.pieninSolmu());
        assertEquals(0, keko.pieninSolmu());
        assertEquals(3, keko.pieninSolmu());
        assertEquals(1, keko.pieninSolmu());

    }

    public void testPystyySyottamaanKeonTayteen() {
        for (int i = 0; i < 7; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }
    }

    public void testTaysiKekoOnJarjestyksessa() {
        for (int i = 0; i < 7; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }
        assertEquals(6, keko.pieninSolmu());
        assertEquals(4, keko.pieninSolmu());
        assertEquals(2, keko.pieninSolmu());        
        assertEquals(0, keko.pieninSolmu());
        assertEquals(5, keko.pieninSolmu());
        assertEquals(3, keko.pieninSolmu());
        assertEquals(1, keko.pieninSolmu());

    }

    public void testArvojenLaskeminenKorjaaKeonOikein() {
        for (int i = 0; i < 7; i++) {
            this.keko.asetaSolmu(i, this.solmut[i].getPaino());
        }
        
        this.keko.laskePainoa(3, 0);
        
        assertEquals(6, keko.pieninSolmu());
        assertEquals(3, keko.pieninSolmu());
    }
}   

