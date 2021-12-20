package BSTTraversal;
import java.util.*;

public class Program {



    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree == null) return array;

        array = inOrderTraverse(tree.left, array);
        array.add(tree.value);
        array = inOrderTraverse(tree.right, array);

        return array;
    }


    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree == null) return array;
        array.add(tree.value);
        array = preOrderTraverse(tree.left, array);
        array = preOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree == null) return array;
        array = postOrderTraverse(tree.left, array);
        array = postOrderTraverse(tree.right, array);
        array.add(tree.value);

        return array;
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        BST five = new BST(5);
        BST fifteen = new BST(15);
        BST two = new BST(2);
        BST five2 = new BST(5);
        BST thirteen = new BST(13);
        BST twentytwo = new BST(22);
        BST one = new BST(1);
        BST fourteen = new BST(14);
        root.left = five;
        root.right = fifteen;
        five.left = two;
        five.right = five2;
        two.left = one;
//        fifteen.left = thirteen;
        fifteen.right = twentytwo;
//        thirteen.right = fourteen;

        List<Integer> array = new ArrayList<>();
        Program.postOrderTraverse(root, array);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
