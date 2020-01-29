/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2014.qr;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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
 @Ignore
    public void testTestCase() throws Exception {
        System.out.println("process");
        String fileName = "/Users/bryce/projects/proto/codejam/inputs/2014/QR/test";
        ProblemA instance = new ProblemA();
        instance.process(fileName);
    }  
    @Test
    public void testSmallProcess() throws Exception {
        System.out.println("process");
        String fileName = "/Users/bryce/projects/proto/codejam/inputs/2014/QR/A-small-attempt0";
        ProblemA instance = new ProblemA();
        instance.process(fileName);
    }
}
