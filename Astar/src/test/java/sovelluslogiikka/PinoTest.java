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
public class PinoTest extends TestCase {
    private Pino pino;
    
    public PinoTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        pino = new Pino(5);
        
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testTyhjaPinoOnTyhja() {
        assertEquals(this.pino.tyhja(), true);
    }
    
    public void testPalauttaaArvotOikeassaJarjestyksessa() {
        pino.lisaa(1);
        pino.lisaa(2);
        pino.lisaa(3);
        pino.lisaa(4);
        
        assertEquals(pino.pop(), 4);
        assertEquals(pino.pop(), 3);
        assertEquals(pino.pop(), 2);
        assertEquals(pino.pop(), 1);
    }
    
    public void testTaysiPinoToimii() {
        pino.lisaa(1);
        pino.lisaa(2);
        pino.lisaa(3);
        pino.lisaa(4);
        pino.lisaa(5);
        
        assertEquals(pino.pop(), 5);
        assertEquals(pino.pop(), 4);
        assertEquals(pino.pop(), 3);
        assertEquals(pino.pop(), 2);
        assertEquals(pino.pop(), 1);
        
    }
}
