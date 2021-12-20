package SpiralTraverse;

import java.util.*;

public class Program {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        int xStart = 0;
        int xEnd = array[0].length;
        int yStart = 0;
        int yEnd = array.length;

        List<Integer> answer = new ArrayList<>();
        int direction = 1;

        while (true) {
            if(direction == 1) {
                for (int row = xStart; row < xEnd; row++) {
                    answer.add(array[yStart][row]);
                }
                yStart++;
                direction = 2;
                if (yStart == yEnd) break;
            }

            if (direction == 2) {
                for (int col = yStart; col < yEnd; col++) {
                    answer.add(array[col][xEnd-1]);
                }
                xEnd--;
                direction = 3;
                if (xStart == xEnd) break;
            }

            if (direction == 3) {
                for (int row = xEnd - 1; row >= xStart; row--) {
                    answer.add(array[yEnd-1][row]);
                }
                yEnd--;
                direction = 4;
                if (yStart == yEnd) break;
            }

            if (direction == 4) {
                for (int col = yEnd - 1; col >= yStart; col--) {
                    answer.add(array[col][xStart]);
                }
                xStart++;
                direction = 1;
                if (xStart == xEnd) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6} };
        Program.spiralTraverse(array);
    }
}
