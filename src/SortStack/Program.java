package SortStack;

import java.util.*;

class Program {

	public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
		// Write your code here.
		sortStackHelper(stack);
		return stack;
	}

	public static void sortStackHelper(ArrayList<Integer> stack) {
		if (stack.size() == 0) return;
		int element = stack.remove(stack.size() - 1);
		sortStackHelper(stack);
		List<Integer> temp = new ArrayList<>();
		while (stack.size() > 0 && element < stack.get(stack.size() - 1)) {
			temp.add(stack.remove(stack.size() - 1));
		}

		stack.add(element);
		for (int i = temp.size() - 1; i >= 0; i--) {
			stack.add(temp.get(i));
		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> input =  new ArrayList<>(Arrays.asList(1,-5,3,4,-2,2));

		sortStack(input);
	}
}
