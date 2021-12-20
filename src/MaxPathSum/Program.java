package MaxPathSum;

import java.util.*;

class Program {

    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        List<Integer> ans = maxPathSumHelper(tree);

        return ans.get(1);
    }

    public static List<Integer> maxPathSumHelper(BinaryTree tree) {

        if (tree == null) {
            return Arrays.asList(0, Integer.MIN_VALUE);
        }

        List<Integer> left = maxPathSumHelper(tree.left);
        List<Integer> right = maxPathSumHelper(tree.right);
        int leftSubBranch = left.get(0);
        int leftSub = left.get(1);

        int rightSubBranch = right.get(0);
        int rightSub = right.get(1);

        int maxChildSubBranch = Math.max(leftSubBranch, rightSubBranch);
        int maxSubBranch = Math.max(maxChildSubBranch + tree.value, tree.value);
        int maxSubTriangle = Math.max(maxSubBranch, leftSubBranch + tree.value + rightSubBranch);
        int runningMaxSubBranch = Math.max(Math.max(leftSub, rightSub), maxSubTriangle);

        return Arrays.asList(new Integer[]{maxSubBranch, runningMaxSubBranch});
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
