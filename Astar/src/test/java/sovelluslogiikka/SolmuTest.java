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
public class SolmuTest extends TestCase {
    
    public SolmuTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSolmuTallentuuAnnetuillaParametreilla() {
        Solmu solmu  = new Solmu(1,4,5);
        assertEquals(1, solmu.getX());
        assertEquals(4, solmu.getY());
        assertEquals(5, solmu.getPaino());
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
