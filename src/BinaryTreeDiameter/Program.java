package BinaryTreeDiameter;

public class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here
        if (tree == null)
            return 0;
        int x = findDepth(tree.left, 0);
        int y = findDepth(tree.right, 0);

        int pathThruRoot = x + y;
        int leftSubTree = binaryTreeDiameter(tree.left);
        int rightSubTree = binaryTreeDiameter(tree.right);
        int subTreeHeight = Math.max(leftSubTree, rightSubTree);

        return Math.max(pathThruRoot, subTreeHeight);
    }

    public static int findDepth(BinaryTree tree, int depth) {
        if (tree == null)
            return depth;
        return Math.max(findDepth(tree.left, depth + 1), findDepth(tree.right, depth + 1));
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

        root.left = three;
        root.right = two;
        three.left = seven;
        three.right = four;
        seven.left = eight;
        eight.left = nine;
        four.right = five;
        five.right = six;
        root.right = two;

        binaryTreeDiameter(root);
    }
}
