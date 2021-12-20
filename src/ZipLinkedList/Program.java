package ZipLinkedList;

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

	public static LinkedList zipLinkedList(LinkedList linkedList) {
		// Write your code here.
		int middle = 0;

		LinkedList iter = linkedList;
		while (iter != null && iter.next != null) {
			middle++;
			iter = iter.next.next;
		}

		LinkedList head = linkedList;
		LinkedList secondHalf = reverseLinkedList(head, middle);
		LinkedList firstHalf = head;
		iter = head;
		boolean alternate = true;
		middle *= 2;
		while (middle > 0) {
			if (alternate) {
				firstHalf = iter.next;
				iter.next = secondHalf;
				iter = iter.next;
				secondHalf = secondHalf.next;
			} else {
				secondHalf = iter.next;
				iter.next = firstHalf;
				iter = iter.next;
				firstHalf = firstHalf.next;

			}
			alternate = !alternate;
			middle--;
		}
		iter.next = null;

		return head;
	}


	static LinkedList reverseLinkedList(LinkedList head, int start) {
		LinkedList prev = null;
		LinkedList curr = head;

		while (start > 0) {
			curr = curr.next;
			start--;
		}

		while (curr.next != null) {
			LinkedList temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;

		}

		curr.next = prev;

		return curr;
	}

	public static void main(String[] args) {
		LinkedList one = new LinkedList(1);
		LinkedList two = new LinkedList(2);
		LinkedList three = new LinkedList(3);
//		LinkedList four = new LinkedList(4);
//
//		LinkedList five = new LinkedList(5);
//		LinkedList six = new LinkedList(6);

		one.next = two;
		two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next = six;
		zipLinkedList(one);
	}
}
