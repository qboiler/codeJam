/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1b.p1;

import java.io.IOException;
import junit.framework.Assert;
import qboiler.codejam.y2014.r1b.p1.ProblemA;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author bryce
 */
public class ProblemATest {

    String directory = "/Users/bryce/projects/proto/gcodejam/comps/y2014/r1b/p1/src/test/inputs/";
    public ProblemATest() {
    }

    @Test
//    @Ignore
    public void testTestCase() throws Exception {
        executeTest("test");
    }

    @Test
    @Ignore
    public void testSmallProcess() throws Exception {
        executeTest("A-small-attempt0");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("A-large-practice");
    }
    
    private void executeTest(String inputFile) throws IOException {
        String caseBaseName = inputFile;
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
        String fileName = directory +caseBaseName;
        ProblemA instance = new ProblemA();
        instance.process(fileName);
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
    }
    
}
