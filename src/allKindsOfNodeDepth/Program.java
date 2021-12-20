package allKindsOfNodeDepth;
import java.util.*;



class Program {
	public static int allKindsOfNodeDepths(BinaryTree root) {
		// Write your code here.

		int sum = allKindsOfNodeDepthsHelper(root);

		return sum;
	}

	static int allKindsOfNodeDepthsHelper(BinaryTree node) {
		if (node == null) return 0;

		int a = findAllDepth(node, 0);
		int b = allKindsOfNodeDepthsHelper(node.left);
		int c = allKindsOfNodeDepthsHelper(node.right);

		return a + b +c ;
	}

	static int findAllDepth(BinaryTree node, int depth) {
		if (node == null) return 0;

		int leftDepth = findAllDepth(node.left, depth + 1);
		int rightDepth = findAllDepth(node.right , depth + 1);

		return leftDepth  +  rightDepth+ depth;
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
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
		BinaryTree nine = new BinaryTree(9);
		BinaryTree ten = new BinaryTree(10);
		BinaryTree eleven = new BinaryTree(11);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;

		four.left = eight;
		four.right = nine;

		allKindsOfNodeDepths(one);

	}
}