package FourNumberSum;

import java.util.*;

class Program {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer[][]> hashes = new HashMap<>();
        List<Integer[]> res = new ArrayList<>();
        
        for (int i = 0 ; i < array.length; i++) {
            int main = array[i];
            
            for (int j = i+1; j < array.length; j++) {
                int right = array[j];
                int diff = targetSum - (main + right);
                
                if (hashes.containsKey(diff)) {
                    Integer[][] pairs = hashes.get(diff);

                    for (Integer[] pair: pairs) {
                        Integer[] tempRes = Arrays.copyOf(pair, 4);
                        tempRes[2] = main;
                        tempRes[3] = right;
                        res.add(tempRes);
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int left = array[k];
                int tempTotal = main + left;

                if (hashes.containsKey(tempTotal)) {
                    Integer[][] prev = hashes.get(tempTotal);
                    Integer[] temp = new Integer[]{main, left};
                    prev = Arrays.copyOf(prev, prev.length + 1);
                    prev[prev.length - 1] = temp;
                    hashes.put(tempTotal, prev);
                } else {
                    Integer[][] temp = new Integer[][]{{main, left}};
                    hashes.put(tempTotal,temp);
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
    }
}
