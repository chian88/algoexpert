package InvertBinaryTree;

public class Program {
    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) return;
        if (tree.left == null && tree.right == null) return;

        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

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

        invertBinaryTree(root);
    }


    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
