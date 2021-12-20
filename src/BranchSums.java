import java.util.*;

class BranchSums {
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
        branchSum(root, sums, 0);
        return sums;
    }

    private static List<Integer> branchSum(BinaryTree node,  List<Integer> sums, int leafSum) {
        leafSum += node.value;
        if (node.left != null) {
            branchSum(node.left, sums, leafSum);
            //leafSum -= node.left.value;
        }
        if (node.right != null) {
            branchSum(node.right, sums, leafSum);
            //leafSum -= node.right.value;
        }

        if (node.left == null && node.right == null) {
            sums.add(leafSum);
        }

        return sums;

    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        BinaryTree tree2 = new BinaryTree(2);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree9 = new BinaryTree(9);
        BinaryTree tree10 = new BinaryTree(10);

        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree4.left = tree8;
        tree4.right = tree9;
        tree5.left = tree10;
        tree3.left = tree6;
        tree3.right = tree7;

        branchSums(tree1);
    }
}
