/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemB extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        int n = Integer.parseInt(br.readLine());
        
        TreeMap<Integer,AtomicInteger> input = new TreeMap<>();
        for(int i=0;i<2*n-1;++i){
            String[] sa =  br.readLine().split(" ");
            System.out.println("n: "+ n+" sa: " + sa.length);
            for(int k = 0; k<n;++k){
                
                Integer next =Integer.parseInt(sa[k]);
                if(!input.containsKey(next)){
                    input.put(next, new AtomicInteger(1));
                }else{
                    input.get(next).incrementAndGet();
                }
            }
        }
        
        
        return new QCase(caseNumber, n, input);

    }

    public class QCase extends Case {

        int n;
        TreeMap<Integer,AtomicInteger> input;

        QCase(int pCase, int pN, TreeMap<Integer,AtomicInteger> pInput) {
            super(pCase);
            n=pN;
            input=pInput;
        }
        

        String result;

        @Override
        protected String caseResult() {
            return " " + result;
        }

        @Override
        protected Case processCase() {
            int records =0;
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, AtomicInteger> entry : input.entrySet()) {
                Integer integer = entry.getKey();
                AtomicInteger atomicInteger = entry.getValue();
                if(atomicInteger.get()%2==1){
                    ++records;
                    sb.append(integer.intValue()).append(" ");
                }
            }
            
            if(records!=n){
                System.out.println("Error Condtion Think more");
            }
            result = sb.toString().trim();
            
            return this;
        }
    }
}
