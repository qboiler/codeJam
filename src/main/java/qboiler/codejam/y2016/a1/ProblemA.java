/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.a1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author bryce
 */
public class ProblemA extends CodeJamBase {

    Logger LOGGER = LoggerFactory.getLogger(ProblemA.class);
    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        String s = br.readLine();
        return new PCase(caseNumber, s);

    }

    public class PCase extends Case {

        String game;

        PCase(int pCase, String pGame) {

            super(pCase);
            game = pGame;
        }

        String result;

        @Override
        protected String caseResult() {
            LOGGER.info("slf4j --- {} " , result);
            return " " + result;
        }

        @Override
        protected Case processCase() {
            LinkedList<Character> list = new LinkedList<>();
            list.add(game.charAt(0));
            char front = game.charAt(0);
            for (int i = 1; i < game.length(); ++i) {
                if(front>game.charAt(i)){
                    list.addLast(game.charAt(i));
                }else{
                    list.addFirst(game.charAt(i));
                    front=game.charAt(i);
                }
            }
            result="";
            for (int i = 0; i < list.size(); ++i) {
                result = result + list.get(i);
            }
            return this;
        }

    }
}
