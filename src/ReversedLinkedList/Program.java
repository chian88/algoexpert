package ReversedLinkedList;

import java.util.*;

class Program {
	public static LinkedList reverseLinkedList(LinkedList head) {
		// Write your code here.
		LinkedList prev = null;
		LinkedList curr = head;
		LinkedList next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;

		}


		return prev;
	}

	public static void main(String[] args) {
		LinkedList one = new LinkedList(1);
		LinkedList two = new LinkedList(2);
		LinkedList three = new LinkedList(3);
		one.next = two;
		two.next = three;
		reverseLinkedList(one);
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
