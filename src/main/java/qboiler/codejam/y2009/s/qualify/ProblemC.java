/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2009.s.qualify;

import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author bryce
 */
class ProblemC extends CodeJamBase {



    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {


        return new PCase(caseNumber);

    }

    static class PCase extends Case {


        PCase(int caseNumber) {
            super(caseNumber);
        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }


        @Override
        public Case processCase() {
            return this;
        }
    }
}
