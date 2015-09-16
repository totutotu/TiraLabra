               /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 *
 * @author tuomo
 */
public class KaynnistinTest extends TestCase {
    
    private Kaynnistin kaynnistin;
    
    public KaynnistinTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        kaynnistin = new Kaynnistin();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
