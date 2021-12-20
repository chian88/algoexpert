package RadixSort;

import java.util.*;

class Program {

    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        // Write your code here.

        int largestNum = Integer.MIN_VALUE;
        for (Integer n : array) {
            if (n > largestNum) largestNum = n;
        }

        int largestDigit = 0;
        while (largestNum > 0) {
            largestNum = largestNum / 10;
            largestDigit++;
        }

        int digitMultiplier = 0;

        while (digitMultiplier <= largestDigit) {
            int digit = (int) Math.pow(10,digitMultiplier);

            int[] countSortRes = countSort(array, digit);

            ArrayList<Integer> partialSorted = buildSorted(array, countSortRes, digit);
            array = partialSorted;
            digitMultiplier++;
        }


        return array;
    }

    static ArrayList<Integer> buildSorted(ArrayList<Integer> array, int[] countSortRes, int digit) {
        ArrayList<Integer> result = (ArrayList<Integer>) array.clone();

        for (int i = array.size() - 1; i >= 0; i--) {
            int num = (array.get(i) / digit) % 10;
            int index = --countSortRes[num];

            result.set(index, array.get(i));
        }

        return result;
    }


    static int[] countSort(ArrayList<Integer> array, int digit) {
        int[] result = new int[10];

        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            result[(num / digit) % 10] += 1;
        }

        for (int i = 1; i < result.length; i++){
            result[i] = result[i-1] + result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(new Integer[]{8762, 654, 3008, 345, 87, 65, 234, 12, 2}));
        radixSort(input);
    }


}
