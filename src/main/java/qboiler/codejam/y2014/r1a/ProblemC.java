/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1a.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemC extends CodeJamBase {
    
    int[] badAlgo(){
        int[] i = new int[1000];
        for(int j=0;j<1000;++j){
            i[j]=j;
        }
        Random r = new Random();
        for(int j=0;j<1000;++j){
            int spot = r.nextInt(1000);
            int tmp = i[j];
            i[j]=i[spot];
            i[spot]=tmp;
        }
        return i;
    }
    int[] goodAlgo(){
        int[] i = new int[1000];
        for(int j=0;j<1000;++j){
            i[j]=j;
        }
        Random r = new Random();
        for(int j=0;j<1000;++j){
            int spot = j+r.nextInt(1000-j);
            int tmp = i[j];
            i[j]=i[spot];
            i[spot]=tmp;
        }
        return i;
    }

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        Scanner s = new Scanner(br.readLine());
        int cnt = s.nextInt();
        s = new Scanner(br.readLine());
        int[] points = new int[cnt];
        for(int i=0;i<cnt;++i){
            points[i] = s.nextInt();
        }
        return new PCase(caseNumber, cnt, points);
         }

    public class PCase extends Case {

        //slope = (n*sumxy - sumx*sumy) / (n*sumx2 - sumx*sumx)   

        int[] points;
        int cnt;
        public PCase(int caseNumber, int c,int[] po) {
            super(caseNumber);
            cnt =c;
            points = po;
        }
        String result = "";

        @Override
        public String caseResult() {
            return result;
        }

        @Override
        public Case processCase() {
            
            int count =0;
            for(int i=0;i<points.length;++i){
                if(points[i]<=i){
                    count++;
                }
            }
            
            if(count>=488){
                result = " GOOD";
            }else{
                result = " BAD";
            }
            return this;
        }
    }
}
