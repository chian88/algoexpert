package SolveSudoku;

import java.util.*;

class Program {

    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
       boolean ans = solveSudokuHelper(board, 0, 0);
       int x = 1;
        return board;
    }

    public static boolean solveSudokuHelper(ArrayList<ArrayList<Integer>> board, int row, int col) {
        // Write your code here.
        if (row == 9 && col == 0) { return true; }

        if (board.get(row).get(col) != 0 ) {
            int newcol = col;
            newcol++;
            int newrow = row;
            if (newcol > 8) {
                newcol = newcol % 9;
                newrow++;
            }
            return solveSudokuHelper(board, newrow, newcol);
        }

        for (int tries = 1; tries <= 9; tries++) {
            if (validHorizontally(board, row, tries) &&
                validVertically(board, col, tries) &&
                validWithinGrid(board, row, col, tries)) {
                ArrayList<Integer> sub = board.get(row);
                sub.set(col, tries);

                // go find an empty slow
                int newcol = col;
                int newrow = row;
                newcol++;
                if (newcol > 8) {
                    newcol = newcol % 9;
                    newrow++;
                }

                boolean temp = solveSudokuHelper(board,newrow, newcol);
                if (temp) {
                    return true;
                }

            }
        }

        // tried all possible ocmbination.
        board.get(row).set(col, 0);


        return false;
    }

    static boolean validVertically(ArrayList<ArrayList<Integer>> board, int col, int target) {
        for (int row =0; row < board.size(); row++) {
            ArrayList<Integer> sub = board.get(row);

            Integer colNum = sub.get(col);

            if (target == colNum) return false;
        }

        return true;
    }

    static boolean validHorizontally(ArrayList<ArrayList<Integer>> board, int row, int target) {
        ArrayList<Integer> sub = board.get(row);

        for (int col = 0; col < sub.size(); col++) {
            if (target == sub.get(col)) return false;
        }

        return true;
    }

    static boolean validWithinGrid(ArrayList<ArrayList<Integer>> board, int row, int col, int target) {
        if (row <= 2 && col <= 2) {
            // first grid
            for (int r = 0; r <= 2; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 0 ; c <= 2; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }

        } else if (row <= 2 && col <= 5) {
            // second
            for (int r = 0; r <= 2; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 3 ; c <= 5; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 2 && col <= 8) {
            for (int r = 0; r <= 2; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 6; c <= 8; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 5 && col <= 2) {
            for (int r = 3; r <= 5; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 0 ; c <= 2; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 5 && col <= 5) {
            for (int r = 3; r <= 5; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 3 ; c <= 5; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 5 && col <= 8) {
            for (int r = 3; r <= 5; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 6 ; c <= 8; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 8 && col <= 2) {
            for (int r = 6; r <= 8; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 0 ; c <= 2; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 8 && col <= 5) {
            for (int r = 6; r <= 8; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 3 ; c <= 5; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        } else if (row <= 8 && col <= 8) {
            for (int r = 6; r <= 8; r++) {
                ArrayList<Integer> sub = board.get(r);
                for (int c = 6 ; c <= 8; c++) {
                    Integer n = sub.get(c);

                    if (n == target) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board =  new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{7, 8, 0, 4, 0, 0, 1, 2, 0}));
//
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{7, 8, 0, 4, 0, 0, 1, 2, 0}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{6, 0, 0, 0, 7, 5, 0, 0, 9}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{0, 0, 0, 6, 0, 1, 0, 7, 8}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{0, 0, 7, 0, 4, 0, 2, 6, 0}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{0, 0, 1, 0, 5, 0, 9, 3, 0}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{9, 0, 4, 0, 6, 0, 0, 0, 5}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{0, 7, 0, 3, 0, 0, 0, 1, 2}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 0, 0, 0, 7, 4, 0, 0}))));
        board.add((new ArrayList<>(Arrays.asList(new Integer[]{0, 4, 9, 2, 0, 6, 0, 0, 7}))));
        solveSudoku(board);
    }
}
