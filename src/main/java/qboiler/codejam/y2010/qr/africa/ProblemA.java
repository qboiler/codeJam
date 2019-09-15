package qboiler.codejam.y2010.qr.africa;

import qboiler.codejam.Case;
import qboiler.codejam.CodeJamBase;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author bryce
 */
public class ProblemA extends CodeJamBase {

    @Override
    protected Case readAndProcessCase(int caseNumber, BufferedReader br) throws IOException, NumberFormatException {
        PCase current = new PCase(caseNumber + 1);
        current.credit = Integer.parseInt(br.readLine());
        current.storeItemCount = Integer.parseInt(br.readLine());
        String[] itemPrices = br.readLine().split(" ");
        for (int j = 0; j < itemPrices.length; ++j) {
            current.storeItems.put(new Integer(itemPrices[j]), new Integer(j + 1));
        }
        
        return current;
    }

    private class PCase extends Case {

        PCase(int id){
            super(id);
        }
        int credit;
        int storeItemCount;
        SortedSetMultimap<Integer, Integer> storeItems = TreeMultimap.create();
        int[] result;

       
        @Override
        protected String caseResult() {
            return  result[0] + " " + result[1];
        }

        @Override
        protected Case processCase() {
            result = new int[2];

            for (Integer i : storeItems.keys()) {
                Integer diff = credit - i;
                if (storeItems.containsKey(diff)) {
                    // found match
                    SortedSet<Integer> resultRow;
                    if (i.intValue() == diff.intValue()) {
                        //  two values are equal.
                        resultRow = storeItems.get(i);
                        assert resultRow.size() == 2;
                    } else {
                        //  Only one index for value;
                        resultRow = new TreeSet<>();
                        resultRow.add(storeItems.get(i).first());
                        resultRow.add(storeItems.get(diff).first());
                    }
                    result[0] = resultRow.first();
                    result[1] = resultRow.last();
                    break;
                }
            }
            return this;
        }
    }
}
