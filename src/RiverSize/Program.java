package RiverSize;

import java.util.*;

class Program {
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.

        int[][] visited = new int[matrix.length][matrix[0].length];
        List<Integer> river = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++){
                if (visited[i][j] == 1) continue;
                int size = depthFirstSearch(visited, matrix, i, j , 0);
                if (size > 0) river.add(size);
            }
        }

        return river;
    }

    public static int depthFirstSearch(int[][] visited, int[][] matrix , int i, int j, int count) {
        visited[i][j] = 1;
        if (matrix[i][j] == 1) {
            count += 1;
        } else {
            return count;
        }

        if (i - 1 >= 0 && visited[i-1][j] == 0) {
            // top
            count = depthFirstSearch(visited, matrix, i - 1, j, count);
        }
        if (j - 1 >= 0 && visited[i][j-1] == 0) {
            // left
            count = depthFirstSearch(visited, matrix, i, j - 1, count);
        }
        if (j + 1 < matrix[0].length && visited[i][j+1] == 0) {
            // right
            count = depthFirstSearch(visited, matrix, i, j + 1, count);
        }
        if (i + 1 < matrix.length && visited[i+1][j] == 0) {
            // down
            count= depthFirstSearch(visited, matrix, i+1, j, count);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0} };

        System.out.println(riverSizes(matrix));
    }
}
