package ReconstructBST;

import java.lang.reflect.Array;
import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if (preOrderTraversalValues.size() == 0) return null;
        if (preOrderTraversalValues.size() == 1) return new BST(preOrderTraversalValues.get(0));

        int rightIdx = -1;
        int currentNode = preOrderTraversalValues.get(0);
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            if (preOrderTraversalValues.get(i) >= currentNode) {
                rightIdx = i;
                break;
            }
        }

        BST leftNode = null;
        BST rightNode = null;

        if (rightIdx == -1) {
            // don't have right leaf.
            ArrayList<Integer> left =  new ArrayList<>(preOrderTraversalValues.subList(1, preOrderTraversalValues.size()));
            leftNode = reconstructBst(left);
        } else {
            ArrayList<Integer> left =  new ArrayList<>(preOrderTraversalValues.subList(1, rightIdx));
            ArrayList<Integer> right =  new ArrayList<>(preOrderTraversalValues.subList(rightIdx, preOrderTraversalValues.size()));
            leftNode = reconstructBst(left);
            rightNode = reconstructBst(right);
        }

        BST currentTree = new BST(currentNode);
        currentTree.left = leftNode;
        currentTree.right = rightNode;

        return currentTree;
    }

//    public static BST reconstructBstHelper(BST tree, int idx, ArrayList<Integer> preOrderTraversalValues, BST parent) {
//
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1,4,3,3};
        ArrayList<Integer> input = new ArrayList<>();
        for (int i : arr) {
            input.add(i);
        }
        reconstructBst(input);
    }
}