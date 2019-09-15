/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qr.africa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryce
 */
public class ProblemATest {
    
    public ProblemATest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSmallProcess() throws Exception {
        System.out.println("process");
        String fileName = "/Users/bryce/Downloads/A-small-practice";
        ProblemA instance = new ProblemA();
        instance.process(fileName);
    }
    @Test
    public void testLargeProcess() throws Exception {
        System.out.println("process");
        String fileName = "/Users/bryce/Downloads/A-large-practice";
        ProblemA instance = new ProblemA();
        instance.process(fileName);
    }
}