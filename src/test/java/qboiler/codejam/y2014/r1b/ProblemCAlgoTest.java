/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1b.p3;

import qboiler.codejam.y2014.r1b.p3.ProblemC;
import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import qboiler.codejam.Case;
import qboiler.codejam.y2014.r1b.p3.ProblemC.PCase;

/**
 *
 * @author bryce
 */
public class ProblemCAlgoTest {

    public ProblemCAlgoTest() {
    }

    @Test
    public void testBadAlgo() {
        System.out.println("*************************************");
        System.out.println("BAD");
        System.out.println("BAD");
        System.out.println("*************************************");

        ProblemC instance = new ProblemC();
        int countGood = 0;
        int countBad = 0;
        for (int i = 0; i < 120; ++i) {
        int max=0;
        int min=1000;
        int c488 = 0;
            int count = 0;
            int[] result = instance.badAlgo();
            for (int j = 0; j < 1000; ++j) {
                if (result[j] <= j) {
                    count++;
                }
//                System.out.println(j + ", " + result[j]);
            }
            if(count>488){
                c488++;
            }
            if(count>max){
                max=count;
            }
            if(count<min){
                min=count;
            }
            
            System.out.println("B case " + i + ": " + count +": "+ c488+" : "+max+" : "+min );
//            ProblemC pc = new ProblemC();
//            PCase pcase = pc.new PCase(i, 1000, result);
//            if (pcase.processCase().caseResult().equals(" GOOD")) {
//                countGood++;
//            } else {
//                countBad++;
//            }
//            for (int j = 0; j < 1000; ++j) {
//                System.out.print(result[j] + " ");
//            }
//            System.out.println();
        }
//        System.out.println(countGood +":"+countBad);
    }

    @Test
    public void testGoodAlgo() {
        System.out.println("*************************************");
        System.out.println("GOOD");
        System.out.println("GOOD");
        System.out.println("*************************************");
        ProblemC instance = new ProblemC();
        int countGood = 0;
        int countBad = 0;
        for (int i = 0; i < 120; ++i) {
        int max=0;
        int min=1000;
        int c488 = 0;
            int count = 0;
            int[] result = instance.goodAlgo();
            for (int j = 0; j < 1000; ++j) {
                
                if (result[j] <= j) {
                    count++;
                }
//                System.out.println(j + ", " + result[j]);
            }
            if(count<=488){
                c488++;
            }
            if(count>max){
                max=count;
            }
            if(count<min){
                min=count;
            }
            
            System.out.println("G case " + i + ": " + count +": "+ c488+" : "+max+" : "+min );
//            ProblemC pc = new ProblemC();
//            PCase pcase = pc.new PCase(i,1000,result);
//            if(pcase.processCase().caseResult().equals(" GOOD")){
//                countGood++;
//            }else{
//                countBad++;
//            }
//            for(int j=0;j<1000;++j){
//                System.out.print(result[j] + " ");
//            }
//                System.out.println();
//        }
//        System.out.println(countGood +":"+countBad);
        }

    }
}
