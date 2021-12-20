package ValidateBST;

public class Program {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;

        boolean result = validate(tree, minValue, maxValue);



        return result;
    }

    public static boolean validate(BST tree, int minValue , int maxValue) {
        if (tree == null) return true;
        boolean result = false;

        boolean left = validate(tree.left, minValue, tree.value);
        boolean right = validate(tree.right, tree.value ,maxValue);

        if (left == true && right == true && (tree.value < maxValue && tree.value >= minValue) ) {
            result = true;
        }

        return result;

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
