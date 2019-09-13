/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2008.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
class ProblemA extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        ArrayList<String> enginesA = new ArrayList<>();
        int engines = Integer.parseInt(br.readLine());
        for(int i =0; i<engines; ++i){
            enginesA.add(br.readLine());
        }
        ArrayList<String> queries = new ArrayList<>();
        int qCount = Integer.parseInt(br.readLine());
        for(int i=0;i<qCount; ++i){
            queries.add(br.readLine());
        }
 
        return new PCase(caseNumber, enginesA, queries);

    }

    static class PCase extends Case {

        final ArrayList<String> searchEngines;
        final ArrayList<String> searches;

        PCase(int caseNumber, ArrayList<String> pSEngine, ArrayList<String> pSearch) {
            super(caseNumber);
            searchEngines = pSEngine;
            searches = pSearch;
        }
        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        protected Case processCase() {
            int switches = 0;
            ArrayList<String> engines = new ArrayList<>(searchEngines);
            while(!searches.isEmpty()){
                String currentEngine = searches.remove(0);
                engines.remove(currentEngine);
                if(engines.isEmpty()){
                    ++switches;
                    engines.addAll(searchEngines);
                    engines.remove(currentEngine);
                }
            }
            result =String.valueOf(switches);
            return this;
        }
    }
}
