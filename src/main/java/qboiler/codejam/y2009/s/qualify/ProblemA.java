/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2009.s.qualify;

import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryce
 */
class ProblemA extends CodeJamBase {


    public List<Case> readInput(String fileName) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(fileName + ".in");
        BufferedReader br = new BufferedReader(reader);

        String[] lhdSA = br.readLine().split(" ");
        int L = Integer.parseInt(lhdSA[0]);
        int H = Integer.parseInt(lhdSA[1]);
        int N = Integer.parseInt(lhdSA[2]);

        ArrayList<String> dictionary = new ArrayList<>();
        for(int i=0;i<H;++i){
            dictionary.add(br.readLine().trim());
        }

        List<Case> result = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            result.add(((PCase)readAndProcessCase(i+1, dictionary, br.readLine())).processCase());
        }
        return result;
    }


    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        throw new RuntimeException("Dont use this...");

    }
    protected PCase readAndProcessCase(int caseNumber, ArrayList<String> dict, String alienCode) throws IOException, NumberFormatException {
        return new PCase(caseNumber,dict,alienCode);
    }

    static class PCase extends Case {

        ArrayList<String> Dict;
        ArrayList<ArrayList<Character>> alienCode = new ArrayList<>();
        PCase(int caseNumber, ArrayList<String> pdict, String ac) {
            super(caseNumber);
            Dict = pdict;
            System.out.println("Processing Case: " + ac);
            for(int i=0;i<ac.length();++i){
                Character c = ac.charAt(i);
                ArrayList<Character> levelc = new ArrayList<>();
                if(c=='('){
                    c = ac.charAt(++i);
                    while(c!=')'){
                        levelc.add(c);
                        c = ac.charAt(++i);
                    }
                }else{
                    levelc.add(c);
                }
                alienCode.add(levelc);
            }
        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        public Case processCase() {

            int totalCandidates = 0;
            for (String dictEntry:Dict
                 ) {
                if(allowed(dictEntry,alienCode)){
                    totalCandidates++;
                }
            }
            result = ""+totalCandidates;
            return this;
        }
        private boolean allowed(String entry, ArrayList<ArrayList<Character>> code){
            boolean result = true;
            for(int i =0;i<entry.length();++i){
                if(!code.get(i).contains(entry.charAt(i))){
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}
