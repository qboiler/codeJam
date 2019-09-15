/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2008.r1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemA extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
 
        int vectorLength = Integer.parseInt(br.readLine());
        String[] sV1 = br.readLine().split(" ");
        String[] sV2 = br.readLine().split(" ");
        long[] iV1 = new long[vectorLength];
        long[] iV2 = new long[vectorLength];
        for (int i = 0; i < vectorLength; i++) {
            iV1[i] = Long.parseLong(sV1[i]);
            iV2[i] = Long.parseLong(sV2[i]);
        }
        Arrays.sort(iV2);
        Arrays.sort(iV1);
        return new PCase(caseNumber,iV1,iV2);

    }

    class PCase extends Case {
        long[] vec1;
        long[] vec2;

        PCase(int caseNumber,long[] iV1, long[] iV2 ) {
            super(caseNumber);
            vec1=iV1;
            vec2=iV2;
        }
        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        protected Case processCase() {
            long resultt = 0;
            int lastIndex = vec1.length-1;
            for(int i=0;i<vec1.length; ++i , lastIndex--){
                resultt +=vec1[i]*vec2[lastIndex];
            }
            result = String.valueOf(resultt);
            return this;
        }
    }
}
