package NodeDepth;

public class Program {

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        int sum = 0;
        sum = findDepth(root, 0);
        return -1;
    }

    public static int findDepth(BinaryTree root, int depth) {
        if(root == null) return 0;
        int j = depth + findDepth(root.left, depth + 1) + findDepth(root.right, depth + 1);

        return j;
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
        four.left = eight;
        four.right = nine;
//        five.left = ten;
        three.left = six;
        three.right = seven;

        nodeDepths(root);
    }
}
