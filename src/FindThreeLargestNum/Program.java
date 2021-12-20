package FindThreeLargestNum;

import java.util.*;

class Program {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int x = array[0];
        int y = array[1];
        int z = array[2];

        if (y < x) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (z < x) {
            int temp = x;
            x = z;
            z = temp;
        }

        if (z < y) {
            int temp = y;
            y = z;
            z = temp;
        }


        for (int i = 3; i < array.length; i++) {
            int ele = array[i];

            if (ele > z) {
                x = y;
                y = z;
                z = ele;
            } else if (ele > y) {
                x = y;
                y = ele;
            } else if (ele > x) {
                x = ele;
            }


        }




        return new int[]{x, y, z};
    }

    public static void main(String[] args) {
        findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
    }
}
