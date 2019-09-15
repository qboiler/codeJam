/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1b.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemB extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        Scanner s = new Scanner(br.readLine());
        int a = s.nextInt();
        int b = s.nextInt();
        int k = s.nextInt();

        Case pcase = new PCase(caseNumber, a, b, k);

        return pcase;
    }

    class PCase extends Case {

        final int a;
        final int b;
        final int k;

        PCase(int caseNumber, int pa, int pb, int pk) {
            super(caseNumber);
            a = pa;
            b = pb;
            k = pk;

            System.out.println(caseNumber + " : " + a + ", " + b + ", " + k);
        }

        String result;

        @Override
        protected String caseResult() {
            return result;
        }

        @Override
        protected Case processCase() {
            int matches = 0;
            for (int i = 0; i < a; ++i) {
                for (int j = 0; j < b; ++j) {
                    
                    if ((i & j) < k) {
//                        System.out.println(a +" & "+ b+ " = "+ value + " < " + k);
                        matches++;
                    }else{
//                        System.out.println(a +" & "+ b+ " = "+ value + " > " + k);
                    }
                }
            }
            result = " " + matches;
            return this;
        }
    }
}
