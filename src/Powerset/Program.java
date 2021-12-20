package Powerset;

import java.util.*;

class Program {
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result.add(new ArrayList<Integer>());

        for (int i = 0; i < array.size() ; i++) {
            int ele = array.get(i);
            int limit = result.size();
            for (int j = 0 ; j < limit; j ++) {
                List<Integer> cloneList = new ArrayList<>();
                cloneList.addAll(result.get(j));
                cloneList.add(ele);
                result.add(cloneList);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = Program.powerset(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3})));
    }
}
