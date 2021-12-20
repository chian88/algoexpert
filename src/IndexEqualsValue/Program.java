package IndexEqualsValue;

import java.util.*;

class Program {
    public static int indexEqualsValue(int[] array) {

        // Write your code here.
        int ans = indexEqualsValueHelper(array, -1, 0);


        return ans;
    }

    static int indexEqualsValueHelper(int[] array, int minIdx, int offset) {
        if (array.length <= 0) return minIdx;
        int medianIdx = array.length / 2;
        int value = array[medianIdx];
        int realIdx = medianIdx + offset;



        if (value < realIdx) {
            // go right , because left all smaller than idx.
            int[] newArray = Arrays.copyOfRange(array, medianIdx + 1, array.length);

            return indexEqualsValueHelper(newArray, minIdx, medianIdx+offset + 1);

        } else if (value == realIdx) {
            // go left , but remember minIdx.
            int[] newArray = Arrays.copyOfRange(array, 0, medianIdx);

            return indexEqualsValueHelper(newArray, realIdx, offset );
        } else {
            // go left
            int[] newArray = Arrays.copyOfRange(array, 0, medianIdx);
            return indexEqualsValueHelper(newArray, minIdx, offset);
        }

    }


    public static void main(String[] args) {
        System.out.println(indexEqualsValue(new int[]{-5, -3, 0, 2, 3, 5, 6}));
    }


}
