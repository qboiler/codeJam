/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemD extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        
        String s = br.readLine();
        String[] split = s.split(" ");

        if (split.length != 3) {
            throw new IllegalArgumentException(s + " does not split into two fields");
        }

        int k = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);
        int st = Integer.parseInt(split[2]);

        return new DCase(caseNumber, k,c,st);

    }

    class DCase extends Case {
        int k;
        int c;
        int st;
        long maxIndex;

        
        DCase(int pCase, int pK, int pC, int pSt) {
            super(pCase);
            k=pK;
            c=pC;
            st = pSt;
            Double d = Math.pow(k, c);
            maxIndex=d.longValue();
        }


        String result;
        @Override
        public String caseResult() {
            
//            XXXX
//                k^1+a
//                2*k^1+a
//                3*k^1+a
                        
                        
//                1*k^2+(k*(a-1))-a        
                    
//       1xGx,x2Gx,GGGG,xxG4
//              0*k+1,1*k+2, 2*k+3, 3*k+4;
//1xGx,xxGx,xxGx,xxGx,xxGx,x2Gx,GGGG,xxGx,xxGx,xxxx,xx3x,xxxx,xxxx,xxxx,xxxx,xxx4
//        0*k+1, 1*k*k +k +2, 2*k*k+2k+3, 3*k*k +3k+4
        
               // ---(i-1)*k^(c-1) + (i-1)*k+i
                //
                //
                //
                //
            
            return ""+result;
        }

        @Override
        public Case processCase() {
            //long maxIndex = 0;
            StringBuilder sb = new StringBuilder();
            if(k==2){
                if(st==1 && c>1){
                    sb.append(" 2");
                }else if(st==1 && c==1){
                    sb.append(" IMPOSSIBLE");
                }else{
                    BigInteger i = new BigInteger(""+k);
                    i = i.pow(c);
                    sb.append(" 1 " + i.longValueExact());
                }
            }else{
                if(st<k){
                    sb.append(" IMPOSSIBLE");
                }else{
                    for(int i =0;i<st;++i){
                        
                        long index = get(i+1,c);
                        assert index<=maxIndex:index +" > "+maxIndex;
                        sb.append(" " + index);
                    }
                }
            }
            result = sb.toString();
            return this;
        }
        
        public long get(int i, int depth){
            long result =i;
            if(depth>1){
                Double d = Math.pow(k, (depth-1)) * (i-1) ;
                d = d + get(i,(depth-1));
                result = d.longValue();
            }
            return result;
        }
        
    }
}
