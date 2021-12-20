package NodeSwap;

import java.util.*;

class Program {
	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static LinkedList nodeSwap(LinkedList head) {
		// Write your code here.
		LinkedList curr = head;
		LinkedList currNext = null;
		LinkedList temp = null;
		LinkedList prev = null;
		boolean firstTime = true;
		while (curr != null && curr.next != null) {
			currNext = curr.next;
			temp = currNext.next;

			if (prev != null) {
				prev.next = currNext;
			}

			currNext.next = curr;
			curr.next = temp;
			prev = curr;
			curr = temp;

			if (firstTime) {
				head = currNext;
				firstTime = false;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedList zero = new LinkedList(0);
		LinkedList one = new LinkedList(1);
		LinkedList two = new LinkedList(2);
		LinkedList three = new LinkedList(3);
		LinkedList four = new LinkedList(4);

//		LinkedList five = new LinkedList(5);
		zero.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
//		four.next = five;
		nodeSwap(zero);

	}
}
