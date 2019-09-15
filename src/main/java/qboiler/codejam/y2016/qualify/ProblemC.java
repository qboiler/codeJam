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
public class ProblemC extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        
        String s = br.readLine();
        String[] split = s.split(" ");

        if (split.length != 2) {
            throw new IllegalArgumentException(s + " does not split into two fields");
        }

        int length = Integer.parseInt(split[0]);
        int cases = Integer.parseInt(split[1]);

        return new CCase(caseNumber, length, cases);

    }

    class CCase extends Case {
        int base2size;
        int samples;
        long check;
        boolean foundSolution = false;
        long baseValue;

        long maxCore;
        long currentCore = -1;
        long[][] fresult;
        long[] result;
        long[] jamcoins;

        CCase(int pCase, int l, int n) {
            super(pCase);
            base2size = l;
            samples = n;
            this.maxCore = (long) Math.pow(2, base2size - 2) - 1;
            this.baseValue = (long) Math.pow(2, base2size - 1) + 1;
            this.jamcoins = new long[samples];
            this.fresult = new long[samples][10];
        }


        //String result;
        @Override
        public String caseResult() {

                
            StringBuilder sb = new StringBuilder();
            for(int i =0; i< samples;++i){
                sb.append(Long.toBinaryString(jamcoins[i]));
                sb.append(" ");
                for(int k=0; k<9; ++k){
                    sb.append(fresult[i][k]);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            
            return "\n" + sb.toString();

        }

        @Override
        public Case processCase() {

                run();
            return this;
        }


        void run() {

            for(int i =0; i<samples;++i){
                System.out.println("example: " + i);
                result = fresult[i];
                foundSolution=false;
                
                while (!foundSolution) {
                    currentCore += 1;
                    check = baseValue | (currentCore << 1);
                    foundSolution = checkValue(check);
                    System.out.println(baseValue + "Checking: " + check + " : " + foundSolution);
                    System.out.println(Long.toBinaryString(baseValue)
                            + "Checking: " + Long.toBinaryString(check)
                            + " : " + foundSolution);
                    
                    if (currentCore > maxCore) {
                        break;
                    }
                }
                jamcoins[i]=check;
            }
        }

        boolean checkValue(long la) {
            boolean works = true;
            byte[] b = new byte[base2size];
            long l = la;
            for (int i = 0; i < base2size; ++i) {
                b[i] = (byte) (l % 2);
                l = l / 2;
            }

            for (int i = 2; i <= 10; ++i) {
                for(int k=b.length-1; k>=0;--k){
                    System.out.print(b[k]);
                }
                System.out.println("");
                BigInteger dForBase = toDecimal(b, i);
                
                System.out.println(Long.toBinaryString(la) +" -> "+ dForBase + " : in Base "+i);
                long r = firstNonSimpleMultiple(dForBase);
                if (r != -1) {
                    result[i - 2] = r;
                } else {
                    works = false;
                }
            }
            return works;
        }

        int firstNonSimpleMultiple(BigInteger l) {
           // BigInteger checkLimiter = l;
            // -1 sentinal value did not find.
            int result = -1;
            BigInteger checkLimiter = new BigInteger("0");
            checkLimiter = checkLimiter.add(l);
            for (int i = 3; checkLimiter.compareTo(new BigInteger(""+i))>0; ++i) {
                if (l.remainder(new BigInteger(""+i)).intValue() == 0) {
                    result = i;
                    break;
                }
                checkLimiter = checkLimiter.divide(new BigInteger(""+i));
            }
            return result;
        }

        BigInteger toDecimal(byte[] b, int base) {
            BigInteger l = new BigInteger( "0");
            for (int i = 0; i < b.length; ++i) {
                if(b[i]==0){
                    continue;
                }
                //  assume Math.pow(base,i) is base^i;
                BigInteger other = new BigInteger(""+base);
                other = other.pow(i);
                other.multiply(new BigInteger(""+b[i]));
                l = other.add(l);//* b[i];
                
            }
            return l;
        }

    }
}
