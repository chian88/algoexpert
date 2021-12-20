package Permutations;

import java.util.*;

class Program {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        if (array.size() == 0) return new ArrayList<List<Integer>>();
        return permutationHelper(array, new ArrayList<Integer>(), new ArrayList<List<Integer>> ());
    }


    public static List<List<Integer>> permutationHelper(List<Integer> array, List<Integer> perm, List<List<Integer>> perms) {
        if (array.isEmpty()) {
            perms.add(perm);
            return perms;
        } else {
            for (int i = 0 ; i < array.size(); i ++) {

                List<Integer> newArray = new ArrayList<Integer>(array);
                List<Integer> newPerm = new ArrayList<Integer>(perm);
                newPerm.add(array.get(i));
                newArray.remove(i);

                perms = permutationHelper(newArray, newPerm, perms);
            }
        }
        return perms;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(new Integer[] {1,2,3,4});

        List<List<Integer>> ans = getPermutations(arr);
    }
}
