/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qr.africa;

import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 *
 * @author bryce
 */
public class ProblemC extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        return new CCase(caseNumber, br.readLine());
    }
    private static final TreeMap<Character, int[]> MAPPER = new TreeMap<>();

    static {

        MAPPER.put('a', new int[]{2, 1});
        MAPPER.put('b', new int[]{2, 2});
        MAPPER.put('c', new int[]{2, 3});
        MAPPER.put('d', new int[]{3, 1});
        MAPPER.put('e', new int[]{3, 2});
        MAPPER.put('f', new int[]{3, 3});
        MAPPER.put('g', new int[]{4, 1});
        MAPPER.put('h', new int[]{4, 2});
        MAPPER.put('i', new int[]{4, 3});
        MAPPER.put('j', new int[]{5, 1});
        MAPPER.put('k', new int[]{5, 2});
        MAPPER.put('l', new int[]{5, 3});
        MAPPER.put('m', new int[]{6, 1});
        MAPPER.put('n', new int[]{6, 2});
        MAPPER.put('o', new int[]{6, 3});
        MAPPER.put('p', new int[]{7, 1});
        MAPPER.put('q', new int[]{7, 2});
        MAPPER.put('r', new int[]{7, 3});
        MAPPER.put('s', new int[]{7, 4});
        MAPPER.put('t', new int[]{8, 1});
        MAPPER.put('u', new int[]{8, 2});
        MAPPER.put('v', new int[]{8, 3});
        MAPPER.put('w', new int[]{9, 1});
        MAPPER.put('x', new int[]{9, 2});
        MAPPER.put('y', new int[]{9, 3});
        MAPPER.put('z', new int[]{9, 4});
        MAPPER.put(' ', new int[]{0, 1});
    }

    private class CCase extends Case {

        private final String input;
        private String result;

        protected CCase(int id, String in) {
            super(id);
            input = in;
        }

        @Override
        protected Case processCase() {
            StringBuilder sb = new StringBuilder();
            int previous = -1;
            for (Character c : input.toCharArray()) {
                int[] keyPadButton = MAPPER.get(c);
                if (previous == keyPadButton[0]) {
                    sb.append(' ');
                }
                previous = keyPadButton[0];
                for(int i=0;i<keyPadButton[1];++i){
                    sb.append(keyPadButton[0]);
                }
            }
            result = sb.toString();
            return this;
        }

        @Override
        protected String caseResult() {
            return result;
        }
    }
}
