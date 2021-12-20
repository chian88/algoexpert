package NonAttackingQueen;

import java.util.*;

class Program {

    public static int nonAttackingQueens(int n) {
        // Write your code here.
        int[] placements = new int[n];
        return nonAttackingQueensHelper(placements, 1, n, 0);
    }

    public static int nonAttackingQueensHelper(int[] placements, int row, int n, int result) {

        for (int i = 0; i < placements.length; i++) {

            // check columns for clash.
            boolean columnClash = checkColumnClash(placements, row, i);

            // check diagonals for clash.
            boolean diagonalClash = checkDiagonalClash(placements, row, i);

            if (!columnClash && !diagonalClash) {
                // if no clash, then place a queen in current row with current column;
                placements[row - 1] = i;
                if (row == n) return result + 1;
                result = nonAttackingQueensHelper(placements, row + 1, n, result);
            }


        }
        return result;
    }

    public static boolean checkDiagonalClash(int[] placements, int row, int currentCol) {
        for (int j = 0; j < row - 1; j++) {
            int columnNum = placements[j];
            int rowNum = j;

            if (Math.abs(currentCol - columnNum) == Math.abs(rowNum - (row - 1))) return true;
        }

        return false;
    }
    public static boolean checkColumnClash(int[] placements, int row, int currentCol) {
        for (int j = 0 ; j < row - 1; j++) {
            int columnNum = placements[j];
            if (currentCol == columnNum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        nonAttackingQueens(4);
    }
}
