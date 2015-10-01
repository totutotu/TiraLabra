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
public class VerkkoTest extends TestCase {
    private Verkko verkko;
    
    public VerkkoTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.verkko = new Verkko(new char[][] { 
                { '1', '#', '1', 'Y'}, {'X', '#', '3', '8'}, 
        {'3', '3', '2', '4'}, {'#', '1', '1',  '1'} });
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testAlkuSolmuIndeksiTallentuuOikein() {
        assertEquals(4, verkko.getAlkuSolmu());
        
    }
    
    public void testLoppuSolmuIndeksiTallentuuOikein() {
        assertEquals(3, verkko.getLoppuSolmu());
        
    }
}
