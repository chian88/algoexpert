package FindClosestValueInBST;

public class Program {
    public static int findClosestValueInBst(BST tree, int target) {

        int minVariance = Integer.MAX_VALUE;
        int targetNodeValue = -1;
        int closest = findClosestValue(tree, target, minVariance, targetNodeValue);

        return closest;
    }


    public static int findClosestValue(BST tree, int target, int minVariance, int targetNodeValue) {
        if (tree == null) return targetNodeValue;
        if (tree.value == target) return tree.value;

        if ( Math.abs(tree.value - target) < minVariance) {
            minVariance = Math.abs(tree.value - target);
            targetNodeValue = tree.value;
        }


        if(tree.value > target) {
            // go left
            targetNodeValue = findClosestValue(tree.left, target, minVariance, targetNodeValue);
        } else if (tree.value < target) {
            targetNodeValue = findClosestValue(tree.right, target, minVariance, targetNodeValue);
        }

        return targetNodeValue;
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
        fifteen.left = thirteen;
        fifteen.right = twentytwo;
        thirteen.right = fourteen;
        findClosestValueInBst(root, 12);

    }
}
