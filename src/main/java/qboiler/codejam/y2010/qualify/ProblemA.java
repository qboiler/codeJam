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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author bryce
 */
class ProblemA extends CodeJamBase {



    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        Set<String> s = new TreeSet<>();
        for(int i=0, eng = Integer.parseInt(br.readLine());i<eng;++i){
            s.add(br.readLine());
        }
        List<String> q = new ArrayList<>();
        for(int i=0, qtot = Integer.parseInt(br.readLine());i<qtot;++i){
            q.add(br.readLine());
        }

        return new PCase(caseNumber,s,q).processCase();

    }

    static class PCase extends Case {

        Set<String> searchEngines;
        List<String> queries;

        PCase(int caseNumber, Set<String> engines, List<String> q) {
            super(caseNumber);
            searchEngines = engines;
            queries=q;
        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        public Case processCase() {
            Set<String> seen = new TreeSet<>();
            Set<String> unseen = new TreeSet<>();
            unseen.addAll(searchEngines);
            int changes = 0;
            for(String q:queries){
                if(unseen.size()==1 && unseen.contains(q)){
                    ++changes;
                    Set<String> tmp = unseen;
                    unseen = seen;
                    seen = tmp;
                }else{
                    unseen.remove(q);
                    seen.add(q);
                }
            }
            result = ""+changes;


            return this;
        }
    }
}
