package BranchSum;

import java.util.*;

class Program {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<Integer>();

        FindSums(root, sums, 0);


        return sums;
    }

    public static void FindSums(BinaryTree root, List<Integer> sums, int runningSum) {
        if(root == null) return;
        runningSum += root.value;

        if(root.left == null && root.right == null) sums.add(runningSum);

        FindSums(root.left, sums, runningSum);
        FindSums(root.right, sums, runningSum);
    }

    public static void main(String[] args) {
//        BinaryTree root = new BinaryTree(1);
//        BinaryTree two = new BinaryTree(2);
//        BinaryTree three = new BinaryTree(3);
//        BinaryTree four = new BinaryTree(4);
//        BinaryTree five = new BinaryTree(5);
//        BinaryTree six = new BinaryTree(6);
//        BinaryTree seven = new BinaryTree(7);
//        BinaryTree eight = new BinaryTree(8);
//        BinaryTree nine = new BinaryTree(9);
//        BinaryTree ten = new BinaryTree(10);

        BinaryTree root = new BinaryTree(0);
        BinaryTree one = new BinaryTree(1);
        BinaryTree ten = new BinaryTree(10);
        BinaryTree hundred = new BinaryTree(100);

        root.right = one;
        one.right = ten;
        ten.right = hundred;

//        root.left = two;
//        root.right = three;
//        two.left = four;
//        two.right = five;
//        four.left = eight;
//        four.right = nine;
//        five.left = ten;
//        three.left = six;
//        three.right = seven;

        List<Integer> ans = branchSums(root);
    }
}
