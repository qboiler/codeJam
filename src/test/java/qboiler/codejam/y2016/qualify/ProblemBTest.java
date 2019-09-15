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
import qboiler.codejam.y2016.qualify.ProblemB.BCase;

/**
 *
 * @author bryce
 */
public class ProblemBTest {
    
    public ProblemBTest() {
    }

    @Test
    public void testReadAndProcessCase() throws Exception {
        System.out.println("readAndProcessCase");
        int caseNumber = 0;
        StringReader sr = new StringReader("-++-");
        BufferedReader br = new BufferedReader(sr);
        ProblemB instance = new ProblemB();
        Case expResult = null;
        BCase result = (BCase)instance.readAndProcessCase(caseNumber, br);
        result.processCase();
        assertEquals("3", result.caseResult());
    }
    
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("B-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("B-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/";
    
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
