/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.qualify;

import java.io.IOException;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author bryce
 */
public class ProblemATest {

    String directory = "/Users/bryce/projects/googleCode/2016/r1a/p1/src/main/resources/";
    public ProblemATest() {
    }

    @Test
    @Ignore
    public void testTestCase() throws Exception {
        executeTest("input1");
    }

    @Test
    public void testSmallProcess() throws Exception {
        executeTest("A-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("A-large-practice");
    }
    
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
    
    @Test
    @Ignore
    public void bitTests(){

        int two = 2;
        int four =  4;
        int mask =2;
        System.out.println("[6] 4 ^ 2 = "+ (four^mask) );
        System.out.println("[0] 2 ^ 2 = "+ (two^mask) );
        
        System.out.println("[6] 4 | 2 = "+ (four|mask) );
        System.out.println("[0] 2 | 2 = "+ (two|mask) );

        System.out.println("[6] 4 & 2 = "+ (four&mask) );
        System.out.println("[0] 2 & 2 = "+ (two&mask) );
        
        
    }
}
