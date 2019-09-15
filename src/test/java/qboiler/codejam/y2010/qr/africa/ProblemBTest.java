/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qr.africa;

import junit.framework.TestCase;

/**
 *
 * @author bryce
 */
public class ProblemBTest extends TestCase {
    
    public ProblemBTest(String testName) {
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

    public void testSmallProcess() throws Exception {
        System.out.println("process");
        String file = "/tmp/small";
        ProblemB instance = new ProblemB();
        instance.process(file);
    }
    
    public void testLargeProcess() throws Exception {
        System.out.println("process");
        String file = "/tmp/large";
        ProblemB instance = new ProblemB();
        instance.process(file);
    }
}
