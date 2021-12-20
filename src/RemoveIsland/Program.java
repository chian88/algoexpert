package RemoveIsland;

public class Program {

    public static int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        // go through all border slot, depth firs search if 1, then mark as visited.
        // go through again.  depth first search then make it 0.
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++ ) {
            depthFirstSearchBorder(matrix, 0, j, visited);
            depthFirstSearchBorder(matrix, matrix.length - 1, j, visited);
        }

        for (int i = 0; i < matrix.length; i++) {
            depthFirstSearchBorder(matrix, i, 0, visited);
            depthFirstSearchBorder(matrix, i, matrix[0].length - 1, visited);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 1) continue;
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    public static void depthFirstSearchBorder(int[][] matrix, int i , int j, int[][] visited) {
        visited[i][j] = 1;
        if (matrix[i][j] == 0) return;
        if (i - 1 >= 0 && visited[i - 1][j] == 0) {
            // top
            depthFirstSearchBorder(matrix, i-1, j, visited);
        }
        if (i + 1 < matrix.length && visited[i+1][j] == 0) {
            // down
            depthFirstSearchBorder(matrix, i + 1, j , visited);
        }
        if (j - 1 >= 0 && visited[i][j-1] == 0) {
            // left
            depthFirstSearchBorder(matrix, i, j-1, visited);
        }
        if (j + 1 < matrix[0].length && visited[i][j+1] == 0) {
            // right
            depthFirstSearchBorder(matrix, i, j+1, visited);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 0, 0, 0, 0, 0},{0, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1}};

        removeIslands(matrix);
    }
}
