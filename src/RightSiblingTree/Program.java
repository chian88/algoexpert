package RightSiblingTree;

import java.util.*;

class Program {
	public static BinaryTree rightSiblingTree(BinaryTree root) {
		// Write your code here.
		rightSiblingTreeHelper(root, null, null);
		return root;
	}

	static void rightSiblingTreeHelper(BinaryTree node, BinaryTree parent, Boolean rightChild) {
		if (node == null) return;

		rightSiblingTreeHelper(node.left , node, false);


		BinaryTree tempLeft = node.left;
		BinaryTree tempRight = node.right;

		if (rightChild == null) {
			node.right = null;
		}
		else if (rightChild) {
			node.right = parent.right == null ? null : parent.right.left;

		} else {
			node.right = parent.right;
		}

		rightSiblingTreeHelper(tempRight , node, true);

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

		BinaryTree ten = new BinaryTree(10);
		BinaryTree eleven = new BinaryTree(11);
		BinaryTree twelve = new BinaryTree(12);
		BinaryTree thirteen = new BinaryTree(13);
		BinaryTree fourteen = new BinaryTree(14);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		four.left = eight;
		four.right = nine;
		five.right = ten;
		three.left = six;
		three.right = seven;
		six.left = eleven;
		eleven.left = fourteen;
		seven.left = twelve;
		seven.right = thirteen;

		rightSiblingTree(one);
	}
}
