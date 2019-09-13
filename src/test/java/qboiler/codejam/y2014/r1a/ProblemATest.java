/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1a;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import qboiler.codejam.y2014.r1a.ProblemA;

/**
 *
 * @author bryce
 */
public class ProblemATest {

    public ProblemATest() {
    }

    @Test
    @Ignore
    public void testTestCase() throws Exception {
        executeTest("test");
    }

    @Test
    @Ignore
    public void testSmallProcess() throws Exception {
        executeTest("A-small-practice");
    }
    
    @Test
    public void testLargeProcess() throws Exception {
        executeTest("A-large-practice");
    }
    
    private void executeTest(final String caseBaseName) throws IOException {
        String directory = "./src/test/inputs/";

        File f = new File(directory);

        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + f.getCanonicalPath());
        String fileName = directory +caseBaseName;
        ProblemA instance = new ProblemA();
        instance.process(fileName);
        System.out.println("Execute: " + caseBaseName);
        System.out.println("Looking in:  " + directory);
    }
    
    @Test
    @Ignore
    public void testGetInt(){
        Assert.assertEquals(1, ProblemA.getInt("001"));
        Assert.assertEquals(2, ProblemA.getInt("010"));
        Assert.assertEquals(3, ProblemA.getInt("011"));
        Assert.assertEquals(4, ProblemA.getInt("100"));
        Assert.assertEquals(5, ProblemA.getInt("101"));
        Assert.assertEquals(6, ProblemA.getInt("110"));
        Assert.assertEquals(7, ProblemA.getInt("111"));
        Assert.assertEquals(128, ProblemA.getInt("10000000"));
        Assert.assertEquals(256, ProblemA.getInt("100000000"));
        Assert.assertEquals(255, ProblemA.getInt("011111111"));
        Assert.assertEquals(257, ProblemA.getInt("100000001"));
        Assert.assertEquals(256, ProblemA.getInt("0100000000"));
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
