package RearrangeLinkedList;

import java.util.*;

class Program {
	public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		// Write your code here.
		LinkedList lesser = null;
		LinkedList lesserIter = null;
		LinkedList equal = null;
		LinkedList equalIter = null;
		LinkedList greater = null;
		LinkedList greaterIter = null;

		while (head != null) {
			if (head.value < k) {
				// smaller
				if (lesser == null) {
					lesser = head;
					lesserIter = lesser;
				} else {
					lesserIter.next = head;
					lesserIter = lesserIter.next;
				}
			} else if (head.value == k) {
				if (equal == null) {
					equal = head;
					equalIter = equal;
				} else {
					equalIter.next = head;
					equalIter = equalIter.next;
				}
			} else {
				if (greater == null) {
					greater = head;
					greaterIter = greater;
				} else {
					greaterIter.next = head;
					greaterIter = greaterIter.next;
				}
			}

			head = head.next;
		}

		if (lesser == null) {

			if (equal == null) {
				return greater;
			} else {
				// connect equal and greater
				equalIter.next = greater;
				if (greaterIter != null) greaterIter.next = null;
				return equal;
			}
		} else {
			if (equal == null) {
				//connect leser and greater
				lesserIter.next = greater;
				if (greaterIter != null) greaterIter.next = null;
				return lesser;


			} else {
				// connect lesser and equal and greater.

				lesserIter.next = equal;
				equalIter.next = greater;
				if (greaterIter != null) greaterIter.next = null;
				return lesser;
			}
		}

	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList zero = new LinkedList(3);
		LinkedList two = new LinkedList(0);
		LinkedList one = new LinkedList(5);
		LinkedList three = new LinkedList(2);
		LinkedList five = new LinkedList(1);
		LinkedList four = new LinkedList(4);

		zero.next = two;
		two.next = one;
		one.next= three;
		three.next = five;
		five.next = four;

		rearrangeLinkedList(zero, 3);
	}
}
