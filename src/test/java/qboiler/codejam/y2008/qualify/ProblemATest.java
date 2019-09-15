/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2008.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;
import qboiler.codejam.Case;

/**
 *
 * @author bryce
 */
public class ProblemATest {
    
    public ProblemATest() {
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
        executeTest("A-small-practice");
    }
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("A-large-practice");
    }
    
    
    String directory = "/Users/bryce/projects/googleCode/2008/qualify/p1/";
    
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
