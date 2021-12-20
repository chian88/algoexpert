package searchInSortedMatrix;

class Program {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (target < matrix[row][col]) {
                // go left
                col--;
            } else {
                // go down.
                row++;
            }
        }

        return new int[] {-1, -1};
    }


}

