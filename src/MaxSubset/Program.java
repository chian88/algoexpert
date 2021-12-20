package MaxSubset;

public class Program {
    public static int maxSubsetNoAdjacent(int[] array) {


        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int[] maxSum = array.clone();

        maxSum[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + array[i]);
        }

        return maxSum[maxSum.length - 1];
    }

    public static void main(String[] args) {
        int result = Program.maxSubsetNoAdjacent(new int[]{75, 105, 120, 75, 90, 135});
        System.out.println(result);
    }
}
