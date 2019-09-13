package qboiler.codejam.y2008.qualify;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
class ProblemB extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        
        int turnTime = Integer.parseInt(br.readLine());
        String[] snanb = br.readLine().split(" ");
        int na = Integer.parseInt(snanb[0]);
        int nb = Integer.parseInt(snanb[1]);
        PriorityQueue<Integer> aDepartures = new PriorityQueue<>();
        PriorityQueue<Integer> aArrivals = new PriorityQueue<>();
        PriorityQueue<Integer> bDepartures = new PriorityQueue<>();
        PriorityQueue<Integer> bArrivals = new PriorityQueue<>();
        
        for(int i=0;i<na;++i){
            String[] abdr = br.readLine().split(" ");
            String[] depart = abdr[0].split(":");
            int dtime = Integer.parseInt(depart[0])*60 
                    +Integer.parseInt(depart[1]);
            aDepartures.add(dtime);
            String[] arrive = abdr[1].split(":");
            int atime = Integer.parseInt(arrive[0])*60+
                    Integer.parseInt(arrive[1])+turnTime;
            aArrivals.add(atime);
        }
        for(int i=0;i<nb;++i){
            String[] badr = br.readLine().split(" ");
            String[] depart = badr[0].split(":");
            int dtime = Integer.parseInt(depart[0])*60 
                    +Integer.parseInt(depart[1]);
            bDepartures.add(dtime);
            String[] arrive = badr[1].split(":");
            int atime = Integer.parseInt(arrive[0])*60+
                    Integer.parseInt(arrive[1])+turnTime;
            bArrivals.add(atime);
        }
 
        return new PCase(caseNumber, aDepartures, aArrivals, bDepartures, bArrivals);

    }

    static class PCase extends Case {
                final PriorityQueue<Integer> AD;
        final PriorityQueue<Integer> AA;
        final PriorityQueue<Integer> BD;
        final PriorityQueue<Integer> bA;

        PCase(int caseNumber, 
                PriorityQueue<Integer> pAD,
                PriorityQueue<Integer> pAA
                ,PriorityQueue<Integer> pBD,
                PriorityQueue<Integer> pbA) {
            super(caseNumber);
            AD = pAD;
            AA = pAA;
            BD = pBD;
            bA = pbA;
        }
        String result;

        @Override
        protected String caseResult() {
            return " "+result;
        }

        @Override
        protected Case processCase() {
            
            int ATrainCount = 0;
            Integer integer = AD.poll();
            while ( integer !=null) {
                StringBuilder sb = new StringBuilder();
                sb.append(integer).append(" -> ");
                Integer next = bA.peek();
                if(next!=null && next<=integer){
                    sb.append(bA.poll());
                }else{
                    ++ATrainCount;
                    sb.append(" ").append(next).append(" : ").append(ATrainCount);
                }
                System.out.println(sb.toString());
                integer=AD.poll();
            }
            int BTrainCount = 0;
            integer = BD.poll();
            while(integer !=null ) {
                StringBuilder sb = new StringBuilder();
                sb.append(integer).append(" -> ");
                Integer next = AA.peek();
                if(next!=null && next<=integer){
                    sb.append(AA.poll());
                }else{
                    
                    ++BTrainCount;
                    sb.append(" ").append(next).append(" : ").append(BTrainCount);
                }
                System.out.println(sb.toString());
                integer = BD.poll();
            }
            result = ATrainCount +" "+ BTrainCount;
            return this;
        }
    }
}
