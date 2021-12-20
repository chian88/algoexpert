package TwoSum;


import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer> remaining = new HashMap<>();

        for (int n : array) {
            remaining.put(n, targetSum - n);
        }

        for (Map.Entry<Integer, Integer> entry : remaining.entrySet()) {
            Integer num = entry.getKey();
            Integer remain = entry.getValue();

            if (remaining.containsKey(remain)) {
                return new int[]{num, remain};
            }

        }


        return new int[0];
    }

    public static void main(String[] args) {
        twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    }
}















//import java.util.ArrayList;
//import java.util.HashSet;
//
//public class Program {
//    public static int[] twoNumberSum(int[] array, int targetSum) {
//        // Write your code here.
//        int[] answer = new int[0];
//        HashSet<Integer> numbers = new HashSet<>();
//        for(int i = 0; i < array.length; i++) {
//            numbers.add(array[i]);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            int remainder = targetSum - array[i];
//            if(numbers.contains(remainder)) {
//                answer = new int[2];
//                answer[0] = array[i];
//                answer[1] = remainder;
//            }
//        }
//
//        return answer;
//    }
//}
