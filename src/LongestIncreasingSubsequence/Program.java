package LongestIncreasingSubsequence;

import java.util.*;

class Program {
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        // Write your code here.

        int[] maxSequence = new int[array.length];
        int[] locationSequence = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            maxSequence[i] = 1;
            locationSequence[i] = -1;
            for (int j = 0; j < i; j++) {
                if(array[j] < array[i] && (maxSequence[i] < maxSequence[j] + 1) ) {
                    maxSequence[i] = maxSequence[j] + 1;
                    locationSequence[i] = j;
                }
            }
        }

        int maxSubsequenceIdx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < maxSequence.length; i++) {
            if (max < maxSequence[i]) {
                max = maxSequence[i];
                maxSubsequenceIdx = i;
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();

        while(locationSequence[maxSubsequenceIdx] != -1) {
            ans.addFirst(array[maxSubsequenceIdx]);
            maxSubsequenceIdx = locationSequence[maxSubsequenceIdx];
        }
        ans.addFirst(array[maxSubsequenceIdx]);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7, -24,12,10,2,3,12,5,6,35};
        longestIncreasingSubsequence(arr);
    }
}
