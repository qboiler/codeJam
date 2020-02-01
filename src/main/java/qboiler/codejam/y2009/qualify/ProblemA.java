/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2009.qualify;

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

    private static ArrayList<String> dictionary = new ArrayList<>();
    private static int L;

    @Override
    public List<Case> readInput(String fileName) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(fileName + ".in");
        BufferedReader br = new BufferedReader(reader);

        String[] ldnString = br.readLine().split(" ");
        ProblemA.L = Integer.parseInt(ldnString[0]);
        int D = Integer.parseInt(ldnString[1]);
        int N = Integer.parseInt(ldnString[2]);

        for(int i = 0; i<D;++i){
            dictionary.add(br.readLine().trim());
        }

        int cases = N;
        List<Case> result = new ArrayList<>();
        for (int i = 0; i < cases; ++i) {
            result.add(((PCase)readAndProcessCase(i+1, br)).processCase());
        }
        return result;
    }

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        String wordCombo = br.readLine();
        return new PCase(caseNumber,wordCombo);

    }

    static class PCase extends Case {

        ArrayList<ArrayList<Character>> combo = new ArrayList<>();
        PCase(int caseNumber, String wCombo) {
            super(caseNumber);

            for(int i = 0;  i<wCombo.length();++i){
                char n = wCombo.charAt(i);
                ArrayList<Character> level = new ArrayList<>();
                if(n=='('){
                    n=wCombo.charAt(++i);
                    while(n!=')'){
                        level.add(n);
                        n =wCombo.charAt(++i);
                    }
                }else{
                    level.add(n);
                }
                combo.add(level);
            }
            if(combo.size()!=L){

                throw new RuntimeException("combo is not L " + combo.size()+" : "+L + ":"+wCombo);

            }
        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        public Case processCase() {
            int totalPossibilities = 0;

            for(String s: dictionary){
                boolean possible = true;
                System.out.println("Inspecting:"+s+":"+combo.size());
                for(int i=0;i<s.length();++i){
                    char n = s.charAt(i);
                    ArrayList<Character> level = combo.get(i);
                    if(!level.contains(n)){
                        possible =false;
                        break;
                    }
                }
                if(possible){
                    totalPossibilities++;
                }
            }
            result =""+totalPossibilities;

            return this;
        }
    }
}
