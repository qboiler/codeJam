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
public class ProblemA extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        String s =         br.readLine();
        Integer start = Integer.parseInt(s);
        return new PCase(caseNumber, start);

    }


    public class PCase extends Case {


        private long startNum;
        PCase(int pCase , int pStartNum){
            
            super(pCase);
            startNum = pStartNum;
        }
        
        String result;

        @Override
        protected String caseResult() {
            boolean[] bucketSort = new boolean[10];
            for(int i = 0; i<10;++i){
                bucketSort[i]=false;
            }
            long lastSpoken = startNum;
            List<Long> indexes = getIndexs(lastSpoken);
            for(Long n: indexes){
                
                bucketSort[n.intValue()]=true;
            
            }
            int loopCounter = 2;
            while(loopCounter<1000 
                    && !checkBucket(bucketSort)){
            lastSpoken=startNum*loopCounter;
            indexes = getIndexs(lastSpoken);
            for(Long n: indexes){
                
                bucketSort[n.intValue()]=true;
                System.out.println("bs["+n+"] = true");
            
            }
            System.out.println("Checking: "+ lastSpoken);
            ++loopCounter;
                
                
            }
            if(checkBucket(bucketSort)){
                result = " "+lastSpoken;
            }else{
                result = " INSOMNIA";
            }
            
            
            return result;
        }
        
        private boolean checkBucket(boolean[] pBuckets){
            boolean result = true;
            for (boolean b : pBuckets) {
                if(!b){
                    result=false;
                    break;
                }
            }
            return result;
        }

        @Override
        protected Case processCase() {
            
            return this;
        }

        private List<Long> getIndexs(long input) {
            ArrayList<Long> vals = new ArrayList<>();
            while(input>0){
                Long n = input%10;
                vals.add(n);
                input = input/10;
            }
            return vals;
        }
    }
}
