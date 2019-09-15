/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2016.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.*;
import org.junit.Test;
import qboiler.codejam.Case;
import qboiler.codejam.y2016.qualify.ProblemD.DCase;

/**
 *
 * @author bryce
 */
public class ProblemDTest {
    
    public ProblemDTest() {
    }

    @Test
    public void testReadAndProcessCase() throws Exception {
        System.out.println("readAndProcessCase");
        int caseNumber = 0;
        StringReader sr = new StringReader("91 1 91");
        BufferedReader br = new BufferedReader(sr);
        ProblemD instance = new ProblemD();
        Case expResult = null;
        DCase result = (DCase)instance.readAndProcessCase(caseNumber, br);
        result.processCase();
        assertEquals(" IMPOSSIBLE", result.caseResult());
    }
    
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("D-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("D-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/";
    
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
