/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qboiler.codejam.y2014.r1a.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;

/**
 *
 * @author bryce
 */
public class ProblemB extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        Scanner s = new Scanner(br.readLine());
        PCase pcase = new PCase(caseNumber);
        int edges = s.nextInt();
        for (int i = 0; i < edges - 1; ++i) {
            s = new Scanner(br.readLine());
            pcase.add(s.nextInt(), s.nextInt());
        }

        return pcase;
    }

    class Node {

        ArrayList<Node> nodes = new ArrayList<>();
        Node p;
        ArrayList<Node> children = new ArrayList<>();

        void setParent(Node n) {
            p = n;
            children.clear();
            int ccount = 0;
            for (Node cnode : nodes) {
                if (cnode != p) {
                    children.add(cnode);
                    cnode.setParent(this);
                }
            }
        }

        int getSize() {
            if (children.size() < 2) {
                return 1;
            } else {
                ArrayList<Integer> data = new ArrayList<Integer>();
                for (Node node : children) {
                    data.add(node.getSize());
                }
                Integer[] sa = new Integer[data.size()];
                Arrays.sort(data.toArray(sa));
                return 1 + sa[sa.length-1]+sa[sa.length-2];
            }
        }
    }

    class PCase extends Case {

        HashMap<Integer, Node> s = new HashMap<>();
        // ArrayList<Node> nodes = new ArrayList<>();

        PCase(int caseNumber) {
            super(caseNumber);
        }

        String result;

        void add(int n1, int n2) {
            System.out.println("Adding " + n1 + " " + n2);
            Node node1 = s.get(n1);
            Node node2 = s.get(n2);

            if (node1 == null) {
                node1 = new Node();
                s.put(n1, node1);
            }
            if (node2 == null) {
                node2 = new Node();
                s.put(n2, node2);
            }
            System.out.println(node1.nodes.size() + " : " + node2.nodes.size());

            node1.nodes.add(node2);
            node2.nodes.add(node1);
        }

        @Override
        protected String caseResult() {
            return result;
        }

        private int setAsRoot(Node node) {

            ArrayList<Integer> data = new ArrayList<Integer>();

            for (Node n : node.nodes) {
                n.setParent(node);
                data.add(n.getSize());
            }
            if (data.size() < 2) {
                return 1;
            }
                            Integer[] sa = new Integer[data.size()];
                Arrays.sort(data.toArray(sa));
                return 1 + sa[sa.length-1]+sa[sa.length-2];


        }

        @Override
        protected Case processCase() {
            int maxSize = 0;
            for (Map.Entry<Integer, Node> entry : s.entrySet()) {
                Integer integer = entry.getKey();
                ProblemB.Node node = entry.getValue();
                int size = setAsRoot(node);
                if (size > maxSize) {
                    maxSize = size;
                }
                System.out.println(integer + " Size : " + size);
            }
            result = " " + (s.size() - maxSize);
            return this;
        }
    }
}
