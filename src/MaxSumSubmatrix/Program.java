package MaxSumSubmatrix;

public class Program {
    public static int maximumSumSubmatrix(int[][] matrix, int size) {
        int[][] sums = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int current = matrix[i][j];
                int up = 0;
                int left = 0;
                int diagonal = 0;
                if(i-1 >= 0) up = sums[i-1][j];
                if(j-1 >= 0) left = sums[i][j-1];
                if(i-1 >= 0 && j-1 >= 0) diagonal = sums[i-1][j-1];

                sums[i][j] = current + up + left - diagonal;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = size - 1; i < sums.length; i++) {
            for ( int j = size - 1; j < sums[0].length; j++) {
                int currentSum = sums[i][j];
                int upSum = 0;
                int leftSum = 0;
                int diagonalSum = 0;
                if (i-size >= 0) upSum = sums[i-size][j];
                if (j-size >= 0) leftSum = sums[i][j-size];
                if (i-size >= 0 && j-size >= 0) diagonalSum = sums[i-size][j-size];
                int maxSumCurrent = currentSum - upSum - leftSum + diagonalSum;

                if (maxSumCurrent > maxSum) maxSum = maxSumCurrent;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{5,3,-1,5}, {-7,3,7,4}, {12,8,0,0}, {1,-8,-8,2}};
        int[][] matrix = new int[][]{{2,4}, {5,6}, {-3,2}};
        int size = 2;
        Program.maximumSumSubmatrix(matrix, size);
    }
}
