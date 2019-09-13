/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1a.p1;

import java.io.BufferedReader;
import java.io.IOException;
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
        int devices = s.nextInt();
        int switches = s.nextInt();
        s = new Scanner(br.readLine());
        String[] devicesArray;// = new String[devices];
        String[] currentFlows;// = new String[devices];
        devicesArray = s.nextLine().split(" ");
        s = new Scanner(br.readLine());
        currentFlows = s.nextLine().split(" ");

        return new PCase(caseNumber, devices, switches, devicesArray, currentFlows);

    }
    static int[] masks;// = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
    static {
        masks = new int[40];
        masks[0]=1;
        for(int i =1; i<40;++i){
            masks[i] = masks[i-1]*2;
        }
    }

    public static int getInt(String s) {
        int i = 0;
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; ++j) {
            if (chars[chars.length - 1 - j] == '1') {
                i += masks[j];
            }
        }
        return i;
    }

    static TreeSet<Integer> getSet(String[] i) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int j = 0; j < i.length; ++j) {
            s.add(getInt(i[j]));
        }
        return s;
    }

    static int maskString(String s, int[] mask) {
        int in = getInt(s);
        for (int i = 0; i < mask.length; ++i) {
            in = in ^ mask[i];
        }
        return in;
    }

    static TreeSet<Integer> getSet(String[] i, int[] masks) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int j = 0; j < i.length; ++j) {
            s.add(maskString(i[j], masks));
        }
        return s;
    }

    static int[] getMasks(String required, String change) {
        char[] r = required.toCharArray();
        char[] c = change.toCharArray();
        int[] maskee = new int[r.length];
        int switches = 0;
        for (int i = 0; i < r.length; ++i) {
            if (r[r.length - 1 - i] == c[r.length - 1 - i]) {
                //maskee[i]=0;
            } else {
                maskee[switches] = masks[i];
                ++switches;
            }
        }
        return Arrays.copyOfRange(maskee, 0, switches);
    }

    class PCase extends Case {

        int devices;
        int switches;
        String[] devicesArray;
        String[] currentFlows;

        PCase(int caseNumber, int pDevices, int pSwitches, String[] pDA, String[] pSA) {
            super(caseNumber);
            devices = pDevices;
            switches = pSwitches;
            devicesArray = pDA;
            currentFlows = pSA;
        }
        String result;

        @Override
        protected String caseResult() {
            return result;
        }

        @Override
        protected Case processCase() {
            String firstRecord = devicesArray[0];
            TreeSet<Integer> deviceInputs = getSet(devicesArray);
            int minLength = Integer.MAX_VALUE;
            for(int i=0;i<currentFlows.length;++i){
                int[] maskTest = getMasks(firstRecord, currentFlows[i]);
                int sReq = maskTest.length;
                TreeSet<Integer> maskedSet = getSet(currentFlows, maskTest);
                boolean rs = true;
                for (Integer integer : deviceInputs) {
                    if(integer.intValue() != maskedSet.pollFirst()){
                        rs = false;
                    }
                }
                if(rs  && sReq < minLength){
                    minLength = sReq;
                }
            }
            
            if(minLength>40){
                result = " NOT POSSIBLE";
            }else{
            result = " "+minLength;
            }
                return this;
            
        }
    }
}
