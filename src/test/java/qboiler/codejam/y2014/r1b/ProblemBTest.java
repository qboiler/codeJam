/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2014.r1b.p2;

import qboiler.codejam.y2014.r1b.p2.ProblemB;
import java.io.IOException;
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
public class ProblemBTest {
    
    public ProblemBTest() {
    }
    
    String directory = "/Users/bryce/projects/proto/gcodejam/comps/y2014/r1b/p2/src/test/inputs/";

    @Test
    @Ignore
    public void testTestCase() throws Exception {
        executeTest("test");
    }

    @Test
    @Ignore
    public void testSmallProcess() throws Exception {
        executeTest("B-small-practice");
    }
    
    @Test
//    @Ignore
    public void testLargeProcess() throws Exception {
        executeTest("B-large-practice");
    }
    
    private void executeTest(String inputFile) throws IOException {
        String caseBaseName = inputFile;
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
        String fileName = directory +caseBaseName;
        ProblemB instance = new ProblemB();
        instance.process(fileName);
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
    }
}
