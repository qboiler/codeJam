/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2008.qualify;

import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author bryce
 */
public class ProblemCTest {
    
    public ProblemCTest() {
    }

    @Test
    public void testReadAndProcessCase() throws Exception {
    }
    
    
    @Test
    public void testProcess() throws Exception {
        executeTest("testcase");
    }
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("B-small-practice");
    }
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("B-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2008/qualify/p3/";
    
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
