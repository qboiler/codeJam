/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2010.qualify;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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
    public void test34() throws Exception {
//        0.001334 1.000000 0.000001 0.005970 0.002002
        // f, R, t, r and g s
        // .002002 - 2
        executeTest("t34");
    }
    @Test
    public void testSmallProcess() throws Exception {
        executeTest("C-small-practice");
    }
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("C-large-practice");
    }
//    @Test
//    public void testArchArea(){
//        ProblemC c = new ProblemC();
//        Assert.assertEquals(Math.PI*2*2/2,c.chordArea(4,2), .000000005 );
//    }
//
//    @Test
//    public void testArchLength(){
//        ProblemC testSubject = new ProblemC();
//        Assert.assertEquals(Math.sqrt(2)*2 ,testSubject.chordLength(0,2,2),.000000005);
//        Assert.assertEquals(Math.sqrt(2)*2 ,testSubject.chordLength(2,0,2),.000000005);
//        Assert.assertEquals(4 ,testSubject.chordLength(2,-2,2),.000000005);
//    }


    String directory = "/Users/bryce/projects/github/qboiler/codeJam/src/test/inputs/2010/qualifying/problemC/";

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
