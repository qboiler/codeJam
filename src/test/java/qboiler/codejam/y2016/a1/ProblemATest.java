/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2016.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.*;
import org.junit.Test;
import qboiler.codejam.Case;
import qboiler.codejam.y2016.a1.ProblemA.PCase;

/**
 *
 * @author bryce
 */
public class ProblemATest {
    
    public ProblemATest() {
    }
    
    @Test
    public void testReadAndProcessCase() throws Exception {
        System.out.println("readAndProcessCase");
        int caseNumber = 0;
        StringReader sr = new StringReader("dfafdsfasdfasdfa");
        BufferedReader br = new BufferedReader(sr);
        ProblemA instance = new ProblemA();
        Case expResult = null;
        PCase result = (PCase)instance.readAndProcessCase(caseNumber, br);
        result.processCase();
        assertEquals(" IMPOSSIBLE", result.caseResult());
    }
    
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("A-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("A-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/a1/";
    
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
