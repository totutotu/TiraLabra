package toiminta;

import junit.framework.TestCase;
import sovelluslogiikka.Verkko;

public class AstarTest extends TestCase {
    private Verkko verkko;
    private Astar star;
    
    public AstarTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        star = new Astar(new Verkko(new char[][] { 
                { '1', '#', '1', 'Y'}, {'X', '#', '3', '8'}, 
        {'3', '3', '2', '4'}, {'#', '1', '1', '1'} }) );
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
}
