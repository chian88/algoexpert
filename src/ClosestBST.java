import java.util.*;

class ClosestBST {
    public static int findClosestValueInBst(BST tree, int target) {
        if ( (tree.left == null && tree.right == null) || tree == null || tree.value == target ) {
            return tree.value;
        }

        if (target > tree.value) {
            return findClosestValueInBst(tree.right, target);
        } else {
            return findClosestValueInBst(tree.left, target);
        }


    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST bst1 = new BST(10);
        BST bst2 = new BST(5);
        BST bst3 = new BST(15);
        BST bst4 = new BST(2);
        BST bst5 = new BST(5);
        BST bst6 = new BST(13);
        BST bst7 = new BST(22);
        BST bst8 = new BST(1);
        BST bst9 = new BST(14);

        bst1.left = bst2;
        bst1.right = bst3;
        bst2.left = bst4;
        bst2.right = bst5;
        bst3.left = bst6;
        bst3.right = bst7;
        bst4.left = bst8;
        bst6.right = bst9;

        int value = findClosestValueInBst(bst1, 12);

        System.out.println(value);
    }
}
