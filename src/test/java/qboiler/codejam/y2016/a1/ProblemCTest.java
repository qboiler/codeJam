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
import qboiler.codejam.y2016.a1.ProblemC.QCase;

/**
 *
 * @author bryce
 */
public class ProblemCTest {
    
    public ProblemCTest() {
    }
    
    @Test
    public void testReadAndProcessCase() throws Exception {
        System.out.println("readAndProcessCase");
        int caseNumber = 0;
//        StringReader sr = new StringReader("4\n" +
//"2 1 4 3");
//        StringReader sr = new StringReader("10\n" +
//"10 1 5 7 3 8 4 6 10 1");
//        StringReader sr = new StringReader("10\n" +
//"10 1 5 7 3 8 4 6 2 9");
        StringReader sr = new StringReader("10\n" +
"10 1 4 7 3 5 8 6 2 9");
//        StringReader sr = new StringReader("4\n" +
//"3 3 4 3");
        
        // This should be 10 when done correctly...
//        10
//  10 9 5 7 3 8 4 6 2 1
        // Other cases can be spawned from this case...
        
        
//        StringReader sr = new StringReader("10\n" +
//"7 8 10 10 9 2 9 6 3 3");
//        StringReader sr = new StringReader("10\n" +
//"7 8 10 10 9 2 9 6 3 3");
//        StringReader sr = new StringReader("10\n" +
//"7 8 10 10 9 2 9 6 3 3");
        BufferedReader br = new BufferedReader(sr);
        ProblemC instance = new ProblemC();
        Case expResult = null;
        QCase result = (QCase)instance.readAndProcessCase(caseNumber, br);
        result.processCase();
        assertEquals(" 3", result.caseResult());
    }
    
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("C-small-practice");
//        executeTest("c");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("C-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/a1/";
    
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
