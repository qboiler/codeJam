/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemB extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        String s =         br.readLine();
        
        return new BCase(caseNumber, s);

    }


    class BCase extends Case {


        private String startNum;
        BCase(int pCase , String pStartNum){
            super(pCase);
            startNum = pStartNum;
        }

        
        String result;
        int switches=0;
        int endSwitch = 0;

        @Override
        public String caseResult() {
            return " "+String.valueOf((switches+endSwitch));
        }

        @Override
        public Case processCase() {
            char next;
            char last;
            last = startNum.charAt(0);
            for(int i =1; i<startNum.length(); ++i){
                next = startNum.charAt(i);
                if(next!=last){
                    ++switches;
                }
                last = next;
            }
            endSwitch = (last=='-')?1:0;
            
            return this;
        }

    }
}
