/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2009.qualify;

import org.junit.Test;

import java.io.IOException;

/**
 *
 * @author bryce
 */
public class ProblemBTest {

    public ProblemBTest() {
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


    String directory = "/Users/bryce/projects/github/qboiler/codeJam/src/test/inputs/2009/qualifying/problemB/";

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
