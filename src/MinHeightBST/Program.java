package MinHeightBST;

import java.util.*;

public class Program {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        BST tree = minHeight(null, array);
        return tree;
    }

    public static BST minHeight(BST tree, List<Integer> array) {
        if(array.size() <= 0) return tree;

        int medianIdx = (array.size()) / 2;
        if(tree == null) {
            tree = new BST(array.get(medianIdx));
        } else {
            tree.insert(array.get(medianIdx));
        }

        List<Integer> firstHalf = array.subList(0, medianIdx);
        List<Integer> secondHalf = array.subList(medianIdx + 1, array.size());

        minHeight(tree, firstHalf);
        minHeight(tree, secondHalf);

        return tree;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(new Integer[] {1,2,5,7, 10, 13,14,15,22});
        minHeightBst(arr);
    }
}
