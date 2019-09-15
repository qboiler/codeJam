/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2010.qr.africa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryce
 */
public class ProblemB {
    
    public void process(String file) throws FileNotFoundException, IOException{
        writeOutput(file, processList(readInput(file)));
    }
    
    private List<String> processList(List<String> input){
        ArrayList<String> result = new ArrayList<>();
        for (String line : input) {
            String [] inputParsed = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i=inputParsed.length ;i>0; --i) {
                sb.append(inputParsed[i-1]);
                sb.append((i-1==0)?"": " ");
            }
            result.add(sb.toString());
        }
        return result;
    }
    
    
    private List<String> readInput(String fileName) throws FileNotFoundException, IOException{
        FileReader reader = new FileReader(fileName + ".in");
        BufferedReader br = new BufferedReader(reader);
        int lines = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();
        for(int i=0;i<lines;++i){
            result.add(br.readLine());
        }
        return result;
    }
    
    private  void writeOutput(String fileName, List<String> output) throws FileNotFoundException, IOException{
        FileWriter reader = new FileWriter(fileName + ".out");
        try (BufferedWriter br = new BufferedWriter(reader)) {
            for (int i = 1; i <= output.size(); i++) {
                br.write("Case #"+i+": "+output.get(i-1) +"\n");
            }
            br.flush();
        }
    }
}
