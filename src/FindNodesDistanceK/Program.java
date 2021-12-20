package FindNodesDistanceK;

import java.util.*;

class Program {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {

		ArrayList<Integer> res = new ArrayList<>();

		findNodesDistanceK(tree, target, k, res);

		return res;
	}

	public static void findNodesDistanceK(BinaryTree tree, int target, int k, ArrayList<Integer> res ) {
		// Write your code here.

		if (tree == null) return;

		int depthTargetLeftSubtree = checkIfTargetInSubTree(tree.left, target, 0) - 1;
		int depthTargetRightSubtree = checkIfTargetInSubTree(tree.right, target, 0) - 1;

		if (depthTargetLeftSubtree >= 0) {
			// search for k - L - 1 in right subtree .
			if ((k - depthTargetLeftSubtree - 1) == 0 ) res.add(tree.value);

			collectAllKAwayNodes(tree.right, k - depthTargetLeftSubtree - 1, 0, res);
			findNodesDistanceK(tree.left, target, k, res);

		} else if (depthTargetRightSubtree >= 0) {
			// left subtree
			if ((k - depthTargetRightSubtree - 1) == 0 ) res.add(tree.value);
			collectAllKAwayNodes(tree.left, k - depthTargetRightSubtree - 1, 0, res);
			findNodesDistanceK(tree.right, target, k, res);
		} else if (tree.value == target) {
			collectAllKAwayNodes(tree.left, k, 0, res);
			collectAllKAwayNodes(tree.right, k, 0, res);
			findNodesDistanceK(tree.left, target, k, res);
			findNodesDistanceK(tree.right, target, k, res);
		}

		return;
	}

	static void collectAllKAwayNodes(BinaryTree tree, int targetDepth, int depth, ArrayList<Integer> res) {

		if (tree == null) return;
		depth += 1;

		if (depth == targetDepth) {
			res.add(tree.value);
			return;
		}

		collectAllKAwayNodes(tree.left, targetDepth, depth, res);
		collectAllKAwayNodes(tree.right, targetDepth, depth, res);

	}


	static int checkIfTargetInSubTree(BinaryTree tree, int target, int depth) {
		if (tree == null) return -1;
		depth += 1;

		if (tree.value == target) return depth;
		int leftSubTreeDepth = checkIfTargetInSubTree(tree.left, target, depth);
		int rightSubTreeDepth = checkIfTargetInSubTree(tree.right, target, depth);


		if (leftSubTreeDepth >= 0) return leftSubTreeDepth;
		if (rightSubTreeDepth >= 0) return rightSubTreeDepth;
		return -1;
	}

	public static void main(String[] args) {
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);
		BinaryTree nine = new BinaryTree(9);
		BinaryTree six = new BinaryTree(6);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree one = new BinaryTree(1);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		four.left = eight;
		four.right = nine;
		three.left = six;
		three.right = seven;

		findNodesDistanceK(one, 8, 2);

	}
}
