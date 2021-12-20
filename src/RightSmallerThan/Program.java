package RightSmallerThan;

import java.util.*;

class Program {

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if(array.size() == 0) return new ArrayList<Integer>();

        int lastIdx = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIdx), lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i);
        }

        List<Integer> rightSmallerCounts = new ArrayList<Integer>(array);
        getRightSmallerCounts(bst, rightSmallerCounts);
        return rightSmallerCounts;
    }

    public static void getRightSmallerCounts(SpecialBST bst, List<Integer> rightSmallerCounts) {
        if(bst == null) return ;
        rightSmallerCounts.set(bst.idx, bst.numSmaller);
        getRightSmallerCounts(bst.left, rightSmallerCounts);
        getRightSmallerCounts(bst.right, rightSmallerCounts);
    }

    static class SpecialBST {
        public SpecialBST left;
        public SpecialBST right;
        public int numSmaller;
        public int numLeftSubtree;
        public int value;
        public int idx;

        public SpecialBST(int value, int idx, int numSmaller) {
            this.left = null;
            this.right = null;
            this.idx = idx;
            this.value = value;
            this.numSmaller = numSmaller;
            this.numLeftSubtree = 0;
        }

        public void insert(int value, int idx) {
            insertHelper(value, idx, 0);
        }

        public void insertHelper(int value, int idx, int numSmaller) {
            if(value < this.value) {
                // left
                this.numLeftSubtree++;
                if(this.left == null) {
                    this.left = new SpecialBST(value, idx, numSmaller);
                } else {
                    this.left.insertHelper(value, idx, numSmaller);
                }
            } else {
                // right
                numSmaller += numLeftSubtree;
                if(value > this.value) numSmaller++;

                if(right == null) {
                    right = new SpecialBST(value, idx, numSmaller);
                } else {
                    right.insertHelper(value, idx, numSmaller);
                }
            }
        }
    }

}
