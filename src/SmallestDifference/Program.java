package SmallestDifference;

import java.util.*;

public class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] ans = new int[]{arrayOne[0], arrayTwo[0]};
        int maxDiff = Math.abs(arrayOne[0] - arrayTwo[0]);

        int j = 0, i = 0;

        while(i < arrayOne.length && j < arrayTwo.length) {
            int one = arrayOne[i];
            int two = arrayTwo[j];
            int absoluteDiff = Math.abs(one - two);
            if (absoluteDiff == 0) {
                ans[0] = one;
                ans[1] = two;
                return ans;
            } else if (absoluteDiff < maxDiff) {
                maxDiff = absoluteDiff;
                ans[0] = one;
                ans[1] = two;
            }

            if (one < two) {
                i++;
            } else {
                j++;
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        int[] arrayOne = new int[] {-1,5,10,20,28,3};
        int[] arrayTwo = new int[] {26,134,135,15,17};
        SmallestDifference.Program.smallestDifference(arrayOne, arrayTwo);
    }
}
