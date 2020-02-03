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
import java.text.DecimalFormat;

/**
 *
 * @author bryce
 */
class ProblemC extends CodeJamBase {



    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {


        //f, R, t, r and g

        double[] d = this.doubleArrayFromString(br.readLine());

        return new PCase(caseNumber,d);

    }

    static class PCase extends Case {

        double rimThickness;
        double gap;
        double rackRadius;
        double stringRadius;
        double EPSILON = .000000001;

        int necase;
        int wecase;
        int wscase;
        int nscase;


        PCase(int caseNumber, double[] d) {
            super(caseNumber);
            rimThickness = d[2] + d[0];
            gap = d[4] - 2 * d[0];
            rackRadius = d[1];
            stringRadius = d[3] + d[0];
        }

        String result;

        @Override
        protected String caseResult() {
            return " " + result;
        }

        @Override
        public Case processCase() {
            double resultProb = 0d;
            if(gap<0d){
                resultProb = 1.0d;
                result = df.format(1.0d);
            }else {
                double innerRadius = rackRadius - rimThickness;
                double xStart = stringRadius;
                double holeArea = 0d;
                while (xStart < innerRadius) {
                    double yStart = stringRadius;
                    while (yStart < innerRadius) {
                        holeArea += area(xStart, yStart, gap, innerRadius);
                        yStart += gap + 2d * stringRadius;
                    }
                    xStart += gap + 2d * stringRadius;
                }


                double sArea = Math.PI * Math.pow(rackRadius, 2d) / 4d;


                System.out.println(" Results: " + df.format(holeArea)
                        + " " + df.format(sArea)
                        + " " + df.format(1.0d - (holeArea / sArea))
                        + " " + df.format((sArea - holeArea) / sArea)
                );

                System.out.println(" Results: ns->" + nscase + " ne->" + necase + " we->" + wecase + " ws->" + wscase);


                result = df.format(1.0d - (holeArea / sArea));
            }

            return this;
        }


DecimalFormat df = new DecimalFormat("0.000000");

        public double chordArea(double length, double radius) {
            //  1/2*r^2( 2*asin (l/(2r)) - sin(2*asin(l/(2r))))
            double r_squared = radius * radius;
            double l_over_2r = length / (2 * radius);
            double arcsin_l_over_2r = Math.asin(l_over_2r);
            return .5 * r_squared * (2 * arcsin_l_over_2r - Math.sin(2 * arcsin_l_over_2r));
        }

        public double chordLength(double xOne, double xTwo, double radius) {
            return Math.abs(2 * radius * Math.sin((Math.acos(xOne / radius) - Math.acos(xTwo / radius)) / 2d));
        }

        public double area(double xOne, double yOne, double gap, double radius) {
            double pointDistance = Math.sqrt(Math.pow(xOne + gap, 2) + Math.pow(yOne + gap, 2));
            double pointInner = Math.sqrt(Math.pow(xOne, 2) + Math.pow(yOne, 2));
            double result = gap * gap;
            if (pointDistance <= radius) {
                // Inner cell return gap*gap
            } else if (pointInner >= radius) {
                result = 0.0;
            } else {
                double R_Y_at_xOne = Math.sqrt(radius * radius - xOne * xOne);
                double R_X_at_yOne = Math.sqrt(radius * radius - yOne * yOne);
                double R_Y_at_xTwo = Math.sqrt(radius * radius - (xOne + gap) * (xOne + gap));
                double R_X_at_yTwo = Math.sqrt(radius * radius - (yOne + gap) * (yOne + gap));

                if (R_Y_at_xOne >= yOne + gap && R_X_at_yOne >= xOne + gap) {
                    //  NORTH EAST CASE...
                    ++necase;
                    double triangle = .5 * ((xOne + gap) - R_X_at_yTwo) * ((yOne + gap) - R_Y_at_xTwo);
                    double chord=chordArea(chordLength(R_X_at_yTwo, xOne + gap, radius), radius);
                    if(triangle<0 || chord<0){
                        System.out.println("Area Less than 0 ");
                    }
                    result -= triangle;
                    result += chord;
                } else if (R_Y_at_xOne <= yOne + gap && R_X_at_yOne >= xOne + gap) {
                    // West EAST Case
                    ++wecase;
                    Double baseRec = (R_Y_at_xTwo - yOne) * gap;
                    double triangle = 0.5 * (R_Y_at_xOne - R_Y_at_xTwo) * gap;
                    double chordArea = chordArea(chordLength(xOne, xOne + gap, radius), radius);
                    if(triangle<0 || chordArea<0 || baseRec<0){
                        System.out.println("Area Less than 0 ");
                    }
                    result = baseRec + triangle + chordArea;

                } else if (R_Y_at_xOne <= yOne + gap && R_X_at_yOne <= xOne + gap) {
                    // WEST South Case
                    ++wscase;
                    Double triangle = 0.5 * (R_Y_at_xOne - yOne) * (R_X_at_yOne - xOne);
                    Double chordArea = chordArea(chordLength(xOne, R_X_at_yOne, radius), radius);
                    if(triangle<0 || chordArea<0 ){
                        System.out.println("Area Less than 0 ");
                    }
                    result = triangle + chordArea;
                } else {
                    ++nscase;
                    // NORTH South Case...
                    double rectangle = (R_X_at_yTwo - xOne) * gap;
                    double triangle = 0.5 * gap * (R_X_at_yOne - R_X_at_yTwo);
                    double chordArea = chordArea(chordLength(R_X_at_yTwo, R_X_at_yOne, radius), radius);
                    if(triangle<0 || chordArea<0 || rectangle<0){
                        System.out.println("Area Less than 0 ");
                    }
                    if(R_X_at_yTwo>R_X_at_yOne){
                        System.out.println("Error Condition R_X at y2 less than R_X at yOne");
                    }
                    result = rectangle + triangle + chordArea;
                }
            }
            return result;

        }
    }
}
