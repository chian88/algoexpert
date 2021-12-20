package MinMaxStack;

import java.util.*;

class Tuple {
	int max;
	int min;
	int data;

	Tuple(int data, int max, int min) {
		this.max = max;
		this.min = min;
		this.data = data;
	}
}

class Program {
    // Feel free to add new properties and methods to the class.

	private static Deque<Tuple> stack = new ArrayDeque<>();

    static class MinMaxStack {
        public int peek() {
            // Write your code here.
			return stack.peekFirst().data;
        }

        public int pop() {
            // Write your code here.
			return stack.removeFirst().data;
        }

        public void push(Integer number) {
            // Write your code here.
			if (stack.isEmpty()) {
				stack.addFirst(new Tuple(number, number, number));
			} else {
				Tuple prev = stack.peekFirst();

				stack.addFirst(new Tuple(number, Math.max(prev.max, number), Math.min(prev.min, number)));
			}

        }

        public int getMin() {
            // Write your code here.
			return stack.peekFirst().min;
        }

        public int getMax() {
            // Write your code here.
			return stack.peekFirst().max;
        }
    }

	public static void main(String[] args) {
		MinMaxStack test = new MinMaxStack();
		test.push(2);
		System.out.println(test.getMin());
		System.out.println(test.getMax());
	}
}
