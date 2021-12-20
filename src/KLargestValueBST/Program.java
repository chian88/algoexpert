package KLargestValueBST;

public class Program {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        int[] countValue = new int[]{0, -1};

        int[] result = findKthLargestHelper(tree, k, countValue);

        return result[1];
    }

    public static int[] findKthLargestHelper(BST tree, int k, int[] countValue ) {
        if (tree == null || k <= countValue[0]) return countValue;



        countValue = findKthLargestHelper(tree.right, k, countValue);
        countValue[0] += 1;
        if (k == countValue[0]) countValue[1] = tree.value;
        countValue = findKthLargestHelper(tree.left, k, countValue);

        return countValue;
    }

    public static void main(String[] args) {
        BST root = new BST(15);
        BST five = new BST(5);
        BST twenty = new BST(20);
        BST two = new BST(2);
        BST three = new BST(3);
        BST five2 = new BST(5);
        BST thirteen = new BST(13);
        BST seventeen = new BST(17);
        BST twentytwo = new BST(22);
        BST one = new BST(1);
        BST fourteen = new BST(14);
        root.left = five;
        root.right = twenty;
        five.left = two;
        five.right = five2;
        two.left = one;
        two.right = three;
        twenty.left = seventeen;
        twenty.right = twentytwo;

        findKthLargestValueInBst(root, 3);
    }
}
