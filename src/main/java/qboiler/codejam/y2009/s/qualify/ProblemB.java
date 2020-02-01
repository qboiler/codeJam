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

/**
 *
 * @author bryce
 */
class ProblemB extends CodeJamBase {



    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {

        String[] hw= br.readLine().split(" ");
        int H = Integer.parseInt(hw[0]);
        int W = Integer.parseInt(hw[1]);
        Node[][] grid = new Node[H][W];
        for(int i = 0;i<H;++i){
            String[] nLA = br.readLine().split(" ");
            if(nLA.length != W){
                throw new IllegalArgumentException(" Error "+W+" != " +nLA.length);
            }
            for(int j=0;j<W;++j){
                grid[i][j]=new Node(Integer.parseInt(nLA[j]));
            }
        }

        return new PCase(caseNumber, H,  W, grid);

    }
    static class Node{
        Node(int h){
            height = h;
        }
        int height;
        Boolean isSink;
        Node drainTo;
        Character basinId;
    }
    private static final String LABELS ="abcdefghijklmnopqrstuvwxyz";

    static class PCase extends Case {

        Node[][] grid ;
        int H;
        int W;
        int currentbasinLable = 0;
        PCase(int caseNumber, int h, int w, Node[][] g) {
            super(caseNumber);
            grid = g;
            H = h;
            W = w;
        }

        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

         @Override
        public Case processCase() {
            result = "";
            for(int i =0;i<H;++i){
                result +="\n";
                for(int j=0;j<W;++j){
                    if(grid[i][j].basinId!=null){
                        result += " "+grid[i][j].basinId;
                        continue;

                    }else{
                        result += " " + search(i,j);
                    }
                }
            }

            return this;
        }
        private Character search(int i, int j){
            if(grid[i][j].basinId!=null){
                return grid[i][j].basinId;
            }
            Character result = null;
            int height = grid[i][j].height;
            //   --  North, West, East, South
            int lowest = height;
            int draini = -1;
            int drainj = -1;
            if(i>0){
                if(grid[i-1][j].height<lowest){
                    draini=i-1;
                    drainj=j;
                    lowest = grid[i-1][j].height;
                }
            }
            if(j>0){
                if(grid[i][j-1].height<lowest){
                    draini=i;
                    drainj=j-1;
                    lowest = grid[i][j-1].height;
                }
            }
            if(j<W-1){
                if(grid[i][j+1].height<lowest){
                    draini=i;
                    drainj=j+1;
                    lowest = grid[i][j+1].height;
                }

            }
            if(i<H-1) {
                if (grid[i + 1][j].height < lowest) {
                    draini = i + 1;
                    drainj = j;
                    lowest = grid[i + 1][j].height;
                }
            }
            if(draini==-1){
                // This is a sink...
                result = LABELS.charAt(currentbasinLable);
                currentbasinLable++;
            }else{
                result = search(draini,drainj);
            }
            grid[i][j].basinId=result;
            return result;

        }
    }
}
