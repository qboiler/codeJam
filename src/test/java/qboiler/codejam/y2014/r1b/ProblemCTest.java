/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2014.r1b.p3;

import qboiler.codejam.y2014.r1b.p3.ProblemC;
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
public class ProblemCTest {
    
    public ProblemCTest() {
    }
    String directory = "/Users/bryce/projects/proto/gcodejam/comps/y2014/r1b/p3/src/test/inputs/";

    @Test
    @Ignore
    public void testTestCase() throws Exception {
        executeTest("test");
    }

    @Test
    public void testSmallProcess() throws Exception {
        executeTest("C-small-practice");
    }
    
    @Test
    @Ignore
    public void testLargeProcess() throws Exception {
        executeTest("C-large");
    }
    
    private void executeTest(String inputFile) throws IOException {
        String caseBaseName = inputFile;
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
        String fileName = directory +caseBaseName;
        ProblemC instance = new ProblemC();
        instance.process(fileName);
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
    }
}
