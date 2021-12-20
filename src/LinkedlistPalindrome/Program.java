package LinkedlistPalindrome;
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

	public static boolean linkedListPalindrome(LinkedList head) {
		// Write your code here.

		LinkedList iter = head;
		int middle = 0;
		while (iter != null && iter.next != null) {
			iter = iter.next.next;
			middle++;
		}

		LinkedList secondHalf = reverseLinkedList(head, middle);


		while (middle > 0) {
			if (head.value != secondHalf.value) return false;
			head = head.next;
			secondHalf = secondHalf.next;

			middle--;
		}
		return true;
	}


	static LinkedList reverseLinkedList(LinkedList head, int start) {
		LinkedList curr = head;
		LinkedList prev = null;
		LinkedList temp = null;

		while (curr != null && start > 0) {
			curr = curr.next;
			start--;
		}


		while (curr.next != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;

		}
		curr.next = prev;
		return curr;
	}

	public static void main(String[] args) {
		LinkedList zero = new LinkedList(0);
		LinkedList two = new LinkedList(1);
//		LinkedList one = new LinkedList(2);
		LinkedList three = new LinkedList(2);

		LinkedList five = new LinkedList(1);
		LinkedList four = new LinkedList(0);

		zero.next = two;
		two.next = three;
//		one.next= three;
		three.next = five;
		five.next = four;
		linkedListPalindrome(zero);
	}
}
