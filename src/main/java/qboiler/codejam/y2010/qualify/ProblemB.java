/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qualify;

import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author bryce
 */
class ProblemB extends CodeJamBase {

    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        int turnTimeMin = Integer.parseInt(br.readLine());
        int[] abba = intArrayFromString(br.readLine());
        ArrayList<Long> departureA = new ArrayList<>();
        ArrayList<Long> arrivalB = new ArrayList<>();
        ArrayList<Long> departureB = new ArrayList<>();
        ArrayList<Long> arrivalA = new ArrayList<>();
        try {

        for(int i=0;i<abba[0];++i){
            String[] nl = br.readLine().split(" ");
            long depart = sdf.parse(nl[0]).getTime();
            long arrive = sdf.parse(nl[1]).getTime() + turnTimeMin*60*1000;

            departureA.add(depart);
            arrivalB.add(arrive);
        }
        for(int i=0;i<abba[1];++i){
            String[] nl = br.readLine().split(" ");
            long depart = sdf.parse(nl[0]).getTime();
            long arrive = sdf.parse(nl[1]).getTime() + turnTimeMin*60*1000;
            departureB.add(depart);
            arrivalA.add(arrive);
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collections.sort(departureA);
        Collections.sort(departureB);
        Collections.sort(arrivalA);
        Collections.sort(arrivalB);

        return new PCase(caseNumber, departureA,departureB,arrivalA,arrivalB);

    }

    static class PCase extends Case {
        ArrayList<Long> departureA = new ArrayList<>();
        ArrayList<Long> arrivalB = new ArrayList<>();
        ArrayList<Long> departureB = new ArrayList<>();
        ArrayList<Long> arrivalA = new ArrayList<>();


        PCase(int caseNumber, ArrayList<Long> ldepartureA,ArrayList<Long> ldepartureB
                ,ArrayList<Long> larrivalA,ArrayList<Long> larrivalB) {
            super(caseNumber);
            departureA = ldepartureA;
            departureB=ldepartureB;
            arrivalA = larrivalA;
            arrivalB = larrivalB;
            System.out.println("Case Number"+caseNumber);

        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        public Case processCase() {
            int aReq = 0;
            int bReq = 0;
            for(int i =0;i<departureA.size();++i){
                if(!arrivalA.isEmpty() && arrivalA.get(0)<=departureA.get(i)){
                    arrivalA.remove(0);
                }else{
                    String nextArrival = (arrivalA.isEmpty())?"none":sdf.format(arrivalA.get(0));
                    System.out.println(i+" i "+sdf.format(new Date(departureA.get(i))) +" : " + nextArrival);

                    ++aReq;
                }
            }
            for(int i=0;i<departureB.size();++i){
                if(!arrivalB.isEmpty() && arrivalB.get(0)<=departureB.get(i)){
                    arrivalB.remove(0);
                }else{
                    ++bReq;
                }
            }
            result ="" + aReq+" "+bReq;
            return this;
        }
    }
}
