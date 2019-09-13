/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qboiler.codejam.y2008.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
class ProblemC extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, 
            BufferedReader br) 
            throws IOException, NumberFormatException {
        String[] input = br.readLine().split(" ");
        
        return new PCase(caseNumber,
                Double.parseDouble(input[0]),
                Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Double.parseDouble(input[3]),
                Double.parseDouble(input[4])
        );

    }

    static class PCase extends Case {

        final double flyRadius;
        final double racketRadius;
        final double racketThickness;
        final double stringRadius;
        final double stringGap;
        final int caseNumbert;
        
        PCase(int caseNumber, 
                double f,
                double R, 
                double t, 
                double r, 
                double g) {
            super(caseNumber);
            
            //f, R, t, r and g
            flyRadius = f;
            racketRadius = R;
            racketThickness = t;
            stringRadius= r;
            stringGap=g;
            caseNumbert=caseNumber;

        }
        String result = "";
        final Double EPSILON = 0.00000001;
        final DecimalFormat df2 = new DecimalFormat( "#0.000000" );

        @Override
        protected String caseResult() {
            return " "+result;
        }
            
        @Override
        protected Case processCase() {

            int hits=0;
            int total = 0;
            
            double percent = 1;
            double delta;
            int c = 0;
            do{
                ++c;
                for(int i=0;i<1000000;++i){
                    ++total;
                    if(monteCarloTest()){
                        ++hits;
                    }
                }
                double t = (double)hits/(double)total;
                delta = Math.abs(t-percent);
                percent =t;
            }while(delta>EPSILON || c<5);
            result = String.valueOf(df2.format(percent));
            System.out.println("Case #"+caseNumbert+":"+this.caseResult()+"\n\t\t// "+ c +": "+delta 
                    + " : drand_avg="
                    +(totalRand/(double)total) 
                    + " : drand2_avg="
                    +(totalRand2/(double)total) 
            );
            return this;
            
        }
        final Random r = new Random(7777777);
        final Random r2 = new Random(123456);
        
        double totalRand =0;
        double totalRand2 =0;
        
        private boolean monteCarloTest(){
            //boolean hitRacket = false;
            
            double drand  = r.nextDouble();
            double drand2 = r2.nextDouble();
            totalRand+=drand;
            totalRand2+=drand2;
            double pathRadius = Math.sqrt(drand)*racketRadius;
            double pathAngle  = drand2*(Math.PI/2.0);
            if(pathRadius>=racketRadius - racketThickness-flyRadius){
                return true;
            }else{
                double pitch = 2.0d*stringRadius+stringGap;// - 2*stringRadius;
                if(2*flyRadius>stringGap){
                    return true;
                }
                // Convert to cartesian coordinates and try...
                double x = Math.cos(pathAngle) * pathRadius;
                double y = Math.sin(pathAngle) * pathRadius;
                
                double minX = x - flyRadius;
                double maxX = x + flyRadius;
                double minY = y - flyRadius;
                double maxY = y + flyRadius;
                
                int leftX   = (int)(minX/pitch);
                int rightX  = (int)(maxX/pitch);
                int bottomY = (int)(minY/pitch);
                int topY    = (int)(maxY/pitch);
                if(leftX!=rightX  || bottomY!=topY){
                    return true;
                }
                
                double leftStringEdge 
                        = pitch * leftX + stringRadius;
                if(leftStringEdge>=minX){
                    return true;
                }
                
                
                double rightStringEdge 
                        = pitch * (leftX+1) - stringRadius;
                assert (rightStringEdge-leftStringEdge -stringGap)<EPSILON;
                if(rightStringEdge<=maxX){
                    return true;
                }
                
                
                double bottomStringEdge =
                        pitch * bottomY + stringRadius;
                if(bottomStringEdge>=minY){
                    return true;
                    
                }
                
                
                double topStringEdge =
                        pitch * (bottomY+1) - stringRadius;
                // Confirm the Top String's Bottom Edge is the same via both calcs...
                assert (topStringEdge - bottomStringEdge-stringGap)<EPSILON;
                return topStringEdge <= maxY;
                
                
            }
        }
    }
}
