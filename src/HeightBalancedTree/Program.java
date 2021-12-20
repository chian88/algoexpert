package HeightBalancedTree;

import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) return true;
        if (tree.left == null && tree.right == null) return true;

        int leftTreeHeight = findHeight(tree.left, 0);
        int rightTreeHeight = findHeight(tree.right, 0);

        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) return false;

        return heightBalancedBinaryTree(tree.left) && heightBalancedBinaryTree(tree.right);
    }

    public static int findHeight(BinaryTree tree, int height) {
        if (tree == null) return height;

        return Math.max(findHeight(tree.left, height + 1), findHeight(tree.right, height + 1));
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree ten = new BinaryTree(10);

        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        five.left = seven;
        five.right = eight;
        three.right = six;


        heightBalancedBinaryTree(root);
    }


}
