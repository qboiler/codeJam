/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qr.africa;

import qboiler.codejam.Case;
import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author bryce
 */
public class ProblemCTest {
    
    public ProblemCTest() {
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
//    @I??gnore
    public void testLargeData() throws Exception {
        String file = "/Users/bryce/Downloads/C-large-practice";
        ProblemC instance = new ProblemC();
        instance.process(file);
    }
    
    @Test
    public void testSmallData() throws Exception {
        String file = "/Users/bryce/Downloads/C-small-practice";
        ProblemC instance = new ProblemC();
        instance.process(file);
    }
}