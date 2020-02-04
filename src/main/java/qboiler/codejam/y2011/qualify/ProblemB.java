/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2011.qualify;

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
