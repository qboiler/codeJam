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
import qboiler.codejam.y2016.a1.ProblemB.QCase;

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
        StringReader sr = new StringReader("3\n1 2 3\n2 3 5\n3 5 6\n2 3 4\n1 2 3\n");
        BufferedReader br = new BufferedReader(sr);
        ProblemB instance = new ProblemB();
        Case expResult = null;
        QCase result = (QCase)instance.readAndProcessCase(caseNumber, br);
        result.processCase();
        assertEquals(" 3 4 6", result.caseResult());
    }
    
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("B-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("B-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/a1/";
    
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
