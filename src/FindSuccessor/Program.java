package FindSuccessor;

public class Program {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if(node.right != null) {
            return findLeftMostChild(node.right);
        }

        BinaryTree parent = findAncestor(node.parent, node);

        return parent;
    }

    public static BinaryTree findLeftMostChild(BinaryTree node) {
        if(node.left == null) return node;
        return findLeftMostChild(node.left);
    }

    public static BinaryTree findAncestor(BinaryTree parent, BinaryTree node) {
        if (parent == null) return null;
        if (parent.left == node) return parent;


        return findAncestor(parent.parent, parent);
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
        two.parent = root;
        three.parent = root;
        two.left = four;
        four.parent = two;
        five.parent = two;
        two.right = five;
        four.left = six;
        six.parent = four;

        BinaryTree target = findSuccessor(root, three);
    }
}
