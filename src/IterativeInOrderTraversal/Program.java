package IterativeInOrderTraversal;

import java.util.function.Function;
import java.util.*;

class Program {
	public static void iterativeInOrderTraversal(
			BinaryTree tree, Function<BinaryTree, Void> callback) {
		// Write your code here.

		BinaryTree current = tree;
		BinaryTree prev = null;

		while (current != null) {
			if (current.parent == prev) {
				if (current.left != null) {
					// go left if ok.
					prev = current;
					current = current.left;
				} else {
					callback.apply(current);
					if (current.right != null) {
						// go right if ok.
						prev = current;
						current = current.right;
					} else {
						// go up
						prev = current;
						current = current.parent;
					}
				}

			} else if (prev == current.right) {
				// just go up
				prev = current;
				current = current.parent;
			} else {
				callback.apply(current);
				// go right if possible
				if (current.right != null) {
					prev = current;
					current = current.right;
				} else {
					prev = current;
					current = current.parent;
				}
			}
		}

	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		public BinaryTree parent;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
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
		two.left = four;
		four.right = nine;
		three.left = six;
		three.right = seven;

		two.parent = one;
		four.parent = two;
		nine.parent = four;

		three.parent = one;
		six.parent = three;
		seven.parent = three;

		iterativeInOrderTraversal(one, (t) -> {
			System.out.print(t);
			return null;
		});
	}
}
