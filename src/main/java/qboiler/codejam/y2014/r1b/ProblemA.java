/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1b.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemA extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        Scanner s = new Scanner(br.readLine());
        int cnt = s.nextInt();
        ArrayList<String> strings = new ArrayList<>();
        for(int i =0;i<cnt;++i){
            strings.add(br.readLine().trim());
        }
        
        Case pcase = new PCase(caseNumber,cnt,strings);

        return pcase;
    }

    class Data{
        ArrayList<Integer> cnt = new ArrayList<Integer>();
        ArrayList<Character> chars = new ArrayList<Character>();
        String asString ="";
    }

    class PCase extends Case {

        int cnt;
        ArrayList<String> strings;
        ArrayList<Data> data = new ArrayList<Data>();
        int pcn;

        PCase(int caseNumber, int pcnt, ArrayList<String> ps){
            super(caseNumber);
            cnt = pcnt;
            strings =ps;
            pcn=caseNumber;
        }
        String result;

        @Override
        protected String caseResult() {
            return result;
        }

        @Override
        protected Case processCase() {
            for (String string : strings) {
                char[] d = string.toCharArray();
                Data rd = new Data();
                Character c = d[0];
                int cCount =1;
                for(int i=1;i<d.length;++i){
                    if(c.equals(d[i])){
                        ++cCount;
                    }else{
                        rd.asString += c;
                        rd.chars.add(c);
                        rd.cnt.add(cCount);
                        cCount=1;
                        c=d[i];
                    }
                }
                rd.asString +=c;
                rd.chars.add(c);
                rd.cnt.add(cCount);
                data.add(rd);
            }
            String lString = null;
            int distinctSize = 0;
            for(Data d:data){
                if(lString==null){
                    lString = d.asString;
                    distinctSize = lString.length();
                }else{
                    if(!lString.equals(d.asString)){
                        result = " Fegla Won";
                        return this;
                    }
                }
            }
            int operations = 0;
            System.out.println(distinctSize);
            for(int i = 0; i < distinctSize;++i){
                
                ArrayList<Integer> arrayList = new ArrayList<>();
                
                for(Data d: data){
                   arrayList.add(d.cnt.get(i)) ;//   operations += Math.abs((avg - d.cnt.get(i)));
                }
                
                operations += findMinOps(arrayList);
            }
            
            
            result = " "+ operations;// + " " + distinctSize;
            
            
           return this;
        }
        int findMinOps(ArrayList<Integer> i){
            int min = Integer.MAX_VALUE;
            for (Integer integer : i) {
                int test=0;
                for (Integer integer1 : i) {
                    test+=Math.abs(integer-integer1);
                }
                if(test<min){
                    min=test;
                }
            }
            return min;
        }
    }
}
