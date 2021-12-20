package FlattenBinaryTree;

import java.util.*;

class Program {
	public static BinaryTree flattenBinaryTree(BinaryTree root) {
		// Write your code here.
		flattenBinaryTreeHelper(root);


		return findLeftMost(root);
	}

	static void flattenBinaryTreeHelper(BinaryTree node) {

		if (node.left != null) flattenBinaryTree(node.left);


		BinaryTree rightMostLeftSubtree = findRightMost(node.left);


		node.left = rightMostLeftSubtree;
		if (rightMostLeftSubtree != null) rightMostLeftSubtree.right = node;

		if (node.right != null) flattenBinaryTree(node.right);

		BinaryTree leftMostRightSubtree = findLeftMost(node.right);

		node.right = leftMostRightSubtree;
		if (leftMostRightSubtree != null) leftMostRightSubtree.left = node;
	}

	static BinaryTree findRightMost(BinaryTree node) {
		if (node == null || node.right == null) return node;

		return findRightMost(node.right);
	}

	static BinaryTree findLeftMost(BinaryTree node) {
		if (node == null || node.left == null) return node;

		return findLeftMost(node.left);
	}

	// This is the class of the input root. Do not edit it.
	static class BinaryTree {
		int value;
		BinaryTree left = null;
		BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
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
		three.left = six;
		two.left = four;
		two.right = five;
		five.left = seven;
		five.right = eight;
		flattenBinaryTree(one);

	}
}
