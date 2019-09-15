/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2016.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemC extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        int n = Integer.parseInt(br.readLine());
        String[] bffString = br.readLine().split(" ");
        return new QCase(caseNumber, n, bffString);

    }
    
    
    class Node{
        Node(Integer pId, Integer pFid){
            id = pId;
            fid = pFid;
        }
        Integer id;
        Integer fid;
        ArrayList<Integer> mfid = new ArrayList<>();
        boolean isCouple;
        final LinkedList<Integer> seq = new LinkedList<>();
        int length=0;
        boolean isPrimary = false;
        boolean used = false;
        boolean isLoop = false;
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(id).append("->").append(fid);
            sb.append(" [");
                for(Integer mm: mfid){
                    sb.append(mm).append(",");
                }
                sb.append("]");
                sb.append(" isPrimary="+isPrimary);
                sb.append(" isCouple="+isCouple);
                sb.append(" isLoop="+isLoop);
                sb.append(" length="+length);
                sb.append(" used="+used);
                
            return sb.toString();
        }
    }

    public class QCase extends Case {

        int n;

        ArrayList<Node> nodes = new ArrayList<>();
        
        
        QCase(int pCase, int pN, String[] bff) {
            super(pCase);
            n = pN;
            for (int i = 0; i < bff.length; ++i) {
                Integer studentKey = i + 1;
                Integer bestFriend = Integer.parseInt(bff[i]);
                nodes.add(new Node(studentKey, bestFriend));
            }

            for (Node entry : nodes) {
                Node friend = nodes.get(entry.fid-1);
                if(!friend.fid.equals(entry.id)){
                    friend.mfid.add(entry.id);
                }else{
                    if(!friend.isPrimary && !entry.isPrimary){
                        entry.isPrimary=true;
                    }
                    friend.isCouple=true;
                    entry.isCouple=true;
                }
            }
            for(Node entry: nodes){
                if(entry.isCouple && !entry.used){
                    entry.length=walk(entry,entry.seq,1);
                    
                }
            }
            for(Node entry: nodes){
                if(!entry.isCouple && !entry.used){
                    LinkedList<Integer> circle= new LinkedList<>();
                    int loopSize = findLoop(entry,0,entry.id,circle);
                    if(loopSize>2){
                        entry.isLoop=true;
                        entry.isPrimary=true;
                        entry.length=loopSize;
                        entry.seq.clear();
                        entry.seq.addAll(circle);
                    }
                }
            }
        }
        
        final int findLoop(Node entry, int depth,Integer startNode
                , final LinkedList<Integer> pSeq){
            
            int maxDepth = 0;
            entry.used=true;
            
            for(Integer i: entry.mfid){
                if(i.equals(startNode)){
                    // Closed Loop Found...
                    pSeq.add(entry.id);
                    maxDepth =depth+1;
                    break;
                }
                else{
                    Node nextNode = nodes.get(i-1);
                    if(!nextNode.used){
                       int localDepth=findLoop(nextNode,(depth+1),startNode,pSeq);
                       if(localDepth>0){
                           pSeq.add(entry.id);
                           maxDepth =localDepth;
                       }
                    }
                }
            }
            return maxDepth;
        }
        
        
        final int walk(final Node n, final LinkedList<Integer> pSeq, int depth){
            
            int maxDepth = depth;
            n.used=true;
            for(Integer i: n.mfid){
                LinkedList<Integer> lseq = new LinkedList<>();
                int d = walk(nodes.get(i-1),lseq,depth+1);
                if(d>maxDepth){
                    maxDepth=d;
                    pSeq.clear();
                    pSeq.add(n.id);
                    pSeq.addAll(lseq);
                }
            }
            return maxDepth;
        }
        


        String result ="";

        @Override
        protected String caseResult() {
            return " " + result;
        }

        @Override
        protected Case processCase() {
            
            LinkedList<Integer> answer = new LinkedList<>();
            int totalCouples = 0;
            
            LinkedList<Integer> closedLoop = new LinkedList<>();
            int maxClosedLoop = 0;
            
            
            for(Node n: nodes){
                System.out.println(n);
                        
                
                if(n.isPrimary && n.isCouple){
                    
                    totalCouples = totalCouples+n.length;
                    answer.addAll(n.seq);
                    
                    Node nPartner = nodes.get(n.fid-1);
                    totalCouples = totalCouples+nPartner.length;
                    answer.addAll(nPartner.seq);
                }
                if(n.isPrimary && n.isLoop){
                    if(n.length>maxClosedLoop){
                        maxClosedLoop=n.length;
                        closedLoop.clear();
                        closedLoop.addAll(n.seq);
                    }
                }
            }
            String strategy
                    =(totalCouples>maxClosedLoop)?"C":"L";
            Integer circleSize 
                    = (totalCouples>maxClosedLoop)?totalCouples:maxClosedLoop;
            LinkedList<Integer> k = (totalCouples>maxClosedLoop)?answer:closedLoop;
            
            StringBuilder sb = new StringBuilder();
            sb.append(circleSize);
//            {
//            sb.append(" ");
//            sb.append(strategy).append(" [");
//            for(Integer mm:k){
//                sb.append(mm).append(",");
//            }
//            sb.append("]");
//            
//            }
            result = sb.toString();
            
            return this;
        }

    }
}
