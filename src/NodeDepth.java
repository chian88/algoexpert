import java.util.*;

class NodeDepth {

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.

        return searchDepth(root, 0, 0);
    }

    private static int searchDepth(BinaryTree node, int total, int depth) {
        if (node == null) return total;
        total += depth;
        depth += 1;
        total = searchDepth(node.left, total, depth);
        total = searchDepth(node.right, total, depth);

        return total;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        BinaryTree tree2= new BinaryTree(2);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree9 = new BinaryTree(9);

        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree4.left = tree8;
        tree4.right = tree9;
        tree3.left = tree6;
        tree3.right = tree7;

        nodeDepths(tree1);

    }
}
