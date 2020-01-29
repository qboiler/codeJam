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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author bryce
 */
class ProblemA extends CodeJamBase {

    private ArrayList<String> dictionary = new ArrayList<>();


    public List<Case> readInput(String fileName) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(fileName + ".in");
        BufferedReader br = new BufferedReader(reader);

        //HashMap<String,String> dictionary = new HashMap<>();
        String ldn = br.readLine();
        String[] ldnArray =  ldn.split(" ");
        int l = Integer.parseInt(ldnArray[0]);
        int d = Integer.parseInt(ldnArray[1]);
        int cases = Integer.parseInt(ldnArray[2]);

        for(int i =0;i<d;++i){

            String word = br.readLine();
            System.out.println(i+" : "+word);

            dictionary.add(word);
        }

        List<Case> result = new ArrayList<>();
        for (int i = 0; i < cases; ++i) {
            result.add(((PCase)readAndProcessCase(i+1, br)).processCase());
        }
        return result;
    }

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        return new PCase(caseNumber, dictionary, br.readLine());

    }

    static class PCase extends Case {
        ArrayList<String> dict;
        String testString;
        ArrayList<PChars> combos = new ArrayList<>();

        PCase(int caseNumber, ArrayList<String> pDict, String line) {
            super(caseNumber);
            dict = pDict;
            testString = line;
        }
        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        public Case processCase() {

            for(int i=0, j=0 ;i<testString.length();++i,++j){
                Character nc = testString.charAt(i);
                PChars p = new PChars();
                //PChars allwoed = dict.get(j);

                if(nc.equals('(')){
                    nc = testString.charAt(++i);
                    while(!nc.equals(')')){

                        p.add(nc);
                        nc = testString.charAt(++i);
                    }
                }else{
                        p.add(nc);

                }
                combos.add(p);

            }

            System.out.println("Test String: " + testString);

            int candidateMatch = 0;
            for(String nString: dict){
                boolean didMatch = true;
                for(int i=0; i<nString.length();++i){
                    char c = nString.charAt(i);
                    if(combos.get(i).contains(c)){
                        continue;
                    }else{
                        didMatch=false;
                        break;
                    }
                }
                if(didMatch){
                    candidateMatch++;
                }
            }
            result = ""+ candidateMatch;
            return this;
        }
    }

    static class PChars {
        ArrayList<Character> characters = new ArrayList<>();

        public boolean contains(Character c){
            return characters.contains(c);
        }
        public void add(Character c){
            characters.add(c);
        }

        public String toString(){
            String result = "(";
            for(Character c: characters){
                result += c;
            }
            return result +")";
        }
    }
}
