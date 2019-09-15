/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1b.p4;

import qboiler.codejam.y2014.r1b.p4.ProblemD;
import qboiler.codejam.Case;
import java.io.BufferedReader;
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
public class ProblemDTest {

    public ProblemDTest() {
    }
    String directory = "/Users/bryce/projects/proto/gcodejam/comps/y2014/r1b/p4/src/test/inputs/";

    @Test
    @Ignore
    public void testTestCase() throws Exception {
        executeTest("test");
    }

    @Test
    public void testSmallProcess() throws Exception {
        executeTest("D-small-attempt0");
    }
    
    @Test
//    @Ignore
    public void testLargeProcess() throws Exception {
        executeTest("D-large");
    }
    
    private void executeTest(String inputFile) throws IOException {
        String caseBaseName = inputFile;
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
        String fileName = directory +caseBaseName;
        ProblemD instance = new ProblemD();
        instance.process(fileName);
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
    }

}
