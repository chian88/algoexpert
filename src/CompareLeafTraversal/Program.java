package CompareLeafTraversal;

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

	public static boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
		// Write your code here.
		Deque<BinaryTree> stack1 = new ArrayDeque<>();
		Deque<BinaryTree> stack2 = new ArrayDeque<>();

		stack1.addFirst(tree1);
		stack2.addFirst(tree2);

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			BinaryTree current1 = stack1.removeFirst();
			while (current1 == null || current1.left != null || current1.right != null) {


				if (current1.right != null) stack1.addFirst(current1.right);
				if (current1.left != null) stack1.addFirst(current1.left);
				current1 = stack1.removeFirst();
			}


			BinaryTree current2 = stack2.removeFirst();
			while (current2 == null || current2.left != null || current2.right != null) {

				if (current2.right != null) stack2.addFirst(current2.right);
				if (current2.left != null) stack2.addFirst(current2.left);

				current2 = stack2.removeFirst();
			}


			if (current1.value != current2.value) return false;

		}



		return true;

	}



	public static void main(String[] args) {
		BinaryTree one = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = seven;
		three.right = five;
		five.left = eight;
		five.right = six;


		BinaryTree one2 = new BinaryTree(1);
		BinaryTree two2 = new BinaryTree(2);
		BinaryTree three2 = new BinaryTree(3);
		BinaryTree four2 = new BinaryTree(4);
		BinaryTree five2 = new BinaryTree(5);
		BinaryTree six2 = new BinaryTree(6);
		BinaryTree seven2 = new BinaryTree(7);
		BinaryTree eight2 = new BinaryTree(8);

		one2.left = two2;
		one2.right = three2;
		two2.left = four2;
		two2.right = five2;
		five2.left = seven2;
		five2.right = eight2;
		three2.right = six2;

		compareLeafTraversal(one, one2);
	}
}
